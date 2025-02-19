package com.example.fetchdata.Model

data class User(val id: Int,
                val name: String,
                val company: String,
                val username: String,
                val email: String,
                val address: String,
                val zip: String,
                val state: String,
                val country: String,
                val phone: String,
                val photo: String) {
}