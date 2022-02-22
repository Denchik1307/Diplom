package den.project.diplom.data.storage.dao
//
//import androidx.room.*
//import den.project.diplom.data.storage.entity.MovieEntity
//
//@Dao
//interface MovieDao {
//
//    @Transaction
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(movieEntity: List<MovieEntity>)
//
//    @Transaction
//    @Query("SELECT * FROM favorite")
//    fun getAllMovies(): List<MovieEntity>
//}