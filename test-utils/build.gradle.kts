import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.javaLibrary)
    id(BuildPlugins.kotlinJvm)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = javaVersion
}

dependencies {

    implementation(project(":domain"))

    implementation(Libraries.kotlinStdLib)

}