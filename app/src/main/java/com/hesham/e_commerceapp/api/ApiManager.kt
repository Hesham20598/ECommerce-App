package com.hesham.e_commerceapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://ecommerce.routemisr.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getServices(): EcommerceServices {
        return retrofit.create(EcommerceServices::class.java)
    }
}