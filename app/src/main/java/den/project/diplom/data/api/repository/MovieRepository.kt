package den.project.diplom.data.api.repository

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.api.model.response.MovieDetail
import den.project.diplom.data.api.model.response.TrailerResponse

interface MovieRepository {
    suspend fun getPopular(page: Int, language: String): List<Movie>
    suspend fun getMovieDetail(movie_id: String, language: String): MovieDetail
    suspend fun getTrailer(movie_id: String,language: String): TrailerResponse
}