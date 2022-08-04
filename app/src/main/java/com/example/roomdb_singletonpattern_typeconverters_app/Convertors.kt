package com.example.roomdb_singletonpattern_typeconverters_app

import androidx.room.TypeConverter
import java.util.*

class Convertors {
    @TypeConverter
    fun fromDateToLong(value: Date): Long{
    return value.time
    }
    @TypeConverter
    fun fromLongToDate(value: Long): Date{
        return Date(value)
    }
}