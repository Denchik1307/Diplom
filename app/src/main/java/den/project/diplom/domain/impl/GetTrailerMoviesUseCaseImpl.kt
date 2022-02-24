package den.project.diplom.domain.impl

import den.project.diplom.data.MovieRepository
import den.project.diplom.data.api.model.Trailer
import den.project.diplom.domain.GetTrailerMoviesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrailerMoviesUseCaseImpl(
    private val movieRepository: MovieRepository
) : GetTrailerMoviesUseCase {
    override suspend operator fun invoke(movie_id: String): Flow<Trailer> = flow {
        movieRepository.getTrailer(movie_id = movie_id)
    }
}