package den.project.diplom.utils

import android.util.Log

object Logging {
    var isLogging = false

    fun showLogTagMovie(msg:Any, name:String){
        if (isLogging){
            Log.d("MOVIE", "$msg - $name")
        }
    }
}