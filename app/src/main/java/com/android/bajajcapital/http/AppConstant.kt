package com.android.bajajcapital.http


object AppConstant {

    // API URL
    const val BASE_URL = "https://bfl-api-dev.azure-api.net/PaymentServiceV1WrapperWS/"
    const val URL_TOKEN = "https://login.microsoftonline.com/bajajfinance.in/oauth2/"
    const val URL_AGENCY_CODE = "https://bfl-api-dev.azure-api.net/DealerLoginWS/"


    // CLIENT CREDENTIALS
    const val GRANT_TYPE = "client_credentials"
    const val CLIENT_ID = "268e07f4-5002-4386-be0c-98a0e3f01332"
    const val CLIENT_SECRET = "7CP4S-eGV_/OK:oScPUzkJAn9yCYCZo9"
    const val RESOURCE_URL = "https://management.azure.com/"

    // ALGORITHM TYPE FOR ENCRYPTION AND DECRYPTION
    const val MD = "MD5"
    const val HASH_TEXT = "%032x"
    const val UTF_8 = "UTF-8"
    const val AES = "AES"
    const val AES_PENDING = "AES/CBC/PKCS5Padding"

    // NETWORK TAGS
    const val NETWORK_MESSAGE = "Check your internet connection"
    const val FAILURE_MESSAGE = "FAILURE"
    const val CONNECTION_ERROR = "Connection Error"
    const val SUCCESS = "SUCCESS"


    // API TAGS
    const val LAN_ID = "4020CD33583615"  //working
    //  const val LAN_ID="4050CD31245722"  //not working
    const val APPL_ID_NAME = "appl_id"
    const val OCP_APIM_KEY_NAME = "Ocp-Apim-Subscription-Key"
    const val CONTENT_TYPE_NAME = "Content-Type"
    const val AUTH_NAME = "Authorization"
    const val CHECK_SUM_NAME = "checksum"
    const val OCP_APIM_KEY_VALUE = "82768aa2d52943f6a5183863f1778354"
    const val CONTENT_TYPE_VALUE = "application/json"
    const val ENCRYPTED_REQUEST = "encrptedRequest"
    const val AGENCY_CODE = "agencyCode"
    const val SECRET_KEY = "ynvR7iKThNmkGp3g"


}