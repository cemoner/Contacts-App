pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.2.1" apply false
        id("org.jetbrains.kotlin.android") version "1.9.0" apply false
        id("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false
        id("kotlin-kapt") version "1.9.0" apply false
        id("dagger.hilt.android.plugin") version "2.51.1" apply false
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ContactsApp"
include(":app")
