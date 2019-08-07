package com.android.bajajcapital.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'J6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\'J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0014\b\u0001\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\'\u00a8\u0006\u0018"}, d2 = {"Lcom/android/bajajcapital/http/ApiInterface;", "", "agentValidate", "Lretrofit2/Call;", "Lcom/android/bajajcapital/bean/AgentResponse;", "amount", "", "branch_code", "transaction_ref_no", "received_date", "source", "customername", "getToken", "Lcom/android/bajajcapital/bean/TokenResponse;", "grant_type", "client_id", "client_secret", "resource", "validateCustomer", "Lcom/android/bajajcapital/bean/ValidateCustomer;", "headers", "", "request", "Lokhttp3/RequestBody;", "app_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "CustomerValidation/LanId")
    public abstract retrofit2.Call<com.android.bajajcapital.bean.ValidateCustomer> validateCustomer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.HeaderMap()
    java.util.Map<java.lang.String, java.lang.String> headers, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody request);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "token")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Content-Type:application/x-www-form-urlencoded"})
    public abstract retrofit2.Call<com.android.bajajcapital.bean.TokenResponse> getToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "grant_type")
    java.lang.String grant_type, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "client_id")
    java.lang.String client_id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "client_secret")
    java.lang.String client_secret, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "resource")
    java.lang.String resource);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "AgentPaymentUpdate")
    public abstract retrofit2.Call<com.android.bajajcapital.bean.AgentResponse> agentValidate(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "amount")
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "branch_code")
    java.lang.String branch_code, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "transaction_ref_no")
    java.lang.String transaction_ref_no, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "received_date")
    java.lang.String received_date, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "source")
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "customername")
    java.lang.String customername);
}