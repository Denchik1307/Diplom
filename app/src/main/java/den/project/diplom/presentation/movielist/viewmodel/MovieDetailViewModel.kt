package den.project.diplom.presentation.movielist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.data.api.model.response.MovieDetail
import den.project.diplom.domain.GetDetailMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getDetailMoviesUseCase: GetDetailMoviesUseCase,
) : ViewModel() {

    private val _detailMovie = MutableStateFlow<List<MovieDetail>>(listOf())
    val detailMovie: StateFlow<List<MovieDetail>> = _detailMovie.asStateFlow()

    fun getMovieDetail(movie_id: String, language: String) =
        viewModelScope.launch(Dispatchers.IO) {
            getDetailMoviesUseCase.getMovieDetail(movie_id, language).collect {
                _detailMovie.value = listOf(it)
            }
        }
}