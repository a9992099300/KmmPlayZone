plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
    id ("com.squareup.sqldelight")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.kotlin_json)
                implementation(Dependencies.Ktor.logging)

                implementation(Dependencies.Settings.core)
                implementation(Dependencies.Settings.noargs)
                api(Dependencies.Kodein.core)

                api(Dependencies.SqlDelight.core)

            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}

sqldelight {
    database("Database") {
        packageName = "com.a9992099300.Kmm_Test"
        schemaOutputDirectory = file ("src/commonMain/saldelight/databases/schema")
        migrationOutputDirectory = file (  "src/commonMain/sqldelight/databases/migration")
    }
}