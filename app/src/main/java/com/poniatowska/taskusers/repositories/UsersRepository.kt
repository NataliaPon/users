package com.poniatowska.taskusers.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.poniatowska.taskusers.models.User

class UsersRepository(private val userDao: UserDao){

    val users: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insertUser(user: User){
        userDao.insert(user)
    }
}