package com.pawkrzysciak.portfolio.section.aboutme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutMeSection() {
    Column {
        Text(
            text = "O mnie", style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.SemiBold
            )
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "I'm a Computer Science Engineer and Android developer with more than 6 years of commercial experience building mobile applications.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}