package den.project.imdb.data.api.model.apiconfig


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("backdrop_sizes")
    val backdropSizes: List<String>?,
    @SerializedName("base_url")
    val baseUrl: String?, // http://image.tmdb.org/t/p/
    @SerializedName("logo_sizes")
    val logoSizes: List<String>?,
    @SerializedName("poster_sizes")
    val posterSizes: List<String>?,
    @SerializedName("profile_sizes")
    val profileSizes: List<String>?,
    @SerializedName("secure_base_url")
    val secureBaseUrl: String?, // https://image.tmdb.org/t/p/
    @SerializedName("still_sizes")
    val stillSizes: List<String>?
)