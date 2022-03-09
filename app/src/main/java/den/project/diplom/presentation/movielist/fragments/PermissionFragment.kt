package den.project.diplom.presentation.movielist.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import den.project.diplom.R
import den.project.diplom.databinding.FragmentPermissionBinding
import den.project.diplom.utils.Permission
import javax.inject.Inject

@AndroidEntryPoint
class PermissionFragment(
    private val permission: Permission
    ) :
    Fragment(R.layout.fragment_permission) {

    private val binding by viewBinding(vbFactory = FragmentPermissionBinding::bind)
//    private val permission:Permission get() = permission

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvPermission.setOnClickListener {
            chekPermission()
        }
    }

    private fun chekPermission() {
        permission.requestPermission(requireActivity())
        if (permission.isPermissionGranted(requireActivity())) {
            binding.tvPermission.text = "good"
        }
    }
}