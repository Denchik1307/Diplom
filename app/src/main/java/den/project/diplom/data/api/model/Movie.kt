package den.project.diplom.data.api.model

import com.google.gson.annotations.SerializedName
import den.project.diplom.data.storage.entity.Movie as RoomMovie
import den.project.diplom.data.storage.entity.Genre as RoomGenre
import den.project.diplom.data.storage.dto.MovieWithGenres as MovieWithGenres

data class Movie(
    @SerializedName("id")
    val id: Long, // 634649
    @SerializedName("title")
    val title: String, // Человек-паук: Нет пути домой
    @SerializedName("overview")
    val overview: String, // Действие фильма «Человек-паук: Нет пути домой»...
    @SerializedName("poster_path")
    val posterPath: String, // /zpH4yEqOJOReykVcSQYA1A258SQ.jpg
    @SerializedName("genre_ids")
    val genre: List<Int>, //12,45,46
    @SerializedName("original_title")
    val originalTitle: String, // Spider-Man: No Way Home
    @SerializedName("backdrop_path")
    val backdropPath: String, // /iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg
    @SerializedName("vote_average")
    val rating: Double, // 8.4
    @SerializedName("release_date")
    val releaseDate: String, // 2021-12-15
) {
    fun toRoomEntity(genres: List<RoomGenre>): MovieWithGenres {
        return MovieWithGenres(
            movie = RoomMovie(
                id,
                title,
                overview,
                posterPath,
                originalTitle,
                backdropPath,
                rating,
                releaseDate
            ),
            genres = genre.mapNotNull { id ->
                genres.find { id == it.genreId }
            }
        )
    }
}








