package com.example.kanbanboardapp.ui.home.toDo

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentToDoBinding
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.ui.base.TaskAdapter
import com.example.kanbanboardapp.ui.home.HomeFragmentDirections
import com.example.kanbanboardapp.util.OnTransItemListener

class ToDoFragment : BaseFragment<FragmentToDoBinding, ToDoViewModel>(R.layout.fragment_to_do),
    OnTransItemListener {
    override fun getViewModel() = ToDoViewModel::class.java
    override fun onStart() {
        super.onStart()
        val adapter = TaskAdapter(
            items = emptyList(),
            deletedListener = viewModel,
            itemPosition = viewModel,
            tranListener = this
        )
        binding.myRecycler.adapter = adapter

        binding.addButton.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToAddFragment())
        }
    }

    override fun onTransItem(task: Task?) {
            navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment(task = task))
    }
}
