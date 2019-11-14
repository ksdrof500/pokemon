
buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://maven.fabric.io/public")

    }
    dependencies {
        classpath (BuildPlugins.androidGradlePlugin)
        classpath (BuildPlugins.kotlinGradlePlugin)
        classpath (BuildPlugins.googleServicePlugin)
        classpath (BuildPlugins.firebasePerfPlugin)
        classpath (BuildPlugins.fabricPlugin)

    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}