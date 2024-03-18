package com.pets.mycontactlist.data.database

import android.app.Application
import androidx.room.Room

class App : Application() {

    lateinit var db: AppDataBase

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "db"
        ).build()
    }

}