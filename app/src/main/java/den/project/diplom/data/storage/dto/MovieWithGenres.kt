package den.project.diplom.data.storage.dto

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import den.project.diplom.data.storage.entity.Genre
import den.project.diplom.data.storage.entity.Movie
import den.project.diplom.data.storage.entity.MovieGenreCrossRef

data class MovieWithGenres(

    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "genreId",
        associateBy = Junction(MovieGenreCrossRef::class)
    ) val genres: List<Genre>
)