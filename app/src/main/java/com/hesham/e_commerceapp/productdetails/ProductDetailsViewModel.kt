package com.hesham.e_commerceapp.productdetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProductDetailsViewModel : ViewModel() {
    var amountNumber by mutableIntStateOf(1)
    var priceNumber by mutableIntStateOf(3500)
    var totalPrice by mutableIntStateOf(priceNumber)
    fun getTotalPriceValue() {
        val price = amountNumber * priceNumber
        totalPrice = price
    }
}