package den.project.diplom.domain

import den.project.diplom.data.storage.dao.MovieEntity

interface SaveDaoUseCase {
    suspend fun saveDb(movieEntity: MovieEntity)
}