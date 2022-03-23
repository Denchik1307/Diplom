package den.project.imdb.domain.impl

import den.project.imdb.data.api.model.Movie
import den.project.imdb.data.storage.dao.MovieDao
import den.project.imdb.data.storage.toMovieEntity
import den.project.imdb.domain.SaveDaoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveDaoUseCaseImpl(
    private val movieDao: MovieDao,
) : SaveDaoUseCase {

    override suspend fun saveDb(movie: Movie) {
        withContext(Dispatchers.IO) {
            movieDao.insert(movie.toMovieEntity())
        }
    }
}