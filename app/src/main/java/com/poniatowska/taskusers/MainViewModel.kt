package com.poniatowska.taskusers

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.poniatowska.taskusers.models.User
import com.poniatowska.taskusers.repositories.ApiRepository

class MainViewModel : ViewModel(){
    fun populateUsersDb(context: Context){
        ApiRepository().getAndSaveUsersList(context)
    }

}