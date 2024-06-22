package com.hesham.domain.useCases

import com.hesham.domain.entity.product.ProductItemDTO
import com.hesham.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductOfCategoryUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend operator fun invoke(categoryId: String): List<ProductItemDTO> =
        productRepository.getAllProductsOfCategory(categoryId)
}