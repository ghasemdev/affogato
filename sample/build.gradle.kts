plugins {
  id("com.android.application")
  kotlin("android")
  // Kotlin Serialization
  kotlin("plugin.serialization") version "1.7.10"
  // Kotlin Parcelize
  id("kotlin-parcelize")
  // Kotlin Symbol Processor
  id("com.google.devtools.ksp") version "1.7.10-1.0.6"
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.0"

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
  packagingOptions {
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
  implementation(project(":affogato-unit"))
  ksp(project(":affogato-unit-processor"))

  // AndroidX ------------------------------------------------------------------------------------
  implementation("androidx.core:core-ktx:1.8.0")

  // Compose ---------------------------------------------------------------------------------------
  val composeVersion = "1.2.1"

  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.compose.ui:ui-util:$composeVersion")

  implementation("androidx.compose.foundation:foundation:$composeVersion")

  implementation("androidx.compose.material:material:$composeVersion")
  implementation("androidx.compose.material:material-icons-core:$composeVersion")
  implementation("androidx.compose.material:material-icons-extended:$composeVersion")

  implementation("androidx.compose.ui:ui-tooling:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")

  implementation("androidx.compose.animation:animation:$composeVersion")
  implementation("androidx.compose.animation:animation-graphics:$composeVersion")

  implementation("androidx.compose.runtime:runtime:$composeVersion")
  implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
  implementation("androidx.compose.compiler:compiler:$composeVersion")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
  implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha01")

  implementation("androidx.paging:paging-compose:1.0.0-alpha15")
  implementation("androidx.activity:activity-compose:1.5.1")
  implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
  androidTestImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

  debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
  debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

  // Accompanist -----------------------------------------------------------------------------------
  val accompanistVersion = "0.25.1"

  implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
  implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.3")

  // Instrumentation Test --------------------------------------------------------------------------
  androidTestImplementation("junit:junit:4.13.2")
  androidTestImplementation("com.google.truth:truth:1.1.3")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")

  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

  // Leakcanary ------------------------------------------------------------------------------------
  debugImplementation("com.squareup.leakcanary:leakcanary-android:2.9.1")
}
