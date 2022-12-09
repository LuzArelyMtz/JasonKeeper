package com.luz.codingchallenge.api.model


import com.google.gson.annotations.SerializedName

data class ResponseAPI(
    @SerializedName("items")
    val items: List<ItemAPI>
)