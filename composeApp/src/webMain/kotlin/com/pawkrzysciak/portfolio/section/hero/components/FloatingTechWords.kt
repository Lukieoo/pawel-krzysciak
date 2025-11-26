package com.pawkrzysciak.portfolio.section.hero.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.reenie_beanie_regular

fun generateTechWords(
    viewportHeight: Dp,
    viewportWidth: Dp,
): List<TechWord> {
    val techWords = listOf(
        TechWord("Kotlin", x = 300.dp, y = 50.dp, scale = 2.2f, rotation = -12f),
        TechWord("Android", x = 500.dp, y = 100.dp, scale = 1.0f, rotation = 8f),
        TechWord("KMP", x = 700.dp, y = 180.dp, scale = 1.3f, rotation = -5f),
        TechWord("Compose", x = 900.dp, y = 250.dp, scale = 2.1f, rotation = 10f),
        TechWord("Room", x = 1100.dp, y = 320.dp, scale = 0.9f, rotation = -7f),
        TechWord("MVVM", x = 350.dp, y = 400.dp, scale = 1.5f, rotation = 12f),
        TechWord("MVI", x = 650.dp, y = 470.dp, scale = 1.2f, rotation = -15f),
        TechWord("Clean Architecture", x = 950.dp, y = 540.dp, scale = 1.1f, rotation = -5f),
        TechWord("Coroutines", x = 1150.dp, y = 600.dp, scale = 2.8f, rotation = 6f),
        TechWord("Jetpack", x = 800.dp, y = 660.dp, scale = 1.55f, rotation = -10f),
        TechWord("StateFlow", x = 600.dp, y = 720.dp, scale = 0.95f, rotation = 4f),
        TechWord("Ktor", x = 900.dp, y = 780.dp, scale = 2.5f, rotation = -6f),
        TechWord("Serialization", x = 1000.dp, y = 840.dp, scale = 1.05f, rotation = 7f),
        TechWord("Moshi", x = 1200.dp, y = 900.dp, scale = 1.0f, rotation = -9f),
        TechWord("ViewModel", x = 1250.dp, y = 960.dp, scale = 1.05f, rotation = 5f),
        TechWord("DataStore", x = 650.dp, y = 1020.dp, scale = 1.0f, rotation = -7f),
        TechWord("Retrofit", x = 850.dp, y = 1080.dp, scale = 1.1f, rotation = 6f),
        TechWord("OkHttp", x = 1050.dp, y = 1140.dp, scale = 0.95f, rotation = -8f),
        TechWord("MockK", x = 350.dp, y = 1200.dp, scale = 1.9f, rotation = 4f),
        TechWord("Espresso", x = 850.dp, y = 1060.dp, scale = 1.05f, rotation = -5f),
        TechWord("Android Studio", x = 900.dp, y = 140.dp, scale = 2.1f, rotation = -7f),
        TechWord("JetBrains", x = 1500.dp, y = 240.dp, scale = 2.1f, rotation = -7f),
        TechWord("Docker", x = 900.dp, y = 300.dp, scale = 1.05f, rotation = 6f),
        TechWord("Charles", x = 1100.dp, y = 360.dp, scale = 0.95f, rotation = -8f),
        TechWord("Jira", x = 800.dp, y = 420.dp, scale = 2.0f, rotation = 5f),
        TechWord("Agile", x = 1500.dp, y = 480.dp, scale = 1.05f, rotation = -6f),
        TechWord("Scrum", x = 1300.dp, y = 550.dp, scale = 2.8f, rotation = 8f),
        TechWord("Kanban", x = 1600.dp, y = 620.dp, scale = 0.95f, rotation = -5f),
        TechWord("Trello", x = 1350.dp, y = 680.dp, scale = 1.0f, rotation = 7f),
        TechWord("Postman", x = 1600.dp, y = 740.dp, scale = 1.05f, rotation = -8f),
        TechWord("Figma", x = 1850.dp, y = 800.dp, scale = 2.0f, rotation = 6f),
        TechWord("Firebase", x = 1100.dp, y = 860.dp, scale = 1.05f, rotation = -7f),
        TechWord("Glide", x = 1400.dp, y = 920.dp, scale = 0.95f, rotation = 5f),
        TechWord("Coil", x = 1650.dp, y = 980.dp, scale = 1.0f, rotation = -6f),
        TechWord("Hilt", x = 900.dp, y = 1040.dp, scale = 1.1f, rotation = 7f),
        TechWord("Dagger", x = 1150.dp, y = 1100.dp, scale = 0.95f, rotation = -5f),
        TechWord("Ollama", x = 750.dp, y = 1000.dp, scale = 1.95f, rotation = -15f),
        TechWord("AI", x = 1250.dp, y = 200.dp, scale = 3.95f, rotation = 10f),
    )
    return techWords
}

@Composable
fun HandwritingFont() = Font(Res.font.reenie_beanie_regular).toFontFamily()

//@Composable
//fun FloatingTechWords(
//    modifier: Modifier = Modifier,
//    maxHeight: Dp
//) {
//    val words = remember { generateTechWords() }
//    Box(modifier = modifier.fillMaxSize()) {
//        words.forEach { word ->
//            if (word.y > maxHeight) return
//            Text(
//                text = word.text,
//                fontFamily = HandwritingFont(),
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
//                ),
//                modifier = Modifier
//                    .offset(x = word.x, y = word.y)
//                    .graphicsLayer(
//                        scaleX = word.scale,
//                        scaleY = word.scale,
//                        rotationZ = word.rotation
//                    )
//            )
//        }
//    }
//}

@Composable
fun FloatingTechWordsTypewriter(
    modifier: Modifier = Modifier,
    viewportHeight: Dp,
    viewportWidth: Dp,
) {
    val words = remember {
        generateTechWords(
            viewportHeight = viewportHeight,
            viewportWidth = viewportWidth
        )
    }

    Box(modifier = modifier.fillMaxSize()) {
        words.forEach { word ->
            if (word.y > viewportHeight) return@forEach

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
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
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