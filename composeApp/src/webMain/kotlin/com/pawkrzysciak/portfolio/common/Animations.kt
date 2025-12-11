package com.pawkrzysciak.portfolio.common

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BoxScope.FallingNotesAnimation() {
    val notes = listOf("1", "2", "3", "4", "5", "6")

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .align(Alignment.Center)
    ) {
        notes.forEachIndexed { index, number ->
            val infiniteTransition = rememberInfiniteTransition()

            val fallY by infiniteTransition.animateFloat(
                initialValue = -200f,
                targetValue = 1400f, // wystarczająco by wypaść poza ekran
                animationSpec = infiniteRepeatable(
                    tween(
                        durationMillis = 4000 + index * 500,
                        easing = LinearEasing
                    )
                )
            )

            val driftX by infiniteTransition.animateFloat(
                initialValue = -20f,
                targetValue = 20f,
                animationSpec = infiniteRepeatable(
                    tween(1500 + index * 200, easing = LinearEasing),
                    RepeatMode.Reverse
                )
            )

            val rotation by infiniteTransition.animateFloat(
                initialValue = -15f,
                targetValue = 15f,
                animationSpec = infiniteRepeatable(
                    tween(1800 + index * 200, easing = LinearEasing),
                    RepeatMode.Reverse
                )
            )

            val size = 90.dp

            Box(
                modifier = Modifier
                    .size(size)
                    .offset(
                        x = (driftX + (index * 40)).dp, // każdy lekko przesunięty w bok
                        y = fallY.dp
                    )
                    .graphicsLayer {
                        rotationZ = rotation
                    }
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number,
                    fontSize = 32.sp,
                    color = Color(0xFF333333),
                )
            }
        }
    }
}

@Composable
fun BoxScope.FanOutCardsAnimation() {
    val cardCount = 4

    val colors = listOf(
        Color(0xFF80CBC4),
        Color(0xFF90CAF9),
        Color(0xFFFFCC80),
        Color(0xFFE6EE9C)
    )

    val targetOffsets = listOf(0.dp, (-20).dp, (-40).dp, (-60).dp)
    val targetRotations = listOf(0f, -6f, -12f, -18f)

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .align(Alignment.Center)
    ) {
        repeat(cardCount) { index ->
            var start by remember { mutableStateOf(false) }

            val offsetX by animateDpAsState(
                targetValue = if (start) targetOffsets[index] else 0.dp,
                animationSpec = tween(
                    durationMillis = 600 + index * 120,
                    easing = FastOutSlowInEasing
                )
            )

            val rotation by animateFloatAsState(
                targetValue = if (start) targetRotations[index] else 0f,
                animationSpec = tween(
                    durationMillis = 600 + index * 150,
                    easing = FastOutSlowInEasing
                )
            )

            val alpha by animateFloatAsState(
                targetValue = if (start) 1f else 0f,
                animationSpec = tween(500)
            )

            LaunchedEffect(Unit) { start = true }

            Box(
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.CenterEnd)
                    .graphicsLayer {
                        translationX = offsetX.toPx()
                        rotationZ = rotation
                        this.alpha = alpha
                    }
                    .background(colors[index], RoundedCornerShape(18.dp))
            )
        }
    }
}
