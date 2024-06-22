package com.hesham.domain.repository

import com.hesham.domain.entity.subCategory.SubCategoryItemDTO

interface SubCategoryRepository {

    suspend fun getSupCategories(categoryId: String): List<SubCategoryItemDTO>


}

interface SubCategoryOnlineDataSource{
    suspend fun fetchSupCategories(categoryId: String): List<SubCategoryItemDTO>
}