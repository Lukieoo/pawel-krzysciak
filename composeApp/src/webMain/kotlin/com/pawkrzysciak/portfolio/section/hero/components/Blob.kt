package com.pawkrzysciak.portfolio.section.hero.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

data class Blob(
    val size: Dp,
    val offsetX: Dp,
    val offsetY: Dp,
    val color: Color,
    val alpha: Float,
    val blur: Dp
)