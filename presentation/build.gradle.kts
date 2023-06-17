import Configurations.MinSdk
import Configurations.TargetSdk

plugins {
    id(BuildPlugins.androidLib)
    id(BuildPlugins.kotlinAndroid)
}

android {
    compileSdk = Configurations.CompileSdk

    defaultConfig {
        Configurations.also {
            minSdk = MinSdk
            targetSdk = TargetSdk
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(Libraries.composeUi)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.preview)

    // Modules
    implementation(project(Modules.DOMAIN))

    // Libs
    implementation(Libraries.constraintLayout)
    implementation(Libraries.liveData)
    implementation(Libraries.viewModel)
    implementation(Libraries.preferenceDataStore)
    implementation(Libraries.splashScreen)
    implementation(Libraries.koinCompose)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCore)
    implementation(Libraries.coil)
    implementation(Libraries.landscapist)
    implementation(Libraries.fresco)
    implementation(Libraries.paging)
    implementation(Libraries.pagingCompose)
    implementation(Libraries.composeNavigation)
    implementation(Libraries.systemUiController)
    implementation(Libraries.placeholder)
    implementation(Libraries.permissions)
    implementation(Libraries.lifeCycle)
    implementation(Libraries.activity)
    implementation(Libraries.composeUtil)
    implementation(Libraries.core)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.playUpdate)
    implementation(Libraries.playUpdateKtx)
    implementation(Libraries.pager)

    testImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.jUnitAndroid)
    androidTestImplementation(TestLibraries.androidEspresso)
    androidTestImplementation(TestLibraries.jUnitComposeTest)
    androidTestImplementation(Libraries.koinCompose)
    androidTestImplementation(TestLibraries.composeUiTestManifest)
    debugImplementation(Libraries.tooling)
}
