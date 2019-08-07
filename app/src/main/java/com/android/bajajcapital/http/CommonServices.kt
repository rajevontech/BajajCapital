package com.android.bajajcapital.http

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.android.bajajcapital.bean.ValidateCustomer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.RequestBody


class CommonServices {

    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            Log.e("retrofit", "create")

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))

                .baseUrl(AppConstant.BASE_URL)
                //.baseUrl("https://learn2crack-json.herokuapp.com/api/")

                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

    fun getAppUser(header: HashMap<String, String>, request: RequestBody): MutableLiveData<ValidateCustomer>? {
        val liveAppUserResponse: MutableLiveData<ValidateCustomer> = MutableLiveData()

        val retrofitCall: Call<ValidateCustomer> = create().validateCustomer(header, request)

        retrofitCall.enqueue(object : Callback<ValidateCustomer> {
            override fun onFailure(call: Call<ValidateCustomer>, t: Throwable?) {
                Log.e("on Failure Validation:", "retrofit error")
            }

            override fun onResponse(call: Call<ValidateCustomer>, response: Response<ValidateCustomer>) {
                val value = response.body()

                if (value != null) {
                    liveAppUserResponse?.value = value
                } else {
                    try {
                        val gson = Gson()
                        val type = object : TypeToken<ValidateCustomer>() {}.type
                        var errorResponse: ValidateCustomer? = gson.fromJson(response.errorBody()!!.charStream(), type)
                        Log.e("On Response Validate", errorResponse.toString())
                        liveAppUserResponse?.value = errorResponse
                    } catch (e: Exception) {
                    }


                }
            }
        })

        return liveAppUserResponse
    }
}