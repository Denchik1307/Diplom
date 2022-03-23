package den.project.imdb.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import den.project.imdb.data.storage.dao.MovieDao
import den.project.imdb.data.storage.dao.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
    ], version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}