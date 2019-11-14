const val kotlinVersion = "1.3.21"
const val javaVersion = "1.8"

object BuildPlugins {

    object Versions {
        const val buildTools = "3.3.1"
        const val googleService = "4.2.0"
        const val detekt = "1.0.0-RC14"
        const val fabric = "1+"
        const val firebasePerf = "1.2.0"
    }

    const val androidGradlePlugin       = "com.android.tools.build:gradle:${Versions.buildTools}"
    const val kotlinGradlePlugin        = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val fabricPlugin              = "io.fabric.tools:gradle:${Versions.fabric}"
    const val googleServicePlugin       = "com.google.gms:google-services:${Versions.googleService}"
    const val firebasePerfPlugin        = "com.google.firebase:perf-plugin:${Versions.firebasePerf}"

    const val androidApplication        = "com.android.application"
    const val androidLibrary            = "com.android.library"
    const val javaLibrary               = "java-library"
    const val kotlinJvm                 = "org.jetbrains.kotlin.jvm"

    const val kotlinAndroid             = "kotlin-android"
    const val kotlinAndroidExtensions   = "kotlin-android-extensions"
    const val kotlinKapt                = "kotlin-kapt"

    const val googleService             = "com.google.gms.google-services"
    const val firebasePerf              = "com.google.firebase.firebase-perf"
    const val fabric                    = "io.fabric"

    const val detekt                    = "io.gitlab.arturbosch.detekt"
}

object Libraries {
    private object Versions {
        const val jetpack = "1.0.2"
        const val constraintlayout = "1.1.3"
        const val material = "1.0.0"
        const val lottie = "3.0.3"
        const val ktx = "1.0.1"
        const val room = "1.1.1"
        const val glide = "4.9.0"
        const val arch = "2.0.0"

        const val firebaseCore = "16.0.9"
        const val firebasePerf = "17.0.2"
        const val firebaseUIAuth = "4.1.0"
        const val firebaseAuth = "17.0.0"

        const val rxJava = "2.2.8"
        const val rxKotlin = "2.3.0"
        const val rxAndroid = "2.1.1"

        const val koin = "2.0.0"

        const val retrofit = "2.5.0"
        const val stetho = "1.5.1"

        const val adapterDelegate = "4.0.0"
        const val timber = "4.7.1"

        const val crashlytics = "2.10.1"


    }

    const val kotlinStdLib      = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat         = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val glide             = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler     = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val constraintlayout  = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val ktxCore           = "androidx.core:core-ktx:${Versions.ktx}"

    const val firebaseCore      = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val firebasePerf      = "com.google.firebase:firebase-perf:${Versions.firebasePerf}"
    const val firebaseUIAuth    = "com.firebaseui:firebase-ui-auth:${Versions.firebaseUIAuth}"
    const val firebaseAuth      = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"

    const val lifecycleRuntime  = "androidx.lifecycle:lifecycle-runtime:${Versions.arch}"
    const val lifecycleExt      = "androidx.lifecycle:lifecycle-extensions:${Versions.arch}"

    const val materialDesign    = "com.google.android.material:material:${Versions.material}"
    const val lottie            = "com.airbnb.android:lottie:${Versions.lottie}"

    const val room              = "android.arch.persistence.room:runtime:${Versions.room}"
    const val roomRx            = "android.arch.persistence.room:rxjava2:${Versions.room}"
    const val roomCompiler      = "android.arch.persistence.room:compiler:${Versions.room}"

    const val rxJava            = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxKotlin          = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val rxAndroid         = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    const val adapterDelegate   = "com.hannesdorfmann:adapterdelegates4:${Versions.adapterDelegate}"

    const val koin              = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel     = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val retrofit          = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitGson      = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val stetho            = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stethoOkHttp      = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

    const val crashlytics       = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"

    const val timber            = "com.jakewharton.timber:timber:${Versions.timber}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"

        const val espresso = "3.1.0"
        const val androidTest = "1.1.0"

        const val mockito = "2.27.0"
        const val mockitoKt = "2.1.0"
    }

    const val junit4            = "junit:junit:${Versions.junit4}"
    const val kotlinTest        = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"

    const val mockito           = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKt         = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKt}"

    const val espressoCore      = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTest}"
    const val androidTestRules  = "androidx.test:rules:${Versions.androidTest}"
    const val androidTestExt    = "androidx.test.ext:junit:${Versions.androidTest}"
}
