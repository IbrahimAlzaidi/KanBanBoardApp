package com.example.kanbanboardapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) val user_id: Long,
    @ColumnInfo(name = "name") val user_name : String,
)
