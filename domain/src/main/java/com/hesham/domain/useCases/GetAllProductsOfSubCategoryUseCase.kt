package com.hesham.domain.useCases

import com.hesham.domain.entity.product.ProductItemDTO
import com.hesham.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsOfSubCategoryUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(subCategoryId: String): List<ProductItemDTO> =
        repository.getAllProductsOfSubCategory(subCategoryId)
}