package den.project.diplom.data.storage.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "favorite")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "genres")
    val genres: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "release_date")
    val releaseDate: String
)