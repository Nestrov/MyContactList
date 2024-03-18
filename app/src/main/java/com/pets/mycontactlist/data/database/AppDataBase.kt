package com.pets.mycontactlist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pets.mycontactlist.data.database.storeduserInfo.StoredUserInfo

@Database(entities = [StoredUserInfo::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun storedUserInfoDao(): StoredUserInfoDao

}