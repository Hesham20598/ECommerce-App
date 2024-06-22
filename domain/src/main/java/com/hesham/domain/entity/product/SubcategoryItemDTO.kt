package com.hesham.data.model.subCategory

import com.hesham.domain.entity.subCategory.SubCategoryItemDTO

data class SubCategoryItemDTO(

	val createdAt: String? = null,

	val name: String? = null,

	val id: String? = null,

	val category: String? = null,

	val slug: String? = null,

	val updatedAt: String? = null
){
	fun toDTO():SubCategoryItemDTO{
		return SubCategoryItemDTO(createdAt, name, id, category, slug, updatedAt)
	}
}