package com.pawkrzysciak.portfolio.section.projects.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.section.projects.ProjectItem
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectCard(project: ProjectItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .background(color = Color.White.copy(alpha = 0.8f))
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
    ) {
        ImageCarousel(
            imageUrls = project.previewImagesUrls,
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(12.dp)),
            backgroundColor = project.backgroundColor,
            cropPadding = true
        )
        Column(Modifier.padding(8.dp).width(300.dp)) {
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
                            text = CurrentStrings.strings.archive,
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
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
            }
            project.githubUrl?.let {
                Spacer(Modifier.height(8.dp))
                LinkButton(label = "Github", it)
            }
            project.youtubeUrl?.let {
                Spacer(Modifier.height(8.dp))
                LinkButton(label = "Youtube", it)
            }
        }
    }
}
