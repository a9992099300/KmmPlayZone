package database

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import platform.PlatformConfiguration

actual class DbDriverFactory actual constructor(private val platform: PlatformConfiguration) {
   actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver =
       AndroidSqliteDriver(schema, platform.context, name)
}