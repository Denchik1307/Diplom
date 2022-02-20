package den.project.diplom.data.storage.entity

import androidx.room.Entity

@Entity(primaryKeys = ["movieId", "genreId"])
data class MovieGenreCrossRef(
    val movieId: Long,
    val genreId: Long,
)