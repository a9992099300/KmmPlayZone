package ktor

import io.ktor.client.*
import models.Game

class KtorGamesDataSource(val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<Game> = emptyList()
    suspend fun searchGame(query: String) : Game {
       return Game("game", "title")
    }
}