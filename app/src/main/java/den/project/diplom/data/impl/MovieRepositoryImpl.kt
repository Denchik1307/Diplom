package den.project.diplom.data.impl

import den.project.diplom.data.MovieRepository
import den.project.diplom.data.api.MovieAPI
import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.storage.dao.GenreDao
import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.utils.Constants

class MovieRepositoryImpl(
    private val movieApi: MovieAPI,
    private val movieDao: MovieDao,
    private val genreDao: GenreDao
): MovieRepository {
    override suspend fun getPopular(page: Int, language: String): List<Movie> {
        val movies = movieApi.getPopularMovie(Constants.API_KEY_MOVIE, page, language)

        if(movies.isSuccessful) {
            val genres = genreDao.getAllGenres()

            // Check many to many
            /*movieDao.insertAll(movies.body()!!.results.map {
                it.toRoomEntity(genres)
            })*/

            return movies.body()!!.results
        } else {
            throw Error(movies.errorBody().toString())
        }
    }
}