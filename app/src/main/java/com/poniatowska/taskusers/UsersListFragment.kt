package com.poniatowska.taskusers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poniatowska.taskusers.models.User

class UsersListFragment : Fragment() {

    private lateinit var usersListAdapter: UsersListAdapter // = UsersListAdapter(ArrayList(),requireActivity())
    companion object {
        fun newInstance() = UsersListFragment()
    }

    private lateinit var viewModel: UsersListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        usersListAdapter = UsersListAdapter(ArrayList(),this)

        val view = inflater.inflate(R.layout.fragment_users_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = usersListAdapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[UsersListViewModel::class.java]
        viewModel.getUsersList(requireActivity()).observe(requireActivity(), Observer {
            usersListAdapter.updateUsersList(it as ArrayList<User>)
        })
    }

}