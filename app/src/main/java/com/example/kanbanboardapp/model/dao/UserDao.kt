package com.example.kanbanboardapp.model.dao

import androidx.room.*
import com.example.kanbanboardapp.model.entity.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(task: User) : Completable

    @Update
    fun updateUser(task: User) : Completable

    @Delete
    fun deleteUser(task: User) : Completable

    @Query("Select * from TABLE_USER")
    fun getAllUsers(): Observable<List<User>>
}
