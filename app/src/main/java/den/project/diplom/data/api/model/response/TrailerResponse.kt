package den.project.diplom.data.api.model.response

import com.google.gson.annotations.SerializedName
import den.project.diplom.model.Trailer

data class TrailerResponse(
    @SerializedName("results") val results: List<Trailer>
)
