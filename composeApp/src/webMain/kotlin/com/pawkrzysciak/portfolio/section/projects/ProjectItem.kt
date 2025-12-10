package com.pawkrzysciak.portfolio.section.projects

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class ProjectItem(
    val id: String,
    val title: String,
    val description: String,
    val previewImagesUrls: List<DrawableResource>,
    val iconUrl: DrawableResource,
    val githubUrl: String? = null,
    val playStoreUrl: String? = null,
    val externalUrl: String? = null,
    val isArchived: Boolean = false,
    val youtubeUrl: String? = null,
    val cropPadding: Boolean = false,
    val backgroundColor: Color,
)