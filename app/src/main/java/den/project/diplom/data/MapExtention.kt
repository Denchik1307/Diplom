package den.project.diplom.data.storage

import den.project.diplom.data.api.model.Movie
import den.project.diplom.data.storage.dao.MovieEntity
import java.util.regex.Pattern

fun Movie.toMovieEntity() = MovieEntity(
    id = id.toString(),
    title = title,
    overview = overview,
    posterPath = posterPath,
    genres = intToString(genre),
    originalTitle = originalTitle,
    backdropPath = backdropPath,
    rating = rating,
    releaseDate = releaseDate
)

fun MovieEntity.toMovie() = Movie(
    id = id.toLong(),
    title = title,
    overview = overview,
    posterPath = posterPath,
    genre = stringToListInt(genres),
    originalTitle = originalTitle,
    backdropPath = backdropPath,
    rating = rating,
    releaseDate = releaseDate
)

private fun stringToListInt(value: String): List<Int> {
    val tmp = mutableListOf<Int>()
    Pattern.compile(";").split(value).toList().forEach {
        tmp.add(it.toInt())
    }
    return tmp
}

fun intToString(genre: List<Int>): String {
    var tmp = ""
    genre.forEach {
        tmp += "$it;"
    }
    return tmp
}

