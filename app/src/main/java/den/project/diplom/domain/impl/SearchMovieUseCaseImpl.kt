package den.project.diplom.domain.impl

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.api.repository.SearchRepository
import den.project.diplom.domain.SearchMovieUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchMovieUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchMovieUseCase {
    override suspend fun invoke(page: String, name: String, language: String): Flow<List<Movie>> =
        flow {
            emit(searchRepository.searchMovie(page = page, query = name, language = language))
        }
}