package com.pawkrzysciak.portfolio

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
import com.pawkrzysciak.portfolio.extensions.parallaxLayoutModifier
import com.pawkrzysciak.portfolio.section.aboutme.AboutMeSection
import com.pawkrzysciak.portfolio.section.footer.FooterSection
import com.pawkrzysciak.portfolio.section.hero.HeroSection
import com.pawkrzysciak.portfolio.section.projects.PrivateProjectsSection
import com.pawkrzysciak.portfolio.section.technologies.TechnologiesAndToolsSection
import com.pawkrzysciak.portfolio.section.timeline.TimelineSection
import com.pawkrzysciak.portfolio.theme.isMobile
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
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
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val sectionOffsets = remember { mutableMapOf<String, Int>() }
    val windowsSize = rememberWindowSize()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
        ) {
            HeroSection(
                modifier = Modifier
                    .parallaxLayoutModifier(scrollState, 2)
                    .onGloballyPositioned { coordinates ->
                        sectionOffsets["Home"] = coordinates.positionInParent().y.toInt()
                    })
            AboutMeSection(
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    sectionOffsets["O mnie"] = coordinates.positionInParent().y.toInt()
                })
            TimelineSection(
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    sectionOffsets["Oś czasu"] = coordinates.positionInParent().y.toInt()
                })
            PrivateProjectsSection(
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    sectionOffsets["Projekty"] = coordinates.positionInParent().y.toInt()
                })
            TechnologiesAndToolsSection(
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    sectionOffsets["Technologie"] = coordinates.positionInParent().y.toInt()
                })
            FooterSection()
        }
        if (isMobile.not() && windowsSize.width > 800.dp) {
            DesktopMenu(
                modifier = Modifier.align(Alignment.TopEnd),
                sectionOffsets = sectionOffsets,
                scrollState = scrollState,
                coroutineScope = coroutineScope
            )
        }
    }
}

@Composable
fun DesktopMenu(
    sectionOffsets: Map<String, Int>,
    scrollState: ScrollState,
    coroutineScope: CoroutineScope,
    modifier: Modifier
) {
    val sections = listOf("Home", "O mnie", "Oś czasu", "Projekty", "Technologie")
    val windowsSize = rememberWindowSize()
    val currentSection by remember(windowsSize) {
        derivedStateOf {
            val scrollY = scrollState.value + windowsSize.height.value / 2
            sections.lastOrNull { section ->
                sectionOffsets[section]?.let { offset ->
                    scrollY >= offset
                } ?: false
            } ?: "Home"
        }
    }

    Row(
        modifier = modifier
            .padding(horizontal = 32.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        sections.forEach { section ->
            val isActive = section == currentSection

            val backgroundColor by animateColorAsState(
                targetValue = if (isActive) Color.Black else Color.White,
                animationSpec = tween(durationMillis = 300)
            )
            val contentColor by animateColorAsState(
                targetValue = if (isActive) Color.White else Color.Black,
                animationSpec = tween(durationMillis = 300)
            )

            Button(
                onClick = {
                    if (section == "Home") {
                        window.location.reload()
                    } else {
                        sectionOffsets[section]?.let { y ->
                            coroutineScope.launch {
                                scrollState.animateScrollTo(y)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .height(38.dp)
                    .widthIn(min = 100.dp)
                    .clip(RoundedCornerShape(6.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = backgroundColor,
                    contentColor = contentColor
                ),
                border = BorderStroke(1.dp, Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = section,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}