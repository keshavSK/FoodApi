package com.elitizamaty.foodapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elitizamaty.foodapp.R
import com.elitizamaty.foodapp.adapters.UserListAdapter
import com.elitizamaty.foodapp.interfaces.ApiInterface
import com.elitizamaty.foodapp.models.responses.UserListResponse
import com.elitizamaty.foodapp.models.rest_api.RestAdapterContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var page = "1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewUser)
        recyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        var service = RestAdapterContainer.getInstance().create(ApiInterface::class.java)
        var call = service.getUserList(page)
        call.enqueue(object : Callback<UserListResponse> {
            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<UserListResponse>,
                response: Response<UserListResponse>
            ) {
                if (response.body() == null) {
                    Toast.makeText(this@MainActivity, "${response.message()}", Toast.LENGTH_LONG)
                        .show()
                    return
                }
                if (response.body()!!.data != null) {
                    var adapter = UserListAdapter(response.body()!!.data!!)
                    recyclerView?.adapter = adapter
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MainActivity, "User list not available", Toast.LENGTH_LONG)
                        .show()
                }
            }

        })
    }
}