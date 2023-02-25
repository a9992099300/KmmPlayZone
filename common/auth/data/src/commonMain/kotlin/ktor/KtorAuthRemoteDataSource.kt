package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import models.Token

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient
) {

    suspend fun performLogin(request: KtorLoginRequest): Token {
        return httpClient.get {
            header("X-RapidAPI-Key", "1c2d65f0bamshaca998eaf20e438p11154ajsnd28dd5bd0887")
            header("X-RapidAPI-Host", "marvel-vs-capcom-2.p.rapidapi.com")
            url {
//                parameters.append(API_KEY_HEADER, API_KEY)
                path("characters")
                //   setBody(request)
            }
        }.body()
    }
}