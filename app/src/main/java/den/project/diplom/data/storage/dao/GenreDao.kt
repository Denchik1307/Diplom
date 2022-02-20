package den.project.diplom.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import den.project.diplom.data.storage.entity.Genre

@Dao
interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(genres: List<Genre>)

    @Query("SELECT * FROM Genre")
    fun getAllGenres(): List<Genre>
}