plugins {
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/library-build.gradle")
}

dependencies {
  // KSP -------------------------------------------------------------------------------------------
  "implementation"(libs.bundles.processing)
  // Test ------------------------------------------------------------------------------------------
  "testImplementation"(libs.bundles.junit4)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-hilt-binding-processor"
        version = libs.versions.affogato.get()

        from(components["java"])
      }
    }
  }
}
