package com.example.smartbus.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReservationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( reservation:List<Reservation>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(reservation: Reservation)

    @Delete
    fun delete(reservation: Reservation)

    @Query("SELECT * FROM Reservation order by reservationID")
    fun getAll(): LiveData<List<Reservation>>



}