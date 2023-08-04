import Configuration.APPLICATION_ID
import Configuration.BUILD_TOOLS_VERSION
import Configuration.COMPILE_SDK
import Configuration.MIN_SDK
import Configuration.TARGET_SDK
import Configuration.VERSION_CODE
import Configuration.VERSION_NAME

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.ksp)
  id(libs.plugins.kotlin.parcelize.get().pluginId)
}

android {
  compileSdk = COMPILE_SDK
  buildToolsVersion = BUILD_TOOLS_VERSION
  namespace = APPLICATION_ID

  defaultConfig {
    applicationId = APPLICATION_ID
    minSdk = MIN_SDK
    targetSdk = TARGET_SDK
    versionCode = VERSION_CODE
    versionName = VERSION_NAME
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
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
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
  implementation(project(AffogatoModules.coreKtx))
  implementation(project(AffogatoModules.coroutinesAndroid))
  implementation(project(AffogatoModules.datepicker))
  implementation(project(AffogatoModules.unit))
  ksp(project(AffogatoModules.unitProcessor))

  implementation(project(AffogatoModules.hiltBinding))
  ksp(project(AffogatoModules.hiltBindingProcessor))

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
