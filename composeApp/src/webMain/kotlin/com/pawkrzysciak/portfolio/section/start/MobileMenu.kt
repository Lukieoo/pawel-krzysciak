package com.pawkrzysciak.portfolio.section.start

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.theme.AppColors
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MobileMenu(
    scrollState: LazyListState,
    coroutineScope: CoroutineScope
) {
    var menuOpen by remember { mutableStateOf(false) }

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
                ?.key as? String ?: CurrentStrings.strings.navHome
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Fullscreen overlay
        AnimatedVisibility(
            visible = menuOpen,
            enter = fadeIn(tween(180)) + slideInVertically(
                initialOffsetY = { -it / 3 },
                animationSpec = tween(280)
            ),
            exit = fadeOut(tween(200)) + slideOutVertically(
                targetOffsetY = { -it / 3 },
                animationSpec = tween(250)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = 0.97f))
            ) {
                Box(Modifier.fillMaxWidth().height(3.dp).background(AppColors.KotlinGradient))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp, bottom = 32.dp, start = 24.dp, end = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    sections.forEachIndexed { index, section ->
                        MobileNavItem(
                            text = section,
                            isActive = section == currentSection,
                            onClick = {
                                menuOpen = false
                                if (section == CurrentStrings.strings.navHome) {
                                    window.location.reload()
                                } else {
                                    coroutineScope.launch {
                                        scrollState.animateScrollToItem(index = index * 2)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }

        // Hamburger / Close button — always on top
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .size(44.dp)
                .shadow(3.dp, CircleShape)
                .clip(CircleShape)
                .background(Color.White)
                .pointerHoverIcon(PointerIcon.Hand)
                .clickable { menuOpen = !menuOpen },
            contentAlignment = Alignment.Center
        ) {
            if (menuOpen) {
                Text(
                    text = "×",
                    fontSize = 28.sp,
                    lineHeight = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light
                )
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    repeat(3) {
                        Box(
                            Modifier
                                .width(18.dp)
                                .height(2.dp)
                                .background(Color.Black.copy(alpha = 0.75f))
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MobileNavItem(text: String, isActive: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(10.dp))
            .then(
                if (isActive)
                    Modifier.background(AppColors.KotlinGradient)
                else
                    Modifier
                        .background(Color.White)
                        .border(1.dp, Color.Black.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isActive) Color.White else Color.Black,
            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Medium
        )
    }
}
