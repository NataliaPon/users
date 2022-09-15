package com.poniatowska.taskusers.repositories

import com.poniatowska.taskusers.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    fun getUsersList() : Call<ArrayList<User>>
}