package den.project.imdb.domain

import den.project.imdb.data.api.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend operator fun invoke(page: Int, language: String): Flow<List<Movie>>
}