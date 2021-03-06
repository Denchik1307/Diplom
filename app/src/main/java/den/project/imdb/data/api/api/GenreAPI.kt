package den.project.imdb.data.api.api

import den.project.imdb.data.api.model.response.GenreResponse
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