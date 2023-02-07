package com.example.smartbus.database

import android.app.Application
import androidx.lifecycle.LiveData


public class BusRepository(application: Application) {
    private val mBusDAO:BusDAO
    private val mGetAll: LiveData<List<Bus>>

    init {
        val database = BusTicketDatabase.getInstance(application)

        mBusDAO = database.busDao()
        mGetAll = mBusDAO.getAll()//LiveData<List<Policy>>
    }

    fun insert(bus: Bus)// = viewModelScope.launch
    {
        mBusDAO.insert(bus)
    }

    fun update(bus: Bus) //= viewModelScope.launch
    {
        mBusDAO.update(bus)
    }

    fun delete(bus: Bus) //= viewModelScope.launch
    {
        mBusDAO.delete(bus)
    }




}