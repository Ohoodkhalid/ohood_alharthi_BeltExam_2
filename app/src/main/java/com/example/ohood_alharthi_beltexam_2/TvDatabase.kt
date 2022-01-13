package com.example.ohood_alharthi_beltexam2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TvShow::class], version = 2, exportSchema = false)
abstract class TvDatabase : RoomDatabase(){
    abstract fun TvDao(): TvDao

    companion object{
        @Volatile  // writes to this field are immediately visible to other threads
        private var INSTANCE: TvDatabase? = null

        fun getDatabase(context: Context): TvDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){  // protection from concurrent execution on multiple threads
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TvDatabase::class.java,
                    "Tv_Show_DB"
                ).fallbackToDestructiveMigration()  // Destroys old database on version change
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}