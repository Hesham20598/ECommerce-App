package com.hesham.utils

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.gold
import com.hesham.e_commerceapp.ui.theme.textColor1
import com.hesham.e_commerceapp.ui.theme.textColor2

@Composable
fun CategoryItem(categoryName: String, index: Int, onCategoryItemClick: () -> Unit) {
    Column(
        modifier = when (index) {
            0, 3, 6 -> {
                Modifier.padding(end = 4.dp, top = 10.dp, bottom = 10.dp)
            }

            2, 5, 8 -> {
                Modifier.padding(start = 4.dp, top = 10.dp, bottom = 10.dp)
            }

            else -> Modifier.padding(horizontal = 4.dp, vertical = 10.dp)
        },

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(70.dp)
                .clickable {
                    onCategoryItemClick()
                }, shape = RoundedCornerShape(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.shirt_image),
                contentDescription = "category image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            modifier = Modifier.padding(top = 6.dp),
            text = categoryName,
            style = TextStyle(
                fontSize = 12.sp,
                color = textColor1
            )
        )

    }
}

@Composable
fun ProductItem(index: Int, onProductItemClick: () -> Unit, onAddIconClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = if (index % 2 == 0) {
            Modifier
                .padding(start = 16.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(237.dp)
                .clickable {
                    onProductItemClick()
                }
        } else {
            Modifier
                .padding(start = 8.dp, end = 16.dp, bottom = 16.dp)
                .height(237.dp)
                .fillMaxWidth()
                .clickable {
                    onProductItemClick()
                }
        }

    ) {
        Image(
            painter = painterResource(id = R.drawable.nikeairjordan_image),
            contentDescription = "product image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (name, description, price, originalPrice, review, reviewValue, starIcon, addIcon) = createRefs()
                Text(
                    text = "Nike Air Jordon", style = TextStyle(
                        fontSize = 14.sp,
                        color = textColor1
                    ), modifier = Modifier.constrainAs(name) {
                        top.linkTo(parent.top, margin = 4.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
                )
                Text(
                    text = "Nike shoes flexible for wo..",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = textColor1
                    ),
                    modifier = Modifier.constrainAs(description) {
                        top.linkTo(name.bottom, margin = 4.dp)
                        start.linkTo(name.start)
                        end.linkTo(parent.end, margin = 8.dp)
                        width = Dimension.fillToConstraints
                    }
                )
                Text(text = "EGP 1,200 ", style = TextStyle(
                    fontSize = 14.sp,
                    color = textColor1
                ), modifier = Modifier.constrainAs(price) {
                    top.linkTo(description.bottom, margin = 8.dp)
                    start.linkTo(name.start)
                    bottom.linkTo(review.top)
                }
                )
                Text(
                    text = "2000 EGP",
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 11.sp,
                        color = textColor2
                    ),
                    modifier = Modifier.constrainAs(originalPrice) {
                        top.linkTo(price.top)
                        start.linkTo(price.end, margin = 14.dp)
                        bottom.linkTo(price.bottom)
                    }

                )
                Text(text = "Review ", style = TextStyle(
                    fontSize = 12.sp,
                    color = textColor1
                ),
                    modifier = Modifier.constrainAs(review) {
                        top.linkTo(price.bottom, margin = 8.dp)
                        start.linkTo(price.start)
                        bottom.linkTo(parent.bottom)
                    }
                )

                Text(text = "(4.6)", style = TextStyle(
                    fontSize = 12.sp,
                    color = textColor1
                ),
                    modifier = Modifier.constrainAs(reviewValue) {
                        top.linkTo(review.top)
                        start.linkTo(review.end, margin = 8.dp)
                        bottom.linkTo(review.bottom)
                    }
                )
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star icon",
                    tint = gold,
                    modifier = Modifier
                        .size(15.dp)
                        .constrainAs(starIcon) {
                            top.linkTo(review.top)
                            start.linkTo(reviewValue.end, margin = 4.dp)
                            bottom.linkTo(review.bottom)
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "add icon",
                    modifier = Modifier
                        .size(30.dp)
                        .constrainAs(addIcon) {
                            bottom.linkTo(parent.bottom, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                        }
                        .clickable {
                            onAddIconClick()
                            Log.e("TAG", "ProductItem: you clicked on add button ")
                        }

                )

            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xff808080)
@Composable
private fun ProductItemPreview() {
    ProductItem(0, onProductItemClick = {}) {}
}

@Composable
fun RowColorItem(colorsList: List<Color>, index: Int,mutableSelectedIntState: MutableIntState) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(colorsList[index])
            .size(35.dp)
            .clickable {
                if (mutableSelectedIntState.intValue!=index){
                    mutableSelectedIntState.intValue =index
                } else {
                    mutableSelectedIntState.intValue = -1
                }

            }
    ) {
        var isSelected by remember {
            mutableStateOf(false)
        }
        isSelected = mutableSelectedIntState.intValue == index
        if (isSelected) {
            Image(
                painter = painterResource(id = R.drawable.ic_checkmark),
                contentDescription = "selected icon",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }

}

//@Preview()
//@Composable
//private fun CategoryItemPreview() {
//    CategoryItem("T-Shirts", 0) {}
//}