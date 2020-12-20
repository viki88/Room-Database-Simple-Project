package com.purwadhika.roomdatabasesimpleproject.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.purwadhika.roomdatabasesimpleproject.databinding.RowUserLayoutBinding
import com.purwadhika.roomdatabasesimpleproject.model.User

class ListUserAdapter :ListAdapter<User, ListUserAdapter.UserViewHolder>(DIFF_CALLBACK){

    companion object{
        val DIFF_CALLBACK = object :DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class UserViewHolder(var binding :RowUserLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(user: User){
            binding.nameUserText.text = "${user.firstName} ${user.lastName}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = RowUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}