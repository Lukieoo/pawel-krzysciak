package com.pawkrzysciak.portfolio.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

private val GLOBAL_MOBILE_PADDING = 16.dp
private val GLOBAL_WEB_PADDING = 80.dp

val isMobile = window.innerWidth < 600

@Composable
fun GetLayoutPadding(): Dp {
    return if (isMobile) GLOBAL_MOBILE_PADDING else GLOBAL_WEB_PADDING
}
