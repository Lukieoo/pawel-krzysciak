package com.pawkrzysciak.portfolio.section.start

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
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
    val windowsSize = rememberWindowSize()

    val currentSection by rememberSaveable(windowsSize, scrollState) {
        derivedStateOf {
            scrollState.layoutInfo.visibleItemsInfo.firstOrNull { itemInfo -> itemInfo.offset > -100 }?.key
                ?: CurrentStrings.strings.navHome
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
                    if (section == CurrentStrings.strings.navHome) {
                        window.location.reload()
                    } else {
                        coroutineScope.launch {
                            val targetIndex = sections.indexOf(section)
                            scrollState.animateScrollToItem(targetIndex)
                        }
                    }
                },
                modifier = Modifier
                    .height(38.dp)
                    .widthIn(min = 100.dp)
                    .pointerHoverIcon(PointerIcon.Hand)
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