package den.project.diplom.presentation.movielist.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentPermissionBinding
import den.project.diplom.utils.Permission
import javax.inject.Inject

@AndroidEntryPoint
class PermissionFragment : Fragment(R.layout.fragment_permission) {

    private val binding by viewBinding(vbFactory = FragmentPermissionBinding::bind)

    @Inject
    lateinit var permission: Permission
    private val action by lazy {
        DialogInterface.OnClickListener { _, _ ->
            if (!permission.isPermissionGranted(requireActivity())) {
                permission.requestPermission(requireActivity())
                Log.d("MOVIE", "entry")
            } else {
                binding.tvPermission.text = "good"
                Log.d("MOVIE", "good")
            }
        }
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            createDialog(action = action)

        }

        private fun chekPermission() {

        }

        private fun createDialog(action: DialogInterface.OnClickListener)=
            AlertDialog.Builder(requireContext())
                .setTitle("123")
                .setMessage("456")
                .setPositiveButton("ok",action)
    }
}