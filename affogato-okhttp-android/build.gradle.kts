plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.2"
  namespace = "com.parsuomash.affogato.okhttp.android"

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
  // OkHttp3 ---------------------------------------------------------------------------------------
  api("com.squareup.okhttp3:okhttp:4.11.0")
  api("com.squareup.okhttp3:logging-interceptor:4.11.0")
  testApi("com.squareup.okhttp3:mockwebserver:4.11.0")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-okhttp-android"
        version = "1.7.0"

        from(components["release"])
      }
    }
  }
}
