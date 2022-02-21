package den.project.diplom.data.storage.dto

//import androidx.room.Embedded
//import androidx.room.Junction
//import androidx.room.Relation
//import den.project.diplom.data.storage.entity.Reservation
//import den.project.diplom.data.storage.entity.Guest
//import den.project.diplom.data.storage.entity.ReservationGuest
//
//data class ReservationWithGuests(
//
//    @Embedded val reservation: Reservation ,
//    @Relation(
//        parentColumn = "idGenre",
//        entity = Guest::class,
//        entityColumn = "idMovie",
//        associateBy = Junction(
//            value = ReservationGuest::class,
//            parentColumn = "reservationId",
//            entityColumn = "guestId",
//        )
//    ) val guestIdList: List<Guest>
//)