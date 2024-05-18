package com.hesham.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hesham.e_commerceapp.BottomBarScreen
import com.hesham.e_commerceapp.ui.theme.mainColor

@Composable
fun BottomBar(navHostController: NavHostController) {
    val selectedIndexState = remember {
        mutableIntStateOf(0)
    }
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Categories,
        BottomBarScreen.Favourite,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = mainColor,
        modifier = Modifier.clip(
            RoundedCornerShape(15.dp)
        )
    ) {

        screens.forEachIndexed() { index, screen ->
            AddItem(
                selectedState = selectedIndexState,
                index = index,
                screen = screen,
                navHostController = navHostController
            )

        }

    }

}

@Preview
@Composable
private fun BottomBarPreview() {
    val navHostController = rememberNavController()
    BottomBar(navHostController = navHostController)
}


@Composable
fun RowScope.AddItem(
    selectedState: MutableIntState,
    index: Int,
    screen: BottomBarScreen,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        selected = selectedState.intValue == index,
        onClick = {
            selectedState.intValue = index
            navHostController.popBackStack()
            navHostController.navigate(screen.route)
        },
        icon = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        start = if (index == 0) 50.dp else if (index == 1) 20.dp else 0.dp,
                        end = if (index == 3) 50.dp else if (index==2) 20.dp else 0.dp
                    )
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(if (selectedState.intValue == index) Color.White else Color.Transparent)
            ) {
                Image(
                    colorFilter = if (selectedState.intValue == index) ColorFilter.tint(
                        mainColor
                    ) else ColorFilter.tint(Color.White),
                    painter = painterResource(id = screen.image),
                    contentDescription = "${screen.route} image"
                )
            }
        }
    )

}