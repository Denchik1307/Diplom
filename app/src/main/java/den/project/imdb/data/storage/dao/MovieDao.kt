package den.project.imdb.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)

    @Query("SELECT * FROM favorite")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM favorite WHERE id = :id")
    fun getMovie(id: String): List<MovieEntity>

    @Query("DELETE FROM favorite WHERE id = :id")
    fun deleteMovies(id: String)

}