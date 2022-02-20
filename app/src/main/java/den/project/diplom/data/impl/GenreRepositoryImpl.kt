package den.project.diplom.data.impl

import android.util.Log
import den.project.diplom.data.GenreRepository
import den.project.diplom.data.api.GenreAPI
import den.project.diplom.data.api.model.Genre
import den.project.diplom.data.storage.dao.GenreDao
import den.project.diplom.utils.Constants

class GenreRepositoryImpl(
    private val genreAPI: GenreAPI,
    private val genreDao: GenreDao
): GenreRepository {

    override suspend fun getGenres(language: String): List<Genre> {
        val genres = genreAPI.getGenres(Constants.API_KEY_MOVIE, language)

        if(genres.isSuccessful) {
            val list = genres.body()!!.genres

            genreDao.insertAll(list.map(Genre::toRoomEntity))

            return list
        } else {
            throw Exception(genres.errorBody().toString())
        }
    }
}