package den.project.diplom.models


import com.google.gson.annotations.SerializedName

data class LanguageDadaItem(
    @SerializedName("english_name") val englishName: String, // Yoruba
    @SerializedName("iso_639_1") val shorNameLang: String, // yo
    @SerializedName("name") val originName: String // Èdè Yorùbá
)