package com.hesham.e_commerceapp.favourite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import com.hesham.utils.bottomBar.BottomBarViewModel
import com.hesham.utils.bottomBar.BottomBar
import com.hesham.utils.CustomSearchAppBar

@Composable
fun FavouriteScreen(bottomBarViewModel: BottomBarViewModel) {
    val navController = rememberNavController()
    Scaffold(topBar = {

        CustomSearchAppBar(onSearchIconClick = { /*TODO*/ }) { // on cart icon clicked:-

        }
    }, bottomBar = {
        BottomBar(navHostController = navController, bottomBarViewModel = bottomBarViewModel)
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = "Favourite screen",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
            )
        }


    }
}