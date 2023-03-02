package settings

import com.russhwolf.settings.Settings

class SettingsDaraSource(
    val setting: Settings
) {

    fun saveToken(token: String){
        setting.putString(tokenKey, token)
    }

    fun fetchToken(): String {
        return setting.getStringOrNull(tokenKey) ?: ""
    }

    companion object{
        private val tokenKey = "token"
    }

}