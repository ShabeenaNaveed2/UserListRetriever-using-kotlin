package com.example.fetchdata

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchdata.Model.User
import com.bumptech.glide.Glide
import com.example.fetchdata.R

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        Log.d("UserAdapter", "Binding user at position: $position")
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        Log.d("UserAdapter", "Total item count: ${users.size}")
        return users.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userPhoto: ImageView = itemView.findViewById(R.id.userPhoto)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val userUsername: TextView = itemView.findViewById(R.id.userUsername)
        private val userEmail: TextView = itemView.findViewById(R.id.userEmail)
        private val userPhone: TextView = itemView.findViewById(R.id.userPhone)
        private val userAddress: TextView = itemView.findViewById(R.id.userAddress)
        private val userCompany: TextView = itemView.findViewById(R.id.userCompany)
        private val userCountry: TextView = itemView.findViewById(R.id.userCountry)

        fun bind(user: User) {
            userName.text = user.name
            userUsername.text = user.username
            userEmail.text = user.email
            userPhone.text = user.phone
            userAddress.text = user.address
            userCompany.text = user.company
            userCountry.text = user.country

            Glide.with(itemView.context)
                .load(user.photo)
                .placeholder(R.drawable.baseline_circle_24)
                .into(userPhoto)
        }
    }
}
