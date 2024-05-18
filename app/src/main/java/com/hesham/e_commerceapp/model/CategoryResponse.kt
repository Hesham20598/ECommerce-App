package com.hesham.e_commerceapp.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

    @field:SerializedName("metadata")
	val metadata: Metadata? = null,

    @field:SerializedName("data")
	val data: List<CategoryItem>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)