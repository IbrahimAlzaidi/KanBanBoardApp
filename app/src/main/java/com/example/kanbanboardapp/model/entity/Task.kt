package com.example.kanbanboardapp.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity(tableName = "TABLE_TASK")
@Parcelize
data class Task(
    @ColumnInfo(name = "name") val task_name : String?,
    @ColumnInfo(name = "title") val task_title: String?,
    @ColumnInfo(name = "description") val task_description: String?,
    @ColumnInfo(name = "type") val task_type : String?,
    @ColumnInfo(name = "stats") val task_stats : String?,
    @ColumnInfo(name = "startDate") val task_startDate : Date,
    @ColumnInfo(name = "endDate") val task_endDate : Date,
    @PrimaryKey(autoGenerate = true) val task_id : Long = 0,
    ): Parcelable
