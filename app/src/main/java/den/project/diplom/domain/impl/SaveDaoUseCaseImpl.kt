package den.project.diplom.domain.impl

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.data.storage.toMovieEntity
import den.project.diplom.domain.SaveDaoUseCase
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