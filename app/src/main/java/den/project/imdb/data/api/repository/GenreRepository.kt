package den.project.imdb.data.api.repository

import den.project.imdb.data.api.model.Genre

interface GenreRepository {
    suspend fun getGenres(language: String): List<Genre>
}