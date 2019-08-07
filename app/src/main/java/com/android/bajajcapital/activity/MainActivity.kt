package com.android.bajajcapital.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.android.bajajcapital.fragment.AgencyFragment
import com.android.bajajcapital.fragment.BranchFragment
import com.android.bajajcapital.R
import com.android.bajajcapital.http.AppUtilities




class MainActivity : AppCompatActivity() {
    private var tabLayout: TabLayout? = null
    private var frameLayout: FrameLayout? = null
    private var fragment: Fragment? = null
    private var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null
    private var relative: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.android.bajajcapital.R.layout.activity_main)
        initWindow()
        initViewMain()

    }

   // Main view function
    private fun initWindow() {
        AppUtilities.hideKeyboard(this)
        this.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()
    }

   //Main view
    private fun initViewMain() {
        tabLayout = findViewById(R.id.tab_layout)
        frameLayout = findViewById(R.id.frame_layout)
        relative = findViewById(R.id.relative)

        fragment = AgencyFragment()
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.frame_layout, fragment!!)
        fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction!!.commit()


        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                when (tab.position) {

                    0 -> fragment = AgencyFragment()
                    1 -> fragment = BranchFragment()

                }

                AppUtilities.hideKeyboard(this@MainActivity)
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(com.android.bajajcapital.R.id.frame_layout, fragment!!)
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}


