package com.android.bajajcapital.bean

import com.google.gson.annotations.SerializedName

data class AgentResponse (
    @SerializedName("appl_id")
    var appl_id: String ,
    @SerializedName("errorCode")
    var errorCode: String ,
    @SerializedName("errorDescription")
    var errorDescription: String
)
