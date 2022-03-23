package den.project.imdb.domain.impl

import den.project.imdb.data.api.model.Movie
import den.project.imdb.data.api.repository.MovieRepository
import den.project.imdb.domain.GetTopRatedMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTopRatedMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetTopRatedMoviesUseCase {
    override suspend fun getTopRated(page: Int, language: String): Flow<List<Movie>> = flow {
        emit(movieRepository.getTopRated(page = page, language = language))
    }
}