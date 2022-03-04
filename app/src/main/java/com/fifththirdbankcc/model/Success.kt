package com.fifththirdbankcc.model


import com.google.gson.annotations.SerializedName

data class Success(
    @SerializedName("total")
    val total: Int
)