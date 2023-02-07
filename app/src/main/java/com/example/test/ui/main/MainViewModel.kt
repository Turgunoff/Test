package com.example.test.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.model.BaseResponse
import com.example.test.model.Data
import com.example.test.model.Offer
import com.example.test.repository.Repository


class MainViewModel : ViewModel() {
    private val repository = Repository()

    val error = MutableLiveData<String>()

    val listData = MutableLiveData<List<Offer>>()

    fun getList() {
        repository.getList(error, listData)
    }
}