package den.project.imdb.presentation.movielist.adapters.movieadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import den.project.imdb.R
import den.project.imdb.databinding.MoviePatternRecyclerBinding
import den.project.imdb.data.api.model.Movie
import den.project.imdb.utils.Constants.BASE_PATH_POSTER
import den.project.imdb.utils.GenresId

class MovieHolder(
    private val binding: MoviePatternRecyclerBinding,
    private val itemMovieListener: ItemMovieListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, context: Context) {
        with(binding) {
            Glide.with(context).load(BASE_PATH_POSTER + movie.posterPath).into(imMoviePoster)
            Glide.with(context).load(BASE_PATH_POSTER + movie.backdropPath).into(imBackgroundPoster)
            tvTitleMovie.text = "${movie.title}\n(${movie.originalTitle})"
            tvDateMovieRelease.text = movie.releaseDate
            tvOverview.text = movie.overview
            tvGenreMovie.text = GenresId.genreIdToStringGenre(movie.genre)
            tvPopularityMovie.text = movie.rating.toString()
            if (movie.isFavorite){
                imFavorite.setImageResource(R.drawable.ic_star_selected)
            }else{
                imFavorite.setImageResource(R.drawable.ic_star_unselected)
            }
            imTrailer.setOnClickListener {
                itemMovieListener.idClickListener(id = movie.id.toString())
            }
            imFavorite.setOnClickListener {
                movie.isFavorite = true
                imFavorite.setImageResource(R.drawable.ic_star_selected)
                itemMovieListener.favoriteClickListener()
            }
            imMoviePoster.setOnClickListener {
                itemMovieListener.onMoviesClickListener(movie.id.toString())
            }
        }
    }


    companion object {
        fun fromParent(parent: ViewGroup, itemMovieListener: ItemMovieListener): MovieHolder {
            return MovieHolder(
                MoviePatternRecyclerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), itemMovieListener = itemMovieListener
            )
        }
    }
}
