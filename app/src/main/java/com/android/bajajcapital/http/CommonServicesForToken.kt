package com.android.bajajcapital.http

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.android.bajajcapital.bean.TokenResponse
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommonServicesForToken {
    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            Log.e("retrofit", "create")

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(AppConstant.URL_TOKEN)
                //.baseUrl("https://learn2crack-json.herokuapp.com/api/")

                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
    fun loadTokenData(grant_type : String,client_id:String,client_secret:String,resource:String): MutableLiveData<TokenResponse>?{
        val liveTokenResponse: MutableLiveData<TokenResponse> = MutableLiveData()
        val retrofitCall = CommonServicesForToken.create().getToken(grant_type,client_id,client_secret,resource)
        retrofitCall.enqueue(object : Callback<TokenResponse> {
            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.e("on Failure Token:", "retrofit error")
            }

            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                val value=response.body()
                liveTokenResponse?.value=value
            }
        })
        return  liveTokenResponse

    }
}

