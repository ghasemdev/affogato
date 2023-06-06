package com.parsuomash.affogato.hilt.binding.processor.internal

import com.fleshgrinder.extensions.kotlin.toLowerCamelCase
import com.fleshgrinder.extensions.kotlin.toUpperCamelCase
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSValueArgument
import com.google.devtools.ksp.symbol.Modifier
import com.google.devtools.ksp.validate
import com.parsuomash.affogato.hilt.binding.processor.utils.ErrorMassage.ERROR_MASSAGE_HILT_COMPONENT
import com.parsuomash.affogato.hilt.binding.processor.utils.ErrorMassage.ERROR_MASSAGE_HILT_SCOPE
import com.parsuomash.affogato.hilt.binding.processor.utils.ErrorMassage.ERROR_MESSAGE_ANNOTATION_CLASS
import com.parsuomash.affogato.hilt.binding.processor.utils.ErrorMassage.ERROR_MESSAGE_QUALIFIER_ANNOTATION
import com.parsuomash.affogato.hilt.binding.processor.utils.ErrorMassage.namedQualifier
import com.parsuomash.affogato.hilt.binding.processor.utils.ErrorMassage.supperType
import com.parsuomash.affogato.hilt.binding.processor.utils.ImportManager
import com.parsuomash.affogato.hilt.binding.processor.utils.ImportManager.Companion.HILT_SINGLETON_COMPONENT
import com.parsuomash.affogato.hilt.binding.processor.utils.ImportManager.Companion.INJECT_NAMED
import com.parsuomash.affogato.hilt.binding.processor.utils.ImportManager.Companion.INJECT_SINGLETON

