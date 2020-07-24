package dependencies

@Suppress("unused")
object Dep {
    object GradlePlugin {
        object Android {
            const val android = "com.android.tools.build:gradle:4.0.0"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-rc01"
        }

        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val kotlinExtension = "org.jetbrains.kotlin:kotlin-android-extensions:${Kotlin.version}"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"
        const val jetifier = "com.android.tools.build.jetifier:jetifier-processor:1.0.0-beta05"
        const val iconRibbonPlugin = "com.akaita.android:easylauncher:1.3.1"
        const val koin = "org.koin:koin-gradle-plugin:3.0.0-alpha-2"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val testRunner = "androidx.test:runner:1.3.0-alpha02"
        const val testRules = "androidx.test:rules:1.3.0-alpha02"
        const val testCoreKtx = "androidx.test:core-ktx:1.2.1-alpha02"
        const val androidJunit4Ktx = "androidx.test.ext:junit-ktx:1.1.2-alpha02"
        const val orchestrator = "androidx.test:orchestrator:1.3.0-alpha02"
        const val archCore = "androidx.arch.core:core-testing:2.1.0"
        const val liveDataTestingKtx = "com.jraska.livedata:testing-ktx:1.1.0"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha02"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Kotlin.Coroutines.version}"
        const val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"
        const val testingKtx =
            "androidx.navigation:navigation-testing-ktx:2.3.0-rc01"

        object KotlinMultiPlatform {
            const val jvmModuleTest = "org.jetbrains.kotlin:kotlin-test"
            const val jvmModuleTestJunit = "org.jetbrains.kotlin:kotlin-test-junit"
            const val commonModuleTest = "org.jetbrains.kotlin:kotlin-test-common"
            const val commonModuleTestAnnotations = "org.jetbrains.kotlin:kotlin-test-annotations-common"
        }

        const val slf4j = "org.slf4j:slf4j-simple:1.7.25"
    }

    object AndroidX {
        const val jetifier = "com.android.tools.build.jetifier:jetifier-core:1.0.0-beta02"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
        const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-alpha03"
        const val preference = "androidx.preference:preference:1.1.0"
        const val browser = "androidx.browser:browser:1.2.0"

        const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha01"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta7"
        const val emoji = "androidx.emoji:emoji-appcompat:1.0.0"
        const val design = "com.google.android.material:material:1.3.0-alpha01"
        const val activityKtx = "androidx.activity:activity-ktx:1.2.0-alpha06"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.0-alpha04"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"

        object LiveData {
            const val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.3.0-alpha04"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha04"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:2.3.0-alpha04"
        }

        object Room {
            val version = "2.2.4"
            val compiler = "androidx.room:room-compiler:$version"
            val runtime = "androidx.room:room-runtime:$version"
            val common = "androidx.room:room-common:$version"
            val coroutine = "androidx.room:room-ktx:$version"
        }

        object Navigation {
            const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:2.3.0-rc01"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.3.0-rc01"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:2.3.0-rc01"
        }

        object Play {
            const val core = "com.google.android.play:core:1.6.4"
        }
    }

    object Kotlin {
        const val version = "1.3.72"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
        const val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"

        object Coroutines {
            const val version = "1.3.8"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val coroutinesCommon = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$version"
            const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val coroutinesNative = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$version"
            const val coroutinesIosX64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosx64:$version"
            const val coroutinesIosArm64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosarm64:$version"
        }

        object Serialization {
            private const val version = "0.20.0"
            const val serializationCommon = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$version"
            const val serializationAndroid = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$version"
            const val serializationNative = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$version"
            const val serializationIosX64 = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-iosx64:$version"
            const val serializationIosArm64 = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-iosarm64:$version"
        }
    }

    object Uniflow {
        const val androidx = "io.uniflow:uniflow-android:0.11.1"
    }

    object Koin {
        private const val version = "3.0.0-alpha-2"
        const val core = "org.koin:koin-core:$version"
        const val coreExt = "org.koin:koin-core-ext:$version"
        const val android = "org.koin:koin-android:$version"
        const val scope = "org.koin:koin-androidx-scope:$version"
        const val viewmodel = "org.koin:koin-androidx-viewmodel:$version"
        const val fragment = "org.koin:koin-androidx-fragment:$version"
    }

    object Ktor {
        const val version = "1.3.2"
        const val clientCommon = "io.ktor:ktor-client-core:$version"
        const val clientAndroid = "io.ktor:ktor-client-okhttp:$version"
        const val clientIos = "io.ktor:ktor-client-ios:$version"
        const val clientIosArm64 = "io.ktor:ktor-client-ios-iosarm64:$version"
        const val clientIosX64 = "io.ktor:ktor-client-ios-iosx64:$version"
        const val loggingCommon = "io.ktor:ktor-client-logging:$version"
        const val loggingJvm = "io.ktor:ktor-client-logging-jvm:$version"
        const val loggingNative = "io.ktor:ktor-client-logging-native:$version"
        const val loggingIosArm64 = "io.ktor:ktor-client-logging-iosarm64:$version"
        const val loggingIosIosX64 = "io.ktor:ktor-client-logging-iosx64:$version"
        const val jsonCommon = "io.ktor:ktor-client-json:$version"
        const val jsonJvm = "io.ktor:ktor-client-json-jvm:$version"
        const val jsonNative = "io.ktor:ktor-client-json-native:$version"
        const val jsonIosArm64 = "io.ktor:ktor-client-json-iosarm64:$version"
        const val jsonIosIosX64 = "io.ktor:ktor-client-json-iosx64:$version"
        const val serializationCommon = "io.ktor:ktor-client-serialization:$version"
        const val serializationJvm = "io.ktor:ktor-client-serialization-jvm:$version"
        const val serializationNative = "io.ktor:ktor-client-serialization-native:$version"
        const val serializationIosArm64 = "io.ktor:ktor-client-serialization-iosarm64:$version"
        const val serializationIosX64 = "io.ktor:ktor-client-serialization-iosx64:$version"
    }

    object OkHttp {
        private const val version = "4.7.0"
        const val client = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val okio = "com.squareup.okio:okio:1.14.0"
    }

    const val liveEvent = "com.github.hadilq.liveevent:liveevent:1.0.1"

    object Groupie {
        const val groupie = "com.xwray:groupie:2.8.0"
        const val viewbinding = "com.xwray:groupie-viewbinding:2.8.0"
    }

    object Coil {
        const val version = "0.8.0"
        const val coil = "io.coil-kt:coil:$version"
    }

    object Klock {
        const val version = "1.8.6"
        const val common = "com.soywiz.korlibs.klock:klock:$version"
    }

    object MockK {
        const val jvm = "io.mockk:mockk:1.9.3"
        const val common = "io.mockk:mockk-common:1.9.3"
    }

    object Timber {
        const val common = "com.jakewharton.timber:timber-common:5.0.0-SNAPSHOT"
        const val jdk = "com.jakewharton.timber:timber-jdk:5.0.0-SNAPSHOT"
        const val android = "com.jakewharton.timber:timber-android:5.0.0-SNAPSHOT"
    }

    object Insetter {
        const val insetter = "dev.chrisbanes:insetter-ktx:0.2.0"
    }

    object PhotoView {
        const val photoview = "com.github.chrisbanes:PhotoView:2.3.0"
    }

    object Google {
        const val autoservice = "com.google.auto.service:auto-service:1.0-rc6"
    }

    object LeakCanary {
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.1"
    }
}
