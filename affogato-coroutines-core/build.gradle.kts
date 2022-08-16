import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-library")
  kotlin("jvm")
  id("maven-publish")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    apiVersion = "1.7"
    languageVersion = "1.7"
    jvmTarget = "11"
  }
}

dependencies {
  // Coroutines ------------------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("java") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-coroutines-core"
        version = "1.2.0"

        from(components["java"])
      }
    }
  }
}
