package com.cleanarchitecture.creativetask.data.remote.modeldto


import com.google.gson.annotations.SerializedName

data class ErrorMessage(

    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("status_message")
    val statusMessage: String
)
