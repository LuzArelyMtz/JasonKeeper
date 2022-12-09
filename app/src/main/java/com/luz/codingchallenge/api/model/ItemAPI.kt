package com.luz.codingchallenge.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemAPI(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("img")
    val img: String?,
    @SerializedName("title", alternate =["Title"])
    val title: String?
): Parcelable