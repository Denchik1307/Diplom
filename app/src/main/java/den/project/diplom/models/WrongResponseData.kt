package den.project.diplom.models


import com.google.gson.annotations.SerializedName

data class WrongResponseData(
    @SerializedName("status_code") val statusCode: Int = 0, // 7
    @SerializedName("status_message") val statusMessage: String = "empty", // Invalid API key: You must be granted a valid key.
    @SerializedName("success") val success: Boolean = false
)