package com.poniatowska.taskusers

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poniatowska.taskusers.models.User
import com.poniatowska.taskusers.repositories.RetrofitClient
import com.poniatowska.taskusers.repositories.UsersDatabase
import com.poniatowska.taskusers.repositories.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel(){
    private val retrofitClient = RetrofitClient.create()
    var usersList: MutableLiveData<ArrayList<User>?> = MutableLiveData()

    fun populateUsersDb(context: Context){
        viewModelScope.launch {
            val response = retrofitClient.getUsersList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    usersList.postValue(response.body())

                    val database = UsersDatabase.getInstance(context)
                    response.body()?.forEach{
                        UsersRepository(database.userDao()).insertUser(it)
                    }
                }
            }
        }
    }
}