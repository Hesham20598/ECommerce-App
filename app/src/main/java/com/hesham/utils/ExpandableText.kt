package com.hesham.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hesham.e_commerceapp.ui.theme.textColor1

@Composable
fun ExpandableText(modifier: Modifier = Modifier, text: String) {
    var isExpanded by remember { mutableStateOf(false) }

    val displayText = if (isExpanded) {
        buildAnnotatedString {
            append(text)
            append(" ")
            pushStringAnnotation(tag = "action", annotation = "show_less")
            withStyle(
                SpanStyle(
                    color = textColor1,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            ) {
                append("Read Less")
            }
            pop()
        }
    } else {
        buildAnnotatedString {
            append(text.take(105))
            append("...")
            pushStringAnnotation(tag = "action", annotation = "show_more")
            withStyle(
                SpanStyle(
                    color = textColor1,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            ) {
                append("Read More")
            }
            pop()
        }
    }
    Box(modifier = modifier.fillMaxWidth()) {
        Text(
            text = displayText,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val actionTag = displayText
                        .getStringAnnotations(
                            tag = "action",
                            start = displayText.length - "Show More".length - 1,
                            end = displayText.length
                        )
                        .firstOrNull()?.item
                    if (actionTag == "show_more") {
                        isExpanded = true
                    } else if (actionTag == "show_less") {
                        isExpanded = false
                    }
                },
            maxLines = if (isExpanded) Int.MAX_VALUE else 2,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ExpandableTextPreview() {
    ExpandableText(
        text = " \"Nike is a multinational corporation that designs, \" +\n" +
                "                \"develops, and sells athletic footwear , and so many applicationsl\" +\n" +
                "                \"arel, and accessoriesklsdkljsdjksdkljsdkljsdkljsdfkljdfskljsdfkljsdf \""
    )
}