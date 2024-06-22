package com.hesham.e_commerceapp.productDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hesham.data.model.product.ProductItem
import com.hesham.domain.entity.product.ProductItemDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor() : ViewModel() {
    var selectedProductItem by mutableStateOf<ProductItemDTO?>(null)
    val amountNumber = mutableIntStateOf(1)
    val priceNumber = mutableIntStateOf(0)
    val selectedSize = mutableStateOf("")


    var imagesList = mutableStateListOf(String())

    fun getImages() {
        if (selectedProductItem?.images != null) {
            this.imagesList.clear()
            val imagesList = selectedProductItem?.images
            this.imagesList.add(selectedProductItem?.imageCover!!)
            this.imagesList.addAll(imagesList!!)
        }
    }

    fun getPrice() {
        if (selectedProductItem?.priceAfterDiscount == null || selectedProductItem?.priceAfterDiscount == 0) {
            priceNumber.intValue = selectedProductItem?.price!!
        } else {
            priceNumber.intValue = selectedProductItem?.priceAfterDiscount!!
        }
    }

    var totalPrice = mutableIntStateOf(0)
    fun getTotalPriceValue() {
        if (priceNumber.intValue != 0)
            totalPrice.intValue = (priceNumber.intValue) * (amountNumber.intValue)
    }
}
