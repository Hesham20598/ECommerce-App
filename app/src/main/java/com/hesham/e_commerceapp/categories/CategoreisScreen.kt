package com.hesham.e_commerceapp.categories

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.mainColor
import com.hesham.e_commerceapp.ui.theme.textColor1
import com.hesham.e_commerceapp.ui.theme.unSelectedContainerColor
import com.hesham.utils.CategoriesGrid
import com.hesham.utils.ItemCategory


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoriesScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: CategoriesViewModel
) {

    LaunchedEffect(key1 = true) {
        vm.getAllCategories()

    }
    BackHandler {
        navController.navigateUp()
    }
    // Main Row..
    Row(
        modifier = Modifier
            .padding(
                top = paddingValues.calculateTopPadding() + 16.dp,
                start = 19.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {

        // categories column
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(unSelectedContainerColor)
                .width(137.dp)
                .fillMaxHeight()
        )
        {
            items(vm.categoriesList.size) { position ->
                vm.currentCategoryPosition = position
                ItemCategory(
                    categoryItem = vm.categoriesList[position],
                    mutableIntState = vm.selectedState,
                    index = position
                ) {
                    // on category click..
                    vm.currentCategoryPosition = position
                    vm.categoryId = vm.categoriesList[position].id ?: ""
                    Log.e(
                        "TAG",
                        "CategoriesScreen: category name is ${vm.categoriesList[position].name} and categories id is ${vm.categoriesList[position].id} , and categoryPosition is ${vm.currentCategoryPosition}",
                    )
                    vm.selectedNameState = vm.categoriesList[position].name ?: ""

                    vm.getSubCategories(categoryId = vm.categoryId ?: "")
                    vm.selectedCategoryImage = vm.categoriesList[position].image ?: ""

                }
            }
        }

        // content column
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 24.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            // selected category name..
            Text(
                text = if (vm.categoriesList.isNotEmpty()) {
                    if (vm.selectedNameState == "") vm.categoriesList[0].name
                        ?: "" else vm.selectedNameState
                } else "",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor1
                )
            )

            //category name and shop button
            Card(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .height(94.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val (categoryImage, categoryName, shopButton) = createRefs()
                    // category image
                    GlideImage(
                        model = vm.selectedCategoryImage,
                        contentDescription = stringResource(R.string.category_image),
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .constrainAs(categoryImage) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                    )
                    //category name ..
                    Text(
                        modifier = Modifier
                            .width(83.dp)
                            .constrainAs(categoryName) {
                                top.linkTo(parent.top, margin = 4.dp)
                                start.linkTo(parent.start, margin = 16.dp)
                            },
                        text = if (vm.categoriesList.isNotEmpty()) {
                            if (vm.selectedNameState == "") vm.categoriesList[0].name
                                ?: "" else vm.selectedNameState
                        } else "",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = textColor1
                        ),
                        textAlign = TextAlign.Start,
                        maxLines = 2
                    )
                    // shop button..
                    Button(
                        onClick = {

                            vm.getAllProductsOfCategory(vm.categoryId ?: "")
                            Log.e("TAG", "CategoriesScreen:${vm.productsList.size} ")
                            navController.navigate("productListScreen")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = mainColor),
                        modifier = Modifier
                            .constrainAs(shopButton) {
                                bottom.linkTo(parent.bottom, margin = 4.dp)
                                start.linkTo(parent.start, margin = 16.dp)
                            }
                    ) {

                        Text(
                            text = "Shop Now", style = TextStyle(
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        )

                    }

                }


            }
            if (vm.subCategoriesList.isNotEmpty())
                CategoriesGrid(vm = vm, navController = navController)
            else
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.nothing_here_yet),
                        contentDescription = stringResource(R.string.image_says_nothing_here_yet),
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }


        }

    }


}







