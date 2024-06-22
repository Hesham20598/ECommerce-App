package com.hesham.domain.useCases

import com.hesham.domain.entity.category.CategoryItemDTO
import com.hesham.domain.repository.CategoriesRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(private val categoriesRepository: CategoriesRepository) {
    suspend operator fun invoke(): List<CategoryItemDTO> =
        categoriesRepository.getCategories()


}
