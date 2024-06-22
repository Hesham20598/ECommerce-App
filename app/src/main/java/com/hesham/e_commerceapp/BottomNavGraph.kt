package com.hesham.e_commerceapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hesham.e_commerceapp.cart.CartScreen
import com.hesham.e_commerceapp.categories.CategoriesScreen
import com.hesham.e_commerceapp.categories.CategoriesViewModel
import com.hesham.e_commerceapp.favourite.FavouriteScreen
import com.hesham.e_commerceapp.home.HomeScreen
import com.hesham.e_commerceapp.main.MainViewModel
import com.hesham.e_commerceapp.productDetails.ProductDetailsScreen
import com.hesham.e_commerceapp.productDetails.ProductDetailsViewModel
import com.hesham.e_commerceapp.productList.ProductListScreen
import com.hesham.e_commerceapp.profile.ProfileScreen
import com.hesham.utils.bottomBar.BottomBarViewModel

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    mainViewModel: MainViewModel,
    categoryViewModel: CategoriesViewModel,
    productDetailsViewModel: ProductDetailsViewModel,
    bottomBarViewModel: BottomBarViewModel,
) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        // Our App Screens...
        composable(route = BottomBarScreen.Home.route) {
            mainViewModel.shouldBottomBarBeShown = true
            mainViewModel.largeAppBarState = true
            bottomBarViewModel.selectedState.intValue = 0
            HomeScreen(navController)
        }

        composable(route = BottomBarScreen.Categories.route) {
            mainViewModel.shouldBottomBarBeShown = true
            mainViewModel.largeAppBarState = true
            bottomBarViewModel.selectedState.intValue = 1
            CategoriesScreen(paddingValues, navController, categoryViewModel)
        }
        composable(route = BottomBarScreen.Favourite.route) {
            mainViewModel.shouldBottomBarBeShown = true
            mainViewModel.largeAppBarState = true
            bottomBarViewModel.selectedState.intValue = 2
            FavouriteScreen(bottomBarViewModel)
        }
        composable(route = BottomBarScreen.Profile.route) {
            mainViewModel.shouldBottomBarBeShown = true
            mainViewModel.largeAppBarState = false
            bottomBarViewModel.selectedState.intValue = 3
            ProfileScreen(navController, paddingValues)
        }
        composable(route = "productDetailsScreen") {
            mainViewModel.shouldBottomBarBeShown = false
            mainViewModel.largeAppBarState = false
            bottomBarViewModel.selectedState.intValue = 1
            ProductDetailsScreen(
                paddingValues,
                navController,
                productDetailsViewModel,
            ) { // on Add to wishList icon click...

            }
        }
        composable(route = "productListScreen") {
            mainViewModel.shouldBottomBarBeShown = true
            mainViewModel.largeAppBarState = true
            bottomBarViewModel.selectedState.intValue = 1
            ProductListScreen(
                paddingValues,
                navController,
                categoryViewModel,
                productDetailsViewModel
            )
        }
        composable(route = "cartScreen") {
            mainViewModel.shouldBottomBarBeShown = false
            mainViewModel.largeAppBarState = false
            bottomBarViewModel.selectedState.intValue = 1
            CartScreen(paddingValues)
        }

    }

}