package com.pawkrzysciak.portfolio.section.hero.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.reenie_beanie_regular
import kotlin.random.Random

fun generateTechWords(
    viewportHeight: Dp,
    viewportWidth: Dp,
    random: Random = Random.Default
): List<TechWord> {
    val texts = listOf(
        "Kotlin", "Android", "KMP", "Compose", "Room", "MVVM", "MVI",
        "Clean Architecture", "Coroutines", "Jetpack", "StateFlow", "Ktor",
        "Serialization", "Moshi", "ViewModel", "DataStore", "Retrofit", "OkHttp",
        "MockK", "Espresso", "Android Studio", "JetBrains", "Docker", "Charles",
        "Jira", "Agile", "Scrum", "Kanban", "Trello", "Postman", "Figma",
        "Firebase", "Glide", "Coil", "Hilt", "Dagger", "Ollama", "AI"
    ).run { if (viewportWidth < 800.dp) take(6) else this }

    return texts.mapIndexed { index, text ->
        val xBase = 0.1f + (index % 6) * 0.15f
        val yBase = 0.05f + (index / 6) * 0.15f

        val xChaos = xBase + (random.nextFloat() - 0.5f) * 0.2f
        val yChaos = yBase + (random.nextFloat() - 0.5f) * 0.2f

        val scale = 0.8f + random.nextFloat() * 1.2f
        val rotation = random.nextInt(-20, 21).toFloat()

        TechWord(
            text = text,
            x = (viewportWidth.value * xChaos.coerceIn(0.0f, 1.0f)).dp,
            y = (viewportHeight.value * yChaos.coerceIn(0.0f, 1.0f)).dp,
            scale = scale,
            rotation = rotation
        )
    }
}

@Composable
fun HandwritingFont() = Font(Res.font.reenie_beanie_regular).toFontFamily()


@Composable
fun FloatingTechWordsTypewriter(
    windowSize: DpSize,
) {
    val words = remember(windowSize) {
        generateTechWords(
            viewportHeight = windowSize.height,
            viewportWidth = windowSize.width
        )
    }
    Box(modifier = Modifier.size(windowSize)) {
        words.forEach { word ->
            if (word.y > windowSize.height) return@forEach

            var visibleChars by remember { mutableStateOf(0) }

            LaunchedEffect(Unit) {
                delay((0..2000L).random())
                for (i in 1..word.text.length) {
                    visibleChars = i
                    delay(50L)
                }
            }

            Text(
                text = word.text.take(visibleChars),
                fontFamily = HandwritingFont(),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.65f)
                ),
                modifier = Modifier
                    .offset(x = word.x, y = word.y)
                    .graphicsLayer(
                        scaleX = word.scale,
                        scaleY = word.scale,
                        rotationZ = word.rotation
                    )
            )
        }
    }
}