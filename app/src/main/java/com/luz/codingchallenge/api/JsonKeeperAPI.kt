package com.luz.codingchallenge.api

import com.luz.codingchallenge.api.model.ResponseAPI
import retrofit2.http.GET

interface JsonKeeperAPI {
    @GET("b/WN0G")
    suspend fun getResponse(): ResponseAPI
}