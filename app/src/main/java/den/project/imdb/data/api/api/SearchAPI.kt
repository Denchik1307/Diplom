package den.project.imdb.data.api.api

import den.project.imdb.data.api.model.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: String,
        @Query("query") query: String,
        @Query("language") language: String
    ): Response<MovieResponse>
}