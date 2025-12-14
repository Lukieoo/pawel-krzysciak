package com.pawkrzysciak.portfolio.section.aboutme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import com.pawkrzysciak.portfolio.translation.CurrentStrings

@Composable
fun AboutMeSection(modifier: Modifier) {
    val animationPlayed = rememberSaveable { mutableStateOf(false) }
    val experienceYears = 6
    val animatedExperience by animateIntAsState(
        targetValue = if (animationPlayed.value) experienceYears else 0,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    LaunchedEffect(Unit) { animationPlayed.value = true }

    var visible by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    Column {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray,
            thickness = 1.dp
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = GetLayoutPadding(), vertical = 120.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            FlowRow(
                verticalArrangement = Arrangement.Center,
                horizontalArrangement = Arrangement.Center,
                itemVerticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(animationSpec = tween(800)) +
                            slideInVertically(
                                initialOffsetY = { it / 2 },
                                animationSpec = tween(800)
                            )
                ) {
                    AboutMeTextColumn(
                        modifier = Modifier.weight(1f),
                    )
                }

                ExperienceColumn(
                    modifier = Modifier.weight(1f),
                    animatedExperience = animatedExperience
                )
            }
        }
    }
}

@Composable
fun AboutMeTextColumn(modifier: Modifier) {
    Column(modifier = modifier.widthIn(max = 900.dp)) {
        Text(
            text = CurrentStrings.strings.aboutMe,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = CurrentStrings.strings.aboutMeDesc,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
            ),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ExperienceColumn(modifier: Modifier, animatedExperience: Int) {
    Column(
        modifier = modifier
            .height(IntrinsicSize.Max)
            .padding(top = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "+ $animatedExperience " + CurrentStrings.strings.years,
            style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = CurrentStrings.strings.commercialExperience,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}