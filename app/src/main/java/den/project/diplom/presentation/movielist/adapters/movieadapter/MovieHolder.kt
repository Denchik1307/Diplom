package den.project.diplom.presentation.movielist.adapters.movieadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.diplom.databinding.MoviePatternRecyclerBinding
import den.project.diplom.model.GenresId
import den.project.diplom.data.api.model.Movie

class MovieHolder(
    private val binding: MoviePatternRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, context: Context) {
        with(binding) {
            tvTitleMovie.text = movie.title
            tvDateMovieRelease.text = movie.releaseDate
            tvGenreMovie.text = GenresId.genreIdToStringGenre(movie)
        }
    }

    companion object {
        fun fromParent(parent: ViewGroup): MovieHolder {
            return MovieHolder(
                MoviePatternRecyclerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

//    private fun
}
