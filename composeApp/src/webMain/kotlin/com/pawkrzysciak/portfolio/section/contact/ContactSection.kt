package com.pawkrzysciak.portfolio.section.contact

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
import com.pawkrzysciak.portfolio.section.hero.components.BackgroundGrid
import com.pawkrzysciak.portfolio.section.hero.components.FloatingTechWordsTypewriter
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import kotlinx.browser.window

@Composable
fun ContactSection(modifier: Modifier) {
    val windowSize = rememberWindowSize()

    BoxWithConstraints(
        modifier = modifier
            .defaultMinSize(minHeight = windowSize.height)
            .background(Color.White),
    ) {
        BackgroundGrid(windowSize = windowSize)
        FloatingTechWordsTypewriter(windowSize = windowSize)
        Box(
            modifier = modifier.defaultMinSize(minHeight = windowSize.height).fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            ContactNoteCard()
        }
    }
}


@Composable
fun BoxScope.ContactNoteCard() {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(horizontal = GetLayoutPadding(), vertical = 120.dp)
            .align(Alignment.CenterStart),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        ContactBody()
    }
}

@Composable
private fun ContactBody() {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        visible = true
    }
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 800)) +
                    slideInVertically(
                        initialOffsetY = { it / 2 },
                        animationSpec = tween(durationMillis = 800)
                    )
        ) {
            Column {
                Text(
                    text = "Paweł Krzyściak",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    text = "Polska · Kraków · Zdalnie",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray
                )
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF9E9E9E)
                )

                EmailText("pawkrzysciak@gmail.com")
            }
        }
    }
}

@Composable
fun EmailText(email: String) {
    Text(
        text = email,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable {
                window.location.href = "mailto:$email"
            }
    )
}