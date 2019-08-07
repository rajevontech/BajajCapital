package com.android.bajajcapital.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ:\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\b2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0012j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/android/bajajcapital/viewModel/CommonViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "mService", "Lcom/android/bajajcapital/http/CommonServices;", "mServiceToken", "Lcom/android/bajajcapital/http/CommonServicesForToken;", "getTokenData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/android/bajajcapital/bean/TokenResponse;", "grant_type", "", "client_id", "client_secret", "resource", "getValidate", "Lcom/android/bajajcapital/bean/ValidateCustomer;", "header", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "request", "Lokhttp3/RequestBody;", "app_debug"})
public final class CommonViewModel extends android.arch.lifecycle.ViewModel {
    private final com.android.bajajcapital.http.CommonServices mService = null;
    private final com.android.bajajcapital.http.CommonServicesForToken mServiceToken = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.arch.lifecycle.MutableLiveData<com.android.bajajcapital.bean.ValidateCustomer> getValidate(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody request) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.arch.lifecycle.MutableLiveData<com.android.bajajcapital.bean.TokenResponse> getTokenData(@org.jetbrains.annotations.NotNull()
    java.lang.String grant_type, @org.jetbrains.annotations.NotNull()
    java.lang.String client_id, @org.jetbrains.annotations.NotNull()
    java.lang.String client_secret, @org.jetbrains.annotations.NotNull()
    java.lang.String resource) {
        return null;
    }
    
    public CommonViewModel() {
        super();
    }
}