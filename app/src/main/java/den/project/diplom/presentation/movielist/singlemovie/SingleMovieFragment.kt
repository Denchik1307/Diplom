package den.project.diplom.presentation.movielist.singlemovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentSingleMovieBinding
import den.project.diplom.presentation.movielist.viewmodel.MovieViewModel

@AndroidEntryPoint
class SingleMovieFragment : Fragment(R.layout.fragment_single_movie) {

    private val binding by viewBinding(vbFactory = FragmentSingleMovieBinding::bind)
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



}




