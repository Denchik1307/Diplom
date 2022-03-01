package den.project.diplom.data.api.repository.impl

import android.util.Log
import den.project.diplom.data.api.api.MovieAPI
import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.api.model.response.MovieDetail
import den.project.diplom.data.api.model.response.TrailerResponse
import den.project.diplom.data.api.repository.MovieRepository
import den.project.diplom.utils.Constants
import kotlinx.coroutines.awaitAll

class MovieRepositoryImpl(
    private val movieApi: MovieAPI
): MovieRepository {
    override suspend fun getPopular(page: Int, language: String): List<Movie> {
        val movies = movieApi.getPopularMovie(Constants.API_KEY_MOVIE, page, language)
        if (movies.isSuccessful) {
        return movies.body()!!.results
        } else {
            throw Error(movies.errorBody().toString())
        }
    }

    override suspend fun getMovieDetail(movie_id: String, language: String): MovieDetail {
        val movie = movieApi.getMovieDetail(Constants.API_KEY_MOVIE, language)
        if (movie.isSuccessful) {
            return movie.body()!!
        } else {
            throw Error(movie.errorBody().toString())
        }
    }

    override suspend fun getTrailer(movie_id: String, language: String): TrailerResponse {
        val trailer = movieApi.getTrailerLink(movie_id, Constants.API_KEY_MOVIE, language)
        if (trailer.isSuccessful) {
            return trailer.body()!!
        } else {
            throw Error(trailer.errorBody().toString())
        }
    }
}