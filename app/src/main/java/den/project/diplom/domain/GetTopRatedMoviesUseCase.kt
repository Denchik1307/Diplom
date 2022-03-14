package den.project.diplom.domain

import den.project.diplom.data.api.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {
    suspend fun getTopRated(page: Int, language: String): Flow<List<Movie>>
}