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

dependencies {
  // KSP -------------------------------------------------------------------------------------------
  implementation("com.google.devtools.ksp:symbol-processing-api:1.8.22-1.0.11")
  implementation("com.fleshgrinder.kotlin:case-format:0.2.0")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.5")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-hilt-binding-processor"
        version = "1.7.0"

        from(components["java"])
      }
    }
  }
}
