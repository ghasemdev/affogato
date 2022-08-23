import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-library")
  kotlin("jvm")
  id("maven-publish")
  kotlin("plugin.serialization") version "1.7.10"
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

tasks.test {
  useJUnitPlatform()
}

dependencies {
  implementation(project(":affogato-core-ktx"))

  // Serialization ---------------------------------------------------------------------------------
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
  // Phone Checker ---------------------------------------------------------------------------------
  implementation("com.googlecode.libphonenumber:libphonenumber:8.12.54")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-structure"
        version = "1.5.1"

        from(components["java"])
      }
    }
  }
}
