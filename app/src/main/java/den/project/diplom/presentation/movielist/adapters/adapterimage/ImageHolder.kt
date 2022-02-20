package den.project.diplom.presentation.movielist.adapters.adapterimage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.project.diplom.databinding.MoviePosterPatternBinding
import den.project.diplom.data.api.model.Movie

class ImageHolder(
    private val binding: MoviePosterPatternBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun fromParent(parent: ViewGroup): ImageHolder {
            return ImageHolder(MoviePosterPatternBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    fun bind(
        image: Movie,
        context: Context
    ) {
//        Glide.with(context).load((BASE_PATH_POSTER + image).toUri()).into(binding.imPosterMovie)
    }
}
