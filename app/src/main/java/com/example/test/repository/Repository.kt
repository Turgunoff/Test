package com.example.test.repository

import androidx.lifecycle.MutableLiveData
import com.example.test.model.BaseResponse
import com.example.test.model.Data
import com.example.test.model.Offer
import com.example.test.retrofit.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getList(error: MutableLiveData<String>, success: MutableLiveData<List<Offer>>) {
        NetworkManager.getApiService().getList()
            .enqueue(object : Callback<BaseResponse<List<Offer>>> {
                override fun onResponse(
                    call: Call<BaseResponse<List<Offer>>>,
                    response: Response<BaseResponse<List<Offer>>>
                ) {
                    if (response.isSuccessful) {
                        success.value = response.body()!!.offers
                    } else {
                        error.value = response.body().toString()
                    }
                }

                override fun onFailure(call: Call<BaseResponse<List<Offer>>>, t: Throwable) {
                    error.value = t.localizedMessage
                }
            })
    }
}