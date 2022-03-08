package den.project.diplom.presentation.movielist.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import den.project.diplom.R
import den.project.diplom.databinding.FragmentPermissionBinding

class PermissionFragment : Fragment(R.layout.fragment_permission) {

    private val binding by viewBinding(vbFactory = FragmentPermissionBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}