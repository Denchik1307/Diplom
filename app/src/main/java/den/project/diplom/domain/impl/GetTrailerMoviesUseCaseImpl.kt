package den.project.diplom.domain.impl

import den.project.diplom.data.MovieRepository
import den.project.diplom.domain.GetTrailerMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrailerMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetTrailerMoviesUseCase {
    override suspend operator fun invoke(movie_id: String): Flow<String> = flow {
        emit(movieRepository.getTrailer(movie_id))
    }
}