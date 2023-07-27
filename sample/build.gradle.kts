plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.ksp)
  id(libs.plugins.kotlin.parcelize.get().pluginId)
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.2"
  namespace = "com.parsuomash.affogato"

  defaultConfig {
    applicationId = "com.parsuomash.affogato"
    minSdk = 21
    targetSdk = 33
    versionCode = 1
    versionName = "1.0.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    apiVersion = "1.9"
    languageVersion = "1.9"
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.1"
  }
  packaging {
    resources.excludes.add("META-INF/AL2.0")
    resources.excludes.add("META-INF/LGPL2.1")
  }
  kotlin {
    sourceSets.debug {
      kotlin.srcDir("build/generated/ksp/debug/kotlin")
    }
    sourceSets.release {
      kotlin.srcDir("build/generated/ksp/release/kotlin")
    }
  }
  lint {
    baseline = file("$rootDir/config/lint/lint-baseline.xml")
  }
}

ksp {
  arg("affogato.packageName", "com.parsuomash.affogato.app")
}

dependencies {
  // Modules
  implementation(project(":affogato-core-ktx"))
  implementation(project(":affogato-coroutines-android"))
  implementation(project(":affogato-unit"))
  ksp(project(":affogato-unit-processor"))

  implementation(project(":affogato-hilt-binding"))
  ksp(project(":affogato-hilt-binding-processor"))

  // AndroidX ------------------------------------------------------------------------------------
  implementation(libs.core.ktx)

  // Compose ---------------------------------------------------------------------------------------
  implementation(libs.bundles.compose)

  androidTestImplementation(libs.compose.ui.test.junit4)
  debugImplementation(libs.compose.ui.tooling)
  debugImplementation(libs.compose.ui.test.manifest)

  // Accompanist -----------------------------------------------------------------------------------
  implementation(libs.bundles.accompanist)

  // Test ------------------------------------------------------------------------------------------
  testImplementation(libs.bundles.junit4)

  // Instrumentation Test --------------------------------------------------------------------------
  androidTestImplementation(libs.bundles.junit4)
  androidTestImplementation(libs.androidx.junit)

  androidTestImplementation(libs.espresso.core)

  // Leakcanary ------------------------------------------------------------------------------------
  debugImplementation(libs.leakcanary.android)
}
