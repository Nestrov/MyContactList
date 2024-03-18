package com.pets.mycontactlist.data.api

import com.pets.mycontactlist.data.api.randomuser.RandomUserApi
import com.pets.mycontactlist.entitis.randomuser.UserInfoJSON
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val RANDOM_URL = "https://randomuser.me"

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(RANDOM_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val randomUserApi: RandomUserApi = retrofit.create(RandomUserApi::class.java)

    suspend fun getUserList(results: Int = 10): UserInfoJSON {
        return randomUserApi.getUserList(results)
    }
}