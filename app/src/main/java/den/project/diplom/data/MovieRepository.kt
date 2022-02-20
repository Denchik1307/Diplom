package den.project.diplom.data

import den.project.diplom.data.api.model.Movie

interface MovieRepository {
    suspend fun getPopular(page: Int, language: String) : List<Movie>
//    suspend fun getTopRated(page: Int) : MovieResponse
//    suspend fun getUpcoming(page: Int) : MovieResponse
//    suspend fun getMovie(movie_id: String) : MovieDetail
//    suspend fun getTrailer(movie_id: String) : TrailerResponse
}