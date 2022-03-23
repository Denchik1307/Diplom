package den.project.imdb.data.api.repository.impl

import den.project.imdb.data.api.api.MovieAPI
import den.project.imdb.data.api.model.Movie
import den.project.imdb.data.api.model.Trailer
import den.project.imdb.data.api.model.response.MovieDetail
import den.project.imdb.data.api.repository.MovieRepository
import den.project.imdb.utils.Constants

class MovieRepositoryImpl(
    private val movieApi: MovieAPI
) : MovieRepository {
    override suspend fun getPopular(page: Int, language: String): List<Movie> {
        val movies = movieApi.getPopular(Constants.API_KEY_MOVIE, page, language)
        if (movies.isSuccessful) {
            return movies.body()!!.results
        } else {
            throw Error(movies.errorBody().toString())
        }
    }

    override suspend fun getTopRated(page: Int, language: String): List<Movie> {
        val movies = movieApi.getTopRated(Constants.API_KEY_MOVIE, page, language)
        if (movies.isSuccessful) {
            return movies.body()!!.results
        } else {
            throw Error(movies.errorBody().toString())
        }
    }

    override suspend fun getMovieDetail(movie_id: String, language: String): MovieDetail {
        val movie = movieApi.getMovieDetail(movie_id,Constants.API_KEY_MOVIE, language)
        if (movie.isSuccessful) {
            return movie.body()!!
        } else {
            throw Error(movie.errorBody().toString())
        }
    }

    override suspend fun getTrailer(movie_id: String, language: String): List<Trailer> {
        val trailer = movieApi.getTrailerLink(movie_id, Constants.API_KEY_MOVIE, language)
        if (trailer.isSuccessful) {
            return trailer.body()!!.results
        } else {
            throw Error(trailer.errorBody().toString())
        }
    }
}