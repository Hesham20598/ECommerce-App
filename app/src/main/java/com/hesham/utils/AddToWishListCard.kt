package com.hesham.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.mainColor

@Composable
fun AddToWishlistIcon(
    modifier: Modifier = Modifier,
    addedToWishList: Boolean,
    onAddToWishListClick: () -> Unit
) {


    Card(
        shape = CircleShape, modifier = modifier
            .size(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (addedToWishList) {
                Image(
                    painter = painterResource(id = R.drawable.ic_added_to_wishlist),
                    contentDescription = stringResource(R.string.added_to_wishlist),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onAddToWishListClick()
                        }
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.favourite_image),
                    contentDescription = stringResource(R.string.add_to_wishlist),
                    modifier = Modifier
                        .clickable {
                            onAddToWishListClick()
                        }
                        .size(24.dp),
                    colorFilter = ColorFilter.tint(mainColor)
                )
            }
        }
    }
}