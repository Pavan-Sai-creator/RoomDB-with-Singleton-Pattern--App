package com.example.roomdb_singletonpattern_typeconverters_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO

    companion object{

        @Volatile
        private var INSTANCE: ContactDatabase? = null
        //var CONVERTER_INSTANCE: Converters = Converters()

        fun getDatabase(context: Context): ContactDatabase{
            synchronized(this){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,"contactDB").build()
                }
                return INSTANCE!!
            }
        }


    }

}