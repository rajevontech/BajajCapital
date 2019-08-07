package com.android.rajshekhar.regitration_kotnil_do

import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by rajshekhar on 9/7/19.
 */

 class ValidationUtil (private val context: Context) {



    fun isEmptyField(textInputEditText: EditText, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (value.isEmpty()) {
            //Snackbar.make(textInputEditText, message, Snackbar.LENGTH_LONG).show()
            textInputEditText.error = message
            textInputEditText.isFocusable = true
            hideKeyboardFrom(textInputEditText)



            return false
        }
        return true
    }

    /**
     * method to check InputEditText has valid email .
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     */
    fun isInputEditTextEmail(textInputEditText: EditText, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            Snackbar.make(textInputEditText, message, Snackbar.LENGTH_LONG).show()
            hideKeyboardFrom(textInputEditText)
            return false
        }
        return true
    }

    /**
     * method to check both InputEditText value matches.
     *
     * @param textInputEditText1
     * @param textInputEditText2
     * @param textInputLayout
     * @param message
     * @return
     */
    fun isLenghtMatch(textInputEditText: EditText, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (value.length < 6){
            Snackbar.make(textInputEditText, message, Snackbar.LENGTH_LONG).show()
            hideKeyboardFrom(textInputEditText)
            return false
        }
        return true
    }
    fun isPasswordMatches(textInputEditText1: EditText, textInputEditText2 : EditText, message: String): Boolean {
        val value1 = textInputEditText1.text.toString().trim()
        val value2 = textInputEditText2.text.toString().trim()
        if (!value1.contentEquals(value2)) {
            Snackbar.make(textInputEditText1, message, Snackbar.LENGTH_LONG).show()
            hideKeyboardFrom(textInputEditText2)
            return false
        }
        return true
    }

    /**
     * method to Hide keyboard
     *
     * @param view
     */
    private fun hideKeyboardFrom(view: View) {
        //val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //imm.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}