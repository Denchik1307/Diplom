package den.project.diplom.domain.impl

import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.data.storage.dao.MovieEntity
import den.project.diplom.domain.SaveDaoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveDaoUseCaseImpl(
    private val movieDao: MovieDao,
) : SaveDaoUseCase {

    override suspend fun saveDb(movieEntity: MovieEntity) {
        withContext(Dispatchers.IO) {
            movieDao.insert(movieEntity)
        }
    }
}