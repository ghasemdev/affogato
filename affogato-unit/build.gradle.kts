plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("maven-publish")
}

android {
  compileSdk = 32

  defaultConfig {
    minSdk = 21
    targetSdk = 32

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
    jvmTarget = "11"
    languageVersion = "1.7"
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
    kotlinCompilerExtensionVersion = "1.2.0"
  }
}

dependencies {
  // Window ----------------------------------------------------------------------------------------
  implementation("androidx.window:window:1.0.0")

  // Compose -------------------------------------------------------------------------------------
  val composeVersion = "1.2.0-rc03"

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
        version = "1.0.0-beta05"

        from(components["release"])
      }
    }
  }
}
