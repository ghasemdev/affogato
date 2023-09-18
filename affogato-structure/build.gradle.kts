plugins {
  alias(libs.plugins.kotlin.serialization)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/library-build.gradle")
}

dependencies {
  "implementation"(project(AffogatoModules.coreKtx))

  // Serialization ---------------------------------------------------------------------------------
  "implementation"(libs.kotlinx.serialization.json)
  // Phone Checker ---------------------------------------------------------------------------------
  "implementation"(libs.libphonenumber)

  // Test ------------------------------------------------------------------------------------------
  "testImplementation"(libs.bundles.junit5)
  "testRuntimeOnly"(libs.junit.jupiter.engine)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-structure"
        version = libs.versions.affogato.get()

        from(components["java"])
      }
    }
  }
}
