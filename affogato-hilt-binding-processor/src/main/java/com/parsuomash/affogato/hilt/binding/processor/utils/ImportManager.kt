package com.parsuomash.affogato.hilt.binding.processor.utils

internal class ImportManager {

  private val imports = mutableListOf<String>()

  init {
    imports.add(DAGGER_BINDS)
    imports.add(DAGGER_MODULE)
    imports.add(HILT_INSTALL_IN)
    imports.add(HILT_ORIGINATING_ELEMENT)
  }

  fun append(dependency: String) {
    imports.add(dependency)
  }

  fun finalize(): String = imports.sorted().joinToString(separator = "\n") { "import $it" }

  companion object {
    const val DAGGER_BINDS = "dagger.Binds"
    const val DAGGER_MODULE = "dagger.Module"
    const val HILT_INSTALL_IN = "dagger.hilt.InstallIn"
    const val HILT_ORIGINATING_ELEMENT = "dagger.hilt.codegen.OriginatingElement"
    const val HILT_SINGLETON_COMPONENT = "dagger.hilt.components.SingletonComponent"
    const val INJECT_SINGLETON = "javax.inject.Singleton"
    const val INJECT_NAMED = "javax.inject.Named"
  }
}
