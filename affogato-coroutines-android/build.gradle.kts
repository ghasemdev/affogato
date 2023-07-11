plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.2"
  namespace = "com.parsuomash.affogato.coroutines.android"

  defaultConfig {
    minSdk = 16
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
  }
}

dependencies {
  api(project(":affogato-coroutines-core"))

  // Coroutines ------------------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-coroutines-android"
        version = "1.7.0"

        from(components["release"])
      }
    }
  }
}
