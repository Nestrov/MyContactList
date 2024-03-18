package com.pets.mycontactlist.entitis.randomuser

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String,
    @SerializedName("title") val title: String
)

fun Name.toUserInfoFio() : String{
    var res: String = title
    if (first.isNotEmpty()) res += " $first"
    if (last.isNotEmpty()) res += " $last"

    return res
}