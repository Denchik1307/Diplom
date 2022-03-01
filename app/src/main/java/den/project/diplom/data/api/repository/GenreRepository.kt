package den.project.diplom.data.api.repository

import den.project.diplom.data.api.model.Genre

interface GenreRepository {
    suspend fun getGenres(language: String): List<Genre>
}