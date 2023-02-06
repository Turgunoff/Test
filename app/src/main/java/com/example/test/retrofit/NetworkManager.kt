package com.example.test.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private const val BASE_URL = "https://www.kattabozor.uz/hh/test/api/v1/" //offers

    var retrofit: Retrofit? = null
    var api: ApiService? = null

    fun getApiService(): ApiService {
        if (api == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit!!.create(ApiService::class.java)
        }
        return api!!
    }
}