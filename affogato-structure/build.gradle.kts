import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-library")
  kotlin("jvm")
  id("maven-publish")
  kotlin("plugin.serialization") version "1.8.22"
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    apiVersion = "1.8"
    languageVersion = "1.8"
    jvmTarget = "17"
  }
}

tasks.test {
  useJUnitPlatform()
}

dependencies {
  implementation(project(":affogato-core-ktx"))

  // Serialization ---------------------------------------------------------------------------------
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
  // Phone Checker ---------------------------------------------------------------------------------
  implementation("com.googlecode.libphonenumber:libphonenumber:8.13.13")

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
        artifactId = "affogato-structure"
        version = "1.7.0"

        from(components["java"])
      }
    }
  }
}
