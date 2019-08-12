package com.android.bajajcapital.fragment

import android.app.Activity
import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.rajshekhar.regitration_kotnil_do.ValidationUtil
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.android.bajajcapital.R
import com.android.bajajcapital.activity.ReceiptActivity
import com.android.bajajcapital.bean.*
import com.android.bajajcapital.http.AppConstant
import com.android.bajajcapital.http.AppUtilities
import com.android.bajajcapital.viewModel.CommonViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.fragment_branch.*
import okhttp3.MediaType
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import org.json.JSONObject


class BranchFragment : Fragment() {

    private lateinit var validationUtil: ValidationUtil
    private var debitCardBtn: Button? = null
    private var crossBtn: Button? = null

    private var editLan: EditText? = null
    private var editTransaction: EditText? = null
    private var mainViewBranch: ConstraintLayout? = null
    private var accessToken = ""
    private var customerName = ""
    private var amount = "0"
    private var apiCheck = false

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater!!.inflate(R.layout.fragment_branch, container, false)
        validationUtil = ValidationUtil(requireActivity())

        initWindow()
        initView(view)

        return view
    }

    // Main View function
    private fun initWindow() {
        AppUtilities.hideKeyboard(requireActivity())

        activity!!.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or
                    WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        )
    }

    //Branch view
    @RequiresApi(Build.VERSION_CODES.O)
    private fun initView(view: View?) {
        debitCardBtn = view?.findViewById(R.id.pay_debit_card_branch) as Button
        mainViewBranch = view?.findViewById(R.id.main_view_branch) as ConstraintLayout
        editLan = view?.findViewById(R.id.edit_lan_num) as EditText
        editTransaction = view?.findViewById(R.id.edit_transaction_branch) as EditText
        editLan?.addTextChangedListener(mTextEditorWatcherLAN)

        editTransaction?.addTextChangedListener(mTextEditorWatcherTransaction)
        crossBtn = view?.findViewById(R.id.button_cross_frame) as Button

        crossBtn!!.setOnClickListener {
            edit_lan_num.setText("")
            AppUtilities.hideKeyboard(requireActivity())
            edit_customer_name.setText("")
            editTransaction?.setText("")

        }

        // Hide the soft keyboard
        mainViewBranch!!.setOnClickListener {
            val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

        //Click Button Debit card
        RxView.clicks(debitCardBtn!!)
            .subscribe {
                /* do something */
                if (AppUtilities.isNetworkAvailable(requireActivity())) {
//                    validation()
                } else {
                    requireActivity().toast(AppConstant.NETWORK_MESSAGE)
                }

            }

    }

    private val mTextEditorWatcherTransaction = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {


        }
        override fun afterTextChanged(s: Editable) {
            try {
                val strEnteredVal = s.toString()

                if (strEnteredVal != "") {
                    Log.e("Amount++---", amount)
                    if (amount == "null" || amount.isEmpty()) {
                        amount = "0"
                    }
                    val amountDouble = amount.toDouble()

                    System.out.println(amountDouble)

                    Log.e("Amount***---", amountDouble.toString())


                    var inputNum = strEnteredVal.toDouble()
                    Log.e("num***---", inputNum.toString())
                    if (inputNum > 200000) {
                        editTransaction!!.error = getString(R.string.amount_not_exceeds)
                        editTransaction!!.requestFocus()
                    } else if (amountDouble >= 200000) {
                        editTransaction!!.error = getString(R.string.amount_not_exceeds)
                        editTransaction!!.requestFocus()
                    } else if (amountDouble > 0 && inputNum > amountDouble) {
                        editTransaction!!.error = getString(R.string.enter_amount)
                        editTransaction!!.requestFocus()
                    } else {
                        editTransaction!!.error = null
                    }


                }
            } catch (e: Exception) {
            }
        }

    }


    private val mTextEditorWatcherLAN = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            // edit_customer_name.setText(customerName)
        }

        override fun afterTextChanged(s: Editable) {
            val str = s.toString()

            if (str.length == 14) {

                if (AppUtilities.isNetworkAvailable(requireActivity())) {
                    if (!apiCheck) {
                        apiCheck = true
                        getToken()
                    }
                } else {
                    requireActivity().toast(AppConstant.NETWORK_MESSAGE)
                }

            } else {
                //  Toast.makeText(context, " Match.", Toast.LENGTH_SHORT).show()


            }

            if (str.isNotEmpty()) {
                crossBtn!!.setVisibility(View.VISIBLE);
            } else {
                crossBtn!!.setVisibility(View.GONE);

            }

        }
    }

    //Submit details Validation
    @RequiresApi(Build.VERSION_CODES.O)
    private fun validation() {
        when {
            !validationUtil.isEmptyField(edit_lan_num!!, getString((R.string.hint_lane))) -> return
            !validationUtil.isEmptyField(edit_transaction_branch!!, getString((R.string.hint_amount))) -> return

            else -> getToken()
        }

        val i = Intent(activity, ReceiptActivity::class.java)
        startActivity(i)
        (activity as Activity).overridePendingTransition(0, 0)

    }

    //LAN API
    @RequiresApi(Build.VERSION_CODES.O)
    private fun doValidateCustomer() {
        val rootObject = JSONObject()
        // rootObject.put(AppConstant.APPL_ID_NAME, AppConstant.LAN_ID)  //require
        rootObject.put(AppConstant.APPL_ID_NAME, editLan!!.editableText.toString().trim())
        val encrypted = AppUtilities.encrypt(rootObject.toString())
        val encryptedJason = JSONObject()
        encryptedJason.put(AppConstant.ENCRYPTED_REQUEST, encrypted)
        val checksum = AppUtilities.getChecksumValue(encrypted + AppConstant.SECRET_KEY)

        val headers = HashMap<String, String>()
        headers[AppConstant.OCP_APIM_KEY_NAME] = AppConstant.OCP_APIM_KEY_VALUE
        headers[AppConstant.CONTENT_TYPE_NAME] = AppConstant.CONTENT_TYPE_VALUE
        headers[AppConstant.AUTH_NAME] = accessToken
        headers[AppConstant.CHECK_SUM_NAME] = checksum.toString()


        Log.e("decrypt--", rootObject.toString())
        // Log.e("header--", headers.toString())
        Log.e("encryptedJason--", encryptedJason.toString())

        val mSignViewModel = ViewModelProviders.of(requireActivity()).get(CommonViewModel::class.java)
        val requestBody: RequestBody =
            RequestBody.create(MediaType.parse("application/json"), encryptedJason.toString())
        val appValidateDetails = mSignViewModel.getValidate(headers, requestBody)

        appValidateDetails?.observe(this, Observer<ValidateCustomer> { response ->
            AppUtilities.dismissProgress(requireActivity(), "Loading", false)
            if (response != null) {
                Log.e("Validate---", response!!.encryptedResponse)

                if (response != null) {
                    edit_customer_name.setText("")
                    edit_transaction_branch.setText("")


                    val decrypted = AppUtilities.decrypt(response!!.encryptedResponse)
                    val gson = Gson()
                    val type = object : TypeToken<ValidateCustomerResponse>() {}.type
                    var dataGet: ValidateCustomerResponse? = gson.fromJson(decrypted, type)

                    customerName = dataGet?.cust_name.toString()
                    amount = dataGet?.tot_over.toString()

                    amount = dataGet?.tot_over.toString()
                    Log.e("Amount----", amount)


                    Log.e("On Response $$++%", dataGet.toString())

                    if (!(dataGet?.status == AppConstant.SUCCESS)) {
                        AppUtilities.hideKeyboard(requireActivity())

                        //AlertDialog
                        val dialogBuilder = AlertDialog.Builder(requireActivity())
                        // set message of alert dialog
                        dialogBuilder.setMessage(dataGet?.errorDescription)
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

                        edit_customer_name.setText("")
                        edit_transaction_branch.setText("")


                    } else {

                        AppUtilities.hideKeyboard(requireActivity())


                        Log.e("CustomerName%", customerName)
                        Log.e("Amount%", amount)

                        edit_customer_name.setText(customerName)
                        edit_transaction_branch.setText(amount)


                    }

                }
            }

        })
    }

    //Token API
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
                doValidateCustomer()
            } else {
                AppUtilities.dismissProgress(requireActivity(), "Loading", false)
            }
        })
    }
}

