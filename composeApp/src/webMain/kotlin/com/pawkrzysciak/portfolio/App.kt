package com.pawkrzysciak.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
import com.pawkrzysciak.portfolio.extensions.parallaxLayoutModifier
import com.pawkrzysciak.portfolio.section.aboutme.AboutMeSection
import com.pawkrzysciak.portfolio.section.contact.ContactSection
import com.pawkrzysciak.portfolio.section.footer.FooterSection
import com.pawkrzysciak.portfolio.section.hero.HeroSection
import com.pawkrzysciak.portfolio.section.projects.PrivateProjectsSection
import com.pawkrzysciak.portfolio.section.start.ButtonFlags
import com.pawkrzysciak.portfolio.section.start.DesktopMenu
import com.pawkrzysciak.portfolio.section.technologies.TechnologiesAndToolsSection
import com.pawkrzysciak.portfolio.section.timeline.TimelineSection
import com.pawkrzysciak.portfolio.theme.isMobile
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import kotlin.js.ExperimentalWasmJsInterop

@Composable
fun App() {
    MaterialTheme {
        PortfolioPage()
    }
}

@OptIn(ExperimentalWasmJsInterop::class)
@Composable
fun PortfolioPage() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val windowsSize = rememberWindowSize()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            item(CurrentStrings.strings.navHome) {
                HeroSection(modifier = Modifier.parallaxLayoutModifier(listState, 2))
            }
            item(CurrentStrings.strings.navAboutMe) {
                AboutMeSection(modifier = Modifier)
            }
            item(CurrentStrings.strings.navTimeline) {
                TimelineSection(modifier = Modifier)
            }
            item(CurrentStrings.strings.navProjects) {
                PrivateProjectsSection(modifier = Modifier)
            }
            item(CurrentStrings.strings.navTechnologies) {
                TechnologiesAndToolsSection(modifier = Modifier)
            }
            item(CurrentStrings.strings.navContact) {
                ContactSection(modifier = Modifier)
            }
            item {
                FooterSection()
            }
        }
        ButtonFlags(Modifier.align(Alignment.TopStart).padding(16.dp))
        if (!isMobile && windowsSize.width > 800.dp) {
            DesktopMenu(
                modifier = Modifier.align(Alignment.TopEnd),
                scrollState = listState,
                coroutineScope = coroutineScope
            )
        }
    }
}
