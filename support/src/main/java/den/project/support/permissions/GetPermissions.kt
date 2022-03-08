package den.project.support.permissions

import android.app.Activity

interface GetPermissions {
    fun requestPermission(activity: Activity, vararg :Array<String>)
}