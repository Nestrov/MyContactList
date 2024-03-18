package com.pets.mycontactlist.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pets.mycontactlist.data.database.storeduserInfo.StoredUserInfo

@Dao
interface StoredUserInfoDao {

    @Insert()
    fun insert( user : StoredUserInfo)

    @Insert()
    fun insertAll( list : List<StoredUserInfo>)

    @Query("DELETE FROM user")
    fun clear()

    @Query("Select * From user")
    fun getStoredUserInfo() : List<StoredUserInfo>

    @Query ("Select count(id) From user")
    fun getCount () : Int

}