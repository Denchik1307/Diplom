package den.project.diplom.domain.impl

import den.project.diplom.data.api.model.Trailer
import den.project.diplom.data.api.repository.MovieRepository
import den.project.diplom.domain.GetTrailerMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrailerMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetTrailerMoviesUseCase {
    override suspend fun invoke(movie_id: String, language: String): Flow<List<Trailer>> = flow {
        emit(movieRepository.getTrailer(movie_id = movie_id, language = language))
    }
}