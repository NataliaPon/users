package com.poniatowska.taskusers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.populateUsersDb(context = this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, UsersListFragment.newInstance())
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}