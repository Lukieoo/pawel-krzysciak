package com.pawkrzysciak.portfolio.section.projects.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.section.projects.ProjectItem
import com.pawkrzysciak.portfolio.theme.AppColors
import com.pawkrzysciak.portfolio.translation.CurrentStrings

@Composable
fun VerticalProjectCard(project: ProjectItem) {
    Box(
        modifier = Modifier
            .width(900.dp)
            .padding(12.dp)
            .background(color = Color.White)
    ) {
        ImageCarousel(
            imageUrls = project.previewImagesUrls,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            backgroundColor = project.backgroundColor,
            cropPadding = project.cropPadding,
            isVertical = true
        )
        Column(
            Modifier
                .width(700.dp)
                .shadow(6.dp, RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White)
                .border(1.dp, AppColors.KotlinPurple.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                .padding(12.dp)
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = project.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            if (project.isNew) {
                Text(
                    text = CurrentStrings.strings.new,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(8.dp))
            Text(text = project.description, fontSize = 14.sp, modifier = Modifier)
            if (project.githubUrl != null || project.externalUrl != null || project.playStoreUrl != null || project.youtubeUrl != null) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = CurrentStrings.strings.seeMore,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                )
                Spacer(Modifier.height(8.dp))
            }
            FlowRow {
                project.playStoreUrl?.let {
                    Spacer(Modifier.width(8.dp))
                    LinkButton(label = "Google Play", it)
                }
                project.externalUrl?.let {
                    Spacer(Modifier.width(8.dp))
                    LinkButton(label = project.externalUrlLabel, it)
                }
            }
        }
    }
}