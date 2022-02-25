package den.project.diplom.data.storage.dao

import androidx.room.*
import den.project.diplom.data.storage.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert()

    @Query("SELECT * FROM favorite")
    fun getMovies(id: String?): List<MovieEntity>

    @Query("DELETE FROM favorite WHERE id = :id")
    fun deleteMovies(id:String?)

}