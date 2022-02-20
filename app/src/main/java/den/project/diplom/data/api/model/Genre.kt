package den.project.diplom.data.api.model

import com.google.gson.annotations.SerializedName
import den.project.diplom.data.storage.entity.Genre as RoomGenre

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
) {
    fun toRoomEntity(): RoomGenre {
        return RoomGenre(this.id, this.name)
    }
}
