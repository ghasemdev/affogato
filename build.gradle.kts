import io.gitlab.arturbosch.detekt.Detekt
import kotlinx.kover.gradle.plugin.dsl.AggregationType.COVERED_PERCENTAGE
import kotlinx.kover.gradle.plugin.dsl.GroupingEntityType.APPLICATION
import kotlinx.kover.gradle.plugin.dsl.MetricType.LINE
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration

plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.jvm) apply false
  alias(libs.plugins.detekt)
  alias(libs.plugins.dokka)
  alias(libs.plugins.kover)
}

buildscript {
  dependencies {
    classpath(libs.dokka.base)
  }
}

subprojects {
  repositories {
    mavenCentral()
  }
  apply {
    plugin("io.gitlab.arturbosch.detekt")
    plugin("org.jetbrains.dokka")
    plugin("org.jetbrains.kotlinx.kover")
  }
  dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.0")
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.8.20")
  }
  // Static analysis
  detekt {
    // detekt version
    toolVersion = "1.23.0"
    // preconfigure defaults
    buildUponDefaultConfig = true
    // activate all available (even unstable) rules.
    allRules = false
    // point to your custom config defining rules to run, overwriting default behavior
    @Suppress("DEPRECATION")
    config = files("$rootDir/config/detekt/detekt.yml")
    // a way of suppressing issues before introducing detekt
    baseline = file("$rootDir/config/detekt/baseline.xml")
  }
  tasks.withType<Detekt>().configureEach {
    reports {
      html.required.set(true)
      xml.required.set(false)
      txt.required.set(false)
      sarif.required.set(false)
      md.required.set(true)
    }
  }
  // Test coverage
  kover {
    useJacoco()
  }
  koverReport {
    filters {
      excludes {
        classes(
          "com.parsuomash.affogato.app.*",
          "com.parsuomash.affogato.unit.*",
          "com.parsuomash.affogato.core.ktx.time.messages.*",
          "com.parsuomash.affogato.metrica.ktx.*",
          "com.parsuomash.affogato.logger.android.*",
          "com.parsuomash.affogato.okhttp.android.*"
        )
      }
    }
    verify {
      rule { // add verification rule
        isEnabled = true // false to disable rule checking
        // specify the code unit for which coverage will be aggregated
        entity = APPLICATION
        bound { // add rule bound
          minValue = 70
          maxValue = 100
          // specify which units to measure coverage for
          metric = LINE
          // specify an aggregating function to obtain a single value that will be checked against the lower and upper boundaries
          aggregation = COVERED_PERCENTAGE
        }
      }
    }
    defaults {
      xml { onCheck = true }
      html { onCheck = true }
    }
  }
}

// Dokka
tasks.dokkaHtml.configure {
  dokkaSourceSets {
    configureEach {
      perPackageOption {
        matchingRegex.set(""".*\.app.*""")
        suppress.set(true)
      }
    }
  }
}
tasks.dokkaHtmlMultiModule.configure {
  outputDirectory.set(rootDir.resolve("docs"))
  // Set module name displayed in the final output
  moduleName.set("Affogato")
  // Custom Style
  pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
    customAssets = listOf(file("$rootDir/config/dokka/logo-icon.svg"))
  }
}

tasks.register("testAll") {
  dependsOn("test", "connectedAndroidTest")
  group = "affogato"
  description = "Run all tests"
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
