package com.android.bajajcapital.http

import com.android.bajajcapital.bean.AgentResponse
import com.android.bajajcapital.bean.TokenResponse
import com.android.bajajcapital.bean.ValidateCustomer
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("CustomerValidation/LanId")
    fun validateCustomer(@HeaderMap headers: Map<String, String>, @Body request: RequestBody): Call<ValidateCustomer>


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



    @POST("AgentPaymentUpdate")
    fun agentValidate(
        @Field("amount")amount: String,
        @Field("branch_code")branch_code:String,
        @Field("transaction_ref_no")transaction_ref_no:String,
        @Field("received_date")received_date:String,
        @Field("source")source:String,
        @Field("customername")customername:String):Call<AgentResponse>




}