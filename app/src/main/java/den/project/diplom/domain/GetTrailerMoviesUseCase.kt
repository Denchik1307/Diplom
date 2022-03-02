package den.project.diplom.domain

import den.project.diplom.data.api.model.Trailer
import den.project.diplom.data.api.model.response.TrailerResponse
import kotlinx.coroutines.flow.Flow

interface GetTrailerMoviesUseCase {
    suspend fun getTrailer(movie_id: String,language: String): Flow<List<Trailer>>
}