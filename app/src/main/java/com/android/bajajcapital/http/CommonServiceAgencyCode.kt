package com.android.bajajcapital.http

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.android.bajajcapital.bean.AgentResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommonServiceAgencyCode {
    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            Log.e("retrofit", "create")

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(AppConstant.URL_AGENCY_CODE)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }


    //Agency Code Api hit
    fun getAgencyCodeDetails(header: HashMap<String, String>, request: RequestBody): MutableLiveData<AgentResponse>? {
        val liveAgencyResponse: MutableLiveData<AgentResponse> = MutableLiveData()
        val retrofitCall = CommonServiceAgencyCode.create().getAgencyCode(header, request)
        retrofitCall.enqueue(object : Callback<AgentResponse> {
            override fun onFailure(call: Call<AgentResponse>, t: Throwable) {
                Log.e("on Failure Token:", "retrofit error")
            }

            override fun onResponse(call: Call<AgentResponse>, response: Response<AgentResponse>) {
                val value = response.body()

                if (value != null) {
                    liveAgencyResponse?.value = value
                } else {
                    try {
                        val gson = Gson()
                        val type = object : TypeToken<AgentResponse>() {}.type
                        var errorResponse: AgentResponse? = gson.fromJson(response.errorBody()!!.charStream(), type)
                        Log.e("Agent Code Response", errorResponse.toString())
                        liveAgencyResponse?.value = errorResponse
                    } catch (e: Exception) {
                    }
                }
            }
        })
        return liveAgencyResponse
    }
}