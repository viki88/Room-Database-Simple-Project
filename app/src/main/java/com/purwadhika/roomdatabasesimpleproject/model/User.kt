package com.purwadhika.roomdatabasesimpleproject.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id : Long = 0,
    @ColumnInfo(name = "firstname") var firstName :String,
    @ColumnInfo(name = "lastname") var lastName :String
)