package den.project.diplom.data

import den.project.diplom.data.api.model.Movie

interface SearchRepository {
    suspend fun searchMovie(page: Int, query: String, language: String): List<Movie>
}