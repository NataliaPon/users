package com.poniatowska.taskusers.repositories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.poniatowska.taskusers.models.User

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): LiveData<List<User>>

//    @Query("DELETE FROM users_table")
//    suspend fun deleteAll()
}