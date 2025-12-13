package com.pawkrzysciak.portfolio.section.aboutme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pawkrzysciak.portfolio.section.hero.components.HandwritingFont
import com.pawkrzysciak.portfolio.theme.GetLayoutPadding

@Composable
fun AboutMeSection(modifier: Modifier) {
    val animationPlayed = rememberSaveable { mutableStateOf(false) }
    val experienceYears = 6
    val animatedExperience by animateIntAsState(
        targetValue = if (animationPlayed.value) experienceYears else 0,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    LaunchedEffect(Unit) { animationPlayed.value = true }

    var visible by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }

    Column {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray,
            thickness = 1.dp
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = GetLayoutPadding(), vertical = 120.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            FlowRow(
                verticalArrangement = Arrangement.Center,
                horizontalArrangement = Arrangement.Center,
                itemVerticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(animationSpec = tween(800)) +
                            slideInVertically(
                                initialOffsetY = { it / 2 },
                                animationSpec = tween(800)
                            )
                ) {
                    AboutMeTextColumn(
                        modifier = Modifier.weight(1f),
                    )
                }

                ExperienceColumn(
                    modifier = Modifier.weight(1f),
                    animatedExperience = animatedExperience
                )
            }
        }
    }
}

@Composable
fun AboutMeTextColumn(modifier: Modifier) {
    Column(modifier = modifier.widthIn(max = 900.dp)) {
        Text(
            text = "O mnie",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Jestem inżynierem informatyki oraz programistą Androida z ponad 6 letnim doświadczeniem w tworzeniu nowoczesnych aplikacji mobilnych. Współpracowałem nad projektami dla różnych branż od systemów POS i aplikacji społecznościowych dla sprzedawców, po sektor ochrony zdrowia i e-commerce z których część była używana przez ponad milion użytkowników.\n\n" +
                    "Swoje aplikacje głównie tworzę i rozwijam w Kotlinie dbając o dobre praktyki. Łączę podejście business-first z dbałością o jakość kodu, czytelność i skalowalność projektu. Na co dzień pracuję w metodykach Agile.\n\n" +
                    "Po godzinach rozwijam własne aplikacje, tworzę UI/UX i eksperymentuję z grafiką. Dodatkowo piszę gry w silniku Godot, co pozwala mi rozwijać kreatywność i umiejętności projektowe.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
            ),
            textAlign = TextAlign.Justify
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Znajdź mnie tutaj:",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
        )

        Spacer(Modifier.height(16.dp))

        SocialButtonsRow()
    }
}

@Composable
fun SocialButtonsRow() {
    val uriHandler = LocalUriHandler.current
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SocialButton("GitHub", "https://github.com/Lukieoo", uriHandler)
        SocialButton(
            "LinkedIn",
            "https://www.linkedin.com/in/paweł-krzyściak-2691a8186",
            uriHandler
        )
        SocialButton("Itch.io", "https://lukieoo.itch.io/", uriHandler)
    }
}

@Composable
fun SocialButton(text: String, url: String, uriHandler: UriHandler) {
    Button(
        onClick = { uriHandler.openUri(url) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(48.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontFamily = HandwritingFont(),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Composable
fun ExperienceColumn(modifier: Modifier, animatedExperience: Int) {
    Column(
        modifier = modifier
            .height(IntrinsicSize.Max)
            .padding(top = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "+ $animatedExperience lat",
            style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Doświadczenia komercyjnego",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}