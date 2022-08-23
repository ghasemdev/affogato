@file:Suppress("ForbiddenClassName", "MaxLineLength", "LongMethod")

package com.parsuomash.affogato.unit.processor.internal

import com.fleshgrinder.extensions.kotlin.toUpperCamelCase
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSValueArgument
import com.google.devtools.ksp.validate
import com.parsuomash.affogato.unit.processor.utils.DimenValidator
import com.parsuomash.affogato.unit.processor.utils.DimenValidator.Companion.COLON_SYMBOL
import com.parsuomash.affogato.unit.processor.utils.DimenValidator.Companion.EQUALS_SYMBOL

class DimenSymbolProcessor(
  private val config: DimenConfig,
  private val codeGenerator: CodeGenerator,
  private val logger: KSPLogger
) : SymbolProcessor {
  private val declarations = mutableListOf<KSPropertyDeclaration>()
  private val visitor = DimenVisitor(declarations)

  private val dimenPackage: List<String>
    get() = declarations.map { it.packageName.asString() }

  private val dimenTypes: List<String?>
    get() = declarations.map {
      it.annotations.getValue<String>(ANNOTATION_PARAM_TYPE)?.lowercase()?.trim()
    }

  private val dimenValues: List<List<*>?>
    get() = declarations.map {
      it.annotations.getValues(ANNOTATION_PARAM_VALUES)
    }

  private val dimenClassNames: List<String?>
    get() = declarations.map { it.getClassSimpleName() }

  private val dimenClassQualifiedNames: List<String?>
    get() = declarations.map { it.getClassQualifiedName() }

  private val dimenNames: List<String?>
    get() = declarations.map { it.simpleName.getShortName() }

  override fun process(resolver: Resolver): List<KSAnnotated> {
    resolver.getSymbolsWithAnnotation(ANNOTATION_PACKAGE)
      .filter { it is KSPropertyDeclaration && it.validate() }
      .forEach { it.accept(visitor, Unit) }

    return emptyList()
  }

  override fun finish() {
    val validator = DimenValidator(dimenTypes, dimenValues, dimenClassQualifiedNames)
    if (!validator.validate(logger)) return

    val fileName = "${config.moduleName.toUpperCamelCase()}DimenProvider"
    val visibility = if (config.internalVisibility) "internal" else "public"

    val screenWidths = dimenValues[0]!!.map { keys ->
      keys.toString().split(EQUALS_SYMBOL, COLON_SYMBOL).map { it.trim().toInt() }.first()
    }.sorted()

    val whenStatement = buildString {
      append("${INDENTATION}screenWidth < ${screenWidths.first()} -> sw${screenWidths.first()}Dimensions\n")
      screenWidths.windowed(2) {
        append("${INDENTATION * 2}screenWidth in ${it[0]}..${it[1]} -> sw${it[0]}Dimensions\n")
      }
      append("${INDENTATION * 2}else -> sw${screenWidths.last()}Dimensions")
    }

    val dimensions = buildString {
      var counter = 0
      (dimenPackage zip dimenNames).zip(dimenClassNames) { (packageName, name), className ->
        val newLine = if (counter < dimenNames.lastIndex) "\n" else ""
        append("${INDENTATION}val $name: $className = $packageName.$name,$newLine")
        counter++
      }
    }

    val dimensionObjects = buildString {
      screenWidths.forEachIndexed { index, width ->
        val newLine1 = if (index < screenWidths.lastIndex) "\n" else ""
        append("private val sw${width}Dimensions = Dimensions(\n")
        (dimenTypes zip dimenNames).zip(dimenValues) { (type, name), value ->
          val newValue = value?.associate { v ->
            val list = v.toString().split(EQUALS_SYMBOL, COLON_SYMBOL)
              .map { it.trim().toInt() }
            list[0] to list[1]
          }
          append("$INDENTATION$name = ${newValue?.get(width)}.$type,\n")
        }
        append(")\n$newLine1")
      }
    }

    codeGenerator.createNewFile(
      dependencies = Dependencies(
        aggregating = true,
        sources = declarations.map { it.containingFile!! }.toTypedArray()
      ),
      packageName = config.packageName,
      fileName = fileName
    ).use { stream ->
      stream.write(
        """
        |package ${config.packageName}
        |
        |import android.content.res.Configuration
        |import androidx.compose.runtime.Composable
        |import androidx.compose.runtime.CompositionLocalProvider
        |import androidx.compose.runtime.remember
        |import androidx.compose.runtime.staticCompositionLocalOf
        |import androidx.compose.ui.platform.LocalConfiguration
        |import androidx.compose.ui.unit.Dp
        |import androidx.compose.ui.unit.TextUnit
        |import androidx.compose.ui.unit.dp
        |import androidx.compose.ui.unit.sp
        |
        |/**
        | * Provide dimens for multiscreen support.
        | * in Theme.kt add this function
        | * ```Kotlin
        | * ProvideDimens {
        | *   MaterialTheme(
        | *     colors = colors,
        | *     typography = Typography,
        | *     shapes = Shapes,
        | *     content = content
        | *   )
        | * }
        | * ```
        | *
        | * @param dimensions
        | * @param content
        | */
        |@Composable
        |$visibility fun ProvideDimens(
        |  dimensions: Dimensions = defaultDimens(),
        |  content: @Composable () -> Unit
        |) {
        |  val dimensionSet = remember { dimensions }
        |  CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
        |}
        |
        |private val LocalAppDimens = staticCompositionLocalOf {
        |  Dimensions()
        |}
        |
        |$visibility val dimen: Dimensions
        |  @Composable
        |  get() = LocalAppDimens.current
        |
        |@Composable
        |private fun defaultDimens(): Dimensions {
        |  val configuration = LocalConfiguration.current
        |  val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        |  val screenWidth = if (isLandscape) configuration.screenHeightDp else configuration.screenWidthDp
        |
        |  return when {
        |  $whenStatement
        |  }
        |}
        |
        |$visibility data class Dimensions(
        |$dimensions
        |)
        |
        |$dimensionObjects
        """.trimMargin().toByteArray()
      )
    }
  }

  private fun KSPropertyDeclaration.getClassSimpleName(): String? =
    getter?.returnType?.resolve()?.declaration?.simpleName?.asString()

  private fun KSPropertyDeclaration.getClassQualifiedName(): String? =
    getter?.returnType?.resolve()?.declaration?.qualifiedName?.asString()

  private inline fun <reified T> Sequence<KSAnnotation>.getValue(argumentName: String): T? =
    withName(ANNOTATION_NAME)
      ?.arguments
      ?.withName(argumentName)
      ?.value as? T

  private fun Sequence<KSAnnotation>.getValues(argumentName: String): List<*>? =
    withName(ANNOTATION_NAME)
      ?.arguments
      ?.withName(argumentName)
      ?.value as? List<*>

  private fun Sequence<KSAnnotation>.withName(name: String): KSAnnotation? =
    firstOrNull { it.shortName.getShortName() == name }

  private fun List<KSValueArgument>.withName(name: String): KSValueArgument? =
    firstOrNull { it.name?.getShortName() == name }

  private companion object {
    val INDENTATION = " ".repeat(2)

    const val ANNOTATION_NAME = "Dimen"
    const val ANNOTATION_PACKAGE = "com.parsuomash.affogato.unit.$ANNOTATION_NAME"
    const val ANNOTATION_PARAM_TYPE = "type"
    const val ANNOTATION_PARAM_VALUES = "values"
  }
}

private operator fun String.times(i: Int): String = repeat(i)
