package com.example.smartbus.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BusDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( buses:List<Bus>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bus: Bus)

    @Delete
    fun delete(bus:Bus)

    @Query("SELECT * FROM Bus order by busName")
    fun getAll():LiveData<List<Bus>>

    @Update
    fun update(bus:Bus)


}