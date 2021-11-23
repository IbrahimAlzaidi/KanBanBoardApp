package com.example.kanbanboardapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.ui.home.HomeViewModel
import com.example.kanbanboardapp.ui.taskFragment.TaskViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val contentDataSource: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(contentDataSource) as T
            modelClass.isAssignableFrom(TaskViewModel::class.java) -> TaskViewModel(contentDataSource) as T
            else -> throw IllegalArgumentException("Unknown viewModel")
        }

    }
}
