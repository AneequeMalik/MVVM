package com.aneeque.mvvm

import android.app.Application
import androidx.room.Room
import com.aneeque.mvvm.db.AppDatabase

class MyApp : Application() {
    companion object {
        lateinit var roomDB: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        roomDB = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "mvvm-database",
        ).allowMainThreadQueries().build()
    }
}