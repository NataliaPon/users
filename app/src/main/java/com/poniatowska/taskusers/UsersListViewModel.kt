package com.poniatowska.taskusers

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.poniatowska.taskusers.models.User
import com.poniatowska.taskusers.repositories.UsersDatabase

class UsersListViewModel : ViewModel() {//(context: Context)
//    private var database: UsersDatabase
//    init {
//        database = UsersDatabase.getInstance(context)
//    }
    fun getUsersList(context: Context): LiveData<List<User>> {
        val database = UsersDatabase.getInstance(context)
        return database.userDao().getAllUsers()
    }
}