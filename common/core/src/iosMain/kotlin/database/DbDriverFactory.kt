package database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import platform.PlatformConfiguration

actual class DbDriverFactory actual constructor(private val platform: PlatformConfiguration) {
   actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver =
       NativeSqliteDriver(schema, name)
}