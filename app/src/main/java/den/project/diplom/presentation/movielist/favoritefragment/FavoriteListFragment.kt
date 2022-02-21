package den.project.diplom.presentation.movielist.favoritefragment

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
class FavoriteListFragment : Fragment(R.layout.favorite_movie_fragment) {
    //    private val binding by viewBinding(FragmentMovieListBinding::bind)
//    private val viewModel: FavoriteListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        lifecycleScope.launch {
//            viewModel.listMovie.collect {
//                Log.d("MOVIE", it.toString())
//            }
//        }
//
////        viewModel.getPopular(1, "ru")
    }

}