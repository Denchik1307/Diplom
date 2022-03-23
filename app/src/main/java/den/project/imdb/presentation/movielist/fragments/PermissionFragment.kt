package den.project.imdb.presentation.movielist.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.imdb.R
import den.project.imdb.databinding.FragmentPermissionBinding
import den.project.imdb.utils.Logging.showLog
import den.project.imdb.utils.Permission
import javax.inject.Inject

@AndroidEntryPoint
class PermissionFragment : Fragment(R.layout.fragment_permission) {

    private val binding by viewBinding(vbFactory = FragmentPermissionBinding::bind)

    @Inject
    lateinit var permission: Permission
    private val dialogCanceled by lazy {
        DialogInterface.OnCancelListener {
            binding.tvPermission.text = "you can`t use application without INTERNET"
        }
    }
    private val dialogPermission by lazy {
        DialogInterface.OnClickListener { _, _ ->
            if (!permission.isPermissionGranted(requireActivity())) {
                permission.requestPermission(requireActivity())
                showLog("MOVIE", "entry")
            } else {
                binding.tvPermission.text = "good"
                showLog("MOVIE", "good")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bvGetPermission.setOnClickListener {
            createDialog(dialogListener = dialogPermission, dialogCanceled = dialogCanceled).show()
        }
    }

    private fun createDialog(
        dialogListener: DialogInterface.OnClickListener,
        dialogCanceled: DialogInterface.OnCancelListener,
    ) = AlertDialog.Builder(requireContext())
        .setIcon(R.drawable.ic_alert)
        .setTitle("PERMISSION")
        .setMessage("Need assess INTERNET permission")
        .setPositiveButton("ok", dialogListener)
        .setCancelable(true)
        .setOnCancelListener(dialogCanceled)
        .create()

}