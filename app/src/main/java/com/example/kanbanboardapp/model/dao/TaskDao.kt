package com.example.kanbanboardapp.model.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kanbanboardapp.model.entity.Task

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