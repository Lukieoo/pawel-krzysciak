package com.pawkrzysciak.portfolio.section.hero.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BlurredBlobs(height: Dp, max: Dp) {

    val blobs = remember(height, max) {
        listOf(
            Blob(
                size = max + max,
                offsetX = -max,
                offsetY = (height / 2) - (max + max)/2,
                color = Color.White,
                alpha = 0.9f,
                blur = 100.dp
            ),
//            Blob(
//                size = max,
//                offsetX = -max / 2,
//                offsetY = (height / 2) - max / 2,
//                color = Color.White,
//                alpha = 0.9f,
//                blur = 100.dp
//            ),
//            Blob(
//                size = max,
//                offsetX = 0.dp,
//                offsetY = (height / 2) - max / 2,
//                color = Color.White,
//                alpha = 0.9f,
//                blur = 100.dp
//            ),
//            Blob(
//                size = 500.dp,
//                offsetX = (-90).dp,
//                offsetY = (height / 2) - 250.dp,
//                color = Color.White,
//                alpha = 0.8f,
//                blur = 120.dp
//            ),
//            Blob(
//                size = 360.dp,
//                offsetX = 250.dp,
//                offsetY = (height / 2) - 180.dp,
//                color = Color.White,
//                alpha = 0.8f,
//                blur = 140.dp
//            ),
        )
    }

    Box(modifier = Modifier.fillMaxWidth().height(height)) {
        blobs.forEach { blob ->
            Box(
                modifier = Modifier
                    .size(blob.size)
                    .offset(blob.offsetX, blob.offsetY)
                    .background(blob.color.copy(alpha = blob.alpha), CircleShape)
                    .blur(blob.blur)
            )
        }
    }
}