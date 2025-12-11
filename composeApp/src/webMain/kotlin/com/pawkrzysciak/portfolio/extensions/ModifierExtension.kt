package com.pawkrzysciak.portfolio.extensions

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.parallaxLayoutModifier(listState: LazyListState, rate: Int) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        // Obliczamy przesunięcie scrolla w pikselach
        val scrollOffset = (listState.firstVisibleItemIndex * placeable.height + listState.firstVisibleItemScrollOffset)
        val parallaxOffset = if (rate > 0) scrollOffset / rate else scrollOffset

        layout(placeable.width, placeable.height) {
            placeable.place(0, parallaxOffset)
        }
    }