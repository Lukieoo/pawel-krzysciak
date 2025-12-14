package com.pawkrzysciak.portfolio.section.start

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.translation.CurrentStrings
import com.pawkrzysciak.portfolio.translation.Strings
import com.pawkrzysciak.portfolio.translation.countries.StringsEn
import com.pawkrzysciak.portfolio.translation.countries.StringsPl


@Composable
fun ButtonFlags(modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {

        UnicodeFlagButton(
            flag = "PL",
            strings = StringsPl,
        )

        UnicodeFlagButton(
            flag = "EN",
            strings = StringsEn,
        )
    }
}

@Composable
fun UnicodeFlagButton(
    flag: String,
    strings: Strings,
    modifier: Modifier = Modifier
) {
    if (CurrentStrings.strings == strings) return
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = CircleShape
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(onClick = { CurrentStrings.strings = strings }),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = flag,
            fontSize = 18.sp,
            lineHeight = 18.sp,
            fontFamily = FontFamily.SansSerif
        )
    }
}