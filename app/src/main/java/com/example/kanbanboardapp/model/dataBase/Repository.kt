package com.example.kanbanboardapp.model.dataBase

import com.example.kanbanboardapp.model.KanBanDatabase
import com.example.kanbanboardapp.model.dao.TaskDao
import com.example.kanbanboardapp.model.entity.Task

class Repository : TaskDao {

    private val dateSource = KanBanDatabase.getInstanceWithoutContext()

    override fun insertTask(task: Task) = dateSource.taskDao().insertTask(task)

    override fun updateTask(task: List<Task>) = dateSource.taskDao().updateTask(task)

    override fun deleteTask(task: Task) = dateSource.taskDao().deleteTask(task)

    override fun getAllTask() = dateSource.taskDao().getAllTask()

    override fun taskFilter(contentFilter: String) = dateSource.taskDao().taskFilter(contentFilter)

    override fun taskProgressFilter(progress: String) =
        dateSource.taskDao().taskProgressFilter(progress)

    override fun taskUpdate(taskStats: String, id: Long) =
        dateSource.taskDao().taskUpdate(taskStats, id)
}
