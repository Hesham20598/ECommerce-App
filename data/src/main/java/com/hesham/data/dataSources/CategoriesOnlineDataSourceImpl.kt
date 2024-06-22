package com.hesham.data.dataSources

import com.hesham.data.api.EcommerceServices
import com.hesham.data.model.category.CategoryItem
import com.hesham.domain.entity.category.CategoryItemDTO
import com.hesham.domain.repository.CategoriesOnlineDataSource

class CategoriesOnlineDataSourceImpl(
    private val service: EcommerceServices
) : CategoriesOnlineDataSource {
    override suspend fun fetchCategories(): List<CategoryItemDTO> {
        return try {
            service.getCategories().data?.map {
                it.toDTO()
            } ?: listOf()
        } catch (e: Exception) {
            throw e
        }
    }
}