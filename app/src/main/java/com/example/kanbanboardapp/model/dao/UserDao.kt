package com.example.kanbanboardapp.model.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kanbanboardapp.model.entity.User

interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("Select * from tbl_user")
    fun getAllUsers(): List<User>


}