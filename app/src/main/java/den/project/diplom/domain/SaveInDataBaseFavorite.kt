package den.project.diplom.domain

import den.project.diplom.data.storage.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface SaveInDataBaseFavorite {

    suspend operator fun invoke()
}
