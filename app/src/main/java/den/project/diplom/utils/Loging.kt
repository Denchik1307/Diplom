package den.project.diplom.utils

import android.util.Log

object Loging {
    var isLoging = true

    fun showLogTagMovie(msg:Any, name:String){
        Log.d("MOVIE", "$msg - $name")
    }
}