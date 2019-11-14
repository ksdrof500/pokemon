plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)

    defaultConfig {
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
    }

    flavorDimensions("default")

    productFlavors {
        create("prod")
        create("hlg")
    }
}

dependencies {

    implementation(project(":domain"))

    testImplementation (TestLibraries.junit4)

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.koin)

    implementation(Libraries.rxJava)

    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitRxAdapter)
    implementation(Libraries.retrofitGson)

    implementation(Libraries.stethoOkHttp)

    implementation(Libraries.room)
    implementation(Libraries.roomRx)
    kapt(Libraries.roomCompiler)

}