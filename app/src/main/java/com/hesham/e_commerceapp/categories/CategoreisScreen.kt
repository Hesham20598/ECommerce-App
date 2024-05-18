package com.hesham.e_commerceapp.categories

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.hesham.e_commerceapp.BottomBarScreen
import com.hesham.e_commerceapp.ui.theme.cardContainerColor
import com.hesham.e_commerceapp.ui.theme.mainColor
import com.hesham.e_commerceapp.ui.theme.textColor1
import com.hesham.e_commerceapp.ui.theme.unSelectedContainerColor
import com.hesham.utils.CategoriesGrid
import com.hesham.utils.ItemCategory
import kotlinx.coroutines.launch


@Composable
fun CategoriesScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: CategoriesViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launch {
            vm.getAllCategories()
            if (vm.categoriesList.isNotEmpty()) {
                Log.e("TAG", "CategoriesScreen: ${vm.categoriesList.size}")
            } else Log.e("TAG", "CategoriesScreen: the list is empty")
        }

    }
    BackHandler {
        navController.navigate(BottomBarScreen.Home.route)
    }

    val selectedState = remember {
        mutableIntStateOf(0)
    }
    val selectedNameState = remember {
        mutableStateOf("")
    }



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
            items(vm.categoriesList.size) { postion ->
               ItemCategory(
                    categoryItem = vm.categoriesList[postion],
                    mutableIntState = selectedState,
                    index = postion
                ) {
                    // on category click..
                    selectedNameState.value = vm.categoriesList[postion].name ?: ""
                }
            }
        }
//            categoryList.forEachIndexed { index, s ->
//                // every tab is represents a category in categories column
//                CustomTab(
//                    mutableIntState = selectedState,
//                    index = index,
//                    name = s
//                ) {
//                    selectedNameState.value = s
//                }
//            }
//        }
        // content column
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 24.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            // selected category name..
            Text(
                text = if (selectedNameState.value == "") vm.categoriesList[0].name
                    ?: "" else selectedNameState.value,
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
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = cardContainerColor),
            ) {
                // category name
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp, start = 16.dp)
                        .width(83.dp),
                    text = if (selectedNameState.value == "") vm.categoriesList[0].name
                        ?: "" else selectedNameState.value,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = textColor1
                    ),
                    textAlign = TextAlign.Start,
                )
                // shop button
                Button(
                    onClick = {
                        // on shop button clicked
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = mainColor),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
                ) {

                    Text(
                        text = "Shop Now", style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    )

                }
            }

            CategoriesGrid(navController = navController)
        }


    }
}



