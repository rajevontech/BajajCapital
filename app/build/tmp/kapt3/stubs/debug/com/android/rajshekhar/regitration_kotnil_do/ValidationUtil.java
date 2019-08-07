package com.android.rajshekhar.regitration_kotnil_do;

import java.lang.System;

/**
 * * Created by rajshekhar on 9/7/19.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/android/rajshekhar/regitration_kotnil_do/ValidationUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hideKeyboardFrom", "", "view", "Landroid/view/View;", "isEmptyField", "", "textInputEditText", "Landroid/widget/EditText;", "message", "", "isInputEditTextEmail", "isLenghtMatch", "isPasswordMatches", "textInputEditText1", "textInputEditText2", "app_debug"})
public final class ValidationUtil {
    private final android.content.Context context = null;
    
    public final boolean isEmptyField(@org.jetbrains.annotations.NotNull()
    android.widget.EditText textInputEditText, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return false;
    }
    
    /**
     * * method to check InputEditText has valid email .
     *     *
     *     * @param textInputEditText
     *     * @param textInputLayout
     *     * @param message
     *     * @return
     */
    public final boolean isInputEditTextEmail(@org.jetbrains.annotations.NotNull()
    android.widget.EditText textInputEditText, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return false;
    }
    
    /**
     * * method to check both InputEditText value matches.
     *     *
     *     * @param textInputEditText1
     *     * @param textInputEditText2
     *     * @param textInputLayout
     *     * @param message
     *     * @return
     */
    public final boolean isLenghtMatch(@org.jetbrains.annotations.NotNull()
    android.widget.EditText textInputEditText, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return false;
    }
    
    public final boolean isPasswordMatches(@org.jetbrains.annotations.NotNull()
    android.widget.EditText textInputEditText1, @org.jetbrains.annotations.NotNull()
    android.widget.EditText textInputEditText2, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return false;
    }
    
    /**
     * * method to Hide keyboard
     *     *
     *     * @param view
     */
    private final void hideKeyboardFrom(android.view.View view) {
    }
    
    public ValidationUtil(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}