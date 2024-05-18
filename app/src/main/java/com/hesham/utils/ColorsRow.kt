package com.hesham.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hesham.e_commerceapp.R
import com.hesham.e_commerceapp.ui.theme.blue
import com.hesham.e_commerceapp.ui.theme.brown
import com.hesham.e_commerceapp.ui.theme.green
import com.hesham.e_commerceapp.ui.theme.purple
import com.hesham.e_commerceapp.ui.theme.red

@Composable
fun ColorsRow() {
    val mutableSelectedIntState = remember { mutableIntStateOf(-1) }
    val colorsList = listOf(brown, red, blue, green, purple)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
    ) {

        items(colorsList.size) { position ->
            RowColorItem(colorsList = colorsList, index = position,mutableSelectedIntState)
        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ColorsRowPreview() {
    ColorsRow()
}