plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.2"
  namespace = "com.parsuomash.affogato.hilt.binding"

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
  // Hilt ------------------------------------------------------------------------------------------
  api("com.google.dagger:hilt-android:2.46.1")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("com.google.truth:truth:1.1.5")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-hilt-binding"
        version = "1.7.0"

        from(components["release"])
      }
    }
  }
}
