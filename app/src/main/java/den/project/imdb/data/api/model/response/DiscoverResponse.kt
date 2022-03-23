package den.project.imdb.data.api.model.response


import com.google.gson.annotations.SerializedName
import den.project.imdb.data.api.model.Result

data class DiscoverResponse(
    @SerializedName("page")
    val page: Int?, // 1
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("total_pages")
    val totalPages: Int?, // 870
    @SerializedName("total_results")
    val totalResults: Int? // 17394
)