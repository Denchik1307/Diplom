package den.project.imdb.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import den.project.imdb.utils.Permission.Companion.REQUEST_PERMISSION_CODE
import javax.inject.Inject

class PermissionImpl @Inject constructor(): Permission {

    override fun requestPermission(activity: Activity) {
        ActivityCompat.requestPermissions(activity,
            arrayOf(Manifest.permission.ACCESS_NETWORK_STATE),
            REQUEST_PERMISSION_CODE)
    }

    override fun isPermissionGranted(activity: Activity): Boolean {
        return ContextCompat.checkSelfPermission(activity,
            Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED
    }
}