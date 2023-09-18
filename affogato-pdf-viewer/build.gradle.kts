import Configuration.MIN_SDK

plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.kotlin.parcelize.get().pluginId)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.pdfviewer"

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
  implementation(libs.core.ktx)
  // Compose ---------------------------------------------------------------------------------------
  implementation(libs.compose.ui)
  implementation(libs.compose.foundation)
  implementation(libs.compose.material)
  implementation(libs.compose.ui.tooling)
  implementation(libs.accompanist.pager)
  debugImplementation(libs.compose.ui.tooling)
  // Network ---------------------------------------------------------------------------------------
  implementation(libs.okhttp)
  implementation(libs.retrofit)
  // PdfBox  ---------------------------------------------------------------------------------------
  api(libs.pdfbox)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-pdfviewer"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
