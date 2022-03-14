package den.project.diplom.presentation.movielist.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentPermissionBinding
import den.project.diplom.utils.Logging.isLogging
import den.project.diplom.utils.Logging.showLogTagMovie
import den.project.diplom.utils.Permission
import javax.inject.Inject

@AndroidEntryPoint
class PermissionFragment : Fragment(R.layout.fragment_permission) {

    private val binding by viewBinding(vbFactory = FragmentPermissionBinding::bind)

    @Inject
    lateinit var permission: Permission
    private val dialogPermission by lazy {
        DialogInterface.OnClickListener { _, _ ->
            if (!permission.isPermissionGranted(requireActivity())) {
                permission.requestPermission(requireActivity())
                if (isLogging) {
                    showLogTagMovie("MOVIE", "entry")
                }
            } else {
                binding.tvPermission.text = "good"
                if (isLogging) {
                    showLogTagMovie("MOVIE", "good")
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createDialog(dialog = dialogPermission).show()
    }

//    private fun chekPermission() {
//
//    }

    private fun createDialog(dialog: DialogInterface.OnClickListener) =
        AlertDialog.Builder(requireContext())
            .setIcon(R.drawable.ic_alert)
            .setTitle("123")
            .setMessage("456")
            .setPositiveButton("ok", dialog)
            .setCancelable(false)
            .create()

}