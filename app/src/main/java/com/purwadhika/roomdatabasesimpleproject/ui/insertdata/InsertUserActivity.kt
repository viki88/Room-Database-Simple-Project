package com.purwadhika.roomdatabasesimpleproject.ui.insertdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.purwadhika.roomdatabasesimpleproject.databinding.ActivityInsertUserBinding
import com.purwadhika.roomdatabasesimpleproject.model.User
import com.purwadhika.roomdatabasesimpleproject.ui.main.MainViewModel

class InsertUserActivity : AppCompatActivity() {
    lateinit var binding :ActivityInsertUserBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            mainViewModel.insertUser(
                User(
                    firstName = binding.firstnameInput.text.toString(),
                    lastName = binding.lastnameInput.text.toString()
                )
            )
            finish()
        }
    }
}