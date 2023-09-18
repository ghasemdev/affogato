plugins {
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/library-build.gradle")
}

dependencies {
  // Serialization ---------------------------------------------------------------------------------
  "api"(libs.kotlinx.serialization.json)
  // Immutable Collections -------------------------------------------------------------------------
  "api"(libs.kotlinx.collections.immutable)
  // DateTime --------------------------------------------------------------------------------------
  "api"(libs.kotlinx.datetime)

  // Test ------------------------------------------------------------------------------------------
  "testImplementation"(libs.kotlintest.core)
  "testImplementation"(libs.hamcrest)
  "testImplementation"(libs.bundles.junit5)
  "testRuntimeOnly"(libs.junit.jupiter.engine)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-core-ktx"
        version = libs.versions.affogato.get()

        from(components["java"])
      }
    }
  }
}
