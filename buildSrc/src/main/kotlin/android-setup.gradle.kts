import org.gradle.api.JavaVersion

plugins {
    id("com.android.library")
}

android {
    compileSdk =33

    defaultConfig {
        minSdk = 26
        targetSdk =33
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }


    sourceSets{
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidmain/res", "src/commonMain/resources")
        }
    }

}