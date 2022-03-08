package den.project.diplom.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import den.project.diplom.utils.Permission.Companion.REQUEST_PERMISSION_CODE

class PermissionImpl : Permission {

    override fun requestPermission(activity: Activity) {
        ActivityCompat.requestPermissions(activity,
            arrayOf(Manifest.permission.INTERNET, Manifest.permission.ACCESS_WIFI_STATE),
            REQUEST_PERMISSION_CODE)
    }

    override fun isPermissionGranted(activity: Activity): Boolean {
        return !(internetStatus(activity) || wifiStatus(activity))
    }

    private fun internetStatus(activity: Activity): Boolean {
        return ContextCompat.checkSelfPermission(activity,
            Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED
    }

    private fun wifiStatus(activity: Activity): Boolean {
        return ContextCompat.checkSelfPermission(activity,
            Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED
    }


}