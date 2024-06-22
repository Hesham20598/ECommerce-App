package com.hesham.data.repository

import com.hesham.domain.entity.category.CategoryItemDTO
import com.hesham.domain.repository.CategoriesOnlineDataSource
import com.hesham.domain.repository.CategoriesRepository
import com.hesham.domain.repository.NetworkHandler
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val onlineDataSource: CategoriesOnlineDataSource,
    private val networkHandler: NetworkHandler
) : CategoriesRepository {
    override suspend fun getCategories(): List<CategoryItemDTO> {
        if (networkHandler.isOnline()) {
            val categoriesList = onlineDataSource.fetchCategories()
            return categoriesList
        } else return listOf()
    }
}