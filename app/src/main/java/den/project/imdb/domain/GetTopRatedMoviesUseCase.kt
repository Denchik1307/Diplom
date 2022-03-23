package den.project.imdb.domain

import den.project.imdb.data.api.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {
    suspend fun getTopRated(page: Int, language: String): Flow<List<Movie>>
}