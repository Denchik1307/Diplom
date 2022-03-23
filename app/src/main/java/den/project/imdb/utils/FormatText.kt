package den.project.imdb.utils

object FormatText {

    fun formatToSimple(text: String): String {
        text.replace(". ","\n\t\t")
        return text
    }
}
