package den.project.imdb.data.api.repository.impl

import den.project.imdb.data.api.repository.GenreRepository
import den.project.imdb.data.api.api.GenreAPI
import den.project.imdb.data.api.model.Genre
import den.project.imdb.utils.Constants

class GenreRepositoryImpl(
    private val genreAPI: GenreAPI,
): GenreRepository {

    override suspend fun getGenres(language: String): List<Genre> {
        val genres = genreAPI.getGenres(Constants.API_KEY_MOVIE, language)
        if(genres.isSuccessful) {
            return genres.body()!!.genres
        } else {
            throw Exception(genres.errorBody().toString())
        }
    }
}