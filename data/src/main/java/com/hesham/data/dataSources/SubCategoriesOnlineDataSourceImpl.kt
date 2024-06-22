package com.hesham.data.dataSources

import com.hesham.data.api.EcommerceServices
import com.hesham.domain.entity.subCategory.SubCategoryItemDTO
import com.hesham.domain.repository.SubCategoryOnlineDataSource

class SubCategoriesOnlineDataSourceImpl(private val service: EcommerceServices) :
    SubCategoryOnlineDataSource {
    override suspend fun fetchSupCategories(categoryId: String): List<SubCategoryItemDTO> {
        return try {
            service.getSubCategories(categoryId).data?.map {
                it.toDTO()
            } ?: listOf()

        } catch (e: Exception) {
            throw e
        }
    }
}