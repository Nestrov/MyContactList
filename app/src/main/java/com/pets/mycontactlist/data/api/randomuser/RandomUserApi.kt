package com.pets.mycontactlist.data.api.randomuser

import com.pets.mycontactlist.entitis.randomuser.UserInfoJSON
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RandomUserApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )

    @GET("api/")
    suspend fun getUserList(@Query("results") results:Int = 10): UserInfoJSON

}