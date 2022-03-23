package den.project.imdb.data.api.repository

import den.project.imdb.data.api.model.Movie

interface SearchRepository {
    suspend fun searchMovie(page: String, query: String, language: String): List<Movie>
}