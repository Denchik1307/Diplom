package den.project.diplom.presentation.movielist.singlemovie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentSingleMovieBinding
import den.project.diplom.presentation.movielist.viewmodel.MoviePopularViewModel

@AndroidEntryPoint
class SingleMovieFragment : Fragment(R.layout.fragment_single_movie) {

    private val binding by viewBinding(vbFactory = FragmentSingleMovieBinding::bind)
    private val viewModel: MoviePopularViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}




