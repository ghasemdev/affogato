plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.metrica.ktx"

  defaultConfig {
    minSdk = 17
  }
}

dependencies {
  // AppMetrica ------------------------------------------------------------------------------------
  api(libs.bundles.metrica)
  // Serialization ---------------------------------------------------------------------------------
  implementation(libs.kotlinx.serialization.json)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-metrica-ktx"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
