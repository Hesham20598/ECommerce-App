package com.hesham.e_commerceapp.productlist

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.hesham.utils.ProductsGrid

@Composable
fun ProductListScreen(paddingValues: PaddingValues, navHostController: NavHostController) {
    BackHandler {
        navHostController.navigateUp()
    }
    ProductsGrid(paddingValues = paddingValues, navHostController)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    val navHostController = NavHostController(LocalContext.current)
    ProductListScreen(paddingValues = PaddingValues(), navHostController)
}