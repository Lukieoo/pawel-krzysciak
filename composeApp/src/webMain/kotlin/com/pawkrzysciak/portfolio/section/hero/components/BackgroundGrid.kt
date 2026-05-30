package com.pawkrzysciak.portfolio.section.hero.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.theme.AppColors

@Composable
fun BackgroundGrid(windowSize: DpSize) {
    Canvas(modifier = Modifier.fillMaxWidth().height(windowSize.height)) {
        val step = 32.dp.toPx()
        val color = AppColors.KotlinPurple.copy(alpha = 0.07f)
        var x = 0f
        while (x < size.width) {
            drawLine(color, Offset(x, 0f), Offset(x, size.height))
            x += step
        }
        var y = 0f
        while (y < size.height) {
            drawLine(color, Offset(0f, y), Offset(size.width, y))
            y += step
        }
    }
}