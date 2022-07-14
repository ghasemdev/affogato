@file:Suppress("ForbiddenClassName")

package com.parsuomash.affogato.unit.processor.internal

import com.fleshgrinder.extensions.kotlin.toLowerCamelCase
import com.fleshgrinder.extensions.kotlin.toUpperCamelCase
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSValueArgument
import com.google.devtools.ksp.validate
import com.parsuomash.affogato.unit.processor.utils.UnitValidator

internal class UnitSymbolProcessor(
    private val config: UnitConfig,
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    private val declarations = mutableListOf<KSPropertyDeclaration>()
    private val visitor = UnitVisitor(declarations)

    private val unitTypes: List<String?>
        get() = declarations.map {
            it.annotations.getValue<String>(ANNOTATION_PARAM_TYPE)?.lowercase()?.trim()
        }

    private val unitValues: List<List<*>?>
        get() = declarations.map {
            it.annotations.getValues(ANNOTATION_PARAM_VALUES)
        }

    private val unitClassNames: List<String?>
        get() = declarations.map { it.getClassQualifiedName() }

    private val unitNames: List<String?>
        get() = declarations.map { it.simpleName.getShortName() }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        resolver.getSymbolsWithAnnotation(ANNOTATION_PACKAGE)
            .filter { it is KSPropertyDeclaration && it.validate() }
            .forEach { it.accept(visitor, Unit) }

        return emptyList()
    }

    override fun finish() {
        if (!UnitValidator(unitTypes, unitValues, unitClassNames).validate(logger)) return

        val fileName = "${config.moduleName.toUpperCamelCase()}Strings"
        val stringsName = "${config.moduleName.toLowerCamelCase()}Strings"
        val visibility = if (config.internalVisibility) "internal" else "public"

//        val defaultLanguageTag = declarations
//            .firstNotNullOfOrNull { it.annotations.getDefaultLanguageTag() }
//            ?.let { "\"$it\"" }
//            ?: "Locale.current.toLanguageTag()"
//
//        val defaultStrings = declarations
//            .first { it.annotations.getValue<Boolean>(ANNOTATION_PARAM_DEFAULT) == true }
//
//        val packagesOutput = declarations
//            .mapNotNull { it.qualifiedName?.asString() }
//            .plus(defaultStrings.getClassQualifiedName())
//            .joinToString(separator = "\n") { packageName -> "import $packageName" }
//
//        val stringsClassOutput = defaultStrings.getClassSimpleName()
//
//        val defaultStringsOutput = defaultStrings.simpleName.getShortName()
//
//        val translationMappingOutput = declarations.map {
//            it.annotations.getValue<String>(ANNOTATION_PARAM_LANGUAGE_TAG)!! to
//                it.simpleName.getShortName()
//        }.joinToString(",\n") { (languageTag, property) ->
//            "$INDENTATION\"$languageTag\" to $property"
//        }
//
//        codeGenerator.createNewFile(
//            dependencies = Dependencies(
//                aggregating = true,
//                sources = declarations.map { it.containingFile!! }.toTypedArray()
//            ),
//            packageName = config.packageName,
//            fileName = fileName
//        ).use { stream ->
//            stream.write(
//                """
//                |package ${config.packageName}
//                |
//                |import androidx.compose.runtime.Composable
//                |import androidx.compose.runtime.staticCompositionLocalOf
//                |import androidx.compose.ui.text.intl.Locale
//                |import cafe.adriel.lyricist.Lyricist
//                |import cafe.adriel.lyricist.LanguageTag
//                |import cafe.adriel.lyricist.rememberStrings
//                |import cafe.adriel.lyricist.ProvideStrings
//                |$packagesOutput
//                |
//                |$visibility val $stringsName = mapOf<LanguageTag, $stringsClassOutput>(
//                |$translationMappingOutput
//                |)
//                |
//                |$visibility val Local$fileName = staticCompositionLocalOf { $defaultStringsOutput }
//                |
//                |@Composable
//                |$visibility fun remember$fileName(
//                |    languageTag: LanguageTag = $defaultLanguageTag
//                |): Lyricist<$stringsClassOutput> =
//                |    rememberStrings($stringsName, languageTag)
//                |
//                |@Composable
//                |$visibility fun Provide$fileName(
//                |    lyricist: Lyricist<$stringsClassOutput> = remember$fileName(),
//                |    content: @Composable () -> Unit
//                |) {
//                |    ProvideStrings(lyricist, Local$fileName, content)
//                |}
//                """.trimMargin().toByteArray()
//            )
//        }
    }

    private fun KSPropertyDeclaration.getClassSimpleName(): String? =
        getter?.returnType?.resolve()?.declaration?.simpleName?.asString()

    private fun KSPropertyDeclaration.getClassQualifiedName(): String? =
        getter?.returnType?.resolve()?.declaration?.qualifiedName?.asString()

    private fun KSPropertyDeclaration.getClassQualified(): String? =
        getter?.returnType?.resolve()?.declaration?.qualifiedName?.getQualifier()

    private fun Sequence<KSAnnotation>.getDefaultLanguageTag(): String? =
        firstOrNull {
            withName(ANNOTATION_NAME)
                ?.arguments
                ?.withName(ANNOTATION_PARAM_DEFAULT)
                ?.value == true
        }?.arguments
            ?.withName(ANNOTATION_PARAM_LANGUAGE_TAG)
            ?.value as? String

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
        val INDENTATION = " ".repeat(4)

        const val ANNOTATION_NAME = "Unit"
        const val ANNOTATION_PACKAGE = "com.parsuomash.affogato.unit.$ANNOTATION_NAME"
        const val ANNOTATION_PARAM_LANGUAGE_TAG = "languageTag"
        const val ANNOTATION_PARAM_DEFAULT = "default"
        const val ANNOTATION_PARAM_TYPE = "type"
        const val ANNOTATION_PARAM_VALUES = "values"
    }
}
