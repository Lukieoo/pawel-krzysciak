package com.pawkrzysciak.portfolio.section.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pawkrzysciak.portfolio.section.education.EducationSection
import com.pawkrzysciak.portfolio.section.experience.ExperienceSection

@Composable
fun TimelineSection(modifier: Modifier) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        ExperienceSection(modifier = Modifier.weight(1f))
        EducationSection(modifier = Modifier.weight(1f))
    }
}