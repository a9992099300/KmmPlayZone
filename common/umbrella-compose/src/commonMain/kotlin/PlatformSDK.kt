import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import platform.PlatformConfiguration

object PlatformSDK {

    fun init(
        config: PlatformConfiguration
    ) {
        val umbrellaModule = DI.Module(name = "umbrella",
        init = {
            bind<PlatformConfiguration>() with singleton { config }

        })

        Inject.createDependencies(
            DI {
                importAll(
                    umbrellaModule,
                    coreModule,
                    gamesModule
                )
            }.direct
        )
    }
}