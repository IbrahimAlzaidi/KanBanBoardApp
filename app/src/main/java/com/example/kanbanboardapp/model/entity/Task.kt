package com.example.kanbanboardapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_task")
data class Task(
    @PrimaryKey(autoGenerate = true) val task_id : Long,
    @ColumnInfo(name = "name") val task_name : String,
    @ColumnInfo(name = "title") val task_title: String,
    @ColumnInfo(name = "description") val task_description: String,
    @ColumnInfo(name = "type") val task_type : String,
    @ColumnInfo(name = "stats") val task_stats : Boolean,
    @ColumnInfo(name = "startDate") val task_startDate : String,
    @ColumnInfo(name = "endDate") val task_endDate : String,
)