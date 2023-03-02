import ktor.KtorAuthRemoteDataSource
import models.Token
import settings.SettingsDaraSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val settingsDaraSource: SettingsDaraSource
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
//        val token = remoteDataSource.performLogin(
//          request = KtorLoginRequest(
//                login, password
//            )
//        )
      //  settingsDaraSource.saveToken(token.token)
        settingsDaraSource.saveToken("token.token")
        return Token("token.token")
    }

    override fun isUserLoggedIn(): Boolean {
     return settingsDaraSource.fetchToken().isNotBlank()
    }
}