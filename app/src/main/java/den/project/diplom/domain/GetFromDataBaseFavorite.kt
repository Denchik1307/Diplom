package den.project.diplom.domain

import den.project.diplom.data.storage.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface GetFromDataBaseFavorite {
    suspend operator fun invoke(id: String?): Flow<List<MovieEntity>>
}
