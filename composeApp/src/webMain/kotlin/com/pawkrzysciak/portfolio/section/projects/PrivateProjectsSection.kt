package com.pawkrzysciak.portfolio.section.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.pawkrzysciak.portfolio.fakes.sampleProjects
import com.pawkrzysciak.portfolio.fakes.verticalProjects
import com.pawkrzysciak.portfolio.section.projects.components.ProjectCard
import com.pawkrzysciak.portfolio.section.projects.components.VerticalProjectCard
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.draw


@Composable
fun PrivateProjectsSection(items: List<ProjectItem> = remember { sampleProjects }) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .border(1.dp, Color.LightGray)
            .background(Color.White),
    ) {
        Text(
            text = "Prywatne projekty",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(horizontal = GetLayoutPadding(), vertical = 40.dp)
        )
        Box(
            modifier = Modifier.fillMaxWidth().height(550.dp).background(color = Color.White),
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
                items(items.count()) { index ->
                    ProjectCard(items[index])
                }
                items(verticalProjects.count()) { index ->
                    VerticalProjectCard(verticalProjects[index])
                }
            }

        }
        FlowRow(
            modifier = Modifier.padding(vertical = 40.dp),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ) {
            TechnologiesAndToolsSection()
            Image(
                painter = painterResource(Res.drawable.draw),
                contentDescription = null,
                modifier = Modifier.weight(1f).size(600.dp),
            )

        }
    }
}
