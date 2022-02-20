package den.project.diplom.presentation.movielist.adapters.movieadapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.diplom.data.api.model.Movie
import den.project.diplom.model.MovieDetail

class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieHolder>() {

    private val listMovie = mutableListOf<Movie>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHolder {
        return MovieHolder.fromParent(parent)
    }

    override fun onBindViewHolder(
        holder: MovieHolder,
        position: Int
    ) {
        holder.bind(listMovie[position], context)
    }

    override fun getItemCount(): Int = listMovie.size

    private fun getGenre(movieId: MovieDetail): String = movieId.genres.toString()
}