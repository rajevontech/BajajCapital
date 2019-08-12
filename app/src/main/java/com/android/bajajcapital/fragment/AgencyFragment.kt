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
import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher

import com.android.bajajcapital.activity.ReceiptActivity
import com.android.bajajcapital.http.AppConstant
import com.android.bajajcapital.http.AppUtilities
import com.android.rajshekhar.regitration_kotnil_do.ValidationUtil
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.fragment_agency.*
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.android.bajajcapital.R
import com.android.bajajcapital.bean.AgentResponse
import com.android.bajajcapital.bean.TokenResponse

import com.android.bajajcapital.viewModel.CommonViewModel

import okhttp3.MediaType
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import org.json.JSONObject


class AgencyFragment : Fragment() {
    private var mainView: ConstraintLayout? = null
    private var btnDebitCard: Button? = null
    private lateinit var validationUtil: ValidationUtil
    private var apiCheck = false
    private var accessToken = ""
    private var editAgentCode: EditText? = null
    private var crossBtnAgentCode: Button? = null

//    private var agentResponse: AgentResponse? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: View? = inflater!!.inflate(com.android.bajajcapital.R.layout.fragment_agency, container, false)

        initWindow()
        initView(view)
        return view
    }

    private fun initWindow() {
        AppUtilities.hideKeyboard(requireActivity())

        activity!!.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or
                    WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        )

        activity!!.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
    }


    private fun initView(view: View?) {
        mainView = view?.findViewById(com.android.bajajcapital.R.id.main_view_agency) as ConstraintLayout
        btnDebitCard = view?.findViewById(com.android.bajajcapital.R.id.pay_debit_card_agency) as Button
        validationUtil = ValidationUtil(requireActivity())
        editAgentCode = view?.findViewById(R.id.edit_code) as EditText
        editAgentCode?.addTextChangedListener(mTextEditorWatcherAgencyCode)

        crossBtnAgentCode = view?.findViewById(R.id.cross_agent_code_frame) as Button

        crossBtnAgentCode!!.setOnClickListener {
            edit_agency_name.setText("")
            AppUtilities.hideKeyboard(requireActivity())
            edit_amount_agency.setText("")
            edit_code.setText("")
        }


        mainView!!.setOnClickListener {
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

    private val mTextEditorWatcherAgencyCode = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun afterTextChanged(s: Editable) {
            val str = s.toString()

            if (str.length == 10) {
                if (AppUtilities.isNetworkAvailable(requireActivity())) {
                    if (!apiCheck) {
                        apiCheck = true
                        getToken()
                    }
                } else {
                    requireActivity().toast(AppConstant.NETWORK_MESSAGE)
                }

            } else {

            }
            if (str.isNotEmpty()) {
                crossBtnAgentCode!!.setVisibility(View.VISIBLE);

            } else {
                crossBtnAgentCode!!.setVisibility(View.GONE);

            }

        }
    }


    private fun getAgentCodeDetails() {
        val encryptedJason = JSONObject()
        // encryptedJason.put(AppConstant.AGENCY_CODE, "BFLOW4X005")
        encryptedJason.put(AppConstant.AGENCY_CODE, editAgentCode!!.editableText.toString().trim())

        //  rootObject.put(AppConstant.APPL_ID_NAME, editLan!!.editableText.toString().trim())

        val headers = HashMap<String, String>()
        headers[AppConstant.OCP_APIM_KEY_NAME] = AppConstant.OCP_APIM_KEY_VALUE
        headers[AppConstant.CONTENT_TYPE_NAME] = AppConstant.CONTENT_TYPE_VALUE
        headers[AppConstant.AUTH_NAME] = accessToken

        Log.e("encryptedJason--", encryptedJason.toString())


        val mAgencyViewModel = ViewModelProviders.of(requireActivity()).get(CommonViewModel::class.java)
        val requestBody: RequestBody =
            RequestBody.create(MediaType.parse("application/json"), encryptedJason.toString())
        val appAgentValidateDetails = mAgencyViewModel.getAgencyCodeDetails(headers, requestBody)
        appAgentValidateDetails?.observe(this, Observer<AgentResponse> { response ->

            AppUtilities.dismissProgress(requireActivity(), "Loading", false)


            if (response != null) {
                if (response?.errorDescription == AppConstant.SUCCESS) {
                    AppUtilities.hideKeyboard(requireActivity())
                    edit_agency_name.setText(response!!.agencyName)
                    edit_amount_agency.setText(response!!.amount)

                } else {
                    AppUtilities.hideKeyboard(requireActivity())
                    //AlertDialog
                    val dialogBuilder = AlertDialog.Builder(requireActivity())
                    // set message of alert dialog
                    dialogBuilder.setMessage(response.errorDescription)
                        // if the dialog is cancelable
                        .setCancelable(false)
                        .setNegativeButton(R.string.dialog_ok, DialogInterface.OnClickListener { dialog, id ->
                            dialog.dismiss()
                        })

                    // create dialog box
                    val alert = dialogBuilder.create()
                    // set title for alert dialog box
                    alert.setTitle(R.string.dialog_title)
                    alert.setIcon(R.drawable.appicon)

                    // show alert dialog
                    alert.show()
                    edit_agency_name.setText("")
                    edit_amount_agency.setText("")
                }
            }

        })
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun getToken() {

        AppUtilities.showProgress(requireActivity(), "Fetching customer details..", false)

        val mTokenViewModel = ViewModelProviders.of(requireActivity()).get(CommonViewModel::class.java)
        val appTokenDetails = mTokenViewModel.getTokenData(
            AppConstant.GRANT_TYPE,
            AppConstant.CLIENT_ID,
            AppConstant.CLIENT_SECRET,
            AppConstant.RESOURCE_URL
        )

        appTokenDetails?.observe(this, Observer<TokenResponse> { response ->

            apiCheck = false
            if (response != null) {
                Log.e("response", response.access_token)
                accessToken = response.access_token
                    getAgentCodeDetails()
            } else {
                AppUtilities.dismissProgress(requireActivity(), "Loading", false)
            }
        })
    }


    //Validation
    private fun validation() {
        when {
            !validationUtil.isEmptyField(edit_agency_name!!, getString((R.string.hint_agency))) -> return
            !validationUtil.isEmptyField(edit_agent!!, getString((R.string.hint_agent))) -> return
            !validationUtil.isEmptyField(edit_code!!, getString((R.string.hint_agent_code))) -> return
            !validationUtil.isEmptyField(edit_amount_agency!!, getString((R.string.hint_amount))) -> return
        }
        val i = Intent(activity, ReceiptActivity::class.java)
        startActivity(i)
        (activity as Activity).overridePendingTransition(0, 0)

    }
}

