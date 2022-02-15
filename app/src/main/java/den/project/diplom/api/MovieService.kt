package den.project.diplom.api

import den.project.diplom.models.LanguageResponseItem
import den.project.diplom.models.response.ImageMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    //https://api.themoviedb.org/3/configuration/languages?api_key=b561f68242545b905c15c305c059577a
    //https://image.tmdb.org/t/p/w500/zpH4yEqOJOReykVcSQYA1A258SQ.jpg

    @GET("configuration/languages")
    suspend fun getLanguagesMovie(
        @Query("iso_639_1") shortNameLang: String,
    ): List<LanguageResponseItem>

    @GET("configuration/languages")
    suspend fun getImageMovie(
        @Query("id") id: String,
    ): List<ImageMovieResponse>

    @GET("configuration/languages")
    suspend fun getPopularMovie(
        @Query("id") id: String,
    ): List<ImageMovieResponse>


}