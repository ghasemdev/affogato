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
    apiVersion = "1.9"
    languageVersion = "1.9"
    jvmTarget = "17"
  }
}

dependencies {
  // KSP -------------------------------------------------------------------------------------------
  implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.12")
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
        artifactId = "affogato-unit-processor"
        version = "1.7.2"

        from(components["java"])
      }
    }
  }
}
