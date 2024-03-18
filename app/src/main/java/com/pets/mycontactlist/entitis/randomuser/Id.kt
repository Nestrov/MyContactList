package com.pets.mycontactlist.entitis.randomuser

import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String
)