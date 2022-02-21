//package den.project.diplom.data.storage
//
//import androidx.room.Database
//import androidx.room.RoomDatabase
//import den.project.diplom.data.storage.dao.GenreDao
//import den.project.diplom.data.storage.dao.MovieDao
//import den.project.diplom.data.storage.entity.Reservation
//import den.project.diplom.data.storage.entity.Guest
//import den.project.diplom.data.storage.entity.ReservationGuest
//
//@Database(
//    entities = [
//        Reservation::class,
//        Guest::class,
//        ReservationGuest::class],
//    version = 1
//)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun genreDao(): GenreDao
//    abstract fun movieDao(): MovieDao
//}