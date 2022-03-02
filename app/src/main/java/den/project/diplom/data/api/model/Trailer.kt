package den.project.diplom.data.api.model

import com.google.gson.annotations.SerializedName

data class Trailer(
    @SerializedName("name") val title: String?,
    @SerializedName("key") val key: String?,
    @SerializedName("site") val site: String?,
)
