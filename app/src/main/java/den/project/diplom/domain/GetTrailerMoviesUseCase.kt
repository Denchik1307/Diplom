package den.project.diplom.domain

import kotlinx.coroutines.flow.Flow

interface GetTrailerMoviesUseCase {
    suspend operator fun invoke(movie_id: String): Flow<String>
}