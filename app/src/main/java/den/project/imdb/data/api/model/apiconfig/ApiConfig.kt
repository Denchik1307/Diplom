package den.project.imdb.data.api.model.apiconfig


import com.google.gson.annotations.SerializedName

data class ApiConfig(
    //https://api.themoviedb.org/3/configuration?api_key=b561f68242545b905c15c305c059577a
    @SerializedName("change_keys")
    val changeKeys: List<String>?,
    @SerializedName("images")
    val images: Images?
)