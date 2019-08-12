package com.android.bajajcapital.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.bajajcapital.bean.AgentResponse
import com.android.bajajcapital.bean.TokenResponse
import com.android.bajajcapital.bean.ValidateCustomer
import com.android.bajajcapital.http.CommonServiceAgencyCode
import com.android.bajajcapital.http.CommonServices
import com.android.bajajcapital.http.CommonServicesForToken
import okhttp3.RequestBody

class CommonViewModel :ViewModel() {

    private val mService  =  CommonServices()
    private val mServiceToken=CommonServicesForToken()
    private val mServiceAgentCode=CommonServiceAgencyCode()

    //LAN input API
    fun getValidate(header: HashMap<String, String>, request: RequestBody):MutableLiveData<ValidateCustomer>?{
        return mService.getAppUser(header,request)
    }
    fun getAgentData(header: HashMap<String, String>, request: RequestBody) :MutableLiveData<ValidateCustomer>?{
        return mService.getAgentDetails(header,request)
    }

      //Agency Input API
    fun getAgencyCodeDetails(header: HashMap<String, String>, request: RequestBody) :MutableLiveData<AgentResponse>?{
        return mServiceAgentCode.getAgencyCodeDetails(header,request)
    }

     //Token get
    fun getTokenData(grant_type : String,client_id:String,client_secret:String,resource:String) : MutableLiveData<TokenResponse>? {
        return mServiceToken.loadTokenData(grant_type,client_id,client_secret,resource)
    }

}