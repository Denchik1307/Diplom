package den.project.imdb.data.api.repository

import den.project.imdb.data.api.model.Movie
import den.project.imdb.data.api.model.Trailer
import den.project.imdb.data.api.model.response.MovieDetail

interface MovieRepository {
    suspend fun getPopular(page: Int, language: String): List<Movie>
    suspend fun getTopRated(page: Int, language: String): List<Movie>
    suspend fun getMovieDetail(movie_id: String, language: String): MovieDetail
    suspend fun getTrailer(movie_id: String,language: String): List<Trailer>
}