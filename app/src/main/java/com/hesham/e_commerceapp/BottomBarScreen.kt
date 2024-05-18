package com.hesham.e_commerceapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(

    val route: String,
    val image: Int,
){
    object Home:BottomBarScreen("Home", R.drawable.home_image)
    object Categories:BottomBarScreen("Categories", R.drawable.category_image)
    object Favourite:BottomBarScreen("Favourite", R.drawable.favourite_image)
    object Profile:BottomBarScreen("Profile", R.drawable.profile_image)
}






