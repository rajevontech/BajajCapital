package com.android.bajajcapital.http

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.app.FragmentActivity
import android.view.inputmethod.InputMethodManager
import org.apache.commons.codec.binary.Base64
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


object AppUtilities {
    var SHARED_VECTOR = "1234567887654321".toByteArray()
    private var progressDialog: ProgressDialog? = null


    /**
     * @Module Name/Class		:	isNetworkAvailable
     * @Author Name             :   RajShekhar
     * @Date                    :   18/07/2019
     * @Purpose                 :	method to get network connection availability
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }

    @Throws(Exception::class)
    fun encrypt(jsonText: String): String {

        val textBytes = jsonText.toByteArray(charset(AppConstant.UTF_8))
        val ivSpec = IvParameterSpec(SHARED_VECTOR)
        val newKey = SecretKeySpec(AppConstant.SECRET_KEY.toByteArray(Charsets.UTF_8), AppConstant.AES)
        var cipher: Cipher? = null
        cipher = Cipher.getInstance(AppConstant.AES_PENDING)
        cipher!!.init(Cipher.ENCRYPT_MODE, newKey, ivSpec)

        val encodedString = String(Base64.encodeBase64(cipher!!.doFinal(textBytes)))
        return encodedString.replace('+', '-').replace('/', '_')


    }

    fun getChecksumValue(jsonEncAndSecKey: String): String? {
        val md: MessageDigest
        var hashText: String? = null
        try {
            md = MessageDigest.getInstance(AppConstant.MD)
            md.reset()
            md.update(jsonEncAndSecKey.toByteArray())
            hashText = String.format(AppConstant.HASH_TEXT, *arrayOf<Any>(BigInteger(1, md.digest())))
        } catch (e: NoSuchAlgorithmException) {
            System.out.println("Exception: : " + e.toString())
        }

        return hashText
    }


    fun hideKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Check if no view has focus
        val currentFocusedView = activity.currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(
                currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    fun showProgress(context: Context, message: String, isCancellable: Boolean) {

        try {
            progressDialog = ProgressDialog(context)
            progressDialog!!.setTitle("")
            progressDialog!!.setIndeterminate(false)
            progressDialog!!.setMessage(message)
            progressDialog!!.setCancelable(isCancellable)
            progressDialog!!.show()
        } catch (e: Exception) {

        }

    }

    fun dismissProgress(requireActivity: FragmentActivity, s: String, b: Boolean) {
        try {
            if (progressDialog != null && progressDialog!!.isShowing()) {
                progressDialog!!.dismiss()
                progressDialog = null
            }
        } catch (e: Exception) {

        }

    }

    @Throws(Exception::class)
    fun decrypt(jsonText: String): String {
        val textBytes = android.util.Base64.decode(jsonText, android.util.Base64.DEFAULT)

        val ivSpec = IvParameterSpec(SHARED_VECTOR)
        val newKey = SecretKeySpec(AppConstant.SECRET_KEY.toByteArray(Charsets.UTF_8), AppConstant.AES)
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec)
        return String(cipher.doFinal(textBytes), Charsets.UTF_8)   }
}