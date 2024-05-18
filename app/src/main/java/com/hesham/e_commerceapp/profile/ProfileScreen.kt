package com.hesham.e_commerceapp.profile

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navHostController: NavHostController, paddingValues: PaddingValues) {
    BackHandler {
        navHostController.navigateUp()
    }
    Box(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier,
            text = "Profile screen",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start,
        )
    }


}
