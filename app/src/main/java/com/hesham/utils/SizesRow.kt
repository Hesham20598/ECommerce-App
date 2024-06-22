package com.hesham.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hesham.e_commerceapp.productDetails.ProductDetailsViewModel
import com.hesham.e_commerceapp.ui.theme.mainColor
import com.hesham.e_commerceapp.ui.theme.textColor1

@Composable
fun SizesRow(vm:ProductDetailsViewModel) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth(.5f)
    ) {

        Text(
            text = "38",
            style = TextStyle(
                fontSize = 14.sp,
                color = if (vm.selectedSize.value == "38") Color.White else textColor1
            ),
            modifier = Modifier
                .clip(CircleShape)
                .background(if (vm.selectedSize.value == "38") mainColor else Color.Transparent)
                .padding(8.dp)
                .clickable {
                    if (vm.selectedSize.value == "38") {
                        vm.selectedSize.value = ""
                    } else {
                        vm.selectedSize.value = "38"
                    }
                }
        )
        Text(
            text = "39",
            style = TextStyle(
                fontSize = 14.sp,
                color = if (vm.selectedSize.value == "39") Color.White else textColor1
            ),
            modifier = Modifier
                .clip(CircleShape)
                .background(if (vm.selectedSize.value == "39") mainColor else Color.Transparent)
                .padding(8.dp)
                .clickable {
                    if (vm.selectedSize.value == "39") {
                        vm.selectedSize.value = ""
                    } else {
                        vm.selectedSize.value = "39"
                    }
                }
        )
        Text(
            text = "40",
            style = TextStyle(
                fontSize = 14.sp,
                color = if (vm.selectedSize.value == "40") Color.White else textColor1
            ),
            modifier = Modifier
                .clip(CircleShape)
                .background(if (vm.selectedSize.value == "40") mainColor else Color.Transparent)
                .padding(8.dp)
                .clickable {
                    if (vm.selectedSize.value == "40") {
                        vm.selectedSize.value = ""
                    } else {
                        vm.selectedSize.value = "40"
                    }
                }
        )
        Text(
            text = "41",
            style = TextStyle(
                fontSize = 14.sp,
                color = if (vm.selectedSize.value == "41") Color.White else textColor1
            ),
            modifier = Modifier
                .clip(CircleShape)
                .background(if (vm.selectedSize.value == "41") mainColor else Color.Transparent)
                .padding(8.dp)
                .clickable {
                    if (vm.selectedSize.value == "41") {
                        vm.selectedSize.value = ""
                    } else {
                        vm.selectedSize.value = "41"
                    }
                }
        )
        Text(
            text = "42",
            style = TextStyle(
                fontSize = 14.sp,
                color = if (vm.selectedSize.value == "42") Color.White else textColor1
            ),
            modifier = Modifier
                .clip(CircleShape)
                .background(if (vm.selectedSize.value == "42") mainColor else Color.Transparent)
                .padding(8.dp)
                .clickable {
                    if (vm.selectedSize.value == "42") {
                        vm.selectedSize.value = ""
                    } else {
                        vm.selectedSize.value = "42"
                    }
                }
        )


    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SizesRowPreview() {
    SizesRow(ProductDetailsViewModel())
}