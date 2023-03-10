package com.example.smartbus.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="user")
data class User (
    @PrimaryKey val userID:Int,
    @ColumnInfo(name = "UserName") val userName:String,
    @ColumnInfo(name = "UserAddress") val userAddress:String,
    @ColumnInfo(name = "UserMobileNo") val userMobNo:String,
    @ColumnInfo(name = "UserEmail") val userEmail:String,
    @ColumnInfo(name = "Admin") val isAdmin:Boolean
//    @ColumnInfo(name = "busList") val busList:List<Bus>


        )
