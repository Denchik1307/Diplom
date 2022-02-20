package den.project.diplom.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import den.project.diplom.data.storage.dao.GenreDao
import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.data.storage.entity.Genre
import den.project.diplom.data.storage.entity.Movie
import den.project.diplom.data.storage.entity.MovieGenreCrossRef

@Database(
    entities = [Genre::class, Movie::class, MovieGenreCrossRef::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun genreDao(): GenreDao
    abstract fun movieDao(): MovieDao
}