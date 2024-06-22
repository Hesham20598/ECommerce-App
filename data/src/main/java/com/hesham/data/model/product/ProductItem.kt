package com.hesham.data.model.product

import com.google.gson.annotations.SerializedName
import com.hesham.domain.entity.product.ProductItemDTO

data class ProductItem(

    @field:SerializedName("sold")
    val sold: Int? = null,

    @field:SerializedName("images")
    val images: List<String>? = null,

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @field:SerializedName("imageCover")
    val imageCover: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("ratingsQuantity")
    val ratingsQuantity: Int? = null,

    @field:SerializedName("ratingsAverage")
    val ratingsAverage: Double? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("subcategory")
    val subcategory: List<SubcategoryItem>? = null,

    @field:SerializedName("category")
    val category: Category? = null,

    @field:SerializedName("priceAfterDiscount")
    val priceAfterDiscount: Int? = null,

    @field:SerializedName("brand")
    val brand: Brand? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) {
    fun toDTO(): ProductItemDTO {
        return ProductItemDTO(
            sold,
            images,
            quantity,
            imageCover,
            description,
            title,
            ratingsQuantity,
            ratingsAverage,
            createdAt,
            price,
            id
        )
    }
}