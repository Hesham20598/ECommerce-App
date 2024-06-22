package com.hesham.data.repository

import com.hesham.domain.entity.product.ProductItemDTO
import com.hesham.domain.repository.NetworkHandler
import com.hesham.domain.repository.ProductRepository
import com.hesham.domain.repository.ProductsOnlineDataSource
import javax.inject.Inject

class ProductsRepositoryImpl@Inject constructor(
    private val onlineDataSource: ProductsOnlineDataSource,
    private val networkHandler: NetworkHandler
) : ProductRepository {
    override suspend fun getAllProductsOfCategory(categoryId: String): List<ProductItemDTO> {
        if (networkHandler.isOnline()) {
            val productsList = onlineDataSource.fetchProductsOfCategory(categoryId)
            return productsList
        } else return listOf()
    }

    override suspend fun getAllProductsOfSubCategory(subCategoryId: String): List<ProductItemDTO> {
        if (networkHandler.isOnline()) {
            val productsList = onlineDataSource.fetchProductsOfSubCategory(subCategoryId)
            return productsList

        } else return listOf()
    }
}