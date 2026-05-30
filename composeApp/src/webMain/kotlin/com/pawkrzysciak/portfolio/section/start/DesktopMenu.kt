package com.pawkrzysciak.portfolio.section.start

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.theme.AppColors
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DesktopMenu(
    scrollState: LazyListState,
    coroutineScope: CoroutineScope,
    modifier: Modifier
) {
    val sections = listOf(
        CurrentStrings.strings.navHome,
        CurrentStrings.strings.navAboutMe,
        CurrentStrings.strings.navTimeline,
        CurrentStrings.strings.navProjects,
        CurrentStrings.strings.navTechnologies,
        CurrentStrings.strings.navContact,
    )

    val currentSection by remember(scrollState) {
        derivedStateOf {
            val sectionKeys = sections.toSet()
            scrollState.layoutInfo.visibleItemsInfo
                .firstOrNull { it.offset > -100 && sectionKeys.contains(it.key) }
                ?.key as? String
                ?: CurrentStrings.strings.navHome
        }
    }

    // Nav bar height = 12dp top padding + 38dp button + 12dp bottom padding + 2dp gradient = 64dp
    // Negative scrollOffset positions the section below the nav bar instead of behind it
    val density = LocalDensity.current
    val navBarOffsetPx = with(density) { (-68).dp.roundToPx() }

    Column(modifier = modifier.background(Color.White.copy(alpha = 0.95f))) {
        Row(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            sections.forEach { section ->
                val isActive = section == currentSection
                val textColor by animateColorAsState(
                    targetValue = if (isActive) Color.White else Color.Black,
                    animationSpec = tween(durationMillis = 300)
                )

                Box(
                    modifier = Modifier
                        .height(38.dp)
                        .widthIn(min = 100.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .then(
                            if (isActive)
                                Modifier.background(AppColors.KotlinGradient)
                            else
                                Modifier
                                    .background(Color.White)
                                    .border(1.dp, Color.Black.copy(alpha = 0.15f), RoundedCornerShape(6.dp))
                        )
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable {
                            if (section == CurrentStrings.strings.navHome) {
                                window.location.reload()
                            } else {
                                coroutineScope.launch {
                                    scrollState.animateScrollToItem(
                                        index = sections.indexOf(section) * 2,
                                        scrollOffset = navBarOffsetPx
                                    )
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = section,
                        style = MaterialTheme.typography.labelMedium,
                        color = textColor,
                        fontWeight = if (isActive) FontWeight.Bold else FontWeight.SemiBold
                    )
                }
            }
        }
        Box(Modifier.fillMaxWidth().height(2.dp).background(AppColors.KotlinGradient))
    }
}
