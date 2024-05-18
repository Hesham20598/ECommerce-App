package com.hesham.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.model.CategoryItem
import com.hesham.e_commerceapp.ui.theme.textColor1
import com.hesham.e_commerceapp.ui.theme.unSelectedContainerColor

@Composable
fun ItemCategory(
    categoryItem: CategoryItem,
    mutableIntState: MutableIntState,
    index: Int,
    onTabSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (mutableIntState.intValue == index) Color.White else unSelectedContainerColor)
    ) {
        // image of indicator .. it will change according to the tab
        if (mutableIntState.intValue == index) {
            Image(
                painter = painterResource(id = R.drawable.indicator),
                contentDescription = "indicator image",
                modifier = Modifier
                    .padding(5.dp)
            )
        }
        Tab(
            selected = mutableIntState.intValue == index,
            onClick = {
                mutableIntState.intValue = index
                onTabSelected()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(if (mutableIntState.intValue == index) Color.White else unSelectedContainerColor),
        ) {
            Text(
                text = categoryItem.name ?: "", style = TextStyle(
                    fontSize = 14.sp,
                    color = textColor1,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Preview
@Composable
private fun TabRowPreview() {
    val state = remember {
        mutableIntStateOf(0)
    }
    ItemCategory(mutableIntState = state, index = 0, categoryItem = CategoryItem(name = "Mobile")) {
    }
}