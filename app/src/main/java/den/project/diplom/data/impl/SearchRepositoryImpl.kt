package den.project.diplom.data.impl

import den.project.diplom.data.SearchRepository
import den.project.diplom.data.api.SearchAPI
import den.project.diplom.data.api.model.Movie
import den.project.diplom.utils.Constants

class SearchRepositoryImpl(
    private val searchApi: SearchAPI
) : SearchRepository {
    override suspend fun searchMovie(page: Int, query: String, language: String): List<Movie> {
        val movie = searchApi.getSearchMovie(
            Constants.API_KEY_MOVIE, page = page, query = query, language = "ru"
        )
        if (movie.isSuccessful) {
            return movie.body()!!.results
        } else {
            throw Error(movie.errorBody().toString())
        }
    }

}