package com.poniatowska.taskusers.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.poniatowska.taskusers.models.User

@Database(entities = [User::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        private var instance: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase {
            instance = Room.databaseBuilder(
                context.applicationContext,
                UsersDatabase::class.java, "users_database"
            )
                .fallbackToDestructiveMigration()
                .addCallback(roomCallBack)
                .build()

            return instance as UsersDatabase
        }

        private val roomCallBack: Callback = object : Callback() {
        }

    }



}