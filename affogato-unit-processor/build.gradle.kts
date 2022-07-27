plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm")
  id("maven-publish")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  // KSP -----------------------------------------------------------------------------------------
  implementation("com.google.devtools.ksp:symbol-processing-api:1.7.10-1.0.6")
  implementation("com.fleshgrinder.kotlin:case-format:0.2.0")

  // Test ----------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.3")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("java") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-unit-processor"
        version = "1.0.0-beta05"

        from(components["java"])
      }
    }
  }
}
