package com.hesham.data.model.category

import com.google.gson.annotations.SerializedName
import com.hesham.data.model.Metadata

data class CategoryResponse(

    @field:SerializedName("metadata")
	val metadata: Metadata? = null,

    @field:SerializedName("data")
	val data: List<CategoryItem>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)