package com.android.bajajcapital.bean

import com.google.gson.annotations.SerializedName

data class ValidateCustomerResponse(

    @SerializedName("appl_id")
    var appl_id: String ,
    @SerializedName("cust_id")

    val cust_id: String,
    @SerializedName("branch_code")

    val branch_code: String,
    @SerializedName("product")

    val product: String,
    @SerializedName("status")

    val status: String,
    @SerializedName("single_emi")

    val single_emi: String,
    @SerializedName("inst_over")

    val inst_over: String,
    @SerializedName("penal_over")

    val penal_over: String,
    @SerializedName("tot_over")

    val tot_over: String,
    @SerializedName("pdcid")

    val pdcid: String,
    @SerializedName("flag")

    val flag: String,
    @SerializedName("case_clear_flag")

    val case_clear_flag: String,
    @SerializedName("delinquent_flag")

    val delinquent_flag: String,
    @SerializedName("case_status_flag")

    val case_status_flag: String,
    @SerializedName("cust_name")

    val cust_name: String,
    @SerializedName("bucket")

    val bucket: String,
    @SerializedName("bom_bucket")

    val bom_bucket: String,
    @SerializedName("emi_cycle_date")

    val emi_cycle_date: String,
    @SerializedName("late_fees")

    val late_fees: String,
    @SerializedName("bcc_due")
    val bcc_due: String,
    @SerializedName("other_charges")

    val other_charges: String,
    @SerializedName("product_desc")

    val product_desc: String,
    @SerializedName("cardNo")

    val cardNo: String,
    @SerializedName("minimumAmountDue")

    val minimumAmountDue: String,
    @SerializedName("totalOS")

    val totalOS: String,
    @SerializedName("customerLimit")

    val customerLimit: String,
    @SerializedName("reason")

    val reason: String,
    @SerializedName("transAllowed")

    val transAllowed: String,
    @SerializedName("errorCode")

    val errorCode: String,
    @SerializedName("errorDescription")

    val errorDescription: String,
    @SerializedName("entity_code")

    val entity_code: String

)