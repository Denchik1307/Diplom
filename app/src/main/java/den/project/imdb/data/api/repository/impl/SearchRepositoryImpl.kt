package den.project.imdb.data.api.repository.impl

import den.project.imdb.data.api.api.SearchAPI
import den.project.imdb.data.api.model.Movie
import den.project.imdb.data.api.repository.SearchRepository
import den.project.imdb.utils.Constants

class SearchRepositoryImpl(
    private val searchApi: SearchAPI
) : SearchRepository {
    override suspend fun searchMovie(page: String, query: String, language: String): List<Movie> {
        val movie = searchApi.getSearchMovie(
            Constants.API_KEY_MOVIE, page = page, query = query, language = language
        )
        if (movie.isSuccessful) {
            return movie.body()!!.results
        } else {
            throw Error(movie.errorBody().toString())
        }
    }

}