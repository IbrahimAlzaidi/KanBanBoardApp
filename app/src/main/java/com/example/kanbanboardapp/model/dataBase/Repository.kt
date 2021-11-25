package com.example.kanbanboardapp.model.dataBase

import com.example.kanbanboardapp.model.KanBanDatabase
import com.example.kanbanboardapp.model.dao.*
import com.example.kanbanboardapp.model.entity.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class Repository(private val dateSource: KanBanDatabase) : TaskDao {

    override fun insertTask(task: Task): Completable {
        return dateSource.taskDao().insertTask(task)
    }

    override fun updateTask(task: Task): Completable {
        return dateSource.taskDao().updateTask(task)
    }

    override fun deleteTask(task: Task): Completable {
        return dateSource.taskDao().deleteTask(task)
    }

    override fun getAllTask(): Observable<List<Task>> {
        return dateSource.taskDao().getAllTask()
    }

    override fun taskFilter(contentFilter: String): Single<List<Task>> {
        return dateSource.taskDao().taskFilter(contentFilter)
    }
}
