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

    private var _livedata = MutableLiveData<ResponseAPI>()
    val livedata : LiveData<ResponseAPI> =_livedata

    fun fetchData(){
        viewModelScope.launch{
            _livedata.value=repository.getData()
        }
    }

}