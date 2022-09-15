package com.poniatowska.taskusers.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.poniatowska.taskusers.models.User

class UsersRepository(private val userDao: UserDao){

    val users: LiveData<List<User>> = userDao.getAllUsers()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun insertUser(user: User){
        userDao.insert(user)
    }
}