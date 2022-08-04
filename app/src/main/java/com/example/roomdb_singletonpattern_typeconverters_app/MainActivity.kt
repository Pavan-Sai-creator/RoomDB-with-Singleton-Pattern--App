package com.example.roomdb_singletonpattern_typeconverters_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0,"KingKobe","9874",Date()))
        }

        database.contactDAO().getAllContacts().observe(this, Observer {
            Log.d("Test",it.toString())
        })
    }
}