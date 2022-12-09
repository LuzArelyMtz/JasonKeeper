package com.luz.codingchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luz.codingchallenge.Repository.Repository
import com.luz.codingchallenge.Repository.RepositoryImpl
import com.luz.codingchallenge.api.JsonKeeperAPIImpl
import com.luz.codingchallenge.api.model.ResponseAPI
import kotlinx.coroutines.launch

class JsonKeeperVM: ViewModel() {

    val api = JsonKeeperAPIImpl
    val repository: Repository = RepositoryImpl(api)

    private val _response = MutableLiveData<ResponseAPI>()
    val response : LiveData<ResponseAPI> =_response

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage  : LiveData<String> =_errorMessage

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar   : LiveData<Boolean> =_progressBar

    fun fetchData(){
        viewModelScope.launch{
            _progressBar.value = true
            _response.value=repository.getData()
        }
        _progressBar.value = false
    }
}