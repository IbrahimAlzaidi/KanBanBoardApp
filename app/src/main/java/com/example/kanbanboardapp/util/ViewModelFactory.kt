package com.example.kanbanboardapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kanbanboardapp.model.dataBase.Repository
import com.example.kanbanboardapp.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val contentDataSource: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(contentDataSource) as T
        }
        throw IllegalArgumentException("Unknown viewmodel")
    }
}
