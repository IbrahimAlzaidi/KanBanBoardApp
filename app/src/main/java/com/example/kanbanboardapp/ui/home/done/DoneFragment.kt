package com.example.kanbanboardapp.ui.home.done

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentDoneBinding
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.ui.base.TaskAdapter

class DoneFragment : BaseFragment<FragmentDoneBinding, DoneViewModel>(R.layout.fragment_done){
    override fun getViewModel() = DoneViewModel::class.java

    override fun onStart() {
        super.onStart()
        val adapter = TaskAdapter(
            items = emptyList(),
            deletedListener = viewModel,
            itemPosition = viewModel,
        )
        binding.myRecycler.adapter = adapter
    }
}
