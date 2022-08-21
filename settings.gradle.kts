pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven("https://jitpack.io")
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
  }
}
rootProject.name = "affogato"
include(":sample")
include(":affogato-core-ktx")
include(":affogato-coroutines-android")
include(":affogato-coroutines-core")
include(":affogato-metrica-ktx")
include(":affogato-structure")
include(":affogato-unit")
include(":affogato-unit-processor")
