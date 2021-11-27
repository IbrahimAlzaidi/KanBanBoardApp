package com.example.kanbanboardapp.ui.home.toDo

import com.example.kanbanboardapp.R
import com.example.kanbanboardapp.databinding.FragmentToDoBinding
import com.example.kanbanboardapp.ui.base.BaseFragment
import com.example.kanbanboardapp.ui.home.HomeFragmentDirections
import com.example.kanbanboardapp.ui.home.TaskAdapter

class ToDoFragment : BaseFragment<FragmentToDoBinding, ToDoViewModel>(R.layout.fragment_to_do){
    override fun getViewModel() = ToDoViewModel::class.java

    override fun onStart() {
        super.onStart()
        val adapter = TaskAdapter(emptyList(),viewModel,null,viewModel)
        binding.myRecycler.adapter = adapter

        binding.addButton.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToAddFragment())
        }
    }
}
