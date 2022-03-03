package den.project.diplom.data.storage.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "favorite")
data class MovieEntity(
    @NotNull
    @PrimaryKey
    val id: String,
    val title: String,
    val overview: String,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    val genres: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    val rating: Double,
    @ColumnInfo(name = "release_date")
    val releaseDate: String
)