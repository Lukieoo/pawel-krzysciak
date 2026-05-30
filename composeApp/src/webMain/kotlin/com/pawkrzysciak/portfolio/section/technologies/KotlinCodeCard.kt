package com.pawkrzysciak.portfolio.section.technologies

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawkrzysciak.portfolio.theme.AppColors

private val BgEditor = Color(0xFF1E1E2E)
private val BgChrome = Color(0xFF181825)

private val LineNumColor = Color(0xFF45475A)
private val TabInactiveText = Color(0xFF585B70)

private val CDefault = Color(0xFFCDD6F4)
private val CKeyword = Color(0xFFCBA6F7)
private val CClass = Color(0xFFF9E2AF)
private val CFunction = Color(0xFF89B4FA)
private val CString = Color(0xFFA6E3A1)
private val CNumber = Color(0xFFFAB387)
private val CComment = Color(0xFF6C7086)

@Composable
fun KotlinCodeCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .widthIn(max = 520.dp)
            .shadow(20.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
    ) {
        Box(Modifier.fillMaxWidth().height(3.dp).background(AppColors.KotlinGradient))
        TitleBar()
        TabBar()
        Row(Modifier.fillMaxWidth().background(BgEditor)) {
            LineNumbers(count = 19)
            CodeBody()
        }
    }
}

@Composable
private fun TitleBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgChrome)
            .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(10.dp).background(Color(0xFFFF5F57), CircleShape))
            Spacer(Modifier.width(6.dp))
            Box(Modifier.size(10.dp).background(Color(0xFFFFBD2E), CircleShape))
            Spacer(Modifier.width(6.dp))
            Box(Modifier.size(10.dp).background(Color(0xFF28CA41), CircleShape))
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = "TechStack.kt — Portfolio",
            color = TabInactiveText,
            fontSize = 11.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(Modifier.weight(1f))
    }
}

@Composable
private fun TabBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgChrome)
    ) {
        Column(modifier = Modifier.width(IntrinsicSize.Min)) {
            Box(Modifier.fillMaxWidth().height(2.dp).background(AppColors.KotlinPurple))
            Box(
                modifier = Modifier
                    .background(BgEditor)
                    .padding(horizontal = 16.dp, vertical = 7.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "K ",
                        color = AppColors.KotlinPurple,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "TechStack.kt",
                        color = CDefault,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }
        Box(Modifier.padding(horizontal = 16.dp, vertical = 9.dp)) {
            Text(
                text = "Tools.kt",
                color = TabInactiveText,
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Composable
private fun LineNumbers(count: Int) {
    Column(
        modifier = Modifier
            .background(BgEditor)
            .padding(start = 16.dp, end = 12.dp, top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.End
    ) {
        repeat(count) { index ->
            Text(
                text = "${index + 1}",
                color = LineNumColor,
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                lineHeight = 22.sp
            )
        }
    }
}

@Composable
private fun CodeBody() {
    val cursorAlpha by rememberInfiniteTransition(label = "cursor")
        .animateFloat(
            initialValue = 1f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 530),
                repeatMode = RepeatMode.Reverse
            ),
            label = "cursorAlpha"
        )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgEditor)
            .padding(end = 20.dp, top = 16.dp, bottom = 16.dp)
    ) {
        CodeLine {
            keyword("object ")
            cls("TechStack")
            default(" {")
        }
        CodeLine { default("") }
        CodeLine {
            default("    ")
            keyword("val ")
            default("mobile = ")
            fn("listOf")
            default("(")
        }
        CodeLine {
            default("        ")
            str("\"Kotlin\"")
            default(", ")
            str("\"KMP\"")
            default(",")
        }
        CodeLine {
            default("        ")
            str("\"Jetpack Compose\"")
            default(",")
        }
        CodeLine {
            default("        ")
            str("\"Coroutines\"")
            default(", ")
            str("\"Ktor\"")
        }
        CodeLine { default("    )") }
        CodeLine { default("") }
        CodeLine {
            default("    ")
            keyword("val ")
            default("arch = ")
            fn("listOf")
            default("(")
        }
        CodeLine {
            default("        ")
            str("\"Clean Architecture\"")
            default(",")
        }
        CodeLine {
            default("        ")
            str("\"MVVM\"")
            default(", ")
            str("\"MVI\"")
            default(", ")
            str("\"Koin\"")
        }
        CodeLine { default("    )") }
        CodeLine { default("") }
        CodeLine {
            default("    ")
            keyword("val ")
            default("tools = ")
            fn("listOf")
            default("(")
        }
        CodeLine {
            default("        ")
            str("\"Android Studio\"")
            default(",")
        }
        CodeLine {
            default("        ")
            str("\"Figma\"")
            default(", ")
            str("\"Git\"")
        }
        CodeLine { default("    )") }
        CodeLine { default("}") }
        Text(
            text = "▌",
            color = CDefault.copy(alpha = cursorAlpha),
            fontSize = 13.sp,
            fontFamily = FontFamily.Monospace,
            lineHeight = 22.sp
        )
    }
}

private data class CodeBuilder(val spans: MutableList<Pair<SpanStyle, String>> = mutableListOf()) {
    fun keyword(text: String) = spans.add(SpanStyle(color = CKeyword) to text)
    fun cls(text: String) = spans.add(SpanStyle(color = CClass) to text)
    fun fn(text: String) = spans.add(SpanStyle(color = CFunction) to text)
    fun str(text: String) = spans.add(SpanStyle(color = CString) to text)
    fun num(text: String) = spans.add(SpanStyle(color = CNumber) to text)
    fun default(text: String) = spans.add(SpanStyle(color = CDefault) to text)
    fun comment(text: String) = spans.add(SpanStyle(color = CComment) to text)
}

@Composable
private fun CodeLine(content: CodeBuilder.() -> Unit) {
    val builder = CodeBuilder().apply(content)
    val annotated = buildAnnotatedString {
        builder.spans.forEach { (style, text) ->
            withStyle(style) { append(text) }
        }
    }
    Text(
        text = annotated,
        fontSize = 13.sp,
        fontFamily = FontFamily.Monospace,
        lineHeight = 22.sp
    )
}
