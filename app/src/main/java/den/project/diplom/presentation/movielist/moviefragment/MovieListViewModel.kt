package den.project.diplom.presentation.movielist.moviefragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.data.api.model.Movie
import den.project.diplom.domain.GetFromDataBaseFavorite
import den.project.diplom.domain.GetPopularMoviesUseCase
import den.project.diplom.domain.GetTrailerMoviesUseCase
import den.project.diplom.domain.SaveInDataBaseFavorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTrailerMoviesUseCase: GetTrailerMoviesUseCase,
    private val saveToFavorite: SaveInDataBaseFavorite,
    private val getFromDataBaseFavorite: GetFromDataBaseFavorite,
) : ViewModel() {

    private val _listMovies = MutableStateFlow<List<Movie>>(value = listOf())
    val listMovie: StateFlow<List<Movie>> = _listMovies.asStateFlow()

    private val _trailer = MutableStateFlow<String>(value = "")
    val trailer: StateFlow<String> = _trailer.asStateFlow()

    fun getPopular(page: Int, language: String) = viewModelScope.launch(Dispatchers.IO) {
        getPopularMoviesUseCase(page = page, language = language).collect {
            _listMovies.value = it
        }
    }

    fun getTrailer(movie_id: String) = viewModelScope.launch(Dispatchers.IO) {
        getTrailerMoviesUseCase(movie_id = movie_id).collect { trailer->
            _trailer.value = trailer.key
        }
    }

    fun saveFavorite(){

    }
}