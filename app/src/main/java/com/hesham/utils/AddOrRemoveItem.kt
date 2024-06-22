package com.hesham.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.productDetails.ProductDetailsViewModel
import com.hesham.e_commerceapp.ui.theme.mainColor

@Composable
fun AddOrRemoveItem(modifier: Modifier = Modifier, vm: ProductDetailsViewModel) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(mainColor)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // decrease an item
        Image(
            painter = painterResource(id = R.drawable.ic_minus),
            contentDescription = stringResource(R.string.decrease_item),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(20.dp)
                .clickable {
                    if (vm.amountNumber.intValue > 1) {
                        vm.amountNumber.intValue--
                        vm.getTotalPriceValue()
                    }
                }
        )
        Text(
            text = "${vm.amountNumber.intValue}", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        // add an item
        Image(
            painter = painterResource(id = R.drawable.ic_plus),
            contentDescription = stringResource(R.string.add_another_item),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(20.dp)
                .clickable {
                    vm.amountNumber.intValue++
                    vm.getTotalPriceValue()
                }
        )

    }


}

@Preview
@Composable
private fun AddOrRemovePreview() {
    AddOrRemoveItem(vm = ProductDetailsViewModel())
}