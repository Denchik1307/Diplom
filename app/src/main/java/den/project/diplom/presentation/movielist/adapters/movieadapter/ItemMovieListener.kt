package den.project.diplom.presentation.movielist.adapters.movieadapter

interface ItemMovieListener {

    fun idClickListener(id: String)
    fun favoriteClickListener()
    fun onMoviesClickListener(id: String)
}
