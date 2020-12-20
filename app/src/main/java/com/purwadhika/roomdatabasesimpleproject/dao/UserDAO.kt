package com.purwadhika.roomdatabasesimpleproject.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.purwadhika.roomdatabasesimpleproject.model.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM User")
    suspend fun getAllUsers() :List<User>

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

}