
import json.serializationModule
import ktor.ktorModule
import org.kodein.di.DI
import settings.settingModule

val coreModule = DI.Module("coreModule") {
    importAll(
        serializationModule,
     //   databaseModule,
        ktorModule,
        settingModule
    )
}