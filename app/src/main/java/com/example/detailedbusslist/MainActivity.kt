package com.example.detailedbusslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.detailedbusslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val imageId = intArrayOf(
//            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
//            R.drawable.h
//        )
//
//        val name = arrayOf(
//            "Christopher",
//            "Anurag",
//            "Daksh",
//            "Naman",
//            "Umesh",
//            "Naveen",
//            "Rout"
//        )
//
//        val lastMessage = arrayOf(
//            "Hi",
//            "How r u",
//            "Aur project kaisa chal raha hai",
//            "Mera haltal thik nhi hai",
//            "I am sleepy",
//            "Hungry",
//            "Idly"
//        )
//        val lastMsgTime = arrayOf(
//            "8:00 pm",
//            "9:45 pm",
//            "10:00 pm",
//            "11:00 pm",
//            "7:00 pm",
//            "6:00 pm",
//            "5:00 pm"
//        )
//        val phoneNo = arrayOf(
//            "7675",
//            "9652",
//            "9000",
//            "9059",
//            "8523",
//            "9492",
//            "8985"
//        )
//        val country = arrayOf(
//            "Franc",
//            "Usa",
//            "Britain",
//            "Russia",
//            "India",
//            "Nepal",
//            "Ukrain"
//        )
//
//        userArrayList = ArrayList()
//
//        for(i in name.indices){
//            val user = User(name[i], lastMessage[i], lastMsgTime[i], phoneNo[i], country[i], imageId[i] )
//            userArrayList.add(user)
//        }
//        binding.listview.isClickable = true
//        binding.listview.adapter =  MyAdapter(this, userArrayList)
//        binding.listview.setOnItemClickListener{parent, view, position, id ->
//            val name = name[position]
//            val phone = phoneNo[position]
//            val country = country[position]
//            val image = imageId[position]
//
//            val i = Intent(this, UserActivity::class.java)
//            i.putExtra("name",name)
//            i.putExtra("phone",phone)
//            i.putExtra("imageId",imageId)
//            i.putExtra("country",country)
//            startActivity(i)
//
//        }
    }
}