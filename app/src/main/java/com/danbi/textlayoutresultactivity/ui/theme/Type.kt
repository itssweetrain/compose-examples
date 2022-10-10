package com.danbi.textlayoutresultactivity.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily =  pocketMonFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = gray90
    ),
    h2 = TextStyle(
        fontFamily =  pocketMonFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.1.sp,
        color = gray90
    ),
    h3 = TextStyle(
        fontFamily =  pocketMonFamily,
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        color = gray90
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)