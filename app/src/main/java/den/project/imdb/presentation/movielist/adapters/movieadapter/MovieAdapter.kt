package den.project.imdb.presentation.movielist.adapters.movieadapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.imdb.data.api.model.Movie

class MovieAdapter(
    private val context: Context,
    private val itemMovieListener: ItemMovieListener
) : RecyclerView.Adapter<MovieHolder>() {

    private var listMovie = mutableListOf<Movie>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MovieHolder {
//        when (viewType) {
//            1 ->
        return MovieHolder.fromParent(parent, itemMovieListener)
//            2 -> return FavoriteHolder.fromParent(parent, itemMovieListener)
//        }
    }

    override fun onBindViewHolder(
        holder: MovieHolder, position: Int
    ) {
        holder.bind(listMovie[position], context)
    }

    override fun getItemCount(): Int = listMovie.size

    @SuppressLint("NotifyDataSetChanged")
    fun showMovie(movie: List<Movie>) {
        listMovie = movie.toMutableList()
        notifyDataSetChanged()
    }
}