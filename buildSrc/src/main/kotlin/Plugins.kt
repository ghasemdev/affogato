object Plugins {
  object Detekt {
    const val version = "1.23.0"
    const val value = "io.gitlab.arturbosch.detekt"
    const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
  }

  object Dokka {
    private const val version = "1.8.20"
    const val value = "org.jetbrains.dokka"
    const val KotlinAsJavaPlugin = "org.jetbrains.dokka:kotlin-as-java-plugin:$version"
  }

  object Kover {
    const val value = "org.jetbrains.kotlinx.kover"
  }
}
