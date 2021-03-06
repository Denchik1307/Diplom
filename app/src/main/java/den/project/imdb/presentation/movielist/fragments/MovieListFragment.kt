package den.project.imdb.presentation.movielist.fragments

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
import den.project.imdb.R
import den.project.imdb.databinding.FragmentMovieListBinding
import den.project.imdb.presentation.movielist.adapters.movieadapter.ItemMovieListener
import den.project.imdb.presentation.movielist.adapters.movieadapter.MovieAdapter
import den.project.imdb.presentation.movielist.viewmodel.MovieViewModel
import den.project.imdb.utils.Constants
import den.project.imdb.utils.Logging.showLog
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
            showLog("MOVIE", id)
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
            val itemCount = recycler.itemCount
            if (itemCount <= lastCompleteItemCount + 1 && pagePopular != Constants.MAX_PAGE && !isSearch) {
                pagePopular++
                showPopularMovie(pagePopular)
                recycler.scrollToPosition(1)
            }
            showLog(lastCompleteItemCount, "lastCompleteItemCount")
            showLog(recycler.findLastVisibleItemPosition(), "lastVisibleItemCount")
            showLog(recycler.findFirstCompletelyVisibleItemPosition(),
                "firstCompleteItemCount")
            showLog(recycler.findFirstVisibleItemPosition(), "firstVisibleItemCount")
            showLog(recycler.spanCount, "spanCount")
            showLog(pagePopular, "pagePopular")
            showLog(recycler.baseline, "baseline")
            showLog(recycler.childCount, "childCount")
            showLog(recycler.initialPrefetchItemCount, "initialPrefetchItemCount")
            showLog(itemCount, "itemCount")
            showLog(dx.absoluteValue, "dxAbsolute")
            showLog(dx.sign, "dxSign")
        }
    }

    init {
        Log.d("!!!", "init")
    }

    override fun onStart() {
        super.onStart()
        Log.d("!!!", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("!!!", "onResume")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("!!!", "onCreate")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initTrailerViewModel()
        isInit = false
        Log.d("!!!", "onViewCreated")
        initRecycler()
        initYoutubeObserver()
        showPopularMovie(pagePopular)
        lifecycleScope.launch {
            viewModel.listTopRatedMovie.collect {
                movieAdapter.showMovie(movie = it)
            }
        }
        lifecycleScope.launch {

            viewModel.listPopularMovie.collect {
                movieAdapter.showMovie(movie = it)
            }
        }
        with(binding) {
            if (tvSearchMovie.isPressed) {
                showLog("MOVIE", tvSearchMovie.isCursorVisible.toString())
                showLog("MOVIE", tvSearchMovie.isActivated.toString())
                showLog("MOVIE", tvSearchMovie.isEnabled.toString())
                showLog("MOVIE", tvSearchMovie.isFocused.toString())
                tvSearchMovie.width = 200
            } else {
                tvSearchMovie.width = 200
                showLog("MOVIE", tvSearchMovie.isCursorVisible.toString())
                showLog("MOVIE", tvSearchMovie.isActivated.toString())
                showLog("MOVIE", tvSearchMovie.isEnabled.toString())
                showLog("MOVIE", tvSearchMovie.isFocused.toString())
                showLog("MOVIE", "low")
            }
            tvSearchMovie.addTextChangedListener { searchText ->
                if (searchText!!.length >= 3) {
                    lifecycleScope.launch {
                        delay(500L)
                        viewModel.searchMovie(pageSearch.toString(), searchText.toString(), "ru")
                    }
                }
                if (searchText.isEmpty()) {
                    pagePopular = 1
                    showPopularMovie(pagePopular)
                }
            }
            showPopularMovie(pagePopular)
            binding.container.startAnimation(
                AnimationUtils.loadAnimation(
                    requireContext(),
                    R.anim.scale
                )
            )
        }
    }

    private fun initRecycler() {
        Log.d("!!!", "initRecycler")
        binding.apply {
            recyclerMovieList.adapter = movieAdapter
            recyclerMovieList.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerMovieList.addOnScrollListener(scrollListener)
        }
    }

    private fun initYoutubeObserver() {
        Log.d("!!!", "initYoutubeObserver")
        lifecycleScope.launch {
            viewModel.trailer.collect {
                if (it != "empty") {
                    val intentOne =
                        Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BASE_PATH_TRAILER + it))
                    try {
                        requireActivity().startActivity(intentOne)
                    } catch (ex: ActivityNotFoundException) {
                        throw ex
                    }
                } else {
                    if (isInit) {
                        Toast.makeText(
                            requireContext(),
                            "?????? ???????????? ???? ???????????? ?????? ?????????? ???????????? :(",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        isInit = true
                    }
                }
            }
        }
    }

    private fun showPopularMovie(page: Int) {
        Log.d("!!!", "showPopularMovie")
        viewModel.getPopular(page = page, language = "ru")
    }

}