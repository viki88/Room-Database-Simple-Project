package com.purwadhika.roomdatabasesimpleproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.purwadhika.roomdatabasesimpleproject.model.User
import com.purwadhika.roomdatabasesimpleproject.dao.UserDAO

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao() : UserDAO

    companion object{
        fun dbBuild(context: Context) =
            Room.databaseBuilder(context,AppDatabase::class.java,"app-database").build()
    }
}