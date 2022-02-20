package den.project.diplom.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie (
    @PrimaryKey
    val movieId: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val originalTitle: String,
    val backdropPath: String,
    val rating: Double,
    val releaseDate: String,
)