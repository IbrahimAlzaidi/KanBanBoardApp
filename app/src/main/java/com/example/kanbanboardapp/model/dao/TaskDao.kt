package com.example.kanbanboardapp.model.dao

import androidx.room.*
import com.example.kanbanboardapp.model.entity.Task
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task: Task) : Completable

    @Update
    fun updateTask(task: Task) : Completable

    @Delete
    fun deleteTask(task: Task) : Completable

    @Query("Select * from TABLE_TASK ORDER BY task_id DESC")
    fun getAllTask(): Observable<List<Task>>

    @Query("Select * from TABLE_TASK WHERE stats LIKE :contentFilter ORDER BY task_id DESC")
    fun taskFilter(contentFilter : String): Single<List<Task>>
}