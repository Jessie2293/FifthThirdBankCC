package com.fifththirdbankcc.model


import com.google.gson.annotations.SerializedName

data class DailyJoke(
    @SerializedName("contents")
    val contents: Contents,
    @SerializedName("success")
    val success: Success
)