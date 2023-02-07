package com.example.smartbus.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bus(
    @PrimaryKey val busID:String,
    @ColumnInfo(name = "busName") val busName:String,
    @ColumnInfo(name = "source") val source:String,
    @ColumnInfo(name = "destination") val destination:String,
    @ColumnInfo(name = "price") val price:Double,
    @ColumnInfo(name = "startTime") val startTime:String,
    @ColumnInfo(name = "endTime") val endTime:String
){

}