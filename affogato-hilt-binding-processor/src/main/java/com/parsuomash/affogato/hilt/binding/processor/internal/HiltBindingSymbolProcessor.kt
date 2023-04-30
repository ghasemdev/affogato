package com.parsuomash.affogato.hilt.binding.processor.internal

import com.fleshgrinder.extensions.kotlin.toUpperCamelCase
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSValueArgument
import com.google.devtools.ksp.validate

internal class HiltBindingSymbolProcessor(
  private val config: HiltBindingConfig,
  private val codeGenerator: CodeGenerator,
  private val logger: KSPLogger
) : SymbolProcessor {
  private val declarations = mutableListOf<KSClassDeclaration>()
  private val visitor = HiltBindingVisitor(declarations)

  private val hiltBindingPackage: List<String>
    get() = declarations.map { it.packageName.asString() }

//  private val dimenTypes: List<String?>
//    get() = declarations.map {
//      it.annotations.getValue<String>(ANNOTATION_PARAM_TYPE)?.lowercase()?.trim()
//    }

//  private val dimenValues: List<List<*>?>
//    get() = declarations.map {
//      it.annotations.getValues(ANNOTATION_PARAM_VALUES)
//    }

//  private val dimenClassNames: List<String?>
//    get() = declarations.map { it.getClassSimpleName() }
//
//  private val dimenClassQualifiedNames: List<String?>
//    get() = declarations.map { it.getClassQualifiedName() }

  private val hiltBindingNames: List<String?>
    get() = declarations.map { it.simpleName.getShortName() }

  override fun process(resolver: Resolver): List<KSAnnotated> {
    resolver.getSymbolsWithAnnotation(ANNOTATION_PACKAGE)
      .filter { it is KSClassDeclaration && it.validate() }
      .forEach { it.accept(visitor, Unit) }

    return emptyList()
  }

  override fun finish() {
    logger.error(hiltBindingPackage.toString())
    logger.error(hiltBindingNames.toString())
//    val validator = DimenValidator(dimenTypes, dimenValues, dimenClassQualifiedNames)
//    if (!validator.validate(logger)) return

    val fileName = "${config.moduleName.toUpperCamelCase()}HiltGenerated"
    val visibility = if (config.internalVisibility) "internal" else "public"

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
        |class Bar
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

    const val ANNOTATION_NAME = "HiltBinding"
    const val ANNOTATION_PACKAGE = "com.parsuomash.affogato.hilt.binding.$ANNOTATION_NAME"
  }
}

private operator fun String.times(i: Int): String = repeat(i)
