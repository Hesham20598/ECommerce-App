package com.hesham.data.api

import com.hesham.data.model.category.CategoryResponse
import com.hesham.data.model.product.ProductResponse
import com.hesham.data.model.subCategory.SubCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EcommerceServices {
    @GET("/api/v1/categories")
    suspend fun getCategories(): CategoryResponse

    @GET("/api/v1/categories/{categoryId}/subcategories")
    suspend fun getSubCategories(
        @Path("categoryId") categoryId: String
    ): SubCategoryResponse


    @GET("/api/v1/products")
    suspend fun getAllProductsOfCategory(
        @Query("category[in]") categoryId: String? = null,
        @Query("subcategory[in]") subCategoryId: String? = null,
    ): ProductResponse
}