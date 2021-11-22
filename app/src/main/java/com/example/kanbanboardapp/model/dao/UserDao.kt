package com.example.kanbanboardapp.model.dao

import androidx.room.*
import com.example.kanbanboardapp.model.entity.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User) : Completable

    @Update
    fun updateUser(user: User) : Completable

    @Delete
    fun deleteUser(user: User) : Completable

    @Query("Select * from tbl_user")
    fun getAllUsers(): Observable<List<User>>
}
