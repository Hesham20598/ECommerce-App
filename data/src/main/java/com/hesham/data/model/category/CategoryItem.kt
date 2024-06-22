package com.hesham.data.model.category

import com.google.gson.annotations.SerializedName
import com.hesham.domain.entity.category.CategoryItemDTO

data class CategoryItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
){
	fun toDTO(): CategoryItemDTO{
		return CategoryItemDTO(image, createdAt, name, id, slug, updatedAt)
	}
}