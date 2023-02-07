package com.example.smartbus.adapter

import android.app.Activity
import android.text.Layout
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.ImageView
import android.view.View
import android.view.ViewGroup
import com.example.smartbus.R
import com.example.smartbus.User


class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>):
                ArrayAdapter<User>(context, R.layout.list_item,arrayList)
{
     override fun getView(position: Int, convertView:View?, parent: ViewGroup):View{
         val inflater : LayoutInflater = LayoutInflater.from(context)
         val view: View = inflater.inflate(R.layout.list_item,null)
         val imageView: ImageView = view.findViewById(R.id.profile_pic)
         val userName: TextView = view.findViewById(R.id.personName)
         val lastMsg : TextView = view.findViewById(R.id.lastMessage)
         val lastMsgTime : TextView = view.findViewById(R.id.msgtime)
//         val lastRupees : TextView=view.findViewById(R.id.rupees)


         imageView.setImageResource(arrayList[position].imageId)
         userName.text = arrayList[position].name
         lastMsg.text = arrayList[position].lastMessage
         lastMsgTime.text = arrayList[position].lastMsgTime
//         lastRupees.text= arrayList[position].als
//         super.getView(position, convertview, parent)
         return view
     }


}

