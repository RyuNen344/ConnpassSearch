import dependencies.Dep

plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = rootProject.file("gradle/android.gradle"))

dependencies {
    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.stdlibCommon)

    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.design)
}
