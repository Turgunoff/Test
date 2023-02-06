package com.example.test.retrofit

import com.example.test.model.BaseResponse
import com.example.test.model.Data
import com.example.test.model.Offer
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("offers")
    fun getList(): Call<BaseResponse<List<Offer>>>

}