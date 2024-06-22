package com.hesham.data.dataSources

import com.hesham.data.api.EcommerceServices
import com.hesham.domain.entity.product.ProductItemDTO
import com.hesham.domain.repository.ProductsOnlineDataSource

class ProductsOnlineDataSourceImpl(private val services: EcommerceServices) :
    ProductsOnlineDataSource {

    override suspend fun fetchProductsOfCategory(categoryId: String): List<ProductItemDTO> {
        return try {

            services.getAllProductsOfCategory(categoryId = categoryId).data?.map {
                it.toDTO()
            } ?: listOf()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchProductsOfSubCategory(subCategoryId: String): List<ProductItemDTO> {
        return try {
            services.getAllProductsOfCategory(subCategoryId = subCategoryId).data?.map {
                it.toDTO()
            } ?: listOf()
        } catch (e: Exception) {
            throw e
        }
    }
}