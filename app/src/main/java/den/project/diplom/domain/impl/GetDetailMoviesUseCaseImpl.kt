package den.project.diplom.domain.impl

import den.project.diplom.data.api.repository.MovieRepository
import den.project.diplom.data.api.model.response.MovieDetail
import den.project.diplom.domain.GetDetailMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDetailMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetDetailMoviesUseCase {
    override suspend fun invoke(movieId: String, language: String): Flow<MovieDetail> = flow {
        emit(movieRepository.getMovieDetail(movie_id = movieId, language = language))
    }
}