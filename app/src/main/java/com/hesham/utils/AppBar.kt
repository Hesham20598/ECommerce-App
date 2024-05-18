package com.hesham.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.grayColor
import com.hesham.e_commerceapp.ui.theme.mainColor
import com.hesham.e_commerceapp.ui.theme.textColor1


@Composable
fun CustomSearchAppBar(onSearchIconClick: () -> Unit, onCartIconClick: () -> Unit) {
    val value = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        val painter = painterResource(id = R.drawable.route_image)
        val imageRatio = painter.intrinsicSize.width / painter.intrinsicSize.height
        // Route signature image
        Image(
            painter = painter,
            contentDescription = "route Signature",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(70.dp)
                .aspectRatio(imageRatio)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 16.dp, end = 13.dp)
                    .weight(6f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(35.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = mainColor,
                    focusedIndicatorColor = mainColor
                ),
                value = value.value,
                onValueChange = {
                    value.value = it
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.what_do_you_search_for), style = TextStyle(
                            fontSize = 14.sp,
                            color = grayColor,
                            fontWeight = FontWeight.Light
                        )
                    )
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "search icon",
                        modifier = Modifier
                            .padding(start = 24.dp, end = 8.dp, top = 13.dp, bottom = 13.dp)
                            .size(35.dp)
                            .clickable {
                                onSearchIconClick()
                            }
                    )
                }

            )
            // cart image
            Image(
                painter = painterResource(id = R.drawable.cart_image),
                contentDescription = "cart image",
                modifier = Modifier
                    .padding(start = 8.dp, end = 16.dp)
                    .size(35.dp)
                    .weight(1f)
                    .clickable {
                        onCartIconClick()
                    }
            )

        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun CustomAppBarPreview() {
//    CustomSearchAppBar({}) {}
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleAppBar(
    onBackArrowClick: () -> Unit,
    onSearchIconClick: () -> Unit,
    onCartIconClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        title = {
            Text(
                text = "Product Details",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor1
                )
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                tint = mainColor,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onBackArrowClick()
                    }
            )
        },
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(.18f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onSearchIconClick()
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.cart_image),
                    contentDescription = "cart image",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onCartIconClick()
                        }
                )
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SimpleAppBarPreview() {
    SimpleAppBar(onBackArrowClick = {}, onSearchIconClick = {}, onCartIconClick = {})
}

