package com.example.kanbanboardapp.model.dao

import androidx.room.*
import com.example.kanbanboardapp.model.entity.Task
@Dao
interface TaskDao {

    @Insert
    fun insertUser(task: Task)

    @Update
    fun updateUser(task: Task)

    @Delete
    fun deleteUser(task: Task)

    @Query("Select * from tbl_task")
    fun getAllUsers(): List<Task>


}