package den.project.imdb.domain.impl

import den.project.imdb.data.api.model.Trailer
import den.project.imdb.data.api.repository.MovieRepository
import den.project.imdb.domain.GetTrailerMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrailerMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetTrailerMoviesUseCase {
    override suspend fun invoke(movie_id: String, language: String): Flow<List<Trailer>> = flow {
        emit(movieRepository.getTrailer(movie_id = movie_id, language = language))
    }
}