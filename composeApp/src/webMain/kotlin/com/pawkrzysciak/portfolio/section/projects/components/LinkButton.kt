package com.pawkrzysciak.portfolio.section.projects.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun LinkButton(
    label: String,
    url: String
) {
    val uriHandler = LocalUriHandler.current
    AssistChip(onClick = { uriHandler.openUri(url) }, label = {
        Text(
            text = label,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    })
}