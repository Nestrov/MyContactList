package com.pets.mycontactlist.presentations.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.pets.mycontactlist.R
import com.pets.mycontactlist.databinding.UserListItemBinding
import com.pets.mycontactlist.entitis.userinfo.UserInfo

class ContactListAdapter (

    private val onClick : (Int)-> Unit

):  Adapter<ContactListAdapter.ContactListViewHolder>(){
    private var userList : List<UserInfo> = listOf()

    fun update(data: List<UserInfo>) {
        userList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val binding = UserListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ContactListViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return userList.size
    }


    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        val item = userList[position]

        Glide.with(holder.binding.ivAvatar)
            .load(item.smallPhotoUrl)
            .error(R.drawable.ic_empty_photo)
            .into(holder.binding.ivAvatar)

        holder.binding.tvName.text =
            holder.itemView.context.getString(R.string.user_name_preview, item.fio)
        holder.binding.tvAddress.text =
            holder.itemView.context.getString(R.string.user_address_preview, item.address)
        holder.binding.tvPhone.text =
            holder.itemView.context.getString(R.string.user_phone_preview, item.phone)

        holder.binding.cvUser.setOnClickListener {
            onClick (position)
        }
    }


    inner class ContactListViewHolder(val binding : UserListItemBinding): RecyclerView.ViewHolder(binding.root)
}


