package com.pawkrzysciak.portfolio.section.projects.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.section.projects.ProjectItem
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import org.jetbrains.compose.resources.painterResource

@Composable
fun BaseProjectCard(project: ProjectItem) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
            .background(color = Color.White.copy(alpha = 0.8f))
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
    ) {
        Column(Modifier.padding(16.dp).width(350.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(project.iconUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(
                        text = project.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (project.isArchived) {
                        Text(
                            text = "ARCHIWALNA",
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))
            Text(
                text = project.description,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
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
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                project.playStoreUrl?.let {
                    LinkButton(label = "Google Play", it)
                }
                project.externalUrl?.let {
                    LinkButton(label = "itch.io", it)
                }
                project.githubUrl?.let {
                    LinkButton(label = "Github", it)
                }
                project.youtubeUrl?.let {
                    LinkButton(label = "Youtube", it)
                }
            }
        }
    }
}
