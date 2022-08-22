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
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    apiVersion = "1.7"
    languageVersion = "1.7"
    jvmTarget = "11"
  }
}

dependencies {
  api(project(":affogato-coroutines-core"))

  // Coroutines ------------------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-coroutines-android"
        version = "1.5.0"

        from(components["release"])
      }
    }
  }
}
