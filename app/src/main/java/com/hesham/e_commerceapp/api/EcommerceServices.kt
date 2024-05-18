package com.hesham.e_commerceapp.api

import com.hesham.e_commerceapp.model.CategoryResponse
import retrofit2.http.GET

interface EcommerceServices {
    @GET("/api/v1/categories")
    suspend fun getCategories() : CategoryResponse

}