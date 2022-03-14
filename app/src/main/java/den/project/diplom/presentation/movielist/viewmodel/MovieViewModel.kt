package den.project.diplom.presentation.movielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.api.model.response.MovieDetail
import den.project.diplom.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getDetailMoviesUseCase: GetDetailMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getTrailerMoviesUseCase: GetTrailerMoviesUseCase,
    private val searchMovieUseCase: SearchMovieUseCase,
) : ViewModel() {

    private val _detailMovie = MutableStateFlow<List<MovieDetail>>(value = listOf())
    private val _listPopularMovies = MutableStateFlow<List<Movie>>(value = listOf())
    private val _listTopRatedMovies = MutableStateFlow<List<Movie>>(value = listOf())
    private val _trailer = MutableLiveData("empty")
    val detailMovie: StateFlow<List<MovieDetail>> = _detailMovie.asStateFlow()
    val listPopularMovie: StateFlow<List<Movie>> = _listPopularMovies.asStateFlow()
    val listTopRatedMovie: StateFlow<List<Movie>> = _listTopRatedMovies.asStateFlow()
    val trailer: LiveData<String> = _trailer

    fun getMovieDetail(movie_id: String, language: String) = viewModelScope.launch(Dispatchers.IO) {
        getDetailMoviesUseCase(movie_id, language).collect {
            _detailMovie.value = listOf(it)
        }
    }

    fun getPopular(page: Int, language: String) = viewModelScope.launch(Dispatchers.IO) {
        getPopularMoviesUseCase(page = page, language = language).collect {
            _listPopularMovies.value = it
        }
    }

    fun getTopRated(page: Int, language: String) = viewModelScope.launch(Dispatchers.IO) {
        getTopRatedMoviesUseCase.getTopRated(page = page, language = language).collect {
            _listTopRatedMovies.value = it
        }
    }

    fun searchMovie(page: String, name: String, language: String) =
        viewModelScope.launch(Dispatchers.IO) {
            searchMovieUseCase(page = page, name = name, language = language).collect {
                _listPopularMovies.value = it
            }
        }

    fun getTrailer(movie_id: String) {
        viewModelScope.launch(Dispatchers.Main) {
            getTrailerMoviesUseCase(movie_id, "ru").collect { trailerRu ->
                if (trailerRu.isNotEmpty()) {
                    _trailer.value = trailerRu[0].key!!
                } else {
                    getTrailerMoviesUseCase(movie_id, "en").collect { trailerEn ->
                        if (trailerEn.isNotEmpty()) {
                            _trailer.value = trailerEn[0].key!!
                        } else {
                            initTrailerViewModel()
                        }
                    }
                }
            }
        }
    }

    fun initTrailerViewModel(){
        _trailer.value = "empty"
    }
}