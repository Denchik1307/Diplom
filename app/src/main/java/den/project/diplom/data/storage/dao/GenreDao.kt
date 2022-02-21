//package den.project.diplom.data.storage.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import den.project.diplom.data.storage.entity.Reservation
//
//@Dao
//interface GenreDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(reservations: List<Reservation>)
//
//    @Query("SELECT * FROM Reservation")
//    fun getAllGenres(): List<Reservation>
//}