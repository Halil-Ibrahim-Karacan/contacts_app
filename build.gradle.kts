// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}


plugins {

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //id("com.android.application")version "8.1.0" apply false
    //noinspection NewerVersionAvailable
    id ("com.google.dagger.hilt.android") version "2.48" apply false
}