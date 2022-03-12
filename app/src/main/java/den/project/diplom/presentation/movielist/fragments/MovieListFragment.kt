package den.project.diplom.presentation.movielist.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AbsListView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentMovieListBinding
import den.project.diplom.presentation.movielist.adapters.movieadapter.ItemMovieListener
import den.project.diplom.presentation.movielist.adapters.movieadapter.MovieAdapter
import den.project.diplom.presentation.movielist.viewmodel.MovieViewModel
import den.project.diplom.utils.Constants
import den.project.diplom.utils.Logging.isLogging
import den.project.diplom.utils.Logging.showLogTagMovie
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.sign

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val movieAdapter by lazy {
        MovieAdapter(context = requireContext(), itemMovieListener = itemMovieListener)
    }
    private val binding by viewBinding(vbFactory = FragmentMovieListBinding::bind)
    private val viewModel: MovieViewModel by viewModels()
    private var isInit = false
    private var isSearch = false
    private var pagePopular: Int = 1
    private var pageSearch: Int = 1
    private val itemMovieListener: ItemMovieListener = object : ItemMovieListener {
        override fun idClickListener(id: String) {
            showLogTagMovie("MOVIE", id)
            viewModel.getTrailer(id)
        }

        override fun favoriteClickListener() {

        }

        override fun onMoviesClickListener(id: String) {
            val bundle = Bundle()
            bundle.putString("movie", id)
            findNavController().navigate(R.id.singleMovieFragment, bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initTrailerViewModel()
        showPopularMovie()
    }

    override fun onStart() {
        super.onStart()
    }

    private var isScrolling = false
    private val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val recycler = recyclerView.layoutManager as GridLayoutManager
            val lastCompleteItemCount = recycler.findLastCompletelyVisibleItemPosition()
            val lastVisibleItemCount = recycler.findLastVisibleItemPosition()
            val firstCompleteItemCount = recycler.findFirstCompletelyVisibleItemPosition()
            val firstVisibleItemCount = recycler.findFirstVisibleItemPosition()
            val spanCount = recycler.spanCount
            val baseline = recycler.baseline
            val childCount = recycler.childCount
            val initialPrefetchItemCount = recycler.initialPrefetchItemCount
            val dxAbsolute = dx.absoluteValue
            val dxSign = dx.sign
            val itemCount = recycler.itemCount
            if (itemCount <= lastCompleteItemCount + 1 && pagePopular != Constants.MAX_PAGE && !isSearch) {

                pagePopular++
                showPopularMovie()
                recycler.scrollToPosition(1)
            }
            if (isLogging) {
                showLogTagMovie(lastCompleteItemCount, "lastCompleteItemCount")
                showLogTagMovie(lastVisibleItemCount, "lastVisibleItemCount")
                showLogTagMovie(firstCompleteItemCount, "firstCompleteItemCount")
                showLogTagMovie(firstVisibleItemCount, "firstVisibleItemCount")
                showLogTagMovie(spanCount, "spanCount")
                showLogTagMovie(pagePopular, "pagePopular")
                showLogTagMovie(baseline, "baseline")
                showLogTagMovie(childCount, "childCount")
                showLogTagMovie(initialPrefetchItemCount, "initialPrefetchItemCount")
                showLogTagMovie(itemCount, "itemCount")
                showLogTagMovie(dxAbsolute, "dxAbsolute")
                showLogTagMovie(dxSign, "dxSign")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initYoutubeObserver()
        lifecycleScope.launch {
            viewModel.listMovie.collect {
                movieAdapter.showMovie(movie = it)
            }
        }
        with(binding) {
            if (searchMovie.isSelected){
                searchMovie.width = 150
                Log.d("MOVIE","hi")
            }else{
                searchMovie.width = 200
                Log.d("MOVIE","hi")
            }
            searchMovie.addTextChangedListener { searchText ->
                if (searchText!!.length >= 3) {
                    lifecycleScope.launch {
                        delay(500L)
                        viewModel.searchMovie(pageSearch.toString(), searchText.toString(), "ru")
                    }
                }
                if (searchText.isEmpty()) {
                    pagePopular = 1
                    showPopularMovie()
                }
            }
            viewModel.getPopular(page = pagePopular, language = "ru")
            binding.container.startAnimation(
                AnimationUtils.loadAnimation(
                    requireContext(),
                    R.anim.scale
                )
            )
        }

    }

    private fun initRecycler() {
        binding.apply {
            recyclerMovieList.adapter = movieAdapter
            recyclerMovieList.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerMovieList.addOnScrollListener(scrollListener)
        }
    }

    private fun initYoutubeObserver() {
        viewModel.trailer.observe(viewLifecycleOwner) {
            if (it != "empty") {
                val intentOne =
                    Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BASE_PATH_TRAILER + it))
                val intentTwo = Intent(
                    Intent.CATEGORY_APP_BROWSER,
                    Uri.parse(Constants.BASE_PATH_TRAILER2 + it)
                )
                try {
                    requireActivity().startActivity(intentOne)
                } catch (ex: ActivityNotFoundException) {
                    requireActivity().startActivity(intentTwo)
                }
            } else {
                if (isInit) {
                    Toast.makeText(
                        requireContext(),
                        "Нет ссылки на рейлер для этого фильма :(",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    isInit = true
                }
            }
        }
    }

    private fun showPopularMovie() {
        viewModel.getPopular(page = pagePopular, language = "ru")
    }

}