package com.pets.mycontactlist.entitis.randomuser

import com.google.gson.annotations.SerializedName

data class UserInfoJSON(
    //@SerializedName("info") val info: Info?,
    @SerializedName("results") val results: List<Result>?
)