package den.project.diplom.domain.impl

import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.data.storage.entity.MovieEntity
import den.project.diplom.domain.GetFromDataBaseFavorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFromDataBaseFavoriteImpl(
    private val movieDao: MovieDao
) : GetFromDataBaseFavorite {
    override suspend operator fun invoke(id: String?): Flow<List<MovieEntity>> = flow {
        emit(movieDao.getMovies(id = id))
    }
}