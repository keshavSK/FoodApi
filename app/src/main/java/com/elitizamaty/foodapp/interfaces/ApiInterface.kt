package com.elitizamaty.foodapp.interfaces

import com.elitizamaty.foodapp.models.responses.SignUpResponse
import com.elitizamaty.foodapp.models.responses.StateResponse
import com.elitizamaty.foodapp.models.responses.UnknownListResponse
import com.elitizamaty.foodapp.models.responses.UserListResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("api/users")
    fun getUserList(@Query("page") page: String): Call<UserListResponse>

    @GET("api/unknown")
    fun getUnknownList(): Call<UnknownListResponse>

    @FormUrlEncoded
    @POST("api/users/sign_up")
    fun signUp(
        @Field("name") name: String,
        @Field("mobile") mobile: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("password") password: String
    ): Call<SignUpResponse>

    @GET("api/users/get_states")
    fun getState(@Query("country_id") countryId: String): Call<StateResponse>
}