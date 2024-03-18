package com.pets.mycontactlist.entitis.randomuser

import com.google.gson.annotations.SerializedName
import com.pets.mycontactlist.data.database.storeduserInfo.StoredUserInfo
import com.pets.mycontactlist.data.database.storeduserInfo.StoredUserInfoDto
import com.pets.mycontactlist.entitis.userinfo.UserInfo
import com.pets.mycontactlist.entitis.userinfo.UserInfoDto

data class Result (
    @SerializedName("cell") val cell: String,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Id,
    @SerializedName("location") val location: Location,
    @SerializedName("login") val login: Login,
    @SerializedName("name") val name: Name,
    @SerializedName("nat") val nat: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("registered") val registered: Registered
): UserInfoDto, StoredUserInfoDto {
    override fun toStoredUserInfo(): StoredUserInfo = StoredUserInfo(
        id = 0,
        fio = name.toUserInfoFio(),
        phone = phone,
        email = email,
        latitude = location.coordinates.latitude.toDouble(),
        longitude = location.coordinates.longitude.toDouble(),
        address = location.toUserInfoAddress(),
        smallPhotoUrl = picture.thumbnail,
        bigPhotoUrl = picture.large,
    )


    override fun toUserInfo(): UserInfo  = UserInfo(
        fio = name.toUserInfoFio(),
        phone = phone,
        email = email,
        latitude = location.coordinates.latitude.toDouble(),
        longitude = location.coordinates.longitude.toDouble(),
        address = location.toUserInfoAddress(),
        smallPhotoUrl = picture.thumbnail,
        bigPhotoUrl = picture.large
    )


}
