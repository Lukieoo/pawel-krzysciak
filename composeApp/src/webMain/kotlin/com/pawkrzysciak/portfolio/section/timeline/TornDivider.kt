package com.pawkrzysciak.portfolio.section.timeline

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke

enum class TornSide {
    LEFT,
    RIGHT
}

fun Modifier.tornBorder(
    side: TornSide = TornSide.RIGHT,
    color: Color = Color.LightGray,
    strokeWidth: Float = 1f,
    amplitude: Float = 12f,
    step: Float = 20f
) = this.then(
    Modifier.drawBehind {
        val path = Path()

        val left = 0f
        val right = size.width
        val top = 0f
        val bottom = size.height

        path.moveTo(left, top)

        path.lineTo(right, top)

        if (side == TornSide.RIGHT) {
            var y = top
            var direction = 1

            while (y <= bottom) {
                path.lineTo(
                    right + amplitude * direction,
                    y
                )
                y += step
                direction *= -1
            }
        } else {
            path.lineTo(right, bottom)
        }

        path.lineTo(left, bottom)

        if (side == TornSide.LEFT) {
            var y = bottom
            var direction = 1

            while (y >= top) {
                path.lineTo(
                    left - amplitude * direction,
                    y
                )
                y -= step
                direction *= -1
            }
        } else {
            path.lineTo(left, top)
        }

        path.close()

        drawPath(
            path = path,
            color = color,
            style = Stroke(
                width = strokeWidth,
                join = StrokeJoin.Round,
                cap = StrokeCap.Round
            )
        )
    }
)

@Composable
fun TornDivider(
    modifier: Modifier = Modifier,
    xPosition: Float = 0.5f,
    amplitude: Float = 12f,
    step: Float = 20f,
    color: Color = Color.Black
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val dividerX = size.width * xPosition

        val path = Path()
        path.moveTo(dividerX, 0f)

        var y = 0f
        var direction = 1

        while (y < size.height) {
            val offsetX = dividerX + (amplitude * direction)
            path.lineTo(offsetX, y)
            y += step
            direction *= -1
        }

        path.lineTo(dividerX, size.height)

        drawPath(
            path = path,
            color = color,
            style = Stroke(
                width = 1f,
                cap = StrokeCap.Round
            )
        )
    }
}