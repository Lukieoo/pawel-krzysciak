package com.pawkrzysciak.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pawkrzysciak.portfolio.extensions.parallaxLayoutModifier
import com.pawkrzysciak.portfolio.section.aboutme.AboutMeSection
import com.pawkrzysciak.portfolio.section.hero.HeroSection
import com.pawkrzysciak.portfolio.section.timeline.TimelineSection

@Composable
fun App() {
    MaterialTheme {
        PortfolioPage()
    }
}

@Composable
fun PortfolioPage() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
    ) {
        HeroSection(modifier = Modifier.parallaxLayoutModifier(scrollState, 2))
        AboutMeSection()
        TimelineSection()
    }
}


//
//@Composable
//fun TechnologiesSection() {
//    Column {
//        Text(
//            text = "Technologie", style = MaterialTheme.typography.headlineMedium.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//        )
//
//        Spacer(Modifier.height(20.dp))
//
//        FlowRow(
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            listOf("Kotlin", "Jetpack Compose", "MVVM", "MVI").forEach {
//                TechChip(it)
//            }
//        }
//    }
//}
//
//@Composable
//fun TechChip(name: String) {
//    val alpha = animateFloatAsState(
//        targetValue = 1f, animationSpec = tween(600)
//    )
//
//    Box(modifier = Modifier.graphicsLayer { this.alpha = alpha.value }.background(
//            MaterialTheme.colorScheme.primary.copy(alpha = 0.12f), RoundedCornerShape(12.dp)
//        ).border(
//            1.dp,
//            MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
//            RoundedCornerShape(12.dp)
//        ).padding(horizontal = 16.dp, vertical = 10.dp)) {
//        Text(
//            text = name, style = MaterialTheme.typography.bodyMedium.copy(
//                fontWeight = FontWeight.Medium
//            )
//        )
//    }
//}
//
//@Composable
//fun ContactSection(email: String) {
//    Column {
//        Text(
//            text = "Kontakt", style = MaterialTheme.typography.headlineMedium.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//        )
//
//        Spacer(Modifier.height(16.dp))
//
//        Text(
//            text = "Jeśli chcesz się skontaktować, napisz na:",
//            style = MaterialTheme.typography.bodyLarge
//        )
//
//        Spacer(Modifier.height(12.dp))
//
//        Text(
//            text = email, style = MaterialTheme.typography.bodyLarge.copy(
//                fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary
//            )
//        )
//    }
//}
//
//@Composable
//fun FooterSection() {
//    Box(
//        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "© 2025 Paweł Krzyściak • All rights reserved",
//            style = MaterialTheme.typography.bodySmall.copy(
//                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
//            )
//        )
//    }
//}