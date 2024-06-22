package com.hesham.data.model.subCategory

import com.google.gson.annotations.SerializedName
import com.hesham.data.model.Metadata

data class SubCategoryResponse(

    @field:SerializedName("metadata")
	val metadata: Metadata? = null,

    @field:SerializedName("data")
	val data: List<SubCategoryItem>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)