package com.luz.codingchallenge.Repository

import com.luz.codingchallenge.api.model.ResponseAPI

interface Repository {
    suspend fun getData(): ResponseAPI
}