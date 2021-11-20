package com.example.kanbanboardapp.model.entity

import androidx.room.Entity

@Entity(tableName = "tbl_user")
data class User(
    val user_id: Long,
    val user_name : String,
)
