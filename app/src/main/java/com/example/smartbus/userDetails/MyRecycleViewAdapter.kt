package com.example.smartbus.userDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbus.R
import com.example.smartbus.database.RegisterEntity
import com.example.smartbus.database.RegisterRepository
import com.example.smartbus.databinding.ListItemBinding
import com.example.smartbus.databinding.RegisterHomeFragmentBinding

class MyRecycleViewAdapter(private val usersList :List<RegisterEntity>):RecyclerView.Adapter<MyviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.bind(usersList[position])

    }


}

class MyviewHolder(private val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(user : RegisterEntity){
        binding.FirstNameTextView.text = user.firstName
        binding.secondNameTextView.text = user.lastName
        binding.userTextField.text = user.userName
    }

}