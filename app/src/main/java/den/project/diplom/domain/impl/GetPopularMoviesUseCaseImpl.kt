package den.project.diplom.domain.impl

import den.project.diplom.data.GenreRepository
import den.project.diplom.data.MovieRepository
import den.project.diplom.domain.GetPopularMoviesUseCase
import den.project.diplom.data.api.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularMoviesUseCaseImpl(
    private val movieRepository: MovieRepository,
    private val genreRepository: GenreRepository
): GetPopularMoviesUseCase {
    override suspend fun invoke(page: Int, language: String): Flow<List<Movie>> = flow {
        genreRepository.getGenres(language)
        emit(movieRepository.getPopular(page, language))
    }
}