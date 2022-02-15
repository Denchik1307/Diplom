package den.project.diplom.models.response

import com.google.gson.annotations.SerializedName
import den.project.diplom.models.Logo
import den.project.diplom.models.Poster

data class ImageMovieResponse(
    @SerializedName("id") val id: Int, // 634649
    @SerializedName("logos") val logos: List<Logo>,
    @SerializedName("posters") val posters: List<Poster>
)