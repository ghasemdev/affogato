@file:Suppress("ForbiddenClassName")

package com.parsuomash.affogato.unit.processor.internal

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

internal class UnitSymbolProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        with(environment) {
            UnitSymbolProcessor(
                config = UnitConfig(
                    packageName = options[ARG_PACKAGE_NAME] ?: DEFAULT_PACKAGE_NAME,
                    moduleName = options[ARG_MODULE_NAME].orEmpty(),
                    internalVisibility = options[ARG_INTERNAL_VISIBILITY].toBoolean()
                ),
                codeGenerator = codeGenerator,
                logger = logger
            )
        }

    private companion object {
        const val ARG_PACKAGE_NAME = "affogato.packageName"
        const val ARG_MODULE_NAME = "affogato.moduleName"
        const val ARG_INTERNAL_VISIBILITY = "affogato.internalVisibility"

        const val DEFAULT_PACKAGE_NAME = "com.parsuomash.affogato"
    }
}
