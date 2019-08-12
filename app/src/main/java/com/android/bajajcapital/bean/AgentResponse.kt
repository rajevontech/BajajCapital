package com.android.bajajcapital.bean

import com.google.gson.annotations.SerializedName

data class AgentResponse (
    @SerializedName("errorCode")
    var errorCode: String ,

    @SerializedName("errorDescription")
    var errorDescription: String ,

    @SerializedName("agencyName")
    var agencyName: String ,

    @SerializedName("amount")
    var amount: String ,

    @SerializedName("agencyId")
    var agencyId: String

)
