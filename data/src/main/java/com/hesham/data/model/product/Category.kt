package com.hesham.data.model.product

import com.google.gson.annotations.SerializedName
import com.hesham.domain.entity.product.CategoryDTO

data class Category(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null
) {
    fun toDTO(): CategoryDTO {
        return CategoryDTO(image, name, id, slug)
    }
}