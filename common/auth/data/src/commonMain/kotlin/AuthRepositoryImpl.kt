import ktor.KtorAuthRemoteDataSource
import models.Token
import settings.SettingsDaraSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val settingsDaraSource: SettingsDaraSource
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
       return if (login == "admin" && password == "admin") {
           Token("admin")
        } else {
           settingsDaraSource.saveToken("token.token")
           Token("token.token")
        }
//        val token = remoteDataSource.performLogin(
//          request = KtorLoginRequest(
//                login, password
//            )
//        )
      //  settingsDaraSource.saveToken(token.token)

    }

    override fun isUserLoggedIn(): Boolean {
     return settingsDaraSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return "adnmin"
    }
}