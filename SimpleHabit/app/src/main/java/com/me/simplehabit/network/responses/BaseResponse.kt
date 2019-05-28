package com.me.simplehabit.network.responses

import com.google.gson.annotations.SerializedName

abstract class BaseResponse {

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message: String? = null

    @SerializedName("apiVersion")
    var apiVersion: String? = null

    val isResponseSuccess: Boolean
        get() = code == 200
}
