package den.project.imdb.data.api.model.response

import com.google.gson.annotations.SerializedName
import den.project.imdb.data.api.model.Trailer

data class TrailerResponse(
    @SerializedName("results") val results: List<Trailer>
)
