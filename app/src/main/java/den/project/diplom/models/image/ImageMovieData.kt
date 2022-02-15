package den.project.diplom.models.image


import com.google.gson.annotations.SerializedName

data class ImageMovieData(
    @SerializedName("id")
    val id: Int, // 634649
    @SerializedName("logos")
    val logos: List<Logo>,
    @SerializedName("posters")
    val posters: List<Poster>
)