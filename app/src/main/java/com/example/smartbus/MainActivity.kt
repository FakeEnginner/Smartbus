package com.example.smartbus


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.room.Room

import com.example.smartbus.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import com.example.smartbus.database.Bus
import com.example.smartbus.database.BusTicketDatabase
import com.example.smartbus.database.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        @Suppress("UNUSED VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)



//        database
        val db = Room.databaseBuilder(
            applicationContext,BusTicketDatabase::class.java,"BusTicketDatabase"
        ).build()



        GlobalScope.launch {

            BusTicketDatabase.getInstance(applicationContext)

            db.userDao().insert(User(101,"Shashank","Hydrabad","7987685319","sashank@gmail.com",true))
            db.userDao().insert(User(102,"Naman","Gwalior","9726278998","namanshrivastava94253@@gmail.com",false))
            db.busDao().insert(Bus("MH101","RSYDAV","Hyderabad","Pune",15000.0,"18:00","5:00" ))
            db.busDao().insert(Bus("MH202","MHTRI","Cheenai","Mumbai",15000.0, "20:00","6:00"))

            db.userDao().insert(User(101,"Shreyas","Bhopal","7987685319","bhagwatshreyas01@gmail.com",true))
            db.userDao().insert(User(102,"Dhruv","Surat","9726278998","bhagwatshreyas01@gmail.com",false))
        }


    }
}


