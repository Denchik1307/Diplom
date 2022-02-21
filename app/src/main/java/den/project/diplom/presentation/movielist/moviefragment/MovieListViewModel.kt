package den.project.diplom.presentation.movielist.moviefragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.domain.GetPopularMoviesUseCase
import den.project.diplom.data.api.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _listMovies = MutableStateFlow<List<Movie>>(listOf())
    val listMovie: StateFlow<List<Movie>> = _listMovies.asStateFlow()

    fun getPopular(page: Int, language: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getPopularMoviesUseCase(page, language)
                .catch {
                    Log.d("MOVIE","2")
                }
                .collect { movieList ->
                    _listMovies.emit(movieList)
                }
        }
    }
}