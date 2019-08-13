package com.android.bajajcapital.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0003J\b\u0010\u0019\u001a\u00020\u0018H\u0003J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\b\u0010\u001d\u001a\u00020\u0018H\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0017J\b\u0010%\u001a\u00020\u0018H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/android/bajajcapital/fragment/BranchFragment;", "Landroid/support/v4/app/Fragment;", "()V", "accessToken", "", "amount", "apiCheck", "", "crossBtn", "Landroid/widget/Button;", "customerLimit", "customerName", "debitCardBtn", "editLan", "Landroid/widget/EditText;", "editTransaction", "mTextEditorWatcherLAN", "Landroid/text/TextWatcher;", "mTextEditorWatcherTransaction", "mainViewBranch", "Landroid/support/constraint/ConstraintLayout;", "validationUtil", "Lcom/android/rajshekhar/regitration_kotnil_do/ValidationUtil;", "doValidateCustomer", "", "getToken", "initView", "view", "Landroid/view/View;", "initWindow", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "validation", "app_debug"})
public final class BranchFragment extends android.support.v4.app.Fragment {
    private com.android.rajshekhar.regitration_kotnil_do.ValidationUtil validationUtil;
    private android.widget.Button debitCardBtn;
    private android.widget.Button crossBtn;
    private android.widget.EditText editLan;
    private android.widget.EditText editTransaction;
    private android.support.constraint.ConstraintLayout mainViewBranch;
    private java.lang.String accessToken;
    private java.lang.String customerName;
    private java.lang.String amount;
    private java.lang.String customerLimit;
    private boolean apiCheck;
    private final android.text.TextWatcher mTextEditorWatcherTransaction = null;
    private final android.text.TextWatcher mTextEditorWatcherLAN = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @android.support.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initWindow() {
    }
    
    @android.support.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void initView(android.view.View view) {
    }
    
    @android.support.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void validation() {
    }
    
    @android.support.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void doValidateCustomer() {
    }
    
    @android.support.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void getToken() {
    }
    
    public BranchFragment() {
        super();
    }
}