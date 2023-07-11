@file:Suppress("UnstableApiUsage")

plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.2"
  namespace = "com.parsuomash.affogato.unit"

  defaultConfig {
    minSdk = 21
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    apiVersion = "1.8"
    languageVersion = "1.8"
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
    kotlinCompilerExtensionVersion = "1.4.8"
  }
  lint {
    baseline = file("$rootDir/config/lint/lint-baseline.xml")
  }
}

dependencies {
  // Window ----------------------------------------------------------------------------------------
  api("androidx.window:window:1.1.0")

  // Compose -------------------------------------------------------------------------------------
  implementation("androidx.compose.ui:ui:1.4.3")
  implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.5")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-unit"
        version = "1.7.0"

        from(components["release"])
      }
    }
  }
}
