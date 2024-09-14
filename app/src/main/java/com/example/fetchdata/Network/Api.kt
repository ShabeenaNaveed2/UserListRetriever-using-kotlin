package com.example.fetchdata.Network
import retrofit2.Call
import com.example.fetchdata.Model.User
import retrofit2.http.GET

interface Api {
        @GET("/users")
        fun getUsers(): Call<List<User>>
}