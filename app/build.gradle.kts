import Configurations.ApplicationId
import Configurations.MinSdk
import Configurations.TargetSdk
import Configurations.VersionCode
import Configurations.VersionName

plugins {
    id(BuildPlugins.androidApp)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.googleSecrets) version Versions.googleGradleSecrets
}

val composeVersion = "1.2.0-beta01"

android {
    compileSdk = Configurations.CompileSdk

    defaultConfig {
        Configurations.also {
            applicationId = ApplicationId
            minSdk = MinSdk
            targetSdk = TargetSdk
            versionCode = VersionCode
            versionName = VersionName
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libraries.core)
    implementation(Libraries.composeUi)
    implementation(Libraries.constraintLayout)
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.REPOSITORY))
    implementation(project(Modules.PRESENTATION))
    implementation(Libraries.liveData)
    implementation(Libraries.viewModel)
    implementation(Libraries.koinCompose)
    implementation(Libraries.coil)
    implementation(Libraries.paging)
    implementation(Libraries.pagingCompose)
    implementation(Libraries.systemUiController)
    implementation(Libraries.composeNavigation)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.preview)
    implementation(Libraries.fresco)
    implementation(Libraries.lifeCycle)
    implementation(Libraries.activity)
    testImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.jUnitAndroid)
    androidTestImplementation(TestLibraries.androidEspresso)
}
