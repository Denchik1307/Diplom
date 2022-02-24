package den.project.diplom.data.storage.dao

import androidx.room.*
import den.project.diplom.data.storage.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movieEntity: List<MovieEntity>)

    @Query("SELECT * FROM favorite")
    fun getMovies(): List<MovieEntity>

    @Query("DELETE FROM favorite WHERE id = :id")
    fun getMovies(id:String)

}