package den.project.diplom.domain

import den.project.diplom.data.api.model.Trailer
import kotlinx.coroutines.flow.Flow

interface GetTrailerMoviesUseCase {
    suspend operator fun invoke(movie_id: String, language: String): Flow<List<Trailer>>
}