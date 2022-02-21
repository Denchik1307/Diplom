package den.project.diplom.presentation.movielist.favoritefragment

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.data.api.model.Movie
import den.project.diplom.domain.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) :ViewModel() {

//    private val _listMovies = MutableStateFlow<List<Movie>>(listOf())
//    val listMovie: StateFlow<List<Movie>> = _listMovies.asStateFlow()

}
