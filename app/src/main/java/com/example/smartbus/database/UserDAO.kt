package com.example.smartbus.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users:User)

    @Delete
    fun delete(user:User)

    @Update
    fun update(user:User)

    @Query("SELECT * FROM user order by UserName")
    fun getAll():LiveData<List<User>>
}