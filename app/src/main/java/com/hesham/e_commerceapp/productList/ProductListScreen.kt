package com.hesham.e_commerceapp.productList

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.hesham.data.model.category.CategoryItem
import com.hesham.data.repository.CategoriesRepositoryImpl
import com.hesham.data.repository.ProductsRepositoryImpl
import com.hesham.data.repository.SubCategoryRepositoryImpl
import com.hesham.domain.entity.category.CategoryItemDTO
import com.hesham.domain.entity.product.ProductItemDTO
import com.hesham.domain.entity.subCategory.SubCategoryItemDTO
import com.hesham.domain.repository.CategoriesOnlineDataSource
import com.hesham.domain.repository.CategoriesRepository
import com.hesham.domain.repository.NetworkHandler
import com.hesham.domain.repository.ProductsOnlineDataSource
import com.hesham.domain.repository.SubCategoryOnlineDataSource
import com.hesham.domain.useCases.GetAllCategoriesUseCase
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.categories.CategoriesViewModel
import com.hesham.e_commerceapp.productDetails.ProductDetailsViewModel
import com.hesham.utils.ProductsGrid

@Composable
fun ProductListScreen(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    categoriesViewModel: CategoriesViewModel,
    productDetailsViewModel: ProductDetailsViewModel
) {
    BackHandler {
        navHostController.navigateUp()
    }
    Log.e("TAG", "ProductListScreen: the final size is ${categoriesViewModel.productsList.size}")
    if (categoriesViewModel.productsList.isNotEmpty()) {
        ProductsGrid(
            paddingValues = paddingValues,
            navHostController,
            categoriesViewModel = categoriesViewModel,
            productDetailsViewModel = productDetailsViewModel
        )
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.nothing_here_yet),
                contentDescription = stringResource(id = R.string.image_says_nothing_here_yet),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

