package den.project.diplom.data.storage.dao

import androidx.room.*
import den.project.diplom.data.storage.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieEntity: MovieEntity)

    @Query("SELECT * FROM favorite ORDER BY id DESC")
    fun getAllMovies(): Flow<List<MovieEntity>>

//    @Query("SELECT * FROM favorite WHERE id = :id")
//    fun getMovie(id: String): List<MovieEntity>

    @Query("DELETE FROM favorite WHERE id = :id")
    suspend fun deleteMovies(id: String)

}