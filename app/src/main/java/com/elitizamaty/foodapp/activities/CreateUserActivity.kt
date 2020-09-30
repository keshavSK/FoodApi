package com.elitizamaty.foodapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elitizamaty.foodapp.R
import com.elitizamaty.foodapp.interfaces.ApiInterface
import com.elitizamaty.foodapp.models.responses.SignUpResponse
import com.elitizamaty.foodapp.models.rest_api.RestAdapterContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateUserActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtMobile: EditText? = null
    private var edtEmail: EditText? = null
    private var edtAddress: EditText? = null
    private var edtPassword: EditText? = null
    private var btnSignUp: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        edtName = findViewById(R.id.edtUserName)
        edtMobile = findViewById(R.id.edtUserMobile)
        edtEmail = findViewById(R.id.edtUserEmail)
        edtAddress = findViewById(R.id.edtUserAddress)
        edtPassword = findViewById(R.id.edtUserPassword)
        btnSignUp = findViewById(R.id.btnSignUp)

        var service = RestAdapterContainer.getInstance().create(ApiInterface::class.java)

        btnSignUp?.setOnClickListener {
            var name = edtName?.text.toString().trim()
            var email = edtEmail?.text.toString().trim()
            var mobile = edtMobile?.text.toString().trim()
            var address = edtAddress?.text.toString().trim()
            var password = edtPassword?.text.toString().trim()
            var call = service.signUp(name, mobile, email, address, password)
            call.enqueue(object : Callback<SignUpResponse> {
                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    Log.e(Companion.TAG, "onFailure: ${t.localizedMessage}")
                }

                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    if (response.body() == null) {
                        Toast.makeText(
                            this@CreateUserActivity,
                            "Response not available",
                            Toast.LENGTH_LONG
                        ).show()
                        return
                    }
                    val signUpResponse = response.body()
                    if (signUpResponse?.status == 200) {
                        Toast.makeText(
                            this@CreateUserActivity,
                            "${signUpResponse.Message}",
                            Toast.LENGTH_LONG
                        ).show()
                        edtName?.text?.clear()
                        edtEmail?.text?.clear()
                        edtMobile?.text?.clear()
                        edtAddress?.text?.clear()
                        edtPassword?.text?.clear()

                    } else {
                        Toast.makeText(
                            this@CreateUserActivity,
                            "${signUpResponse?.Message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

            })

        }
    }

    companion object {
        private const val TAG = "CreateUserActivity"
    }
}