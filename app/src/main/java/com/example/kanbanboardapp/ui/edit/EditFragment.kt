package com.example.kanbanboardapp.ui.edit

import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentEditBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class EditFragment : BaseFragment<FragmentEditBinding, EditViewModel>(R.layout.fragment_edit) {
    override fun getViewModel() = EditViewModel::class.java

    private val args: EditFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
        val viewModels = EditViewModel(args.task)
        binding.apply {
            viewModel = viewModels
            lifecycleOwner = this@EditFragment
            updateButton.setOnClickListener {
                if (!(viewModels.isValid())) {
                    viewModels.updateTask()
                    findNavController().navigate(
                        R.id.homeFragment,
                        null,
                        NavOptions.Builder().setPopUpTo(R.id.editFragment,true).build()
                    )
                }
            }
        }
    }
}
