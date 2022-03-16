package den.project.diplom.utils

import android.util.Log

object Logging {
    var isLogging = false

    fun showLog(msg:Any, name:String){
        if (isLogging){
            Log.d("MOVIE", "$msg - $name")
        }
    }
}

fun Logging.enable(){
    isLogging = true
}

fun Logging.disable(){
    isLogging = false
}
