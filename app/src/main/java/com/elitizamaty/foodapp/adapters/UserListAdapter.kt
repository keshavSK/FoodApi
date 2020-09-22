package com.elitizamaty.foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elitizamaty.foodapp.R
import com.elitizamaty.foodapp.models.data_models.UserModel
import com.squareup.picasso.Picasso

class UserListAdapter(var userList: List<UserModel?>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvRowUserName)
        val tvEmail = itemView.findViewById<TextView>(R.id.tvRowUserEmail)
        val userImage = itemView.findViewById<ImageView>(R.id.rowUserImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_user_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text =
            "${userList[position]?.first_name} ${userList[position]?.last_name}"
        holder.tvEmail.text = userList[position]?.email
        if (userList[position]?.avatar != null) {
            Picasso.get().load(userList[position]?.avatar).into(holder.userImage)
        }
    }
}