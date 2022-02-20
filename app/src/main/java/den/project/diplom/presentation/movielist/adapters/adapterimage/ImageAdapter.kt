package den.project.diplom.presentation.movielist.adapters.adapterimage

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.diplom.data.api.model.Movie

class ImageAdapter(private val context: Context) : RecyclerView.Adapter<ImageHolder>() {

    private val listPoster by lazy { mutableListOf<Movie>() }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageHolder {
        return ImageHolder.fromParent(parent)
    }

    override fun onBindViewHolder(
        holder: ImageHolder,
        position: Int
    ) {
        holder.bind(listPoster[position], context)
    }

    override fun getItemCount(): Int = listPoster.size
}