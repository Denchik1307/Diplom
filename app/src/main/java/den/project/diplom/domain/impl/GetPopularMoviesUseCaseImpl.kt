package den.project.diplom.domain.impl

import den.project.diplom.data.MovieRepository
import den.project.diplom.data.api.model.Movie
import den.project.diplom.domain.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
): GetPopularMoviesUseCase {
    override suspend operator fun invoke(page: Int, language: String): Flow<List<Movie>> = flow {
        emit(movieRepository.getPopular(page = page, language = language))
    }
}