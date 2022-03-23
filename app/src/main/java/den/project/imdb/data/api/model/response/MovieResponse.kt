package den.project.imdb.data.api.model.response

import com.google.gson.annotations.SerializedName
import den.project.imdb.data.api.model.Movie

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Long,
)
