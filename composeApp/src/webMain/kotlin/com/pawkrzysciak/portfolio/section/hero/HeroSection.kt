package com.pawkrzysciak.portfolio.section.hero

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.section.hero.components.BackgroundGrid
import com.pawkrzysciak.portfolio.section.hero.components.BlurredBlobs
import com.pawkrzysciak.portfolio.section.hero.components.FloatingTechWordsTypewriter
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.draw

@Composable
fun HeroSection() {
    val windowInfo = LocalWindowInfo.current
    val viewportHeight = windowInfo.containerSize.height.dp
    val viewportWidth = windowInfo.containerSize.width.dp

    Box(
        modifier = Modifier
            .height(viewportHeight)
            .background(Color.White)
    ) {
        BackgroundGrid(height = viewportHeight)
        FloatingTechWordsTypewriter(viewportHeight = viewportHeight, viewportWidth = viewportWidth)
        AndroidDraw()
        HeroMainSection(viewportHeight = viewportHeight)
    }
}

@Composable
private fun AndroidDraw() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
    ) {
        Image(
            painter = painterResource(Res.drawable.draw),
            contentDescription = null,
            modifier = Modifier.size(500.dp)
        )
    }
}

@Composable
private fun HeroMainSection(viewportHeight: Dp) {
    BlurredBlobs(height = viewportHeight, max = 900.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.pointerInput(Unit) {},
            text = "Buduję aplikacje Android,\nktóre realnie wspierają cele biznesowe.",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.Bold,
                lineHeight = 52.sp,
            ),
        )
        Spacer(Modifier.height(28.dp))
        Text(
            text = "Stawiam na jakość kodu, testowalność i długoterminową stabilność projektu. Korzystam z Kotlina, Jetpack Compose, modularizacji i clean architecture.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
            ),
            modifier = Modifier.widthIn(max = 700.dp)
        )
    }
}