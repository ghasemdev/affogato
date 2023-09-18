plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.coroutines.android"
}

dependencies {
  api(project(AffogatoModules.coroutinesCore))

  // Coroutines ------------------------------------------------------------------------------------
  api(libs.bundles.kotlinx.coroutines)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-coroutines-android"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
