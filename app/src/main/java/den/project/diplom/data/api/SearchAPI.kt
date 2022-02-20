package den.project.diplom.data.api

import den.project.diplom.data.api.model.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
        @Query("query") query: String,
    ): Response<MovieResponse>
}