plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.hilt.binding"
}

dependencies {
  // Hilt ------------------------------------------------------------------------------------------
  api(libs.hilt.android)

  // Test ------------------------------------------------------------------------------------------
  testImplementation(libs.bundles.junit5)
  testRuntimeOnly(libs.junit.jupiter.engine)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-hilt-binding"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
