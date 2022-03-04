package den.project.diplom.data.api.repository.impl

import den.project.diplom.data.api.repository.SearchRepository
import den.project.diplom.data.api.api.SearchAPI
import den.project.diplom.data.api.model.Movie
import den.project.diplom.utils.Constants

class SearchRepositoryImpl(
    private val searchApi: SearchAPI
) : SearchRepository {
    override suspend fun searchMovie(query: String, language: String): List<Movie> {
        val movie = searchApi.getSearchMovie(
            Constants.API_KEY_MOVIE, query = query, language = language
        )
        if (movie.isSuccessful) {
            return movie.body()!!.results
        } else {
            throw Error(movie.errorBody().toString())
        }
    }

}