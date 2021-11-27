package com.example.kanbanboardapp.ui.home.inProgress

import android.util.Log
import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentInProgressBinding
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.ui.home.HomeFragmentDirections
import com.example.kanbanboardapp.ui.home.TaskAdapter
import com.example.kanbanboardapp.util.Constant.TAG
import com.example.kanbanboardapp.util.OnTransItemListener

class InProgressFragment :
    BaseFragment<FragmentInProgressBinding, InProgressViewModel>(R.layout.fragment_in_progress),
    OnTransItemListener {
    override fun getViewModel() = InProgressViewModel::class.java

    override fun onStart() {
        super.onStart()
        val adapter = TaskAdapter(emptyList(), viewModel, this)
        binding.myRecycler.adapter = adapter
    }

    override fun onTransItem(task: Task?) {
        if (task != null) {
            navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment(task = task))
        }
    }
}
