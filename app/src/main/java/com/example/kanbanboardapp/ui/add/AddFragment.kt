package com.example.kanbanboardapp.ui.add

import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentAddBinding
import com.example.kanbanboardapp.ui.base.BaseFragment

class AddFragment : BaseFragment<FragmentAddBinding, AddViewModel>(R.layout.fragment_add) {
    override fun getViewModel() = AddViewModel::class.java

    override fun onStart() {
        super.onStart()
        binding.addButton.setOnClickListener {
            if (!(viewModel.isValid())) {
                viewModel.insertTask()
                findNavController().navigate(
                    R.id.homeFragment,
                    null,
                    NavOptions.Builder().setPopUpTo(R.id.addFragment,true).build()
                )
            }
        }
    }

}
