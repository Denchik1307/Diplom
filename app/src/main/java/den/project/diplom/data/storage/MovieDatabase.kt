package den.project.diplom.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import den.project.diplom.data.storage.dao.MovieDao
import den.project.diplom.data.storage.entity.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
    ], version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}