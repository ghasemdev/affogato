plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.0"
  defaultConfig {
    minSdk = 17
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
  // AppMetrica ------------------------------------------------------------------------------------
  api("com.yandex.android:mobmetricalib:5.0.1")
  api("com.yandex.android:mobmetricapushlib:2.2.0")
  api("com.yandex.android:appmetricapush-provider-hms:2.2.0")

  // Serialization ---------------------------------------------------------------------------------
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-metrica-ktx"
        version = "1.5.1"

        from(components["release"])
      }
    }
  }
}
