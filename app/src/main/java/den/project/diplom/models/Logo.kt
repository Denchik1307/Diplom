package den.project.diplom.models

import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("aspect_ratio") val aspectRatio: Double, // 5.431
    @SerializedName("file_path") val filePath: String, // /hmalbFydQb0KBU2ltCbtlVKtr1L.png
    @SerializedName("height") val height: Int, // 144
    @SerializedName("iso_639_1") val iso6391: String,   // ru
    @SerializedName("vote_average") val voteAverage: Double, // 0.0
    @SerializedName("vote_count") val voteCount: Int, // 0
    @SerializedName("width") val width: Int // 782
)