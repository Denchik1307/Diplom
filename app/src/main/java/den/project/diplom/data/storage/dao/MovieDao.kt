package den.project.diplom.data.storage.dao

import androidx.room.*
import den.project.diplom.data.storage.dto.MovieWithGenres

@Dao
interface MovieDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movie: List<MovieWithGenres>)

    @Transaction
    @Query("SELECT * FROM Movie")
    fun getAllMovies(): List<MovieWithGenres>
}