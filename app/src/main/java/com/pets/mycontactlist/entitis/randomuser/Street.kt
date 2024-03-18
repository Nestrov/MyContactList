package com.pets.mycontactlist.entitis.randomuser

import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: Int
)