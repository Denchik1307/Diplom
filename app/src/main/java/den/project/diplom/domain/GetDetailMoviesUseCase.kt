package den.project.diplom.domain

import den.project.diplom.data.api.model.response.MovieDetail
import kotlinx.coroutines.flow.Flow

interface GetDetailMoviesUseCase {
    suspend fun getMovieDetail(movieId:String, language: String): Flow<MovieDetail>
}