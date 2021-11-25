package com.example.kanbanboardapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kanbanboardapp.model.dao.*
import com.example.kanbanboardapp.model.dataBase.Converter
import com.example.kanbanboardapp.model.entity.*
import com.example.kanbanboardapp.util.Constant.DATABASE_NAME

@Database(entities = [
    User::class,
    Task::class
], version = 1)
@TypeConverters(Converter::class)
abstract class KanBanDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao

    companion object {
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
