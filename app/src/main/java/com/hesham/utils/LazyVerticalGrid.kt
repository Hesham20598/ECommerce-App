package com.hesham.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CategoriesGrid(navController: NavHostController) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(0.dp),
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
    ) {
        items(9) { index ->
            CategoryItem(categoryName = "T-Shirts", index) { // on category item clicked ..
                navController.navigate("productListScreen")
            }
        }
    }
}

@Composable
fun ProductsGrid(paddingValues: PaddingValues, navController: NavHostController) {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = Modifier
            .padding(
                top = paddingValues.calculateTopPadding() + 24.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {
        items(6) { position ->
            ProductItem(position, onProductItemClick = {
                navController.navigate("productDetailsScreen")
            }) {
                // on Add Icon Click
                navController.navigate("cartScreen")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductsGridPreview() {
    val navHostController = NavHostController(LocalContext.current)
    ProductsGrid(paddingValues = PaddingValues(), navHostController)
}