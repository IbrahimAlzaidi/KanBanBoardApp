package com.example.kanbanboardapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tbl_task")
data class Task(
    @PrimaryKey(autoGenerate = true) val task_id : Long,
    val task_name : String,
    val task_title: String,
    val task_description: String,
    val task_type : String,
    val task_stats : Boolean,
    val task_startDate : Date,
    val task_endDate : Date,
)