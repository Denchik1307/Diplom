package den.project.diplom.models

import com.google.gson.annotations.SerializedName

data class Poster(
    //full link https://image.tmdb.org/t/p/w500/zpH4yEqOJOReykVcSQYA1A258SQ.jpg

    @SerializedName("aspect_ratio") val aspectRatio: Double, // 0.667
    @SerializedName("file_path") val filePath: String, // /zpH4yEqOJOReykVcSQYA1A258SQ.jpg
    @SerializedName("height") val height: Int, // 2000
    @SerializedName("iso_639_1") val iso6391: String, // ru
    @SerializedName("vote_average") val voteAverage: Float, // 5.456
    @SerializedName("vote_count") val voteCount: Int, // 5
    @SerializedName("width") val width: Int // 1334
)