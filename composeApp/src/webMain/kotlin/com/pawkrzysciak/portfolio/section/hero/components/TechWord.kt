package com.pawkrzysciak.portfolio.section.hero.components

import androidx.compose.ui.unit.Dp

data class TechWord(
    val text: String,
    val x: Dp,
    val y: Dp,
    val scale: Float = 1f,
    val rotation: Float = 0f
)