package com.poniatowska.taskusers.repositories

import android.content.Context
import android.util.Log
import com.poniatowska.taskusers.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {
    private val retrofitClient = RetrofitClient.create().getUsersList()

    fun getAndSaveUsersList(context: Context){
        retrofitClient.enqueue(object : Callback<ArrayList<User>>{
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                Log.e("resp", response.body()!![0].login)
                saveUsersList(response.body()!!, context)
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun saveUsersList(usersList: ArrayList<User>, context: Context){
        val database = UsersDatabase.getInstance(context)
        usersList.forEach{
            UsersRepository(database.wineDao()).insertUser(it)
        }
    }
}