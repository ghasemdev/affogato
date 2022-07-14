import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.10" apply false

    id("io.gitlab.arturbosch.detekt") version "1.21.0-RC2"
    id("org.jetbrains.dokka") version "1.7.0"
    id("org.jetbrains.kotlinx.kover") version "0.5.1"
}

subprojects {
    repositories {
        mavenCentral()
    }
    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jetbrains.dokka")
    }
    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0-RC2")
        dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.7.0")
    }
    // Static analysis
    detekt {
        // detekt version
        toolVersion = "1.21.0-RC2"
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
}

// Test coverage
kover {
    // change instrumentation agent and reporter
    coverageEngine.set(kotlinx.kover.api.CoverageEngine.INTELLIJ)
    // change a version of IntelliJ agent and reporter
    intellijEngineVersion.set("1.0.668")
    // change a version of JaCoCo agent and reporter
    jacocoEngineVersion.set("0.8.7")
    // false to do not execute `koverMergedReport` task before `check` task
    generateReportOnCheck = true
    // true to instrument packages `android.*` and `com.android.*`
    instrumentAndroidPackage = false
}
tasks.koverXmlReport { isEnabled = false }
tasks.koverMergedXmlReport { isEnabled = false }
tasks.koverMergedHtmlReport {
    isEnabled = true // false to disable report generation
    htmlReportDir.set(layout.buildDirectory.dir("kover/htmlMultiModule"))
}
tasks.koverMergedVerify {
    rule {
        name = "Minimal line coverage rate in percents"
        bound {
            minValue = 0
        }
    }
}

// Dokka
tasks.dokkaHtml.configure {
    dokkaSourceSets {
        configureEach {
            perPackageOption {
                matchingRegex.set(""".*\app.*""")
                suppress.set(true)
            }
        }
    }
}
tasks.dokkaHtmlMultiModule.configure {
    // Set module name displayed in the final output
    moduleName.set("Affogato")
}

tasks.register("testAll") {
    dependsOn("test", "connectedAndroidTest")
    group = "affogato"
    description = "Run all tests"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
