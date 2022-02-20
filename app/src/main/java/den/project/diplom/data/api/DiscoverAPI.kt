package den.project.diplom.data.api

import den.project.diplom.data.api.model.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverAPI {

    @GET("discover/movie")
    suspend fun getMovieByGenre(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
        @Query("with_genres") genre_id: String,
    ): Response<MovieResponse>
}