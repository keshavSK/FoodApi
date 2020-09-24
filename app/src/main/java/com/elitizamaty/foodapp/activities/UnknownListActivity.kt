package com.elitizamaty.foodapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elitizamaty.foodapp.R
import com.elitizamaty.foodapp.interfaces.ApiInterface
import com.elitizamaty.foodapp.models.responses.UnknownListResponse
import com.elitizamaty.foodapp.models.rest_api.RestAdapterContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UnknownListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unknown_list)

        var service = RestAdapterContainer.getInstance().create(ApiInterface::class.java)
        var call = service.getUnknownList()
        call.enqueue(object : Callback<UnknownListResponse> {
            override fun onFailure(call: Call<UnknownListResponse>, t: Throwable) {
                Toast.makeText(this@UnknownListActivity, "${t.localizedMessage}", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(
                call: Call<UnknownListResponse>,
                response: Response<UnknownListResponse>
            ) {
                if (response.body() == null) {
                    Toast.makeText(
                        this@UnknownListActivity,
                        "${response.message()}",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    return
                }

                var unknownResponse = response.body()
                var page = unknownResponse!!.page
                var perPage = unknownResponse.per_page
                var total = unknownResponse.total
                var totalPages = unknownResponse.total_pages
                var unknownList = unknownResponse.data
            }

        })
    }
}