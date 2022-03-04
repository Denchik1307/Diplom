package den.project.diplom.domain

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.storage.dao.MovieEntity

interface SaveDaoUseCase {
    suspend fun saveDb(movie: Movie)
}