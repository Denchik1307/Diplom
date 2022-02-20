package den.project.diplom.model

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val genres: List<Genre>,
    val originalTitle: String,
    val backdropPath: String,
    val rating: Double,
    val releaseDate: String,
)