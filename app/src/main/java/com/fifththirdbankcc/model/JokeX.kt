package com.fifththirdbankcc.model


import com.google.gson.annotations.SerializedName

data class JokeX(
    @SerializedName("clean")
    val clean: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("length")
    val length: String,
    @SerializedName("racial")
    val racial: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String
)