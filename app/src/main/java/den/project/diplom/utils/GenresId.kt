package den.project.diplom.utils

object GenresId {

    fun genreIdToStringGenre(movie: List<Int>): String {
        var temp = ""
        movie.forEach {
            temp += getGenresById(it)
        }
        return temp
    }

    private fun getGenresById(genreId: Int): String {
        val genre: String
        when (genreId) {
            12 -> genre = "приключения"
            14 -> genre = "фэнтези"
            16 -> genre = "мультфильм"
            18 -> genre = "драма"
            27 -> genre = "ужасы"
            28 -> genre = "боевик"
            35 -> genre = "комедия"
            36 -> genre = "история"
            37 -> genre = "вестерн"
            53 -> genre = "триллер"
            80 -> genre = "криминал"
            99 -> genre = "документальный"
            878 -> genre = "фантастика"
            9648 -> genre = "детектив"
            10402 -> genre = "музыка"
            10749 -> genre = "мелодрама"
            10751 -> genre = "семейный"
            10752 -> genre = "военный"
            10770 -> genre = "телевизионный фильм"
            else -> genre = "хз что за жанр"
        }
        return "$genre; "
    }
}
