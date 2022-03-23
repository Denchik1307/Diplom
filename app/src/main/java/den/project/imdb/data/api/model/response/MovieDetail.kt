package den.project.imdb.data.api.model.response

import com.google.gson.annotations.SerializedName
import den.project.imdb.data.api.model.Genre

data class MovieDetail(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,//
    @SerializedName("tagline") val tagline: String,
    @SerializedName("status") val status: String,
    @SerializedName("overview") val overview: String,//
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("genres") val genres: List<Genre>,
)
