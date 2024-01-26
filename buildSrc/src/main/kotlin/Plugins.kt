object Plugins {
  object Detekt {
    const val version = "1.23.4"
    const val value = "io.gitlab.arturbosch.detekt"
    const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
  }

  object Dokka {
    private const val version = "1.9.10"
    const val value = "org.jetbrains.dokka"
    const val AndroidDocPlugin = "org.jetbrains.dokka:android-documentation-plugin:$version"
  }

  object Kover {
    const val value = "org.jetbrains.kotlinx.kover"
  }
}
