package com.hesham.data.model.subCategory

import com.google.gson.annotations.SerializedName
import com.hesham.domain.entity.subCategory.SubCategoryItemDTO

data class SubCategoryItem(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
){
	fun toDTO():SubCategoryItemDTO{
		return SubCategoryItemDTO(createdAt, name, id, category, slug, updatedAt)
	}
}