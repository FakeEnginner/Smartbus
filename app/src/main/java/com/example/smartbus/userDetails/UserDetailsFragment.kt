package com.example.smartbus.userDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartbus.R
import com.example.smartbus.database.RegisterDatabase
import com.example.smartbus.database.RegisterRepository
import com.example.smartbus.databinding.UserDetailsFragmentBinding



class UserDetailsFragment : Fragment() {

    private lateinit var userDetailsViewModel: UserDetailsViewModel
    private lateinit var binding: UserDetailsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.user_details_fragment, container, false
        )

        val application = requireNotNull(this.activity).application

        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository = RegisterRepository(dao)

        val factory = UserDetalisFactory(repository, application)

        userDetailsViewModel =
            ViewModelProvider(this, factory).get(UserDetailsViewModel::class.java)

        binding.userDelailsLayout = userDetailsViewModel

        binding.lifecycleOwner = this

        userDetailsViewModel.navigateto.observe(this, Observer { hasFinished ->
            if (hasFinished == true) {
              //  val action = UserDetailsFragmentDirection.actionUserDetailsFragmentToLoginFragment()
                NavHostFragment.findNavController(this).navigate(R.id.action_userDetailsFragment_to_loginFragment)
                userDetailsViewModel.doneNavigating()
            }
        })

        initRecyclerView()

        return binding.root

    }



    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this.context)
        displayUsersList()
    }


    private fun displayUsersList() {
        Log.i("MYTAG", "Inside ...UserDetails..Fragment")
        userDetailsViewModel.users.observe(this, Observer {
            binding.usersRecyclerView.adapter = MyRecycleViewAdapter(it)
        })

    }

}