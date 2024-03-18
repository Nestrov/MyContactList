package com.pets.mycontactlist.data.database.storeduserInfo


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pets.mycontactlist.entitis.userinfo.UserInfo
import com.pets.mycontactlist.entitis.userinfo.UserInfoDto


@Entity(tableName = "user")
data class StoredUserInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "fio")
    val fio: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    @ColumnInfo(name = "longitude")
    val longitude: Double,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "smallPhotoUrl")
    val smallPhotoUrl: String,
    @ColumnInfo(name = "bigPhotoUrl")
    val bigPhotoUrl: String
): UserInfoDto{
    override fun toUserInfo(): UserInfo = UserInfo(
        fio = fio,
        phone = phone,
        email = email,
        latitude = latitude,
        longitude = longitude,
        address = address,
        smallPhotoUrl = smallPhotoUrl,
        bigPhotoUrl = bigPhotoUrl
    )


}


