package com.example.kanbanboardapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "TABLE_USER")
data class User(
    @ColumnInfo(name = "name") val user_name : String,
    @PrimaryKey(autoGenerate = true) val user_id: Long = Random.nextLong(),
)
