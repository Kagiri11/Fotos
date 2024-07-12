plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}


kotlin {
    jvm("desktop")
    androidTarget()

    sourceSets {

        val desktopMain by getting{

        }
        androidMain.dependencies {
            api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
        }

        val commonMain by getting {
            dependencies {
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(compose.material)
                implementation(compose.foundation)
                implementation ("io.github.aakira:napier:2.7.1")
                implementation("moe.tlaster:precompose:1.6.0-beta02")
                implementation("moe.tlaster:precompose-viewmodel:1.6.0-beta02")
                implementation("moe.tlaster:precompose-koin:1.6.0-beta02")
                implementation("com.russhwolf:multiplatform-settings:1.1.1")
                implementation(compose.animation)
                implementation(libs.koin.core)
                implementation(libs.kotlin.coroutines.core)
                implementation("media.kamel:kamel-image:0.9.1")
                implementation("app.cash.paging:paging-common:3.3.0-alpha02-0.4.0")
                implementation("app.cash.paging:paging-compose-common:3.3.0-alpha02-0.4.0")
                implementation("androidx.datastore:datastore-preferences-core:1.1.0-alpha07")
                implementation(libs.ktor.client.auth)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.client.logging)
                implementation(libs.androidx.datastore)
            }
        }

    }
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
}

android {
    namespace = "com.cmaina.hellomultiplatform"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}