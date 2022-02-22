package den.project.diplom.presentation.movielist.moviefragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

    private val itemMovieListener: ItemMovieListener = object : ItemMovieListener {
        override fun clickListener(id: String) {
            viewModel.getTrailer(id)
        }
    }
    private val movieAdapter by lazy { MovieAdapter(requireContext(), itemMovieListener) }
    private val binding by viewBinding(FragmentMovieListBinding::bind)
    private val viewModel: MovieListViewModel by viewModels()
    private val totalPage: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObserver()
        lifecycleScope.launch {
            viewModel.listMovie.collect {
                movieAdapter.showMovie(it)
            }
        }
        viewModel.getPopular(page = totalPage, language = "ru")
    }

    private fun initRecycler() {
        binding.apply {
            recyclerMovieList.adapter = movieAdapter
            recyclerMovieList.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initObserver() {
//            val intentOne = Intent(
//                Intent.ACTION_VIEW, Uri.parse(Constants.BASE_PATH_TRAILER + viewModel.trailer.value)
//            )
//            val intentTwo = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(Constants.BASE_PATH_TRAILER2 + viewModel.trailer.value)
//            )
//            Toast.makeText(requireContext(), intentOne.dataString, Toast.LENGTH_LONG).show()
//            Toast.makeText(requireContext(), intentTwo.dataString, Toast.LENGTH_LONG).show()
//            try {
//                requireActivity().startActivity(intentOne)
//            } catch (ex: ActivityNotFoundException) {
//                requireActivity().startActivity(intentTwo)
//            }

    }
}