plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.0"
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

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-logger-android"
        version = "1.5.0"

        from(components["release"])
      }
    }
  }
}
