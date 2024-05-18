package com.hesham.e_commerceapp.categories

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.hesham.e_commerceapp.api.ApiManager
import com.hesham.e_commerceapp.model.CategoryItem

class CategoriesViewModel : ViewModel() {
    val categoriesList = mutableStateListOf<CategoryItem>()

    suspend fun getAllCategories() {
        val response = ApiManager.getServices().getCategories()
        val list: Collection<CategoryItem> = response.data ?: emptyList()
        categoriesList.addAll(list)
    }


}