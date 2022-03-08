package den.project.support.permissions

import android.app.Activity
import androidx.core.app.ActivityCompat

class GetPermissionsImpl : GetPermissions {

    override fun requestPermission(activity: Activity, vararg: Array<String>) {
        ActivityCompat.requestPermissions(activity, vararg, 101)
    }
}