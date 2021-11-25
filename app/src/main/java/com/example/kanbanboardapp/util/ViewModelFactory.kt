package com.example.kanbanboardapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.ui.add.AddViewModel
import com.example.kanbanboardapp.ui.home.done.DoneViewModel
import com.example.kanbanboardapp.ui.home.HomeViewModel
import com.example.kanbanboardapp.ui.home.inProgress.InProgressViewModel
import com.example.kanbanboardapp.ui.home.toDo.ToDoViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val contentDataSource: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel() as T
            modelClass.isAssignableFrom(ToDoViewModel::class.java) -> ToDoViewModel(contentDataSource) as T
            modelClass.isAssignableFrom(InProgressViewModel::class.java) -> InProgressViewModel(contentDataSource) as T
            modelClass.isAssignableFrom(DoneViewModel::class.java) -> DoneViewModel(contentDataSource) as T
            modelClass.isAssignableFrom(AddViewModel::class.java) -> AddViewModel(contentDataSource) as T
            else -> throw IllegalArgumentException("Unknown viewModel")
        }
    }
}
