buildscript {
    configurations.all {
        resolutionStrategy {
            force("com.google.guava:guava:30.1.1-jre")
        }
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.14")
    }
}

plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.9.20" apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.libary) apply false
    alias(libs.plugins.kotlin.androids) apply false
    alias(libs.plugins.kover)
    id("org.jetbrains.compose") version "1.6.0-alpha01" apply false
    id("com.android.test") version "7.2.0" apply false
}

val ktlint by configurations.creating
val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

val ktlintCheck by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Check Kotlin code style."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("src/**/*.kt")
}

val ktlintFormat by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Fix Kotlin code style deviations."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("-F", "src/**/*.kt")
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}

dependencies {
    ktlint("com.pinterest:ktlint:0.45.2") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}
