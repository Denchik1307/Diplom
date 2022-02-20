package den.project.diplom.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Genre(
    @PrimaryKey
    val genreId: Int,
    val name: String,
)