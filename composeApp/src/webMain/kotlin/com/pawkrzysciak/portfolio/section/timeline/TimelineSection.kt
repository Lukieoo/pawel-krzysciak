package com.pawkrzysciak.portfolio.section.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.section.education.EducationSection
import com.pawkrzysciak.portfolio.section.experience.ExperienceSection
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding

@Composable
fun TimelineSection(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = GetLayoutPadding(), vertical = 80.dp)
    ) {
        FlowRow {
            ExperienceSection(modifier = Modifier.weight(1f))
            EducationSection(modifier = Modifier.weight(1f))
        }
    }
}