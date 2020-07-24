import dependencies.Dep
import dependencies.Packages
import dependencies.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("koin")
}

android {
    compileSdkVersion(Versions.androidCompileSdkVersion)
    buildToolsVersion(Versions.androidBuildToolsVersion)

    defaultConfig {
        applicationId = Packages.name
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = Versions.androidVersionCode
        versionName = Versions.androidVersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments = mapOf("clearPackageData" to "true")
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = Packages.debugNameSuffix
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/*.version")
        exclude("META-INF/proguard/*.pro")
    }
    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        animationsDisabled = true
    }
}

dependencies {
    implementation(project(":model"))
    implementation(project(":data:api"))
    implementation(project(":data:db"))
    implementation(project(":data:repository"))
    implementation(project(":core"))
    implementation(project(":feature:main"))
    implementation(project(":feature:detail"))
    implementation(project(":feature:webview"))

    implementation("com.github.DonaldDu:FixUnhandledEvent:1.0.1")

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.stdlibCommon)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.activityKtx)

    implementation(Dep.AndroidX.Navigation.uiKtx)
    implementation(Dep.AndroidX.Navigation.fragmentKtx)
    implementation(Dep.AndroidX.Navigation.runtimeKtx)

    implementation(Dep.Kotlin.Coroutines.coroutines)
    implementation(Dep.Kotlin.Coroutines.coroutinesAndroid)

    implementation(Dep.AndroidX.Play.core)

    implementation(Dep.Koin.android)
    implementation(Dep.Koin.scope)
    implementation(Dep.Koin.viewmodel)
    implementation(Dep.Koin.fragment)

    //jsoup
    implementation("org.jsoup:jsoup:1.12.1")

    testImplementation(Dep.Test.junit)
    testImplementation(Dep.Test.kotlinTestAssertions)
    testImplementation(Dep.MockK.jvm)
    androidTestImplementation(Dep.Test.testRunner)
    androidTestImplementation(Dep.Test.espressoCore)
    debugImplementation(Dep.LeakCanary.leakCanary)
}

configurations.all {
    resolutionStrategy.eachDependency {
        val requested = this.requested
        if (requested.group == "androidx.appcompat") {
            if (!requested.name.startsWith("multidex")) {
                this.useVersion("1.+")
            }
        }
    }
}
