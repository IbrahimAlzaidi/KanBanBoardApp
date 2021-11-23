package com.example.kanbanboardapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "TABLE_USER")
data class User(
    @ColumnInfo(name = "name") val user_name : String,
    @ColumnInfo(name = "password") val user_password : String,
    @ColumnInfo(name = "email") val user_email : String,
    @PrimaryKey(autoGenerate = true) val user_id: Long = Random.nextLong(),
)
