package com.hesham.domain.repository

import com.hesham.domain.entity.category.CategoryItemDTO

interface CategoriesRepository {
    suspend fun getCategories(): List<CategoryItemDTO>
}

interface CategoriesOnlineDataSource {
    suspend fun fetchCategories(): List<CategoryItemDTO>
}