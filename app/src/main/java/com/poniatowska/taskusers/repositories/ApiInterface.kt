package com.poniatowska.taskusers.repositories

import com.poniatowska.taskusers.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    suspend fun getUsersList() : Response<ArrayList<User>>
}