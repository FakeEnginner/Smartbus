package com.example.smartbus

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.smartbus.databinding.ListItemBinding

class UserActivity: AppCompatActivity() {
    private lateinit var binding: ListItemBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId",R.drawable.a)
        val country = intent.getStringExtra("country")
//        val rupees = intent.getStringExtra("rupees")

        binding.personName.text = name
        binding.lastMessage.text = phone
        binding.msgtime.text = country
        binding.profilePic.setImageResource(imageId)
//        binding.rupees.text=rupees

//        binding.tvNameProfile.text = name
//        binding.tvPhoneProfile.text = phone
//        binding.tvCountryProfile.text = country
//        binding.ivProfileImage.setImageResource(imageId)




    }

}