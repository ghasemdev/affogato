plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.unit"

  defaultConfig {
    minSdk = 21
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  lint {
    baseline = file("$rootDir/config/lint/lint-baseline.xml")
  }
}

dependencies {
  // Window ----------------------------------------------------------------------------------------
  api(libs.window)

  // Compose -------------------------------------------------------------------------------------
  implementation(libs.compose.ui)
  implementation(libs.compose.lifecycle.runtime)

  // Test ------------------------------------------------------------------------------------------
  testImplementation(libs.bundles.junit4)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-unit"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
