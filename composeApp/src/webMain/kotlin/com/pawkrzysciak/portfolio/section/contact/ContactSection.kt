package com.pawkrzysciak.portfolio.section.contact

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.common.rememberWindowSize
import com.pawkrzysciak.portfolio.config.CV_DOWNLOAD_URL
import com.pawkrzysciak.portfolio.section.hero.components.BackgroundGrid
import com.pawkrzysciak.portfolio.section.hero.components.FloatingTechWordsTypewriter
import com.pawkrzysciak.portfolio.theme.AppColors
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding
import com.pawkrzysciak.portfolio.theme.SectionAccentBar
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import kotlinx.browser.window

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContactSection(modifier: Modifier) {
    val windowSize = rememberWindowSize()
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = windowSize.height)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        BackgroundGrid(windowSize = windowSize)
        FloatingTechWordsTypewriter(windowSize = windowSize)

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(800)) + slideInVertically(
                initialOffsetY = { it / 3 },
                animationSpec = tween(800)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = GetLayoutPadding(), vertical = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = CurrentStrings.strings.contactTitle,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Spacer(Modifier.height(6.dp))
                SectionAccentBar()
                Spacer(Modifier.height(24.dp))
                BusinessCard()
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun BusinessCard() {
    val uriHandler = LocalUriHandler.current

    Row(
        modifier = Modifier
            .widthIn(max = 740.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, AppColors.KotlinPurple.copy(alpha = 0.15f), RoundedCornerShape(16.dp))
    ) {
        // Left solid panel
        Box(
            modifier = Modifier
                .width(160.dp)
                .fillMaxHeight()
                .background(AppColors.KotlinPurple),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "PK",
                    color = Color.White,
                    fontSize = 52.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 6.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Android",
                    color = Color.White.copy(alpha = 0.70f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 2.sp
                )
            }
        }

        // Right content panel
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(28.dp)
        ) {
            Text(
                text = "Paweł Krzyściak",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.KotlinPurple.copy(alpha = 0.1f), RoundedCornerShape(50))
                    .border(1.dp, AppColors.KotlinPurple.copy(alpha = 0.25f), RoundedCornerShape(50))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Senior Android Developer",
                    color = AppColors.KotlinPurple,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(20.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                ContactDetail(
                    label = CurrentStrings.strings.locationLabel,
                    value = CurrentStrings.strings.place
                )
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = CurrentStrings.strings.emailLabel,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "pawkrzysciak@gmail.com",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = AppColors.KotlinPurple,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .pointerHoverIcon(PointerIcon.Hand)
                            .clickable { window.location.href = "mailto:pawkrzysciak@gmail.com" }
                    )
                }
            }

            Spacer(Modifier.height(20.dp))
            Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.KotlinPurple.copy(alpha = 0.1f)))
            Spacer(Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GradientLinkButton("GitHub") {
                    uriHandler.openUri("https://github.com/Lukieoo")
                }
                GradientLinkButton("LinkedIn") {
                    uriHandler.openUri("https://www.linkedin.com/in/paweł-krzyściak-2691a8186")
                }
                OutlineLinkButton("Itch.io") {
                    uriHandler.openUri("https://lukieoo.itch.io/")
                }
                if (CV_DOWNLOAD_URL.isNotEmpty()) {
                    GradientLinkButton(CurrentStrings.strings.downloadCv) {
                        uriHandler.openUri(CV_DOWNLOAD_URL)
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactDetail(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = label, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun GradientLinkButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(AppColors.KotlinGradient)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClick() }
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun OutlineLinkButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(1.dp, AppColors.KotlinPurple.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClick() }
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = AppColors.KotlinPurple,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp
        )
    }
}
