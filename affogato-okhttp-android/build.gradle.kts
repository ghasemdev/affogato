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

dependencies {
  // define a BOM and its version
  implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))

  // define any required OkHttp artifacts without version
  api("com.squareup.okhttp3:okhttp")
  api("com.squareup.okhttp3:logging-interceptor")
  testApi("com.squareup.okhttp3:mockwebserver")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-okhttp-android"
        version = "1.5.0"

        from(components["release"])
      }
    }
  }
}
