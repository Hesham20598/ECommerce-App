package com.hesham.data.repository

import com.hesham.domain.entity.subCategory.SubCategoryItemDTO
import com.hesham.domain.repository.NetworkHandler
import com.hesham.domain.repository.SubCategoryOnlineDataSource
import com.hesham.domain.repository.SubCategoryRepository
import javax.inject.Inject

class SubCategoryRepositoryImpl @Inject constructor(
    private val onlineDataSource: SubCategoryOnlineDataSource,
    private val networkHandler: NetworkHandler
) :
    SubCategoryRepository {
    override suspend fun getSupCategories(categoryId: String): List<SubCategoryItemDTO> {
        if (networkHandler.isOnline()) {
            val subCategoriesList = onlineDataSource.fetchSupCategories(categoryId)
            return subCategoriesList
        } else return listOf()
    }
}