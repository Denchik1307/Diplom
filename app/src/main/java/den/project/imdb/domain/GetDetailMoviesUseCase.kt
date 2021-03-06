package den.project.imdb.domain

import den.project.imdb.data.api.model.response.MovieDetail
import kotlinx.coroutines.flow.Flow

interface GetDetailMoviesUseCase {
    suspend operator fun invoke(movieId: String, language: String): Flow<MovieDetail>
}