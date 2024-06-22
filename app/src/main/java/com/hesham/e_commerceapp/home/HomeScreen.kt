package com.hesham.e_commerceapp.home

import androidx.activity.compose.BackHandler
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
import androidx.navigation.NavHostController
import com.hesham.e_commerceapp.main.MainActivity
import com.hesham.utils.CustomSearchAppBar

@Composable
fun HomeScreen(navHostController: NavHostController) {
    BackHandler {
        (navHostController.context as? MainActivity)?.finish()
    }
    Scaffold(topBar = {
        CustomSearchAppBar(onSearchIconClick = { /*TODO*/ }) { // on cart icon clicked:-

        }
    }, bottomBar = {

    }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = "Home Screen",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start,
            )
        }


    }
}