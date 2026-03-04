package com.example.a16_room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 2)
abstract class AppDatabse :
    RoomDatabase() {  //roomdatabase muloto ekta abstract class,,tai er modde nishcoy amn kisu method roiese jeta amader ovverride korte hobe..
    //bt override na kore amra ai khane surute a
    // astract class bania dibo,tahole room nijei amader class ke pore implement korbe,method gula ovverrid ekrbe

    abstract fun notedao(): NoteDao

    companion object {
        private var INSTANCE: AppDatabse? = null

        fun getdatabse(context: Context): AppDatabse {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabse::class.java,
                    "note_db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }

}