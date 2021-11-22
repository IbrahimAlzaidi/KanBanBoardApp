package com.example.kanbanboardapp.model.dataBase

import androidx.room.TypeConverter
import java.util.*

class Converter {
    @TypeConverter
    fun dateToLong(date: Date) : Long{
        return date.time
    }

    @TypeConverter
    fun longToDate(long:Long):Date{
        return Date(long)
    }
}
