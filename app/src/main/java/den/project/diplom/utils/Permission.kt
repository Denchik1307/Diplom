package den.project.diplom.utils

import android.app.Activity

interface Permission {

    companion object{
        const val REQUEST_PERMISSION_CODE = 11011011
    }
    fun requestPermission(activity: Activity)

    fun isPermissionGranted(activity: Activity): Boolean
}