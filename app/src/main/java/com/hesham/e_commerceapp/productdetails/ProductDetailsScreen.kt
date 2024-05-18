package com.hesham.e_commerceapp.productdetails

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.gold
import com.hesham.e_commerceapp.ui.theme.mainColor
import com.hesham.e_commerceapp.ui.theme.textColor1
import com.hesham.utils.AddOrRemoveItem
import com.hesham.utils.ColorsRow
import com.hesham.utils.ExpandableText
import com.hesham.utils.SizesRow

@Composable
fun ProductDetailsScreen(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    vm: ProductDetailsViewModel = viewModel()
) {
    BackHandler {
        navHostController.navigateUp()
    }
    val scrollState = rememberScrollState()
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    // main column ..
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = paddingValues.calculateTopPadding())
            .fillMaxWidth()
            .height(screenHeight)
            .verticalScroll(scrollState)
    ) {

        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.nikeairjordan_image),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {

            // Product name ..
            Text(
                text = "Nike Air Jordon", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor1
                )
            )

            // product price
            Text(
                text = "EGP ${vm.priceNumber}", style = TextStyle(
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
                    text = "3,230 Sold", style = TextStyle(
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
                    contentDescription = "Review start image",
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
                    text = "4.8 (7,500)", style = TextStyle(
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
                AddOrRemoveItem(modifier = Modifier
                    .constrainAs(addOrRemoveRow) {
                        end.linkTo(parent.end)
                        top.linkTo(soldNumber.top)
                        bottom.linkTo(soldNumber.bottom)
                    })
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
            text = "Nike is a multinational corporation that designs, develops, and sells a" +
                    "thletic footwear ,apparel, and accessories......Read More "
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
        SizesRow()
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
                    text = "EGP ${vm.totalPrice}", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = textColor1
                    )
                )
            }
            Button(
                modifier = Modifier.weight(2f),
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
        navHostController = rememberNavController()
    )
}
