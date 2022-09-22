package com.poniatowska.taskusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.poniatowska.taskusers.models.User
import com.squareup.picasso.Picasso


class UsersListAdapter(usersList: ArrayList<User>, fragment: Fragment ) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {
    private var usersList: ArrayList<User>
    private var fragment: Fragment

    init {
        this.usersList = usersList
        this.fragment = fragment
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var imageView: ImageView

        init {
            textView = itemView.findViewById(R.id.textView)
            imageView = itemView.findViewById(R.id.imageView)
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
        Picasso.with(fragment.requireContext()).load(user.avatar_url).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}