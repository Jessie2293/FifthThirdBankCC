package com.fifththirdbankcc.model


import com.google.gson.annotations.SerializedName

data class Contents(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("jokes")
    val jokes: List<Joke>
)