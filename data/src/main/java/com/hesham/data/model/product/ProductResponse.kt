package com.hesham.data.model.product

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @field:SerializedName("metadata")
	val metadata: Metadata? = null,

    @field:SerializedName("data")
	val data: List<ProductItem>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)