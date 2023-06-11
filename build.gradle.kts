import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration

plugins {
  id("com.android.application") version "7.4.2" apply false
  id("com.android.library") version "7.4.2" apply false
  kotlin("android") version "1.8.21" apply false
  kotlin("jvm") version "1.8.21" apply false

  id("io.gitlab.arturbosch.detekt") version "1.23.0"
  id("org.jetbrains.dokka") version "1.8.10"
  id("org.jetbrains.kotlinx.kover") version "0.6.1"
}

buildscript {
  dependencies {
    classpath("org.jetbrains.dokka:dokka-base:1.8.10")
    classpath("org.jetbrains.kotlinx:kover:0.6.1")
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
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.8.10")
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
    // true to disable instrumentation and all Kover tasks in this project
    isDisabled.set(hasProperty("disableKover"))
    // change Coverage Engine
    engine.set(kotlinx.kover.api.DefaultIntellijEngine)
  }
}

// Test coverage
koverMerged {
  enable() // create Kover merged reports
  filters { // common filters for all default Kover merged tasks
    classes { // common class filter for all default Kover merged tasks
      excludes += listOf(
        "com.parsuomash.affogato.app.*",
        "com.parsuomash.affogato.unit.*",
        "com.parsuomash.affogato.core.ktx.time.messages.*",
        "com.parsuomash.affogato.metrica.ktx.*",
        "com.parsuomash.affogato.logger.android.*",
        "com.parsuomash.affogato.okhttp.android.*"
      ) // class exclusion rules
    }
  }
  xmlReport { onCheck.set(true) }
  htmlReport { onCheck.set(true) }
  verify {
    // true to run koverMergedVerify task during the execution of the check task
    onCheck.set(true)
    rule { // add verification rule
      isEnabled = true // false to disable rule checking
      name = "Minimal line coverage rate in percents" // custom name for the rule
      // specify by which entity the code for separate coverage evaluation will be grouped
      target = kotlinx.kover.api.VerificationTarget.ALL
      bound { // add rule bound
        minValue = 70
        maxValue = 100
        // change coverage metric to evaluate (LINE, INSTRUCTION, BRANCH)
        counter = kotlinx.kover.api.CounterType.LINE
        // change counter value (COVERED_COUNT, MISSED_COUNT, COVERED_PERCENTAGE, MISSED_PERCENTAGE)
        valueType = kotlinx.kover.api.VerificationValueType.COVERED_PERCENTAGE
      }
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
