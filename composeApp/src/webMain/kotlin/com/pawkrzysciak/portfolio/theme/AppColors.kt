package com.pawkrzysciak.portfolio.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object AppColors {
    val KotlinPurple = Color(0xFF7F52FF)
    val KotlinOrange = Color(0xFFE44857)
    val AndroidGreen = Color(0xFF3DDC84)
    val SectionTint = Color(0xFFF7F5FF)

    val KotlinGradient: Brush
        get() = Brush.horizontalGradient(
            listOf(Color(0xFF7F52FF), Color(0xFFC811E1), Color(0xFFE44857))
        )

    val KotlinGradientVertical: Brush
        get() = Brush.verticalGradient(
            listOf(Color(0xFF7F52FF), Color(0xFFC811E1), Color(0xFFE44857))
        )
}

@Composable
fun KotlinDivider(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(AppColors.KotlinGradient)
    )
}

@Composable
fun SectionAccentBar(modifier: Modifier = Modifier, width: Dp = 56.dp) {
    Box(
        modifier = modifier
            .width(width)
            .height(3.dp)
            .background(AppColors.KotlinGradient)
    )
}
