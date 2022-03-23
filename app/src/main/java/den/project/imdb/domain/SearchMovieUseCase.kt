package den.project.imdb.domain

import den.project.imdb.data.api.model.Movie
import kotlinx.coroutines.flow.Flow

interface SearchMovieUseCase {
    suspend operator fun invoke(page: String, name: String, language: String): Flow<List<Movie>>
}