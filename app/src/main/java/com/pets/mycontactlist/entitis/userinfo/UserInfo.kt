package com.pets.mycontactlist.entitis.userinfo


import com.pets.mycontactlist.data.database.storeduserInfo.StoredUserInfo
import com.pets.mycontactlist.data.database.storeduserInfo.StoredUserInfoDto


data class UserInfo(
    val fio: String,
    val phone: String,
    val email: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val smallPhotoUrl: String,
    val bigPhotoUrl: String

)