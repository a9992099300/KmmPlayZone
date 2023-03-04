import ktor.KtorGamesDataSource
import ktor.models.mapToGame
import models.CreateGameInfo
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource:  KtorGamesDataSource,
    private val localDatasource: SqlDelightGamesDataSource
): GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames().map { it.mapToGame() }
    }

    override suspend fun searchGame(query: String): Game? {
        return remoteDataSource.searchGame(query).map { it.mapToGame() }.firstOrNull()
    }

    override suspend fun createGame(game: CreateGameInfo, token: String) {
        remoteDataSource.createGame(game, token)
    }
}