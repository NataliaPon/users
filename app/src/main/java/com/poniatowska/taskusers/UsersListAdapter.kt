package com.poniatowska.taskusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poniatowska.taskusers.models.User

class UsersListAdapter(usersList: ArrayList<User>) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {
    private var usersList: ArrayList<User>

    init {
        this.usersList = usersList
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.textView)
        }
    }

    fun updateUsersList(usersList: ArrayList<User>){
        this.usersList = usersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.single_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = usersList[position]

        holder.textView.text = user.login
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}