internal class HiltBindingSymbolProcessor(
  private val config: HiltBindingConfig,
  private val codeGenerator: CodeGenerator,
  private val logger: KSPLogger
) : SymbolProcessor {
  private val singletonBindingDeclarations = mutableListOf<KSClassDeclaration>()
  private val hiltBindingDeclarations = mutableListOf<KSClassDeclaration>()

  private val singletonBindingVisitor = SingletonBindingVisitor(singletonBindingDeclarations)
  private val hiltBindingVisitor = HiltBindingVisitor(hiltBindingDeclarations)

  override fun process(resolver: Resolver): List<KSAnnotated> {
    with(resolver) {
      singletonBindingProcess()
      hiltBindingProcess()
    }
    return emptyList()
  }

  override fun finish() {
    singletonBindingFinish()
    hiltBindingFinish()
  }

  private fun singletonBindingFinish() {
    singletonBindingDeclarations.forEach { declaration ->
      val className = declaration.simpleName.getShortName()
      val superType = declaration.superTypes.firstOrNull()
      if (superType == null || superType.toString() == "Any") {
        logger.error(
          "${declaration.location} -> " +
            supperType(className, SINGLETON_BINDING_ANNOTATION)
        )
        return
      }

      var hasInjectNamed = false
      val packageName = declaration.packageName.asString()
      val annotations = StringBuilder().apply {
        append(INDENTATION)
        appendLine("@Singleton")
      }
      val importManager = ImportManager().apply {
        append(HILT_SINGLETON_COMPONENT)
        append(INJECT_SINGLETON)
      }

      val hiltNamed = declaration
        .annotations
        .getValue<String>(SINGLETON_BINDING_ANNOTATION, ANNOTATION_NAMED)

      val hiltQualifier = declaration
        .annotations
        .getValue(SINGLETON_BINDING_ANNOTATION, ANNOTATION_QUALIFIER)

      if (!hiltNamed.isNullOrEmpty()) {
        annotations
          .append(INDENTATION)
          .appendLine("@Named(\"$hiltNamed\")")
        importManager.append(INJECT_NAMED)
        hasInjectNamed = true
      }

      if (hiltQualifier != null && hiltQualifier.toString() != "Any") {
        if (hasInjectNamed) {
          logger.error("${declaration.location} -> ${namedQualifier(SINGLETON_BINDING_ANNOTATION)}")
          return
        }

        val hiltQualifierDeclaration = (hiltQualifier as KSType).declaration

        if (Modifier.ANNOTATION !in hiltQualifierDeclaration.modifiers) {
          logger.error("${declaration.location} -> $ERROR_MESSAGE_ANNOTATION_CLASS")
          return
        }
        if (QUALIFIER !in hiltQualifierDeclaration.annotations.toList().map { it.toString() }) {
          logger.error("${declaration.location} -> $ERROR_MESSAGE_QUALIFIER_ANNOTATION")
          return
        }

        annotations
          .append(INDENTATION)
          .appendLine("@$hiltQualifier")

        val qualifierPackageName = hiltQualifierDeclaration.packageName.asString()
        if (packageName != qualifierPackageName) {
          importManager.append("$qualifierPackageName.$hiltQualifier")
        }
      }

      val superTypePackageName = superType.resolve().declaration.packageName.asString()
      if (packageName != superTypePackageName) {
        importManager.append("$superTypePackageName.$superType")
      }

      writeToFile(
        className = className,
        packageName = packageName,
        imports = importManager.finalize(),
        annotations = annotations.toString(),
        superType = superType.toString(),
        component = "SingletonComponent",
      )
    }
  }

  private fun hiltBindingFinish() {
    hiltBindingDeclarations.forEach { declaration ->
      val className = declaration.simpleName.getShortName()
      val superType = declaration.superTypes.firstOrNull()
      if (superType == null || superType.toString() == "Any") {
        logger.error("${declaration.location} -> ${supperType(className, HILT_BINDING_ANNOTATION)}")
        return
      }

      var hasInjectNamed = false
      val packageName = declaration.packageName.asString()
      val annotations = StringBuilder()
      val importManager = ImportManager()

      val hiltNamed = declaration
        .annotations
        .getValue<String>(HILT_BINDING_ANNOTATION, ANNOTATION_NAMED)

      val hiltQualifier = declaration
        .annotations
        .getValue(HILT_BINDING_ANNOTATION, ANNOTATION_QUALIFIER)

      val hiltComponent = declaration
        .annotations
        .getValue(HILT_BINDING_ANNOTATION, ANNOTATION_COMPONENT)

      val hiltScope = declaration
        .annotations
        .getValue(HILT_BINDING_ANNOTATION, ANNOTATION_SCOPE)

      if (!hiltNamed.isNullOrEmpty()) {
        annotations
          .append(INDENTATION)
          .appendLine("@Named(\"$hiltNamed\")")
        importManager.append(INJECT_NAMED)
        hasInjectNamed = true
      }

      if (hiltQualifier != null && hiltQualifier.toString() != "Any") {
        if (hasInjectNamed) {
          logger.error("${declaration.location} -> ${namedQualifier(HILT_BINDING_ANNOTATION)}")
          return
        }

        val hiltQualifierDeclaration = (hiltQualifier as KSType).declaration

        if (Modifier.ANNOTATION !in hiltQualifierDeclaration.modifiers) {
          logger.error("${declaration.location} -> $ERROR_MESSAGE_ANNOTATION_CLASS")
          return
        }
        if (QUALIFIER !in hiltQualifierDeclaration.annotations.toList().map { it.toString() }) {
          logger.error("${declaration.location} -> $ERROR_MESSAGE_QUALIFIER_ANNOTATION")
          return
        }

        annotations
          .append(INDENTATION)
          .appendLine("@$hiltQualifier")

        val qualifierPackageName = hiltQualifierDeclaration.packageName.asString()
        if (packageName != qualifierPackageName) {
          importManager.append("$qualifierPackageName.$hiltQualifier")
        }
      }

      if (hiltComponent != null && hiltComponent.toString() in validHiltComponents) {
        val hiltComponentDeclaration = (hiltComponent as KSType).declaration

        if (COMPONENT !in hiltComponentDeclaration.annotations.toList().map { it.toString() }) {
          logger.error("${declaration.location} -> $ERROR_MASSAGE_HILT_COMPONENT")
          return
        }

        val componentPackageName = hiltComponentDeclaration.packageName.asString()
        importManager.append("$componentPackageName.$hiltComponent")
      } else {
        logger.error("${declaration.location} -> $ERROR_MASSAGE_HILT_COMPONENT")
        return
      }

      if (hiltScope != null && hiltScope.toString() != "Any") {
        if (hiltScope.toString() in validHiltScopes) {
          val hiltScopeDeclaration = (hiltScope as KSType).declaration

          if (SCOPE !in hiltScopeDeclaration.annotations.toList().map { it.toString() }) {
            logger.error("${declaration.location} -> $ERROR_MASSAGE_HILT_SCOPE")
            return
          }

          annotations
            .append(INDENTATION)
            .appendLine("@$hiltScope")

          val scopePackageName = hiltScopeDeclaration.packageName.asString()
          importManager.append("$scopePackageName.$hiltScope")
        } else {
          logger.error("${declaration.location} -> $ERROR_MASSAGE_HILT_SCOPE")
          return
        }
      }

      val superTypePackageName = superType.resolve().declaration.packageName.asString()
      if (packageName != superTypePackageName) {
        importManager.append("$superTypePackageName.$superType")
      }

      writeToFile(
        className = className,
        packageName = packageName,
        imports = importManager.finalize(),
        annotations = annotations.toString(),
        superType = superType.toString(),
        component = hiltComponent.toString(),
      )
    }
  }

  private fun writeToFile(
    packageName: String,
    className: String,
    imports: String,
    annotations: String,
    superType: String,
    component: String
  ) {
    val fileName = "${config.moduleName.toUpperCamelCase()}${className}Module"
    val visibility = if (config.internalVisibility) "internal " else ""

    codeGenerator.createNewFile(
      dependencies = Dependencies(
        aggregating = true,
        sources = singletonBindingDeclarations.map { it.containingFile!! }.toTypedArray()
      ),
      packageName = packageName,
      fileName = fileName
    ).use { stream ->
      stream.write(
        """
          |package $packageName
          |
          |${imports}
          |
          |@Module
          |@InstallIn($component::class)
          |@OriginatingElement(
          |  topLevelClass = $className::class
          |)
          |${visibility}interface ${className}Module {
          |  @Binds
          |$annotations${INDENTATION}fun bind${superType}(
          |    ${className.toLowerCamelCase()}: $className
          |  ): $superType
          |}
          |
          """.trimMargin().toByteArray()
      )
    }
  }

  private fun Resolver.hiltBindingProcess() {
    getSymbolsWithAnnotation(HILT_BINDING_ANNOTATION_PACKAGE)
      .filter { it is KSClassDeclaration && it.validate() }
      .forEach { it.accept(hiltBindingVisitor, Unit) }
  }

  private fun Resolver.singletonBindingProcess() {
    getSymbolsWithAnnotation(SINGLETON_BINDING_ANNOTATION_PACKAGE)
      .filter { it is KSClassDeclaration && it.validate() }
      .forEach { it.accept(singletonBindingVisitor, Unit) }
  }

  @JvmName("getValueWithTypeCasting")
  private inline fun <reified T> Sequence<KSAnnotation>.getValue(
    annotationName: String,
    argumentName: String
  ): T? = withName(annotationName)
    ?.arguments
    ?.withName(argumentName)
    ?.value as? T

  private fun Sequence<KSAnnotation>.getValue(
    annotationName: String,
    argumentName: String
  ) = withName(annotationName)
    ?.arguments
    ?.withName(argumentName)
    ?.value

  private fun Sequence<KSAnnotation>.withName(annotationName: String): KSAnnotation? =
    firstOrNull { it.shortName.getShortName() == annotationName }

  private fun List<KSValueArgument>.withName(argumentName: String): KSValueArgument? =
    firstOrNull { it.name?.getShortName() == argumentName }

  private companion object {
    val INDENTATION = " ".repeat(2)
    val validHiltComponents = listOf(
      "SingletonComponent",
      "ActivityComponent",
      "ActivityRetainedComponent",
      "FragmentComponent",
      "ServiceComponent",
      "ViewComponent",
      "ViewModelComponent",
      "ViewWithFragmentComponent"
    )
    val validHiltScopes = listOf(
      "Singleton",
      "ActivityRetainedScoped",
      "ActivityScoped",
      "FragmentScoped",
      "ServiceScoped",
      "ViewModelScoped",
      "ViewScoped"
    )

    const val PACKAGE_NAME = "com.parsuomash.affogato.hilt.binding."
    const val HILT_BINDING_ANNOTATION = "HiltBinding"
    const val SINGLETON_BINDING_ANNOTATION = "SingletonBinding"

    const val HILT_BINDING_ANNOTATION_PACKAGE = PACKAGE_NAME + HILT_BINDING_ANNOTATION
    const val SINGLETON_BINDING_ANNOTATION_PACKAGE = PACKAGE_NAME + SINGLETON_BINDING_ANNOTATION

    const val ANNOTATION_COMPONENT = "component"
    const val ANNOTATION_SCOPE = "scope"
    const val ANNOTATION_QUALIFIER = "qualifier"
    const val ANNOTATION_NAMED = "named"

    const val COMPONENT = "@DefineComponent"
    const val SCOPE = "@Scope"
    const val QUALIFIER = "@Qualifier"
  }
}

private operator fun String.times(i: Int): String = repeat(i)
