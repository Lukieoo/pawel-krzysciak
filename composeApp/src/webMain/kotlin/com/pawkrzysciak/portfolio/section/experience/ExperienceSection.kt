package com.pawkrzysciak.portfolio.section.experience

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.fakes.experiences
import com.pawkrzysciak.portfolio.section.timeline.TornSide
import com.pawkrzysciak.portfolio.section.timeline.tornBorder
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding


@Composable
fun ExperienceSection(modifier: Modifier) {
    var visible by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = fadeIn(animationSpec = tween(800)) + slideInHorizontally(
            initialOffsetX = { fullWidth -> -fullWidth }, animationSpec = tween(800)
        )
    ) {
        Column(
            modifier = Modifier.defaultMinSize(minWidth = 600.dp)
                .padding(horizontal = GetLayoutPadding(), vertical = 20.dp),
        ) {
            Text(
                text = "Doświadczenie", style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(Modifier.height(32.dp))

            experiences.forEach { exp ->
                ExperienceItemWithCanvas(
                    experience = exp,
                )
                Spacer(Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun ExperienceItemWithCanvas(experience: ExperienceData) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(40.dp)
        ) {
            Box(
                modifier = Modifier.size(12.dp).border(
                    width = 2.dp, color = Color.Gray, shape = CircleShape
                )
            )
        }
        Spacer(Modifier.width(16.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = experience.company,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = experience.role,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )

            Text(
                text = experience.period,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )

            Text(
                text = experience.location,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = experience.description,
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
            )
        }
    }
}
