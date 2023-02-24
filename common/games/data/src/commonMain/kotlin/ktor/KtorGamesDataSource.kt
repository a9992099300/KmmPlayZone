package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

import io.ktor.http.*
import ktor.models.KtorSearchGame
import ktor.models.KtorSearchRequest
import models.Game

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.get {
            header("X-RapidAPI-Key", "1c2d65f0bamshaca998eaf20e438p11154ajsnd28dd5bd0887")
            header("X-RapidAPI-Host", "marvel-vs-capcom-2.p.rapidapi.com")
            url {
//                parameters.append(API_KEY_HEADER, API_KEY)
                path("characters")
             //   setBody(KtorSearchRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun searchGame(query: String): List<KtorSearchGame>  {
        return httpClient.get{
            url {
                header("X-RapidAPI-Key", "1c2d65f0bamshaca998eaf20e438p11154ajsnd28dd5bd0887")
                header("X-RapidAPI-Host", "marvel-vs-capcom-2.p.rapidapi.com")
//                parameters.append(API_KEY_HEADER, API_KEY)
                path("characters")
                //   setBody(KtorSearchRequest(searchQuery = ""))
            }
        }.body()
    }
}

private const val API_KEY = "pro6YLEqHTodfb3bpEhOdh3LIqN0MsJKJIlMwPdd" //presentation api key
private const val API_KEY_HEADER = "api_key"

//    .addHeader("X-RapidAPI-Key", "1c2d65f0bamshaca998eaf20e438p11154ajsnd28dd5bd0887")
//    .addHeader("X-RapidAPI-Host", "marvel-vs-capcom-2.p.rapidapi.com")