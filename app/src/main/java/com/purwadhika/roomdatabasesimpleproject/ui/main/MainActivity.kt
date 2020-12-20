package com.purwadhika.roomdatabasesimpleproject.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.purwadhika.roomdatabasesimpleproject.databinding.ActivityMainBinding
import com.purwadhika.roomdatabasesimpleproject.ui.insertdata.InsertUserActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    lateinit var adapter: ListUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()

        mainViewModel.userLiveData.observe(this) {
            adapter.submitList(it)
        }

        binding.addButton.setOnClickListener {
            startActivity(Intent(this, InsertUserActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getAllUser()
    }

    private fun setupList(){
        adapter = ListUserAdapter()
        binding.userList.adapter = adapter
        binding.userList.layoutManager = LinearLayoutManager(this)
        binding.userList.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }
}