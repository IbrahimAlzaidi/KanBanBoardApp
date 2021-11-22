package com.example.kanbanboardapp.model.dataBase

import com.example.kanbanboardapp.model.KanBanDatabase
import com.example.kanbanboardapp.model.dao.TaskDao
import com.example.kanbanboardapp.model.dao.UserDao
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.model.entity.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class Repository(private val dateSource: KanBanDatabase) : TaskDao , UserDao {
    override fun insertTask(task: Task): Completable {
        return dateSource.taskDao().insertTask(task = task)
    }

    override fun updateTask(task: Task): Completable {
        return dateSource.taskDao().updateTask(task = task)
    }

    override fun deleteTask(task: Task): Completable {
        return dateSource.taskDao().updateTask(task = task)
    }

    override fun getAllTask(): Observable<List<Task>> {
        return dateSource.taskDao().getAllTask()
    }

    override fun taskFilter(contentFilter: String): Single<List<Task>> {
        return dateSource.taskDao().taskFilter(contentFilter = contentFilter)
    }

    override fun insertUser(user: User): Completable {
        return dateSource.userDao().insertUser(user = user)
    }

    override fun updateUser(user: User): Completable {
        return dateSource.userDao().updateUser(user = user)
    }

    override fun deleteUser(user: User): Completable {
        return dateSource.userDao().deleteUser(user = user)
    }

    override fun getAllUsers(): Observable<List<User>> {
        return dateSource.userDao().getAllUsers()
    }
}
