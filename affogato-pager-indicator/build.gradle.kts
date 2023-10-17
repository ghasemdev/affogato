import Configuration.MIN_SDK

plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.pager.indicator"

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
  // Compose -------------------------------------------------------------------------------------
  implementation(libs.compose.ui.alpha)
  implementation(libs.compose.foundation.alpha)
  implementation(libs.compose.material.alpha)
  implementation(libs.compose.ui.tooling.alpha)
  debugImplementation(libs.compose.ui.tooling.alpha)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-pager-indicator"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
