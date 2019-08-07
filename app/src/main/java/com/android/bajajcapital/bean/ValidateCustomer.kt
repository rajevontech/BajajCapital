package com.android.bajajcapital.bean

import com.google.gson.annotations.SerializedName


data class ValidateCustomer(
    @SerializedName("checksum")

    var checksum: String ,
    @SerializedName("encryptedResponse")
    val encryptedResponse : String


 )