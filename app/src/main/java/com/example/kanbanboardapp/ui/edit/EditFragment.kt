package com.example.kanbanboardapp.ui.edit

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
            button.setOnClickListener {
                if (!(viewModels.isValid())) {
                    viewModels.updateTask()
                    navigate(EditFragmentDirections.actionEditFragmentToHomeFragment())
                }
            }
        }
    }
}
