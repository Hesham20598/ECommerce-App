package com.hesham.e_commerceapp.cart

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
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CartScreen( paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier,
            text = "Cart Screen",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start,
        )
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen(paddingValues = PaddingValues())
}
