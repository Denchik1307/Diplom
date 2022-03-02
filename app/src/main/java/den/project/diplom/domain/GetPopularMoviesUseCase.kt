package den.project.diplom.domain

import den.project.diplom.data.api.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMoviesUseCase {
    suspend fun getPopular(page: Int, language: String): Flow<List<Movie>>
}