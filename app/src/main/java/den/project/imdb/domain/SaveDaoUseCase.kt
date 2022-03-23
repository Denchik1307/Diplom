package den.project.imdb.domain

import den.project.imdb.data.api.model.Movie

interface SaveDaoUseCase {
    suspend fun saveDb(movie: Movie)
}