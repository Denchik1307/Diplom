package den.project.diplom.data.api

import den.project.diplom.data.api.model.response.GenreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreAPI {

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Response<GenreResponse>
}