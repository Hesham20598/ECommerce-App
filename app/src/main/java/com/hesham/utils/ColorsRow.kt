package com.hesham.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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