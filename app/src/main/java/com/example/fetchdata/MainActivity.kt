package com.example.fetchdata

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchdata.Model.User
import com.example.fetchdata.Network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        RetrofitBuilder.api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body() ?: emptyList()
                    Log.d("MainActivity", "Fetched ${users.size} users")
                    userAdapter = UserAdapter(users)
                    recyclerView.adapter = userAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
