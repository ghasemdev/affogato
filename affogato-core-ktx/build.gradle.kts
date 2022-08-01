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
  // Test ------------------------------------------------------------------------------------------
  testImplementation("junit:junit:4.13.2")
  testImplementation("io.kotlintest:kotlintest-core:3.4.2")
  testImplementation("com.google.truth:truth:1.1.3")
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("java") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-core-ktx"
        version = "1.1.0-alpha01"

        from(components["java"])
      }
    }
  }
}
