package den.project.imdb.domain

import den.project.imdb.data.api.model.Trailer
import kotlinx.coroutines.flow.Flow

interface GetTrailerMoviesUseCase {
    suspend operator fun invoke(movie_id: String, language: String): Flow<List<Trailer>>
}