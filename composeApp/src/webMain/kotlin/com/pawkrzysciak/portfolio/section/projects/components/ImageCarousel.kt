package com.pawkrzysciak.portfolio.section.projects.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.theme.isMobile
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCarousel(
    imageUrls: List<DrawableResource>,
    modifier: Modifier = Modifier,
    autoScrollDuration: Long = 4000,
    backgroundColor: Color,
    cropPadding: Boolean,
    isVertical: Boolean = false
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

    Box(
        modifier.background(
            color = if (isVertical) Color.Transparent else backgroundColor.copy(
                alpha = 0.2f
            )
        )
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
                .padding(if (isVertical) 0.dp else if (cropPadding) 15.dp else 40.dp),
            userScrollEnabled = false
        ) { page ->
            val realIndex = page % imageCount
            Image(
                painter = painterResource(imageUrls[realIndex]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = when {
                    isMobile -> ContentScale.FillHeight
                    isVertical -> ContentScale.FillBounds
                    else -> ContentScale.Inside
                }
            )
        }
        if (isVertical.not()) {
            InfinitePagerIndicator(
                pagerState = pagerState,
                pageCount = imageCount,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
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
