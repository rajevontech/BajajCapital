package com.android.bajajcapital.http

import com.android.bajajcapital.bean.AgentResponse
import com.android.bajajcapital.bean.TokenResponse
import com.android.bajajcapital.bean.ValidateCustomer
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    //Customer Validate
    @POST("CustomerValidation/LanId")
    fun validateCustomer(@HeaderMap headers: Map<String, String>, @Body request: RequestBody): Call<ValidateCustomer>


    //Token get
    @Headers(
        "Content-Type:application/x-www-form-urlencoded"
    )
    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("grant_type") grant_type: String,
        @Field("client_id") client_id: String,
        @Field("client_secret") client_secret: String,
        @Field("resource") resource: String
    ): Call<TokenResponse>


    //  Agent API
    @POST("AgentPaymentUpdate")
    fun validateAgent(@HeaderMap headers: Map<String, String>, @Body request: RequestBody): Call<ValidateCustomer>


    //Agency API (agency code input)
    @POST("AgencyNameCdm")
    fun getAgencyCode(@HeaderMap headers: Map<String, String>, @Body request: RequestBody): Call<AgentResponse>


}