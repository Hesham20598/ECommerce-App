package com.hesham.domain.entity.product

import com.hesham.domain.entity.subCategory.SubCategoryItemDTO

data class ProductItemDTO(

	val sold: Int? = null,

	val images: List<String>? = null,

	val quantity: Int? = null,

	val imageCover: String? = null,

	val description: String? = null,

	val title: String? = null,

	val ratingsQuantity: Int? = null,

	val ratingsAverage: Double? = null,

	val createdAt: String? = null,

	val price: Int? = null,

	val id: String? = null,

	val subcategory: List<SubCategoryItemDTO>? = null,

	val category: CategoryDTO? = null,

	val priceAfterDiscount: Int? = null,

	val brand: BrandDTO? = null,

	val slug: String? = null,

	val updatedAt: String? = null
)