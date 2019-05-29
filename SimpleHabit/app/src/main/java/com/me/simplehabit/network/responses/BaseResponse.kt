package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName

abstract class BaseResponse {

    @SerializedName("code")
    val code: Int = 0

    @SerializedName("message")
    val message: String? = null

    @SerializedName("apiVersion")
    val apiVersion: String? = null

    val isResponseSuccess: Boolean
        get() = code == 200
}
