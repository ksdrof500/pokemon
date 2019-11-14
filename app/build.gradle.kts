plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.googleService)
    id(BuildPlugins.firebasePerf)
    id(BuildPlugins.fabric)
    id(BuildPlugins.kotlinKapt)

    id(BuildPlugins.detekt) version BuildPlugins.Versions.detekt
}

detekt {
    toolVersion = BuildPlugins.Versions.detekt
    input = files("$rootDir")
    filters = ".*test.*,.*/resources/.*,.*/tmp/.*,.*/buildSrc/.*"
}

fun generateVersionCode(): Int {
    return "git rev-list --count HEAD".exec(rootDir).text.toInt()
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)

        testInstrumentationRunner = AndroidConfig.instrumentationTestRunner
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    signingConfigs {
        create("release") {
            keyAlias = "vortigo"
            keyPassword = "vortigo@1"
            storeFile = file("../keystore.jks")
            storePassword = "vortigo@1"
        }
    }


    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")

            isMinifyEnabled = true
            isZipAlignEnabled = true
            isShrinkResources = true

            isDebuggable = false
            isJniDebuggable = false

            files(file("../proguard/").listFiles()).forEach { file ->
                println("Proguard file located and processed: ${file.name}")
                proguardFile(file)
            }

            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions("default")

    productFlavors {
        create("prod") {
            versionCode = Versioning.code
            versionName = Versioning.name
        }

        create("hlg") {
            applicationIdSuffix = ".hlg"

            versionCode = generateVersionCode()
            versionName = Versioning.name + "." + generateVersionCode()
        }
    }

    testOptions {
        animationsDisabled = true

        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }

}

allprojects {
    repositories {
        maven(url = "https://maven.fabric.io/public")
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

    testImplementation(project(":test-utils"))

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.kotlinTest)

    testImplementation(TestLibraries.mockito)
    testImplementation(TestLibraries.mockitoKt)

    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.androidTestRunner)
    androidTestImplementation(TestLibraries.androidTestRules)
    androidTestImplementation(TestLibraries.androidTestExt)

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.materialDesign)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    implementation(Libraries.lottie)
    implementation(Libraries.adapterDelegate)

    implementation(Libraries.firebasePerf)
    implementation(Libraries.firebaseCore)
    implementation(Libraries.firebaseAuth)
    implementation(Libraries.firebaseUIAuth)

    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleExt)

    implementation(Libraries.crashlytics) {
        isTransitive = true
    }

    implementation(Libraries.koin)
    implementation(Libraries.koinViewModel)

    implementation(Libraries.timber)
    implementation(Libraries.stetho)

    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)

}
