package den.project.diplom.domain

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.api.model.Trailer
import den.project.diplom.data.api.model.response.TrailerResponse
import kotlinx.coroutines.flow.Flow

interface GetTrailerMoviesUseCase {
    suspend operator fun invoke(movie_id: String): Flow<Trailer>
}