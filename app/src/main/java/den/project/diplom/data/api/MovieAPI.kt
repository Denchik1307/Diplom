package den.project.diplom.data.api

import den.project.diplom.model.MovieDetail
import den.project.diplom.data.api.model.response.MovieResponse
import den.project.diplom.data.api.model.response.TrailerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int,
        @Query("language") language: String
    ): Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movie_id: String,
        @Query("api_key") api_key: String,
    ): Response<MovieDetail>

    @GET("movie/{movie_id}/videos")
    suspend fun getTrailerLink(
        @Path("movie_id") movie_id: String,
        @Query("api_key") api_key: String,
    ): Response<TrailerResponse>
}