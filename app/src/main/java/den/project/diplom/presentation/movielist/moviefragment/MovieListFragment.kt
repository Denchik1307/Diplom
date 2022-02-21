package den.project.diplom.presentation.movielist.moviefragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {
    //    private val binding by viewBinding(FragmentMovieListBinding::bind)
    private val viewModel: MovieListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.listMovie.collect {
                Log.d("MOVIE", "1" + it.toString())
            }
        }
        viewModel.getPopular(page = 1, language = "ru")
    }

//    private fun initObserver() {
//        viewModel.listMovie.observe(viewLifecycleOwner, Observer {
//        })
//    }
}