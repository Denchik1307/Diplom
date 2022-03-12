package den.project.diplom.utils

import android.util.Log

object Logging {
    var isLogging = false

    fun showLogTagMovie(msg:Any, name:String){
        Log.d("MOVIE", "$msg - $name")
    }
}