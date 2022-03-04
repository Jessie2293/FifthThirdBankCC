package com.fifththirdbankcc.model


import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("background")
    val background: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("joke")
    val joke: JokeX,
    @SerializedName("language")
    val language: String
)