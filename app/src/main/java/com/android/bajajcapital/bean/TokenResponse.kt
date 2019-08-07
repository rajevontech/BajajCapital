package com.android.bajajcapital.bean

data class TokenResponse(
    val token_type : String,
    val expires_in :String,
    val ext_expires_in:String,
    val expires_on:String,
    val not_before:String,
    val resource:String,
    val access_token:String


    )