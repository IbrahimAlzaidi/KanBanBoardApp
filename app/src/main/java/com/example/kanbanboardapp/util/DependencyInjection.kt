package com.example.kanbanboardapp.util

import android.content.Context
import com.example.kanbanboardapp.model.KanBanDatabase
import com.example.kanbanboardapp.model.dataBase.Repository

object DependencyInjection {

    private fun provideDataSource(context: Context?): Repository {
        val contentDatabase: KanBanDatabase = KanBanDatabase.getInstance(context!!)
        return Repository(contentDatabase)
    }

    fun provideViewModelFactory(context: Context?): ViewModelFactory {
        val repository: Repository = provideDataSource(context)
        return ViewModelFactory(repository)
    }
}
