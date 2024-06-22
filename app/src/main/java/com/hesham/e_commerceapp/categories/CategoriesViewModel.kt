package com.hesham.e_commerceapp.categories

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hesham.domain.entity.category.CategoryItemDTO
import com.hesham.domain.entity.product.ProductItemDTO
import com.hesham.domain.entity.subCategory.SubCategoryItemDTO
import com.hesham.domain.useCases.GetAllCategoriesUseCase
import com.hesham.domain.useCases.GetAllProductOfCategoryUseCase
import com.hesham.domain.useCases.GetAllProductsOfSubCategoryUseCase
import com.hesham.domain.useCases.GetAllSubCategoriesOfCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getAllSubCategoriesOfCategoryUseCase: GetAllSubCategoriesOfCategoryUseCase,
    private val getAllProductOfCategoryUseCase: GetAllProductOfCategoryUseCase,
    private val getAllProductsOfSubCategoryUseCase: GetAllProductsOfSubCategoryUseCase
) :
    ViewModel() {
    val categoriesList = mutableStateListOf<CategoryItemDTO>()
    val subCategoriesList = mutableStateListOf<SubCategoryItemDTO>()
    val productsList = mutableStateListOf<ProductItemDTO>()
    var selectedNameState by mutableStateOf("")
    var selectedState = mutableIntStateOf(0)
    var selectedCategoryImage by mutableStateOf("")
    var currentCategoryPosition by mutableIntStateOf(0)
    var categoryId by mutableStateOf(if (categoriesList.isNotEmpty()) categoriesList[0].id else "")
    var subCategoryId by mutableStateOf(if (subCategoriesList.isNotEmpty()) subCategoriesList[0].id else "")


    fun getAllCategories() {
        viewModelScope.launch {
            try {
                val response = getAllCategoriesUseCase()
                categoriesList.clear()
                categoriesList.addAll(response)
                if (selectedCategoryImage == "") selectedCategoryImage =
                    categoriesList[0].image ?: ""
            } catch (e: Exception) {
                Log.e("Errors", "getAllCategories: ${e.message}")
            }
        }
    }

    fun getSubCategories(categoryId: String) {
        viewModelScope.launch {
            try {
                val response = getAllSubCategoriesOfCategoryUseCase(categoryId)
                subCategoriesList.clear()
                subCategoriesList.addAll(response)
            } catch (e: Exception) {
                Log.e("Errors", "getSubCategories: ${e.message}")
            }
        }
    }

    fun getAllProductsOfCategory(categoryId: String) {
        viewModelScope.launch {
            try {
                val response = getAllProductOfCategoryUseCase(categoryId)
                productsList.clear()
                productsList.addAll(response)
            } catch (e: Exception) {
                Log.e("Errors", "getAllProductsOfCategory: ${e.message}")
            }
        }
    }

    fun getAllProductsOfSubCategory(subCategoryId: String) {
        viewModelScope.launch {
            try {
                val response = getAllProductsOfSubCategoryUseCase(subCategoryId)
                productsList.clear()
                productsList.addAll(response)
            } catch (e: Exception) {
                Log.e("Errors", "getAllProductsOfSubCategory: ${e.message}")
            }
        }
    }
}




