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
import com.pawkrzysciak.portfolio.section.footer.FooterSection
import com.pawkrzysciak.portfolio.section.hero.HeroSection
import com.pawkrzysciak.portfolio.section.projects.PrivateProjectsSection
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
        PrivateProjectsSection()
        FooterSection()
    }
}