package com.hesham.e_commerceapp.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.hesham.e_commerceapp.BottomNavGraph
import com.hesham.utils.BottomBar
import com.hesham.utils.CustomSearchAppBar
import com.hesham.utils.SimpleAppBar

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.auto(
                    Color.TRANSPARENT,
                    Color.TRANSPARENT
                )
            )
            MainActivityContent()
        }

    }
}

@Composable
fun MainActivityContent(vm: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.padding(top = 20.dp, bottom = 45.dp),
        topBar = {
            if (!vm.largeAppBarState) {
                SimpleAppBar(onBackArrowClick = {
                    navController.navigateUp()
                }, onSearchIconClick = {
                    Log.e("TAG", "MainActivityContent: Search Icon Clicked")
                }) {
                    // on Cart Icon Clicked :-
                    navController.popBackStack()
                    navController.navigate("cartScreen")
                }
            } else {
                CustomSearchAppBar(onSearchIconClick = {
                    Log.e("TAG", "MainActivityContent: Search Icon Clicked")
                }
                ) { // on cart icon click:-
                    navController.navigate("cartScreen")
                }
            }
        },
        // bottom navigation Bar
        bottomBar = {
            if (vm.shouldBottomBarBeShown)
                BottomBar(navHostController = navController)
        },

        ) { paddingValues ->
        BottomNavGraph(navController = navController, paddingValues)

    }
}
