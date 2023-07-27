plugins {
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/library-build.gradle")
}

dependencies {
  "implementation"(project(AffogatoModules.coreKtx))

  // Coroutines ------------------------------------------------------------------------------------
  "api"(libs.kotlinx.coroutines.core)
  "api"(libs.kotlinx.coroutines.test)

  // Test ------------------------------------------------------------------------------------------
  "testImplementation"(libs.bundles.junit5)
  "testRuntimeOnly"(libs.junit.jupiter.engine)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-coroutines-core"
        version = libs.versions.affogato.get()

        from(components["java"])
      }
    }
  }
}
