plugins {
  alias(libs.plugins.android.library)
  id(libs.plugins.maven.publish.get().pluginId)
}

apply {
  from("$rootDir/android-library-build.gradle")
}

android {
  namespace = "com.parsuomash.affogato.okhttp.android"
}

dependencies {
  // OkHttp3 ---------------------------------------------------------------------------------------
  "api"(libs.okhttp)
  "api"(libs.okhttp.logging.interceptor)
  "testApi"(libs.okhttp.mockwebserver)
}

afterEvaluate {
  publishing {
    publications {
      create<MavenPublication>("release") {
        groupId = "com.parsuomash.affogato"
        artifactId = "affogato-okhttp-android"
        version = libs.versions.affogato.get()

        from(components["release"])
      }
    }
  }
}
