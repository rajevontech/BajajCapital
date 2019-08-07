package com.android.bajajcapital.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\r"}, d2 = {"Lcom/android/bajajcapital/http/CommonServices;", "", "()V", "getAppUser", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/android/bajajcapital/bean/ValidateCustomer;", "header", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "request", "Lokhttp3/RequestBody;", "Factory", "app_debug"})
public final class CommonServices {
    private static com.google.gson.Gson gson;
    public static final com.android.bajajcapital.http.CommonServices.Factory Factory = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.arch.lifecycle.MutableLiveData<com.android.bajajcapital.bean.ValidateCustomer> getAppUser(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody request) {
        return null;
    }
    
    public CommonServices() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/android/bajajcapital/http/CommonServices$Factory;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "create", "Lcom/android/bajajcapital/http/ApiInterface;", "app_debug"})
    public static final class Factory {
        
        public final com.google.gson.Gson getGson() {
            return null;
        }
        
        public final void setGson(com.google.gson.Gson p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.android.bajajcapital.http.ApiInterface create() {
            return null;
        }
        
        private Factory() {
            super();
        }
    }
}