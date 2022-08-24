plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.0"

  defaultConfig {
    minSdk = 21
    targetSdk = 33
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    apiVersion = "1.7"
    languageVersion = "1.7"
    jvmTarget = "11"
    freeCompilerArgs = listOf(
      "-P",
      "plugin:androidx.compose.compiler.plugins.kotlin:" +
        "suppressKotlinVersionCompatibilityCheck=true"
    )
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.3.0"
  }
  lint {
    baseline = file("$rootDir/config/lint/lint-baseline.xml")
  }
}

dependencies {
  // Window ----------------------------------------------------------------------------------------
  api("androidx.window:window:1.0.0")

  // Compose -------------------------------------------------------------------------------------
  val composeVersion = "1.2.1"

  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha01")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.3")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-unit"
        version = "1.5.2"

        from(components["release"])
      }
    }
  }
}
