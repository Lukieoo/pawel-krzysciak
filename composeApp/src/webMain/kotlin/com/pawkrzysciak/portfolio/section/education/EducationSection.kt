package com.pawkrzysciak.portfolio.section.education

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EducationSection(modifier: Modifier) {
    val educationList = listOf(
        EducationData(
            school = "Politechnika Krakowska",
            degree = "Inżynier informatyki",
            period = "2020 — 2024"
        ),
        EducationData(
            school = "ZST-Tarnów",
            degree = "Technik informatyk",
            period = "2015 — 2019"
        )
    )

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Edukacja",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.SemiBold
            )
        )

        Spacer(Modifier.height(32.dp))

        educationList.forEach { edu ->
            EducationItem(
                education = edu,
            )
            Spacer(Modifier.height(24.dp))
        }
    }
}

data class EducationData(
    val school: String,
    val degree: String,
    val period: String
)

@Composable
fun EducationItem(education: EducationData) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .border(2.dp, Color.Gray, CircleShape)
            )
        }

        Spacer(Modifier.width(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = education.school,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = education.degree,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )
            Text(
                text = education.period,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )
        }
    }
}