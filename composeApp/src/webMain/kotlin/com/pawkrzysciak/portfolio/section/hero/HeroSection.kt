package com.pawkrzysciak.portfolio.section.hero

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
import com.pawkrzysciak.portfolio.section.hero.components.BackgroundGrid
import com.pawkrzysciak.portfolio.section.hero.components.FloatingTechWordsTypewriter
import com.pawkrzysciak.portfolio.theme.AppColors
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import com.pawkrzysciak.portfolio.theme.SectionAccentBar
import com.pawkrzysciak.portfolio.translation.CurrentStrings

@Composable
fun HeroSection(modifier: Modifier) {
    val windowSize = rememberWindowSize()

    BoxWithConstraints(
        modifier = modifier
            .defaultMinSize(minHeight = windowSize.height)
            .background(Color.White),
    ) {
        BackgroundGrid(windowSize = windowSize)
        FloatingTechWordsTypewriter(windowSize = windowSize)
        HeroMainSection()
        ScrollDownIndicator()
    }
}

@Composable
private fun BoxScope.HeroMainSection() {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to Color.White,
                        0.6f to Color.White,
                        1.0f to Color.White.copy(alpha = 0f)
                    )
                )
            )
            .padding(horizontal = GetLayoutPadding(), vertical = 120.dp)
            .align(Alignment.CenterStart),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(800)) +
                    slideInVertically(initialOffsetY = { it / 2 }, animationSpec = tween(800))
        ) {
            Column {
                Text(
                    text = CurrentStrings.strings.heroTitleSection,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontWeight = FontWeight.Bold,
                        lineHeight = 52.sp,
                    ),
                )
                Spacer(Modifier.height(8.dp))
                SectionAccentBar(width = 80.dp)
            }
        }

        Spacer(Modifier.height(28.dp))

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(1000, delayMillis = 300)) +
                    slideInVertically(
                        initialOffsetY = { it / 2 },
                        animationSpec = tween(1000, delayMillis = 300)
                    )
        ) {
            Text(
                text = CurrentStrings.strings.heroDescSection,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
                ),
                modifier = Modifier.widthIn(max = 800.dp),
                textAlign = TextAlign.Justify
            )
        }

        Spacer(Modifier.height(32.dp))

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(1000, delayMillis = 600)) +
                    slideInVertically(
                        initialOffsetY = { it / 2 },
                        animationSpec = tween(1000, delayMillis = 600)
                    )
        ) {
            HeroStats()
        }
    }
}

@Composable
private fun HeroStats() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatItem(value = "6+", label = CurrentStrings.strings.statExperienceLabel)
        StatDivider()
        StatItem(value = "1M+", label = CurrentStrings.strings.statUsersLabel)
        StatDivider()
        StatItem(value = "3", label = CurrentStrings.strings.statCompaniesLabel)
    }
}

@Composable
private fun StatItem(value: String, label: String) {
    Column {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = AppColors.KotlinPurple
            )
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )
        )
    }
}

@Composable
private fun StatDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(36.dp)
            .background(AppColors.KotlinPurple.copy(alpha = 0.2f))
    )
}

@Composable
private fun BoxScope.ScrollDownIndicator() {
    val infiniteTransition = rememberInfiniteTransition(label = "scroll_arrow")
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 700, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bounce"
    )

    Text(
        text = "↓",
        color = AppColors.KotlinPurple.copy(alpha = 0.45f),
        fontSize = 28.sp,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 20.dp)
            .offset(y = offsetY.dp)
    )
}
