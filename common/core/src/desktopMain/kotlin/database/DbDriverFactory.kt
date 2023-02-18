package database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import platform.PlatformConfiguration

actual class DbDriverFactory actual constructor(private val platform: PlatformConfiguration) {
   actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver =
       JdbcSqliteDriver("jdbc:sqlite:$name")
}