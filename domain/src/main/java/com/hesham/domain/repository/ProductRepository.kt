package com.hesham.domain.repository

import com.hesham.domain.entity.product.ProductItemDTO

interface ProductRepository {
    suspend fun getAllProductsOfCategory(categoryId: String): List<ProductItemDTO>
    suspend fun getAllProductsOfSubCategory(subCategoryId: String): List<ProductItemDTO>
}

interface ProductsOnlineDataSource {
    suspend fun fetchProductsOfCategory(categoryId: String): List<ProductItemDTO>
    suspend fun fetchProductsOfSubCategory(subCategoryId: String): List<ProductItemDTO>

}