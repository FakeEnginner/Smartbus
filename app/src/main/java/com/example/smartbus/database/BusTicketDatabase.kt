package com.example.smartbus.database

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

import java.util.*

@Database(entities = [User::class,Bus::class,Reservation::class],version =1, exportSchema = false)
abstract class BusTicketDatabase:RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun busDao(): BusDAO
    abstract fun reservationDao(): ReservationDAO

    companion object{
        private var dbInstance: BusTicketDatabase?=null
        private var context: Context?=null


       /*//@Synchronized
        fun getInstance(context: Context): BusTicketDatabase {
            return dbInstance ?: synchronized(this) {
                dbInstance ?: buildDatabase(context).also { dbInstance = it }
            }
        }*/
        @Synchronized
       fun getInstance(context: Context):BusTicketDatabase{
         //  buildDatabase(context.applicationContext)
            if(dbInstance == null)
                dbInstance=Room.databaseBuilder(context.applicationContext,BusTicketDatabase::class.java, "word_database"
                ).fallbackToDestructiveMigration().addCallback(roomCallback).build()

         //  buildDatabase(context.applicationContext)

            return dbInstance!!
        }


/*
        private fun buildDatabase(context: Context): BusTicketDatabase {
            return Room.databaseBuilder(context, BusTicketDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<databaseWorker>()
                                .setInputData(workDataOf(KEY_FILENAME to USER_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }*/

        private val roomCallback=object :Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(dbInstance!!)
                //buildDatabase(context!!)
            }
        }

        @SuppressLint("SuspiciousIndentation")
        private fun populateDatabase(db:BusTicketDatabase){
           // buildDatabase(context!!)
            val userDao = db.userDao()
            val busDAO=db.busDao()
            val reservationDAO=db.reservationDao()


           // subscribeOnBackground{
                userDao.insert(User(101,"Shashank","Hydrabad","7987685319","sashank@gmail.com",true))
                userDao.insert(User(102,"Naman","Gwalior","9726278998","namanshrivastava94253@@gmail.com",true))
                busDAO.insert(Bus("MH101","RSYDAV","Hyderabad","Pune",15000.0,"18:00","5:00" ))
                busDAO.insert(Bus("MH202","MHTRI","Cheenai","Mumbai",15000.0, "20:00","6:00"))
//                vehicleDAO.insert(Vehicle(301,"HEROHONDA","Splendor","MP04ND7474",2,"06390","04799","2000","Petrol"))
//                vehicleDAO.insert(Vehicle(302,"MARUTI","Alto","MP04CA2729",4,"MA3EYD81S00669097","F8DN3260096","2006","Petrol"))
            //}
        }
    }
}



