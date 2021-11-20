package com.example.kanbanboardapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kanbanboardapp.model.dao.TaskDao
import com.example.kanbanboardapp.model.dao.UserDao
import com.example.kanbanboardapp.model.entity.Task
import com.example.kanbanboardapp.model.entity.User

@Database(entities = [User::class, Task::class], version = 1)
abstract class KanBanDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao

    companion object {
        private const val DATABASE_NAME = "KanBanDatabase"

        @Volatile
        private var instance: KanBanDatabase? = null

        fun getInstance(context: Context): KanBanDatabase {
            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }
        }

        private fun buildDatabase(context: Context): KanBanDatabase {
            return Room.databaseBuilder(context, KanBanDatabase::class.java, DATABASE_NAME).build()
        }
    }
}