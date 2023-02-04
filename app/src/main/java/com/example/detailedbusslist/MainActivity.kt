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

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.buses, R.drawable.buses, R.drawable.buses, R.drawable.buses, R.drawable.buses, R.drawable.buses,
            R.drawable.buses,R.drawable.buses,R.drawable.buses
        )

        val name = arrayOf(
            "Pune - Mumbai",
            "Gwalior - Bhopal",
            "Vellore - Chennai",
            "Bangalore - Mumbai",
            "Chennai - Kanyakumari",
            "Indore - Bhopal",
            "Delhi - Varanasi",
            "Surat - Pune",
            "Agra - Delhi"
        )

        val lastMessage = arrayOf(
            "2+3, Seater,Non-AC, Non-Video",
            "2+3, Seater,AC, Non-Video",
            "2+1, Volvo Sleeper,AC, Non-Video",
            "2+1, Sleeper,AC, Non-Video (36)",
            "A/C Seater / Sleeper (2+1)",
            "Electric A/C Seater (2+2)",
            "Benz A/C Sleeper (2+1)",
            "Bharat Benz A/C Seater /Sleeper (2+1)",
            "Electric A/C Seater (2+2)",

        )
        val lastMsgTime = arrayOf(
            "8:00  pm",
            "9:45  pm",
            "10:00 pm",
            "11:00 pm",
            "7:00  pm",
            "6:00  pm",
            "5:00  pm",
            "11:00 am",
            "12:00 pm"
        )
        val phoneNo = arrayOf(
            "7675",
            "9652",
            "9000",
            "9059",
            "8523",
            "9492",
            "8985",
            "8985",
            "8985"
        )
        val country = arrayOf(
            "Franc",
            "Usa",
            "Britain",
            "Russia",
            "India",
            "Nepal",
            "Ukrain",
            "Ukrain",
            "Ukrain"
        )
//        val rupees= arrayOf(
//            "350",
//            "350",
//            "350",
//            "350",
//            "350",
//            "350",
//            "350",
//            "350",
//            "350"
//        )

        userArrayList = ArrayList()

        for(i in name.indices){
            val user = User(name[i], lastMessage[i], lastMsgTime[i], phoneNo[i], country[i], imageId[i] )
            userArrayList.add(user)
        }
        binding.listview.isClickable = true
        binding.listview.adapter =  MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener{parent, view, position, id ->
            val name = name[position]
            val phone = phoneNo[position]
            val country = country[position]
            val image = imageId[position]
//            val rupees=rupees[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("imageId",imageId)
            i.putExtra("country",country)
//            i.putExtra("rupees",rupees)
            startActivity(i)

        }
    }


}