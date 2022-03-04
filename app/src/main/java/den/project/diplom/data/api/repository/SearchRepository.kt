package den.project.diplom.data.api.repository

import den.project.diplom.data.api.model.Movie

interface SearchRepository {
    suspend fun searchMovie(query: String, language: String): List<Movie>
}