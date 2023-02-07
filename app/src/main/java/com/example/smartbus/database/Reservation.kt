package com.example.smartbus.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Reservation(
    @PrimaryKey val reservationID:Int,
    @ColumnInfo(name = "userID") val userID:String,
    @ColumnInfo(name = "busID") val busID:String,
    @ColumnInfo(name = "nofSeats") val nofSeats:Int,
    @ColumnInfo(name = "payment") val payment:Double,

    //name ,status ,price,
) {
}