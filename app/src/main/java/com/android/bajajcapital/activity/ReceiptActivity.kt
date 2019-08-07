package com.android.bajajcapital.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager


class ReceiptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.android.bajajcapital.R.layout.activity_recipt)
        initWindow()
        initViewReceipt()

    }

    private fun initViewReceipt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initWindow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}
