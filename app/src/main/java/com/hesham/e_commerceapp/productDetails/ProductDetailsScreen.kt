@file:OptIn(ExperimentalFoundationApi::class)

package com.hesham.e_commerceapp.productDetails

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.gold
import com.hesham.e_commerceapp.ui.theme.mainColor
import com.hesham.e_commerceapp.ui.theme.textColor1
import com.hesham.utils.AddOrRemoveItem
import com.hesham.utils.AddToWishlistIcon
import com.hesham.utils.ColorsRow
import com.hesham.utils.ExpandableText
import com.hesham.utils.PageIndicator
import com.hesham.utils.SizesRow

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductDetailsScreen(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    productDetailsViewModel: ProductDetailsViewModel,
    addedToWishList: Boolean = false,
    onAddToWishListIconClick: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        productDetailsViewModel.getPrice()
        productDetailsViewModel.getTotalPriceValue()
        productDetailsViewModel.getImages()
    }
    BackHandler {
        navHostController.navigateUp()
    }
    val scrollState = rememberScrollState()
    // main column ..
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = paddingValues.calculateTopPadding())
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        val pagerState = rememberPagerState(pageCount = {
            productDetailsViewModel.imagesList.size
        })
        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            onClick = {},
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxHeight(.5f)
                .fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxSize()
            ) { page ->
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val (productImage, addToWishListIcon) = createRefs()
                    GlideImage(
                        model = productDetailsViewModel.imagesList[page],
                        contentDescription = stringResource(R.string.product_image),
                        modifier = Modifier
                            .fillMaxSize()
                            .constrainAs(productImage) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            },
                        contentScale = ContentScale.Crop
                    )
                    AddToWishlistIcon(
                        addedToWishList = addedToWishList,
                        modifier = Modifier.constrainAs(addToWishListIcon) {
                            top.linkTo(parent.top, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                        }) {
                        // on add to wish list icon click..
                        onAddToWishListIconClick()
                    }
                }

            }
        }
        PageIndicator(
            modifier = Modifier.padding(top = 8.dp),
            pagerState = pagerState,
            currentPageColor = mainColor,
            secondaryColor = Color.Transparent,
            borderColor = mainColor
        )




        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {

            // Product name ..
            Text(
                text = productDetailsViewModel.selectedProductItem?.title ?: "", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor1
                ), modifier = Modifier.fillMaxWidth(.75f)
            )

            // product price
            Text(
                text = stringResource(R.string.egp, productDetailsViewModel.priceNumber.intValue),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor1
                )
            )
        }
        // Second Row ..
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (soldNumber, rateIcon, rateText, addOrRemoveRow) = createRefs()

                // Sold Number..
                Text(
                    text = "${productDetailsViewModel.selectedProductItem?.sold} Sold",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = textColor1
                    ),
                    modifier = Modifier
                        .border(1.dp, mainColor.copy(.3f), CircleShape)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .constrainAs(soldNumber) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )
                // Rete Icon..
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = stringResource(R.string.review_star_image),
                    tint = gold,
                    modifier = Modifier
                        .size(15.dp)
                        .constrainAs(rateIcon) {
                            start.linkTo(soldNumber.end, margin = 16.dp)
                            top.linkTo(soldNumber.top)
                            bottom.linkTo(soldNumber.bottom)
                        }
                )
                // Rete Text..
                Text(
                    text = "${productDetailsViewModel.selectedProductItem?.ratingsAverage}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = textColor1
                    ),
                    modifier = Modifier.constrainAs(rateText) {
                        start.linkTo(rateIcon.end, margin = 4.dp)
                        top.linkTo(soldNumber.top)
                        bottom.linkTo(soldNumber.bottom)
                    }
                )
                // add or remove row..
                AddOrRemoveItem(
                    modifier = Modifier
                        .constrainAs(addOrRemoveRow) {
                            end.linkTo(parent.end)
                            top.linkTo(soldNumber.top)
                            bottom.linkTo(soldNumber.bottom)
                        }, vm = productDetailsViewModel
                )
            }
        }
        // Description..
        Text(
            text = stringResource(R.string.description), style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = textColor1
            )
        )
        // Description Value..
        ExpandableText(
            modifier = Modifier.padding(top = 6.dp),
            text = productDetailsViewModel.selectedProductItem?.description ?: ""
        )
        // Size..
        Text(
            text = stringResource(R.string.size), style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = textColor1
            ),
            modifier = Modifier.padding(top = 30.dp)
        )
        // Size Row..
        SizesRow(productDetailsViewModel)
        // Color..
        Text(
            text = stringResource(R.string.color), style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = textColor1
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
        ColorsRow()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                // Total Price..
                Text(
                    text = stringResource(R.string.total_price), style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = textColor1.copy(.60f)
                    )
                )
                // Total Price Value..
                Text(
                    text = "EGP ${productDetailsViewModel.totalPrice.intValue}", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = textColor1
                    )
                )
            }
            // add to cart button..
            Button(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .weight(2f),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = mainColor),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_cart2),
                    contentDescription = "add to cart",
                    modifier = Modifier
                        .padding(start = 16.dp, end = 20.dp)
                        .size(24.dp)
                )
                Text(
                    text = stringResource(R.string.add_to_cart),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                )
            }


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductDetailsPreview() {
    ProductDetailsScreen(
        paddingValues = PaddingValues(),
        navHostController = rememberNavController(),
        productDetailsViewModel = ProductDetailsViewModel(),
    ) {}
}
