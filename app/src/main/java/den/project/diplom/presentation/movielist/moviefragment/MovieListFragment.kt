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
import androidx.navigation.findNavController
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
import den.project.diplom.utils.Constants.MAX_PAGE
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val movieAdapter by lazy {
        MovieAdapter(context = requireContext(), itemMovieListener = itemMovieListener)
    }
    private val binding by viewBinding(vbFactory = FragmentMovieListBinding::bind)
    private val viewModel: MovieViewModel by viewModels()
    private var isInit = false
    private var page: Int = 1
    private val itemMovieListener: ItemMovieListener = object : ItemMovieListener {
        override fun idClickListener(id: String) {
            Log.d("MOVIE", id)
            viewModel.getTrailer(id)
        }

        override fun favoriteClickListener() {

        }

        override fun onMoviesClickListener(id: String) {
//            viewModel.getMovieDetail(movie_id = id, "ru")
            view?.findNavController()?.navigate(R.id.singleMovieFragment,id as Bundle)

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
                viewModel.getPopular(page = page, language = "ru")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        lifecycleScope.launch {
            viewModel.listMovie.collect {
                movieAdapter.showMovie(movie = it)
            }
        }
        viewModel.getPopular(page = page, language = "ru")
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
        viewModel.trailer.observe(viewLifecycleOwner) {
            if (it != "empty") {
                val intentOne =
                    Intent(Intent.ACTION_VIEW, Uri.parse(Constants.BASE_PATH_TRAILER + it))
                val intentTwo = Intent(Intent.CATEGORY_APP_BROWSER,
                    Uri.parse(Constants.BASE_PATH_TRAILER2 + it))
                try {
                    requireActivity().startActivity(intentOne)
                } catch (ex: ActivityNotFoundException) {
                    requireActivity().startActivity(intentTwo)
                }
            } else {
                if (isInit) {
                    Toast.makeText(requireContext(),
                        "Нет ссылки на рейлер для этого фильма :(",
                        Toast.LENGTH_LONG).show()
                } else {
                    isInit = true
                }
            }
        }
    }
}