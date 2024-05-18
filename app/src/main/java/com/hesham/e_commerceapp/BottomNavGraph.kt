package com.hesham.e_commerceapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hesham.e_commerceapp.cart.CartScreen
import com.hesham.e_commerceapp.categories.CategoriesScreen
import com.hesham.e_commerceapp.favourite.FavouriteScreen
import com.hesham.e_commerceapp.home.HomeScreen
import com.hesham.e_commerceapp.main.MainViewModel
import com.hesham.e_commerceapp.productdetails.ProductDetailsScreen
import com.hesham.e_commerceapp.productlist.ProductListScreen
import com.hesham.e_commerceapp.profile.ProfileScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: MainViewModel = viewModel()
) {

    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        // Our App Screens...
        composable(route = BottomBarScreen.Home.route) {
            vm.shouldBottomBarBeShown = true
            vm.largeAppBarState = true
            HomeScreen()
        }
        composable(route = BottomBarScreen.Categories.route) {
            vm.shouldBottomBarBeShown = true
            vm.largeAppBarState = true
            CategoriesScreen(paddingValues, navController)
        }
        composable(route = BottomBarScreen.Favourite.route) {
            vm.shouldBottomBarBeShown = true
            vm.largeAppBarState = true
            FavouriteScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            vm.shouldBottomBarBeShown = true
            vm.largeAppBarState = false
            ProfileScreen(navController,paddingValues)
        }
        composable(route = "productDetailsScreen") {
            vm.shouldBottomBarBeShown = false
            vm.largeAppBarState = false
            ProductDetailsScreen(paddingValues, navController)
        }
        composable(route = "productListScreen") {
            vm.shouldBottomBarBeShown = true
            vm.largeAppBarState = true
            ProductListScreen(paddingValues, navController)
        }
        composable(route = "cartScreen") {
            vm.shouldBottomBarBeShown = false
            vm.largeAppBarState = false
            CartScreen(paddingValues)
        }

    }

}