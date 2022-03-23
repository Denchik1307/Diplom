package den.project.imdb.presentation.movielist.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import den.project.imdb.R
import den.project.imdb.databinding.FragmentSingleMovieBinding
import den.project.imdb.presentation.movielist.viewmodel.MovieViewModel
import den.project.imdb.utils.Constants.BASE_PATH_POSTER
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SingleMovieFragment : Fragment(R.layout.fragment_single_movie) {

    //    private val args by navArgs<>()
    private val binding by viewBinding(vbFactory = FragmentSingleMovieBinding::bind)
    private val movieViewModel: MovieViewModel by viewModels()
    private var listMovie = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId: String = arguments?.getString("movie")!!
        lifecycleScope.launch {
            movieViewModel.getMovieDetail(movieId, "ru")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.async {
            movieViewModel.detailMovie.collect { movie ->
                movie.forEach { movieDetail ->
                    with(binding) {
                        container.startAnimation(
                            AnimationUtils.loadAnimation(
                                requireContext(),
                                R.anim.scale
                            )
                        )
                        tvStatus.text = movieDetail.status
                        tvTagLine.text = movieDetail.tagline
                        tvTitleMovie.text = movieDetail.title
                        tvDateMovieRelease.text = movieDetail.releaseDate
                        tvGenreMovie.text = movieDetail.genres
                                .map { " " + it.name }
                                .toString()
                                .removePrefix("[")
                                .removeSuffix("]")
                        Glide.with(requireContext())
                            .load(BASE_PATH_POSTER + movieDetail.backdropPath)
                            .into(imBackgroundPoster)
                        Glide.with(requireContext())
                            .load(BASE_PATH_POSTER + movieDetail.posterPath)
                            .into(imMoviePoster)
                        tvOverview.text = "\t\t" + movieDetail.overview.replace(". ", "\n\t\t")
                        tvPopularityMovie.text = movieDetail.rating.toString()
                    }
                }
            }
        }
    }
}




