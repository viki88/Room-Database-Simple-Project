package com.purwadhika.roomdatabasesimpleproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.purwadhika.roomdatabasesimpleproject.database.AppDatabase
import com.purwadhika.roomdatabasesimpleproject.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) :AndroidViewModel(application){

    var userLiveData = MutableLiveData<List<User>>()

    val userDAO = AppDatabase.dbBuild(application).userDao()

    fun insertUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            userDAO.insertUser(user)
        }
    }

    fun getAllUser() {
        viewModelScope.launch(Dispatchers.IO){
            val userDatas = userDAO.getAllUsers()
            userLiveData.postValue(userDatas)
        }
    }

}