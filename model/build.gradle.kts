import dependencies.Dep

val ideaActive = System.getProperty("idea.active") == "true"

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("android.extensions")
    kotlin("plugin.serialization")
}

androidExtensions {
    isExperimental = true
    features = setOf("parcelize")
}

kotlin {
    android("android")
    iosArm64("iosArm64") {
        binaries {
            framework {
                freeCompilerArgs = freeCompilerArgs.plus("-Xobjc-generics")
            }
        }
    }
    iosX64("iosX64") {
        binaries {
            framework {
                freeCompilerArgs = freeCompilerArgs.plus("-Xobjc-generics")
            }
        }
    }
    if (ideaActive) {
        iosX64("ios") {
            binaries {
                framework {
                    freeCompilerArgs = freeCompilerArgs.plus("-Xobjc-generics")
                }
            }
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.3"
                apiVersion = "1.3"
                progressiveMode = true // false by default
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(Dep.Kotlin.stdlibCommon)
                implementation(Dep.Kotlin.Serialization.serializationCommon)
                api(Dep.Klock.common)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Dep.Kotlin.stdlibJvm)
                implementation(Dep.Kotlin.Serialization.serializationAndroid)
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Dep.Kotlin.Serialization.serializationNative)
            }
        }

        val iosX64Main by getting {
            dependsOn(iosMain)
            dependencies {
                implementation(Dep.Kotlin.Serialization.serializationIosX64)
            }
        }

        val iosArm64Main by getting {
            dependsOn(iosMain)
            dependencies {
                implementation(Dep.Kotlin.Serialization.serializationIosArm64)
            }
        }
    }
}

apply(from = rootProject.file("gradle/android.gradle"))
