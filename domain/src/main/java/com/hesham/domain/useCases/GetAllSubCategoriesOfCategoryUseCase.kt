package com.hesham.domain.useCases

import com.hesham.domain.entity.subCategory.SubCategoryItemDTO
import com.hesham.domain.repository.SubCategoryRepository
import javax.inject.Inject

class GetAllSubCategoriesOfCategoryUseCase @Inject constructor(private val subCategoriesRepository: SubCategoryRepository) {
    suspend operator fun invoke(categoryId: String):List<SubCategoryItemDTO> =
        subCategoriesRepository.getSupCategories(categoryId)
}