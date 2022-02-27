package den.project.diplom.presentation.movielist.moviefragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.data.api.model.Movie
import den.project.diplom.domain.GetPopularMoviesUseCase
import den.project.diplom.domain.GetTrailerMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTrailerMoviesUseCase: GetTrailerMoviesUseCase,
) : ViewModel() {

    private val _listMovies = MutableStateFlow<List<Movie>>(value = listOf())
    val listMovie: StateFlow<List<Movie>> = _listMovies.asStateFlow()

    private val _trailer = MutableStateFlow<String>("test")
    val trailer: StateFlow<String> = _trailer

    fun getPopular(page: Int, language: String) = viewModelScope.launch(Dispatchers.IO) {
        getPopularMoviesUseCase(page = page, language = language).collect {
            _listMovies.value = it
        }
    }

    fun getTrailer(movie_id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("MOVIE", this.toString() + " <- viewModuleOne")
            getTrailerMoviesUseCase(movie_id).collect {
                Log.d("MOVIE", it + " <- viewModel")
                _trailer.value = it
            }
        }
    }
}