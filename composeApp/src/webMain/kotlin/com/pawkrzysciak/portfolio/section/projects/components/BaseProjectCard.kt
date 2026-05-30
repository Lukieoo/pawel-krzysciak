package com.pawkrzysciak.portfolio.section.projects.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.section.projects.ProjectItem
import com.pawkrzysciak.portfolio.theme.AppColors
import com.pawkrzysciak.portfolio.translation.CurrentStrings

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BaseProjectCard(project: ProjectItem) {
    val headerBg = when {
        project.backgroundColor.alpha < 0.1f -> AppColors.KotlinPurple.copy(alpha = 0.07f)
        project.backgroundColor == Color.White -> AppColors.KotlinPurple.copy(alpha = 0.07f)
        project.backgroundColor == Color.LightGray -> AppColors.KotlinPurple.copy(alpha = 0.07f)
        else -> project.backgroundColor.copy(alpha = 0.14f)
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(340.dp)
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, AppColors.KotlinPurple.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
    ) {
        Box(Modifier.fillMaxWidth().height(3.dp).background(AppColors.KotlinGradient))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerBg)
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(AppColors.KotlinGradient, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = project.emoji,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = project.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 20.sp
                    )
                    if (project.isNew || project.isArchived) {
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            if (project.isNew) {
                                StatusBadge(CurrentStrings.strings.new, AppColors.AndroidGreen)
                            }
                            if (project.isArchived) {
                                StatusBadge(CurrentStrings.strings.archive, AppColors.KotlinOrange)
                            }
                        }
                    }
                }
            }
        }

        Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.KotlinPurple.copy(alpha = 0.08f)))

        Column(Modifier.padding(16.dp)) {
            Text(
                text = project.description,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (project.githubUrl != null || project.externalUrl != null || project.playStoreUrl != null || project.youtubeUrl != null) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = CurrentStrings.strings.seeMore,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.KotlinPurple
                )
                Spacer(Modifier.height(8.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    project.playStoreUrl?.let { LinkButton(label = "Google Play", it) }
                    project.externalUrl?.let { LinkButton(label = project.externalUrlLabel, it) }
                    project.githubUrl?.let { LinkButton(label = "Github", it) }
                    project.youtubeUrl?.let { LinkButton(label = "Youtube", it) }
                }
            }
        }
    }
}

@Composable
private fun StatusBadge(text: String, color: Color) {
    Box(
        modifier = Modifier
            .background(color.copy(alpha = 0.12f), RoundedCornerShape(50))
            .border(1.dp, color.copy(alpha = 0.35f), RoundedCornerShape(50))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(text = text, color = color, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}
