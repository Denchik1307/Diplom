package den.project.diplom.presentation.movielist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import den.project.diplom.domain.GetTrailerMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieTrailerViewModel @Inject constructor(
    private val getTrailerMoviesUseCase: GetTrailerMoviesUseCase
) : ViewModel() {

    private val _trailer = MutableLiveData<String>("test")
    val trailer: LiveData<String> = _trailer

    fun getTrailer(movie_id: String) {
        viewModelScope.launch(Dispatchers.Main) {
            getTrailerMoviesUseCase(movie_id, "ru").collect {
                _trailer.value = it?.results[0]?.key
            }
        }
    }
}