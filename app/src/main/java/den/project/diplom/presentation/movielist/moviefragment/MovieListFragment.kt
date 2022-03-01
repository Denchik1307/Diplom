package den.project.diplom.presentation.movielist.moviefragment

import android.content.ActivityNotFoundException
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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentMovieListBinding
import den.project.diplom.presentation.movielist.adapters.movieadapter.ItemMovieListener
import den.project.diplom.presentation.movielist.adapters.movieadapter.MovieAdapter
import den.project.diplom.presentation.movielist.viewmodel.MovieDetailViewModel
import den.project.diplom.presentation.movielist.viewmodel.MoviePopularViewModel
import den.project.diplom.presentation.movielist.viewmodel.MovieTrailerViewModel
import den.project.diplom.utils.Constants
import den.project.diplom.utils.Constants.MAX_PAGE
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val movieAdapter by lazy {
        MovieAdapter(context = requireContext(), itemMovieListener = itemMovieListener)
    }
    private val binding by viewBinding(vbFactory = FragmentMovieListBinding::bind)
    private val viewModelList: MoviePopularViewModel by viewModels()
    private val viewModelTrailer: MovieTrailerViewModel by viewModels()
    private val viewModelDetail: MovieDetailViewModel by viewModels()
    private var isInit = false
    private var page: Int = 1
    private val itemMovieListener: ItemMovieListener = object : ItemMovieListener {
        override fun idClickListener(id: String) {
            Log.d("MOVIE", id)
            viewModelTrailer.getTrailer(id)

        }

        override fun favoriteClickListener() {
            TODO("Not yet implemented")
        }

        override fun onMoviesClickListener(id: String) {
            viewModelDetail.getMovieDetail(movie_id = id, "ru")
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
            val lastItemCount = recycler.findLastCompletelyVisibleItemPosition()
            val itemCount = recycler.itemCount
            if (itemCount <= lastItemCount + 1 && page != MAX_PAGE) {
                page++
                viewModelList.getPopular(page = page, language = "ru")
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        lifecycleScope.launch {
            viewModelList.listMovie.collect {
                movieAdapter.showMovie(movie = it)
            }
        }
        viewModelList.getPopular(page = page, language = "ru")
        initYoutubeObserver()
    }

    private fun initRecycler() {
        binding.apply {
            recyclerMovieList.adapter = movieAdapter
            recyclerMovieList.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerMovieList.addOnScrollListener(scrollListener)
        }
    }

    private fun initYoutubeObserver() {
//        viewModelTrailer.viewModelScope.launch {
        viewModelTrailer.trailer.observe(viewLifecycleOwner) {
            val intentOne =
                Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BASE_PATH_TRAILER + it))
            val intentTwo = Intent(
                Intent.CATEGORY_APP_BROWSER,
                Uri.parse(Constants.BASE_PATH_TRAILER2 + it)
            )
            Log.d("MOVIE", "$it <- key")
            Log.d("MOVIE", "${intentOne.dataString} <- intent one")
            Log.d("MOVIE", "${intentTwo.dataString} <- intent two")
            if (!isInit) {
                isInit = true
            }else{
                try {
                    requireActivity().startActivity(intentOne)
                } catch (ex: ActivityNotFoundException) {
                    requireActivity().startActivity(intentTwo)
                }
            }
        }
    }
}




