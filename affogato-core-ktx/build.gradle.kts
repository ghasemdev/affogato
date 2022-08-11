plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm")
  id("maven-publish")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
  useJUnitPlatform()
}

dependencies {
  // KotlinX Immutable Collections -----------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")

  // KotlinX DateTime ------------------------------------------------------------------------------
  api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

  // Test ------------------------------------------------------------------------------------------
  testImplementation("io.kotlintest:kotlintest-core:3.4.2")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("org.hamcrest:hamcrest:2.2")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("java") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-core-ktx"
        version = "1.1.0-beta01"

        from(components["java"])
      }
    }
  }
}