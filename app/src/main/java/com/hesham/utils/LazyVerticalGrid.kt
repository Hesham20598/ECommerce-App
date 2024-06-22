package com.hesham.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hesham.e_commerceapp.categories.CategoriesViewModel
import com.hesham.e_commerceapp.productDetails.ProductDetailsViewModel

@Composable
fun CategoriesGrid(
    vm: CategoriesViewModel,
    navController: NavHostController
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(0.dp),
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
    ) {
        items(vm.subCategoriesList.size) { position ->
            SubCategoryItem(
                vm = vm,
                subCategoryItem = vm.subCategoriesList[position],
                index = position
            ) { // on sub category item clicked ..
                vm.subCategoryId = vm.subCategoriesList[position].id ?: ""

                vm.getAllProductsOfSubCategory(vm.subCategoryId ?: "")
                navController.navigate("productListScreen")
            }
        }
    }
}

@Composable
fun ProductsGrid(
    paddingValues: PaddingValues,
    navController: NavHostController,
    categoriesViewModel: CategoriesViewModel,
    productDetailsViewModel: ProductDetailsViewModel
) {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = Modifier
            .padding(
                top = paddingValues.calculateTopPadding() + 24.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {
        items(categoriesViewModel.productsList.size) { position ->
            ItemProduct(
                productItem = categoriesViewModel.productsList[position],
                index = position,
                onProductItemClick = {
                    productDetailsViewModel.selectedProductItem =
                        categoriesViewModel.productsList[position]
                    navController.navigate("productDetailsScreen")
                },
                onAddToWishListClick = {

                })
            {
                // on add to cart icon click
                navController.navigate("cartScreen")
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun ProductsGridPreview() {
//    val navHostController = NavHostController(LocalContext.current)
//    ProductsGrid(
//        paddingValues = PaddingValues(),
//        navHostController,
//        categoriesViewModel = CategoriesViewModel(),
//        productDetailsViewModel = ProductDetailsViewModel()
//    )
//}