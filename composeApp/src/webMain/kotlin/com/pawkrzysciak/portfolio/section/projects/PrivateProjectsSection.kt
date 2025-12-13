package com.pawkrzysciak.portfolio.section.projects

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.config.SHOW_BASE_CARD_VIEW_ITEM_ONLY
import com.pawkrzysciak.portfolio.fakes.sampleProjects
import com.pawkrzysciak.portfolio.fakes.verticalProjects
import com.pawkrzysciak.portfolio.section.projects.components.BaseProjectCard
import com.pawkrzysciak.portfolio.section.projects.components.ProjectCard
import com.pawkrzysciak.portfolio.section.projects.components.VerticalProjectCard
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import kotlinx.coroutines.launch


@Composable
fun PrivateProjectsSection(
    modifier: Modifier,
    itemsHorizontal: List<ProjectItem> = remember { sampleProjects },
    itemsVertical: List<ProjectItem> = remember { verticalProjects },
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .background(Color.White),
    ) {
        Text(
            text = "Prywatne projekty",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(horizontal = GetLayoutPadding(), vertical = 40.dp)
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(if (SHOW_BASE_CARD_VIEW_ITEM_ONLY) 450.dp else 550.dp)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            LazyRow(
                state = listState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        coroutineScope.launch {
                            listState.scrollBy(-delta)
                        }
                    },
                    onDragStopped = { velocity ->
                        coroutineScope.launch {
                            listState.animateScrollBy(velocity / 10)
                        }
                    }
                )
            ) {
                if (SHOW_BASE_CARD_VIEW_ITEM_ONLY) {
                    val baseItems = itemsHorizontal + itemsVertical
                    items(baseItems.count()) { index ->
                        BaseProjectCard(baseItems[index])
                    }
                } else {
                    items(itemsHorizontal.count()) { index ->
                        ProjectCard(itemsHorizontal[index])
                    }
                    items(itemsVertical.count()) { index ->
                        VerticalProjectCard(verticalProjects[index])
                    }
                }
            }
        }
    }
}
