package com.android.bajajcapital.fragment

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.app.Activity
import android.content.Intent
import com.android.bajajcapital.R

import com.android.bajajcapital.activity.ReceiptActivity
import com.android.bajajcapital.http.AppConstant
import com.android.bajajcapital.http.AppUtilities
import com.android.rajshekhar.regitration_kotnil_do.ValidationUtil
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.fragment_agency.*
import org.jetbrains.anko.toast


class AgencyFragment : Fragment() {
    private var mainView: ConstraintLayout? = null
    private var btnDebitCard: Button? = null
    private lateinit var validationUtil: ValidationUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: View? = inflater!!.inflate(com.android.bajajcapital.R.layout.fragment_new, container, false)
        AppUtilities.hideKeyboard(requireActivity())

        activity!!.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or
                    WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        )

        activity!!.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )

       // initView(view)
        return view
    }


    private fun initView(view: View?) {
        mainView = view?.findViewById(com.android.bajajcapital.R.id.main_view_agency) as ConstraintLayout
        btnDebitCard = view?.findViewById(com.android.bajajcapital.R.id.pay_debit_card_agency) as Button
        validationUtil = ValidationUtil(requireActivity())
        mainView!!.setOnClickListener {
            // your code to perform when the user clicks on the button
            //Toast.makeText(context, "You clicked me.", Toast.LENGTH_SHORT).show()
            val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            // Hide the soft keyboard
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

        RxView.clicks(btnDebitCard!!)
            .subscribe {
                /* do something */

                if (AppUtilities.isNetworkAvailable(requireActivity())) {
                    validation()
                } else {
                    requireActivity().toast(AppConstant.NETWORK_MESSAGE)
                }

            }
    }

    //Validation
    private fun validation() {
        when {
            !validationUtil.isEmptyField(edit_agency!!, getString((R.string.hint_agency))) -> return
            !validationUtil.isEmptyField(edit_agent!!, getString((R.string.hint_agent))) -> return
            !validationUtil.isEmptyField(edit_code!!, getString((R.string.hint_agent_code))) -> return
            !validationUtil.isEmptyField(edit_amount_agency!!, getString((R.string.hint_amount))) -> return
        }
        val i = Intent(activity, ReceiptActivity::class.java)
        startActivity(i)
        (activity as Activity).overridePendingTransition(0, 0)

    }
}

