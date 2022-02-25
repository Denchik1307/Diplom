package den.project.diplom.domain.impl

import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.data.storage.entity.MovieEntity
import den.project.diplom.domain.SaveInDataBaseFavorite
import kotlinx.coroutines.flow.flow

class SaveInDataBaseFavoriteImpl(
    private val movieDao: MovieDao
) : SaveInDataBaseFavorite {
    override suspend operator fun invoke() {
        flow {
            emit(movieDao.insert())
        }
    }
}