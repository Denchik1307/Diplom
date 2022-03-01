package den.project.diplom.data.api.repository.impl

import den.project.diplom.data.GenreRepository
import den.project.diplom.data.api.api.GenreAPI
import den.project.diplom.data.api.model.Genre
import den.project.diplom.utils.Constants

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