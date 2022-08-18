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
  // KSP -------------------------------------------------------------------------------------------
  implementation("com.google.devtools.ksp:symbol-processing-api:1.7.20-Beta-1.0.6")
  implementation("com.fleshgrinder.kotlin:case-format:0.2.0")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.3")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("java") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-unit-processor"
        version = "1.3.0"

        from(components["java"])
      }
    }
  }
}
