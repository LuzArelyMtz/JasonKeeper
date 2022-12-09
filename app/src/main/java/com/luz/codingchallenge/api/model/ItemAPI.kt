package com.luz.codingchallenge.api.model

import com.google.gson.annotations.SerializedName

data class ItemAPI(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("img")
    val img: String?,
    @SerializedName("title", alternate =["Title"])
    val title: String?
)