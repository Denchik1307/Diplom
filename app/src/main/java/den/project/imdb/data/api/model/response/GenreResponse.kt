package den.project.imdb.data.api.model.response

import com.google.gson.annotations.SerializedName
import den.project.imdb.data.api.model.Genre


data class GenreResponse(
    @SerializedName("genres") val genres: List<Genre>
)
