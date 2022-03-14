package den.project.diplom.domain.impl

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.api.repository.MovieRepository
import den.project.diplom.domain.GetTopRatedMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTopRatedMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetTopRatedMoviesUseCase {
    override suspend fun getTopRated(page: Int, language: String): Flow<List<Movie>> = flow {
        emit(movieRepository.getTopRated(page = page, language = language))
    }
}