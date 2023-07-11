plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
}

android {
  compileSdk = 33
  buildToolsVersion = "33.0.2"
  namespace = "com.parsuomash.affogato.metrica.ktx"

  defaultConfig {
    minSdk = 17
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    apiVersion = "1.8"
    languageVersion = "1.8"
    jvmTarget = "17"
  }
}

dependencies {
  // AppMetrica ------------------------------------------------------------------------------------
  api("com.yandex.android:mobmetricalib:5.3.0")
  api("com.yandex.android:mobmetricapushlib:2.2.0")
  api("com.yandex.android:appmetricapush-provider-hms:2.2.0")

  // Serialization ---------------------------------------------------------------------------------
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-metrica-ktx"
        version = "1.7.0"

        from(components["release"])
      }
    }
  }
}
