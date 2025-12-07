package com.pawkrzysciak.portfolio.section.projects

data class ProjectItem(
    val id: String,
    val title: String,
    val description: String,
    val previewImagesUrls: List<String>,
    val iconUrl: String,
    val githubUrl: String? = null,
    val playStoreUrl: String? = null,
    val externalUrl: String? = null,
    val isArchived: Boolean = false
)