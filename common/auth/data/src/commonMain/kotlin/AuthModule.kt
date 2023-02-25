import ktor.KtorAuthRemoteDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val authModule = DI.Module("authModule") {
    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance())
    }

    bind<KtorAuthRemoteDataSource>() with singleton {
        KtorAuthRemoteDataSource(instance())
    }
}