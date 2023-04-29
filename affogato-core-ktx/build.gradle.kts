import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-library")
  kotlin("jvm")
  id("maven-publish")
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
  // Serialization ---------------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
  // Immutable Collections -------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")
  // DateTime --------------------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("io.kotlintest:kotlintest-core:3.4.2")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("org.hamcrest:hamcrest:2.2")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-core-ktx"
        version = "1.6.0"

        from(components["java"])
      }
    }
  }
}
