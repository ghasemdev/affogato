import Configuration.MIN_SDK

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
    minSdk = MIN_SDK
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
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
  implementation(libs.lifecycle.runtime.compose)

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
