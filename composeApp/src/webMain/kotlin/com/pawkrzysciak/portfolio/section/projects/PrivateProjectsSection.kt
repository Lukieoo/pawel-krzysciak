package com.pawkrzysciak.portfolio.section.projects

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
import com.pawkrzysciak.portfolio.fakes.sampleProjects
import com.pawkrzysciak.portfolio.section.hero.components.BackgroundGrid
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun PrivateProjectsSection(items: List<ProjectItem> = sampleProjects) {
    val listState = rememberLazyListState()
    val windowSize = rememberWindowSize()
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
            BackgroundGrid(windowSize = DpSize(width = windowSize.width, height = 550.dp))
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
            }
        }
    }
}

@Composable
fun ProjectCard(project: ProjectItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .background(color = Color.White.copy(alpha = 0.8f))
            .border(1.dp, Color.White, RoundedCornerShape(12.dp))
    ) {
        ImageCarousel(
            imageUrls = project.previewImagesUrls,
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(12.dp)),
            backgroundColor = project.backgroundColor
        )
        Column(Modifier.padding(8.dp).width(300.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(project.iconUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text(
                        text = project.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (project.isArchived) {
                        Text(
                            text = "ARCHIWALNA",
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))
            Text(text = project.description, fontSize = 14.sp, modifier = Modifier)
            if (project.githubUrl != null || project.externalUrl != null || project.playStoreUrl != null || project.youtubeUrl != null) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Zobacz więcej na:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                )
            }
            project.githubUrl?.let {
                Spacer(Modifier.height(8.dp))
                LinkButton(label = "Github", it)
            }
            project.youtubeUrl?.let {
                Spacer(Modifier.height(8.dp))
                LinkButton(label = "Youtube", it)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ImageCarousel(
    imageUrls: List<DrawableResource>,
    modifier: Modifier = Modifier,
    autoScrollDuration: Long = 4000,
    backgroundColor: Color
) {
    val imageCount = imageUrls.size
    if (imageCount == 0) return

    val infinitePages = Int.MAX_VALUE
    val startIndex = infinitePages / 2 - (infinitePages / 2 % imageCount)

    val pagerState = rememberPagerState { startIndex }

    LaunchedEffect(pagerState.currentPage) {
        if (imageCount > 1) {
            delay(autoScrollDuration)
            pagerState.scrollToPage(pagerState.currentPage + 1)
        }
    }

    Box(modifier.background(color = backgroundColor.copy(alpha = 0.2f))) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth().padding(40.dp),
            userScrollEnabled = false
        ) { page ->
            val realIndex = page % imageCount
            Image(
                painter = painterResource(imageUrls[realIndex]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Inside
            )
        }
        InfinitePagerIndicator(
            pagerState = pagerState,
            pageCount = imageCount,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun InfinitePagerIndicator(
    modifier: Modifier,
    pagerState: PagerState,
    pageCount: Int,
    activeSize: Dp = 10.dp,
    inactiveSize: Dp = 6.dp,
    spacing: Dp = 6.dp,
    activeColor: Color = Color.White,
    inactiveColor: Color = Color.Gray

) {
    if (pageCount <= 1) return

    val currentRealIndex by remember {
        derivedStateOf {
            (pagerState.currentPage % pageCount + pageCount) % pageCount
        }
    }

    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            for (i in 0 until pageCount) {
                val isActive = i == currentRealIndex
                val dotSize by animateDpAsState(targetValue = if (isActive) activeSize else inactiveSize)
                val dotColor by animateColorAsState(targetValue = if (isActive) activeColor else inactiveColor)

                Box(
                    modifier = Modifier
                        .padding(horizontal = spacing / 2)
                        .size(dotSize)
                        .clip(CircleShape)
                        .background(dotColor)
                        .clickable {
                            scope.launch {
                                val base = pagerState.currentPage
                                val baseIndex = (base % pageCount + pageCount) % pageCount
                                val delta = i - baseIndex
                                pagerState.animateScrollToPage(base + delta)
                            }
                        }
                )
            }
        }
    }
}

@Composable
fun LinkButton(label: String, url: String) {
    val uriHandler = LocalUriHandler.current
    Button(
        onClick = { uriHandler.openUri(url) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
    ) {
        Text(
            text = label,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}