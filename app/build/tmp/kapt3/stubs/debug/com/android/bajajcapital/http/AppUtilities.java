package com.android.bajajcapital.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/android/bajajcapital/http/AppUtilities;", "", "()V", "SHARED_VECTOR", "", "getSHARED_VECTOR", "()[B", "setSHARED_VECTOR", "([B)V", "progressDialog", "Landroid/app/ProgressDialog;", "decrypt", "", "jsonText", "dismissProgress", "", "requireActivity", "Landroid/support/v4/app/FragmentActivity;", "s", "b", "", "encrypt", "getChecksumValue", "jsonEncAndSecKey", "hideKeyboard", "activity", "Landroid/app/Activity;", "isNetworkAvailable", "context", "Landroid/content/Context;", "showProgress", "message", "isCancellable", "app_debug"})
public final class AppUtilities {
    @org.jetbrains.annotations.NotNull()
    private static byte[] SHARED_VECTOR;
    private static android.app.ProgressDialog progressDialog;
    public static final com.android.bajajcapital.http.AppUtilities INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getSHARED_VECTOR() {
        return null;
    }
    
    public final void setSHARED_VECTOR(@org.jetbrains.annotations.NotNull()
    byte[] p0) {
    }
    
    /**
     * * @Module Name/Class		:	isNetworkAvailable
     *     * @Author Name             :   RajShekhar
     *     * @Date                    :   18/07/2019
     *     * @Purpose                 :	method to get network connection availability
     */
    public final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String encrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String jsonText) throws java.lang.Exception {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChecksumValue(@org.jetbrains.annotations.NotNull()
    java.lang.String jsonEncAndSecKey) {
        return null;
    }
    
    public final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void showProgress(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message, boolean isCancellable) {
    }
    
    public final void dismissProgress(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.FragmentActivity requireActivity, @org.jetbrains.annotations.NotNull()
    java.lang.String s, boolean b) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String decrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String jsonText) throws java.lang.Exception {
        return null;
    }
    
    private AppUtilities() {
        super();
    }
}