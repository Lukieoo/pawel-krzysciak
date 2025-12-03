package com.pawkrzysciak.portfolio.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
fun rememberWindowSize(): DpSize {
    var viewportWidth by remember { mutableStateOf(window.innerWidth) }
    var viewportHeight by remember { mutableStateOf(window.innerHeight) }

    DisposableEffect(Unit) {
        val listener: (org.w3c.dom.events.Event) -> Unit = {
            viewportWidth = window.innerWidth
            viewportHeight = window.innerHeight
        }

        window.addEventListener("resize", listener)

        onDispose {
            window.removeEventListener("resize", listener)
        }
    }

    return DpSize(viewportWidth.dp, viewportHeight.dp)
}