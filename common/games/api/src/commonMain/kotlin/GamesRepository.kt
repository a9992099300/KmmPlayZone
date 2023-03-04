import models.CreateGameInfo
import models.Game

interface GamesRepository {
    suspend fun fetchAllGames(): List<Game>
    suspend fun searchGame(query: String) : Game?
    suspend fun createGame(game: CreateGameInfo, token: String)
}