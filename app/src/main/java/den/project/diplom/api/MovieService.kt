package den.project.diplom.api

import den.project.diplom.models.LanguageDadaItem
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    //https://api.themoviedb.org/3/configuration/languages?api_key=b561f68242545b905c15c305c059577a

    @GET("configuration/languages")
    suspend fun getLanguage(
        @Query("iso_639_1") shorNameLang: String,
    ):List<LanguageDadaItem>

}