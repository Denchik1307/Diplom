package den.project.diplom.presentation.movielist.moviefragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentMovieListBinding
import den.project.diplom.presentation.movielist.adapters.movieadapter.ItemMovieListener
import den.project.diplom.presentation.movielist.adapters.movieadapter.MovieAdapter
import den.project.diplom.utils.Constants
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val movieAdapter by lazy {
        MovieAdapter(context = requireContext(), itemMovieListener = itemMovieListener)
    }
    private val binding by viewBinding(vbFactory = FragmentMovieListBinding::bind)
    private val viewModel: MovieListViewModel by viewModels()
    private var totalPage: Int = 1
    private val itemMovieListener: ItemMovieListener = object : ItemMovieListener {
        override fun idClickListener(id: String) {
            Log.d("MOVIE", id)
            initYoutube(id = id)
        }

        override fun favoriteClickListener() {
            TODO("Not yet implemented")
        }

        override fun onMoviesClickListener(id: String) {
            TODO("Not yet implemented")
        }
    }

    private var isScrolling = false
    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val recycler = recyclerView.layoutManager as GridLayoutManager
            val totalItemCount = recycler.findLastCompletelyVisibleItemPosition()
            Log.d("SCROLL", "$totalItemCount <-item count")
            if (totalItemCount >=19){
                totalPage++
                viewModel.getPopular(page = totalPage, language = "ru")
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        lifecycleScope.launch {
            viewModel.listMovie.collect {
                Log.d("MOVIE", "$it <- listMovie")
                movieAdapter.showMovie(movie = it)
            }
        }
        viewModel.getPopular(page = totalPage, language = "ru")


    }

    private fun initRecycler() {
        binding.apply {
            recyclerMovieList.adapter = movieAdapter
            recyclerMovieList.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerMovieList.addOnScrollListener(scrollListener)
        }
    }

    private fun initYoutube(id: String) {
        viewModel.viewModelScope.launch {
            viewModel.trailer.collect {
                viewModel.getTrailer(id)
                val intentOne =
                    Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BASE_PATH_TRAILER + it))
                val intentTwo = Intent(Intent.CATEGORY_APP_BROWSER,
                    Uri.parse(Constants.BASE_PATH_TRAILER2 + it))
                Log.d("MOVIE", "$it <- key")
                Toast.makeText(requireContext(), intentOne.dataString, Toast.LENGTH_LONG).show()
                Toast.makeText(requireContext(), intentTwo.dataString, Toast.LENGTH_LONG).show()
//                try {
//                    requireActivity().startActivity(intentOne)
//                } catch (ex: ActivityNotFoundException) {
//                    requireActivity().startActivity(intentTwo)
//                }
            }
        }
    }
}




