package com.luz.codingchallenge.Repository

import com.luz.codingchallenge.api.JsonKeeperAPI
import com.luz.codingchallenge.api.JsonKeeperAPIImpl
import com.luz.codingchallenge.api.model.ResponseAPI

class RepositoryImpl(val api: JsonKeeperAPIImpl): Repository {
    override suspend fun getData(): ResponseAPI {
        return api.provideRetrofit().create(JsonKeeperAPI::class.java).getResponse()
    }
}