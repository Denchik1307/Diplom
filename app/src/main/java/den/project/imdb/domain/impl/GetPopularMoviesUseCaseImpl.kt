package den.project.imdb.domain.impl

import den.project.imdb.data.api.model.Movie
import den.project.imdb.data.api.repository.MovieRepository
import den.project.imdb.domain.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
): GetPopularMoviesUseCase {
    override suspend fun invoke(page: Int, language: String): Flow<List<Movie>> = flow {
        emit(movieRepository.getPopular(page = page, language = language))
    }
}