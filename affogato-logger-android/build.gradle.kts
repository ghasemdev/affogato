plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.logger.android"
}

dependencies {
  implementation(libs.timber)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-logger-android"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
