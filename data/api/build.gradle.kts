import dependencies.Dep

val ideaActive = System.getProperty("idea.active") == "true"

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("koin")
}

android {
    defaultConfig {
        buildConfigField("String", "API_ENDPOINT", "\"https://connpass.com/api/v1/event\"")
    }
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
                useExperimentalAnnotation("kotlin.RequiresOptIn")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(Dep.Kotlin.stdlibCommon)
                implementation(Dep.Kotlin.Coroutines.coroutinesCommon)
                implementation(Dep.Kotlin.Serialization.serializationCommon)
                implementation(Dep.Ktor.clientCommon)
                implementation(Dep.Ktor.serializationCommon)
                implementation(Dep.Ktor.jsonCommon)
                implementation(Dep.Ktor.loggingCommon)
                implementation(Dep.Klock.common)
                implementation(Dep.Koin.core)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Dep.Kotlin.stdlibJvm)
                implementation(Dep.Kotlin.Coroutines.coroutinesAndroid)
                implementation(Dep.Kotlin.Serialization.serializationAndroid)
                implementation(Dep.Ktor.clientAndroid)
                implementation(Dep.Ktor.serializationJvm)
                implementation(Dep.Ktor.jsonJvm)
                implementation(Dep.Ktor.loggingJvm)
                implementation(Dep.OkHttp.client)
                implementation(Dep.OkHttp.loggingInterceptor)
            }
        }

        val iosMain by getting {
            val mode = project.findProperty("XCODE_CONFIGURATION")?.toString()?.toUpperCase() ?: "DEBUG"
            if (mode == "RELEASE") {
                kotlin.srcDirs("src/iosMain/kotlinRelease")
            } else {
                kotlin.srcDirs("src/iosMain/kotlinDebug")
            }
            dependsOn(commonMain)
            dependencies {
                implementation(Dep.Kotlin.Coroutines.coroutinesNative)
                implementation(Dep.Kotlin.Serialization.serializationNative)
                implementation(Dep.Ktor.clientIos)
                implementation(Dep.Ktor.serializationNative)
                implementation(Dep.Ktor.jsonNative)
                implementation(Dep.Ktor.loggingNative)
            }
        }

        val iosX64Main by getting {
            dependsOn(iosMain)
            dependencies {
                implementation(Dep.Kotlin.Coroutines.coroutinesIosX64)
                implementation(Dep.Kotlin.Serialization.serializationIosX64)
                implementation(Dep.Ktor.clientIosX64)
                implementation(Dep.Ktor.serializationIosX64)
                implementation(Dep.Ktor.jsonIosIosX64)
                implementation(Dep.Ktor.loggingIosIosX64)
            }
        }

        val iosArm64Main by getting {
            dependsOn(iosMain)
            dependencies {
                implementation(Dep.Kotlin.Coroutines.coroutinesIosArm64)
                implementation(Dep.Kotlin.Serialization.serializationIosArm64)
                implementation(Dep.Ktor.clientIosArm64)
                implementation(Dep.Ktor.serializationIosArm64)
                implementation(Dep.Ktor.jsonIosArm64)
                implementation(Dep.Ktor.loggingIosArm64)
            }
        }
    }
}

apply(from = rootProject.file("gradle/android.gradle"))
