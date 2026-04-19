package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private enum class AnalyticsTab { Prelims, Mains, MockTests }

@Composable
fun TestAnalyticsScreen(onBack: () -> Unit = {}) {
    var tab by remember { mutableStateOf(AnalyticsTab.Prelims) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE2E7F0))
    ) {
        item {
            AnalyticsHeader(onBack = onBack)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(26.dp)
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
            )
            TabSwitch(tab = tab, onSelect = { tab = it })
            SpacerH(10)
        }
        item {
            when (tab) {
                AnalyticsTab.Prelims -> PrelimsTab()
                AnalyticsTab.Mains -> MainsTab()
                AnalyticsTab.MockTests -> MockTestsTab()
            }
            SpacerH(14)
        }
    }
}

@Composable
private fun AnalyticsHeader(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0A1631))
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFF9CB0CA), fontSize = 16.sp, modifier = Modifier.clickable { onBack() })
        }
        SpacerH(16)
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(Color(0xFFF5A623).copy(alpha = 0.18f), RoundedCornerShape(999.dp))
                .border(1.dp, Color(0xFFF5A623).copy(alpha = 0.32f), RoundedCornerShape(999.dp))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(
                "📊 TEST ANALYTICS · DASHBOARD",
                color = Color(0xFFF5A623),
                fontSize = 8.5.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.4.sp
            )
        }
        SpacerH(8)
        Text(
            buildAnnotatedString {
                append("Rahul's ")
                withStyle(SpanStyle(color = Color(0xFFF5A623), fontStyle = FontStyle.Italic)) { append("Progress.") }
            },
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 31.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpacerH(4)
        Text(
            "Your complete UPSC test analytics - score trends, subject\nmastery, rank history, time management and Jeet\nAI-powered next steps.",
            color = Color(0xFFFFFFFF).copy(alpha = 0.45f),
            fontSize = 12.5.sp,
            lineHeight = 20.63.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpacerH(10)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White.copy(alpha = 0.07f), RoundedCornerShape(14.dp))
                .border(1.dp, Color.White.copy(alpha = 0.09f), RoundedCornerShape(14.dp))
        ) {
            HeaderStat("34", "TESTS TAKEN", Color(0xFFF5A623), Modifier.weight(1f))
            HeaderStat("127", "AVG SCORE", Color(0xFF1A56C4), Modifier.weight(1f))
            HeaderStat("87%", "ACCURACY", Color(0xFF0E8A56), Modifier.weight(1f))
            HeaderStat("42", "DAY STREAK", Color(0xFF7C3AED), Modifier.weight(1f), showDivider = false)
        }
    }
}

@Composable
private fun TopBubble(label: String) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .background(Color.White, RoundedCornerShape(9.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(label, fontSize = 12.sp)
    }
}

@Composable
private fun HeaderStat(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier,
    showDivider: Boolean = true,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                value,
                color = valueColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.4).sp
            )
            Text(
                label,
                color = Color.White.copy(alpha = 0.32f),
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.4.sp
            )
        }
        if (showDivider) {
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(38.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )
        }
    }
}

@Composable
private fun TabSwitch(tab: AnalyticsTab, onSelect: (AnalyticsTab) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TabChip("🎯 Prelims", tab == AnalyticsTab.Prelims, Modifier.weight(1f)) { onSelect(AnalyticsTab.Prelims) }
        TabChip("✍️ Mains", tab == AnalyticsTab.Mains, Modifier.weight(1f)) { onSelect(AnalyticsTab.Mains) }
        TabChip("📝 Mock Tests", tab == AnalyticsTab.MockTests, Modifier.weight(1f)) { onSelect(AnalyticsTab.MockTests) }
    }
}

@Composable
private fun TabChip(label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(36.dp)
            .background(if (selected) Color(0xFF1A2744) else Color.White, RoundedCornerShape(20.dp))
            .border(0.8.dp, if (selected) Color(0xFFE0E7EE) else Color(0xFFC9D2DE), RoundedCornerShape(20.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            Text(
                label.takeWhile { it != ' ' },
                color = if (selected) Color.White else Color(0xFF1A2744),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.width(6.dp))
            Text(
                label.substringAfter(' ', ""),
                color = if (selected) Color.White else Color(0xFF1A2744),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun PrelimsTab() {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PrelimsTopMetricCard(
                title = "QUESTIONS ATTEMPTED",
                value = "4,218",
                sub = "across all tests",
                topBorder = Color(0xFFFF6900),
                subColor = Color(0xFF8FA4BE),
                modifier = Modifier.weight(1f)
            )
            PrelimsTopMetricCard(
                title = "OVERALL ACCURACY",
                value = "82.4%",
                sub = "↗ Target: 85%",
                topBorder = Color(0xFF0E8A56),
                subColor = Color(0xFF0E8A56),
                modifier = Modifier.weight(1f)
            )
        }
        TrendCard(
            title = "📊 Daily MCQ Performance Trend",
            subtitle = "8-week rolling accuracy",
            metrics = listOf(
                Triple("1,842", "Correct", Color(0xFF0E8A56)),
                Triple("513", "Wrong", Color(0xFFE85D75)),
                Triple("187", "Skipped", Color(0xFF8FA4BE)),
                Triple("78.4%", "Net Acc.", Color(0xFFF0A330))
            ),
            lineColor = Color(0xFF5A78FF),
            showWeekAxis = true,
            markerValue = "82.4%"
        )
        NumberOfQuestionsCard()
        SubjectAccuracyCard()
        BottomActions()
    }
}

@Composable
private fun PrelimsTopMetricCard(
    title: String,
    value: String,
    sub: String,
    topBorder: Color,
    subColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .height(123.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFE3EAF2), RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(topBorder, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.8.dp, end = 16.8.dp, top = 10.8.dp, bottom = 10.dp)
        ) {
            Text(
                title,
                color = Color(0xFF8FA4BE),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp,
                lineHeight = 16.5.sp
            )
            SpacerH(3)
            Text(
                value,
                color = Color(0xFF1A2744),
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 48.sp
            )
            SpacerH(2)
            Text(
                sub,
                color = subColor,
                fontSize = 10.sp,
                fontWeight = if (sub.startsWith("↗")) FontWeight.SemiBold else FontWeight.Normal,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
private fun MainsTab() {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        MainsSummaryStrip()
        MainsTrendCard()
        NumberOfQuestionsCard()
        TimePerQuestionCard()
        RecentMainsCard()
        BottomActions()
    }
}

@Composable
private fun MainsSummaryStrip() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A2744), RoundedCornerShape(20.dp))
            .border(0.8.dp, Color(0xFFE0E7EE), RoundedCornerShape(20.dp))
            .padding(vertical = 8.dp)
    ) {
        MainsSummaryMetric(
            value = "34",
            label = "TESTS TAKEN",
            valueColor = Color(0xFFF5A623),
            modifier = Modifier.weight(1f)
        )
        MainsSummaryMetric(
            value = "127",
            label = "AVG SCORE",
            valueColor = Color(0xFF1A56C4),
            modifier = Modifier.weight(1f)
        )
        MainsSummaryMetric(
            value = "87%",
            label = "ACCURACY",
            valueColor = Color(0xFF0E8A56),
            modifier = Modifier.weight(1f)
        )
        MainsSummaryMetric(
            value = "42",
            label = "DAY STREAK",
            valueColor = Color(0xFF7C3AED),
            modifier = Modifier.weight(1f),
            showDivider = false
        )
    }
}

@Composable
private fun MainsSummaryMetric(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier,
    showDivider: Boolean = true,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                value,
                color = valueColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.4).sp
            )
            Text(
                label,
                color = Color.White.copy(alpha = 0.32f),
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.4.sp,
                textAlign = TextAlign.Center
            )
        }
        if (showDivider) {
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(34.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )
        }
    }
}

@Composable
private fun MainsTrendCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp), clip = false)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            "✍️ Daily Mains Challenge Trend",
            color = Color(0xFF1A2744),
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            "Performance across 8 tests",
            color = Color(0xFF5A7096),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
        MainsTrendChart()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8").forEach {
                Text(it, color = Color(0xFF8FA4BE), fontSize = 9.5.sp)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(62.dp)
                .background(Color(0xFFEEF2F8), RoundedCornerShape(13.dp))
                .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(13.dp))
                .padding(horizontal = 18.dp)
        ) {
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                MainsBottomMetric(
                    value = "8.2",
                    label = "Latest Score",
                    valueColor = Color(0xFF7C3AED),
                    modifier = Modifier.weight(1f)
                )
                Box(modifier = Modifier.width(1.dp).height(36.dp).background(Color(0xFFDDE5F0)))
                MainsBottomMetric(
                    value = "+0.8",
                    label = "Improvement",
                    valueColor = Color(0xFF0E8A56),
                    modifier = Modifier.weight(1f)
                )
                Box(modifier = Modifier.width(1.dp).height(36.dp).background(Color(0xFFDDE5F0)))
                MainsBottomMetric(
                    value = "38",
                    label = "Answers Written",
                    valueColor = Color(0xFFC95212),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun MainsBottomMetric(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            value,
            color = valueColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-0.4).sp
        )
        Text(
            label,
            color = Color(0xFF8FA4BE),
            fontSize = 9.5.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun MainsTrendChart() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(82.dp)
            .padding(top = 6.dp, bottom = 2.dp)
    ) {
        val points = listOf(
            0.03f to 0.74f,
            0.17f to 0.69f,
            0.31f to 0.63f,
            0.45f to 0.55f,
            0.59f to 0.45f,
            0.73f to 0.34f,
            0.87f to 0.25f,
            0.99f to 0.18f,
        )

        val dashed = PathEffect.dashPathEffect(floatArrayOf(6f, 6f), 0f)
        repeat(3) { idx ->
            val y = size.height * (idx + 1) / 4f
            drawLine(
                color = Color(0xFFDDE5F0),
                start = androidx.compose.ui.geometry.Offset(0f, y),
                end = androidx.compose.ui.geometry.Offset(size.width, y),
                strokeWidth = 1f,
                pathEffect = dashed
            )
        }

        val mapped = points.map { (x, y) -> androidx.compose.ui.geometry.Offset(x * size.width, y * size.height) }
        val path = androidx.compose.ui.graphics.Path().apply {
            moveTo(mapped.first().x, mapped.first().y)
            for (i in 1 until mapped.size) lineTo(mapped[i].x, mapped[i].y)
        }

        drawPath(
            path = path,
            color = Color(0xFFF5A623),
            style = Stroke(width = 3.2f, cap = StrokeCap.Round)
        )

        mapped.forEachIndexed { index, pt ->
            if (index == mapped.lastIndex || index % 2 == 0) {
                drawCircle(Color.White, radius = 5.8f, center = pt)
                drawCircle(Color(0xFFF5A623), radius = 3.7f, center = pt)
            }
        }
    }
}

@Composable
private fun MockTestsTab() {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TrendCard(
            title = "📈 Score Progression",
            subtitle = "",
            metrics = emptyList(),
            lineColor = Color(0xFF2A2D36),
            chipLabel = "8W"
        )
        CompleteHistoryCard()
        FullWidthAction("⚡ Take Next Mock Test")
        BottomActions()
        InsightCard(
            title = "🧠 Jeet AI Insights",
            badge = "Updated",
            badgeColor = Color(0xFF63C084),
            body = "Auto-generated · 4 Mar 2026\n\n⚠️ Economy is your weakest link.\nYour accuracy is 36% Economy questions. Budget\naffairs, monetary policy, and fiscal trends need dedicated revision this week."
        )
        InsightCard(
            title = "🧡 Overthinking Economy",
            badge = "STARTED",
            badgeColor = Color(0xFFF09C2B),
            body = "You've spent 4 min+ on 11 polity Qs. The\nyou 50-second instinct + don't overthink difficult\nquestions."
        )
        InsightCard(
            title = "✅ Polity — near perfect 84%",
            badge = "",
            badgeColor = Color.Transparent,
            body = "Correct answers: 15 MCQ, NCERT chapters clearly\nestimated. This is your anchor subject — maintain this."
        )
        InsightCard(
            title = "🟣 History improving every test",
            badge = "SINCE · Q2",
            badgeColor = Color(0xFF7F63FF),
            body = "+12% since Mock Test 1. Factual revision paying off.\nContinue daily 20-min History revision to maintain momentum."
        )
        FullWidthAction("⚡ Take Next Mock Test")
        BottomActions()
    }
}

@Composable
private fun MetricCard(title: String, value: String, sub: String, accent: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(104.dp)
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .height(3.dp)
                .fillMaxWidth()
                .background(accent, RoundedCornerShape(3.dp))
        )
        SpacerH(8)
        Text(title, color = Color(0xFFA1AFC4), fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
        SpacerH(6)
        Text(value, color = Color(0xFF26365D), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        Text(sub, color = Color(0xFF7F8FA8), fontSize = 10.sp)
    }
}

@Composable
private fun TrendCard(
    title: String,
    subtitle: String,
    metrics: List<Triple<String, String, Color>>,
    lineColor: Color,
    chipLabel: String = "",
    showWeekAxis: Boolean = false,
    markerValue: String = "",
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(title, color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                if (subtitle.isNotBlank()) {
                    Text(subtitle, color = Color(0xFFA1AFC4), fontSize = 9.sp)
                }
            }
            if (chipLabel.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF121F39), RoundedCornerShape(10.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(chipLabel, color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        if (metrics.isNotEmpty()) {
            SpacerH(10)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                metrics.forEach { m ->
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            m.first,
                            color = m.third,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            lineHeight = 33.sp
                        )
                        Text(
                            m.second,
                            color = Color(0xFF8FA4BE),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }
        SpacerH(10)
        Sparkline(
            lineColor = lineColor,
            showWeekAxis = showWeekAxis,
            markerValue = markerValue
        )
    }
}

@Composable
private fun Sparkline(
    lineColor: Color,
    showWeekAxis: Boolean = false,
    markerValue: String = "",
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
        ) {
            androidx.compose.foundation.Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 2.dp)
            ) {
                val points = listOf(
                    0.04f to 0.75f,
                    0.17f to 0.68f,
                    0.30f to 0.63f,
                    0.43f to 0.56f,
                    0.56f to 0.48f,
                    0.69f to 0.38f,
                    0.82f to 0.30f,
                    0.95f to 0.22f,
                )

                val grid = Color(0xFFDDE5F0)
                repeat(3) { idx ->
                    val y = size.height * (idx + 1) / 4f
                    drawLine(
                        color = grid,
                        start = androidx.compose.ui.geometry.Offset(0f, y),
                        end = androidx.compose.ui.geometry.Offset(size.width, y),
                        strokeWidth = 1f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 6f), 0f)
                    )
                }

                val mapped = points.map { p ->
                    androidx.compose.ui.geometry.Offset(p.first * size.width, p.second * size.height)
                }

                val path = androidx.compose.ui.graphics.Path().apply {
                    moveTo(mapped.first().x, mapped.first().y)
                    for (i in 1 until mapped.size) {
                        lineTo(mapped[i].x, mapped[i].y)
                    }
                }

                // Gradient fill area under the line
                val fillPath = androidx.compose.ui.graphics.Path().apply {
                    moveTo(mapped.first().x, mapped.first().y)
                    for (i in 1 until mapped.size) {
                        lineTo(mapped[i].x, mapped[i].y)
                    }
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                    close()
                }

                drawPath(
                    path = fillPath,
                    color = Color(0xFFE8F1FF),
                    alpha = 0.6f
                )

                drawPath(path = path, color = lineColor, style = Stroke(width = 3.6f, cap = StrokeCap.Round))

                mapped.forEachIndexed { index, pt ->
                    if (index == mapped.lastIndex || index % 2 == 0) {
                        drawCircle(
                            color = Color(0xFF1A56C4),
                            radius = 5.5f,
                            center = pt,
                            style = Stroke(width = 1.97f)
                        )
                        drawCircle(Color.White, radius = 4.2f, center = pt)
                    }
                }
            }

            if (markerValue.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 18.dp)
                        .background(Color(0xFF1A56C4), RoundedCornerShape(6.dp))
                        .padding(horizontal = 7.dp, vertical = 3.dp)
                ) {
                    Text(
                        markerValue,
                        color = Color.White,
                        fontSize = 9.4.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 11.sp
                    )
                }
            }
        }

        if (showWeekAxis) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8").forEach {
                    Text(
                        it,
                        color = Color(0xFF8FA4BE),
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
private fun NumberOfQuestionsCard() {
    val bars = listOf(
        Triple("Mon", 12, 25.dp),
        Triple("Tue", 12, 32.dp),
        Triple("Wed", 13, 34.dp),
        Triple("Thu", 25, 25.dp),
        Triple("Fri", 28, 25.dp),
        Triple("Sat", 25, 25.dp),
        Triple("Sun", 25, 25.dp),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(16.dp), clip = false)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "📅 Number of Questions",
                color = Color.Black,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.3).sp
            )
            Text(
                "Total: 287",
                color = Color(0xFF1A56C4),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        SpacerH(7)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(84.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 2.dp, end = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(bars.size) {
                    Box(modifier = Modifier.size(9.dp), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .background(Color.White, CircleShape)
                                .border(1.2.dp, Color(0xFF1A56C4), CircleShape)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                bars.forEachIndexed { idx, (day, value, barHeight) ->
                    Column(
                        modifier = Modifier.width(36.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .width(27.dp)
                                .height(barHeight)
                                .background(
                                    when {
                                        idx <= 2 -> Color(0xFF101828)
                                        idx == 3 -> Color(0xFFF5A623)
                                        else -> Color(0x6999A1AF)
                                    },
                                    RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
                                )
                        )
                        SpacerH(4)
                        Text(
                            day,
                            color = if (idx == 3) Color(0xFFD4881A) else Color(0xFF8FA4BE),
                            fontSize = 9.5.sp,
                            fontWeight = if (idx == 3) FontWeight.Bold else FontWeight.SemiBold
                        )
                        Text(
                            value.toString(),
                            color = Color(0xFF8FA4BE),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
        SpacerH(6)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            QuestionsLegendItem(
                label = "Completed",
                color = Color(0xFF1A2744),
                isTarget = false
            )
            QuestionsLegendItem(
                label = "Target",
                color = Color(0xFF1A56C4),
                isTarget = true
            )
        }
    }
}

@Composable
private fun QuestionsLegendItem(
    label: String,
    color: Color,
    isTarget: Boolean,
) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        if (isTarget) {
            Box(
                modifier = Modifier
                    .width(18.dp)
                    .height(9.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFF1A2744))
                )
                Box(
                    modifier = Modifier
                        .size(9.dp)
                        .background(Color.White, CircleShape)
                        .border(1.2.dp, color, CircleShape)
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .size(9.dp)
                    .background(color, RoundedCornerShape(3.dp))
            )
        }
        Text(
            label,
            color = Color(0xFF5A7096),
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
private fun LegendDot(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(7.dp).background(color, CircleShape))
        Spacer(Modifier.width(4.dp))
        Text(label, color = Color(0xFF7F8FA8), fontSize = 9.sp)
    }
}

@Composable
private fun SubjectAccuracyCard() {
    val rows = listOf(
        Triple("Polity", 0.84f, Color(0xFF63C084)),
        Triple("History", 0.78f, Color(0xFF7C63FF)),
        Triple("Environment", 0.66f, Color(0xFF5A78FF)),
        Triple("Curr. Affairs", 0.58f, Color(0xFFF0A330)),
        Triple("Economy", 0.44f, Color(0xFFD87528)),
        Triple("Geography", 0.38f, Color(0xFFCF4B4B))
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("📍 Subject Accuracy", color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("Across all MCQ's", color = Color(0xFFA1AFC4), fontSize = 9.sp)
        }
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            rows.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(modifier = Modifier.size(6.dp).background(row.third, CircleShape))
                    Text(row.first, color = Color(0xFF445572), fontSize = 11.sp, modifier = Modifier.width(74.dp))
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(6.dp)
                            .background(Color(0xFFE8EDF5), RoundedCornerShape(6.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(row.second)
                                .height(6.dp)
                                .background(row.third, RoundedCornerShape(6.dp))
                        )
                    }
                    Text("${(row.second * 100).toInt()}%", color = row.third, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFEF0F0), RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFFFFCECE), RoundedCornerShape(12.dp))
                .padding(13.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                "⚠️ FOCUS AREAS",
                color = Color(0xFFC02828),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.7.sp
            )
            Text(
                "Economy (44%) and Geography (38%) need\nimmediate attention. Dedicate 30 min daily this\nweek to these subjects.",
                color = Color(0xFF1A2744),
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.63.sp
            )
        }
    }
}

@Composable
private fun FocusAreasCard(title: String, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF8F1), RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFF2DEB8), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Text(title, color = Color(0xFFE0A22C), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
        SpacerH(4)
        Text(text, color = Color(0xFF705D3A), fontSize = 10.5.sp, lineHeight = 16.sp)
    }
}

@Composable
private fun BottomActions() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        ActionCard("🧠", "Practice MCQs", "Improve weak areas", Modifier.weight(1f))
        ActionCard("✍️", "Write answers", "Boost mains score", Modifier.weight(1f))
    }
}

@Composable
private fun ActionCard(emoji: String, title: String, subtitle: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(56.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(28.dp)
                .background(Color(0xFFFFF2D9), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(emoji, fontSize = 13.sp)
        }
        Spacer(Modifier.width(8.dp))
        Column {
            Text(title, color = Color(0xFF26365D), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Color(0xFFA1AFC4), fontSize = 9.sp)
        }
    }
}

@Composable
private fun TimePerQuestionCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("⏱ Time Per Question", color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("Ideal: <90s", color = Color(0xFFA1AFC4), fontSize = 9.sp)
        }
        SpacerH(8)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            listOf(
                "MON" to "1m 38s",
                "TUE" to "1m 25s",
                "WED" to "1m 42s",
                "THU" to "2m 18s",
                "FRI" to "1m 16s",
                "SAT" to "1m 38s",
                "SUN" to "" 
            ).forEachIndexed { idx, pair ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(pair.second, color = if (idx == 3) Color(0xFFCF4B4B) else Color(0xFF63C084), fontSize = 8.5.sp)
                    SpacerH(4)
                    Box(
                        modifier = Modifier
                            .width(12.dp)
                            .height((18 + (idx * 3)).dp)
                            .background(if (idx == 3) Color(0xFFCF4B4B) else Color(0xFF63C084), RoundedCornerShape(4.dp))
                    )
                    SpacerH(3)
                    Text(pair.first, color = Color(0xFFA1AFC4), fontSize = 8.sp)
                }
            }
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            LegendDot(Color(0xFF63C084), "On time (<90s)")
            LegendDot(Color(0xFFF0A330), "Slightly over (90-120s)")
            LegendDot(Color(0xFFCF4B4B), "Too slow (>120s)")
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MiniInsight("SLOWEST SUBJECT", "Economy\n2m 18s", Color(0xFFFFF1F1), Color(0xFFCF4B4B), Modifier.weight(1f))
            MiniInsight("FASTEST SUBJECT", "History\n58s", Color(0xFFF0FFF6), Color(0xFF63C084), Modifier.weight(1f))
        }
    }
}

@Composable
private fun MiniInsight(label: String, value: String, bg: Color, accent: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(bg, RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {
        Text(label, color = accent, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
        SpacerH(3)
        Text(value, color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
private fun RecentMainsCard() {
    val rows = listOf(
        Triple("Federalism in India - GS II", "123/200", "24 words | 14 mins · Today"),
        Triple("Indian Economy - Monetary Policy", "43/60", "234 words | 14 mins · Yesterday"),
        Triple("Climate Change & India's NDC", "88/200", "284 words | 14 mins · 2 days ago")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("⏳ Recent Mains Challenges", color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("View All +", color = Color(0xFF4F69DF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
        SpacerH(8)
        rows.forEach {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(it.first, color = Color(0xFF26365D), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    Text(it.third, color = Color(0xFFA1AFC4), fontSize = 8.5.sp)
                }
                Text(it.second, color = Color(0xFF26365D), fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
            }
            SpacerH(8)
        }
    }
}

@Composable
private fun CompleteHistoryCard() {
    val tests = listOf(
        Triple("Prelims Mock Test 8", "44/200", "Current Affairs Test 4 · CA 60+ 30 sec flagged"),
        Triple("Current Affairs Test 4", "43/60", ""),
        Triple("Prelims Mock Test 7", "40/200", "Polity + Economy 20 Q + geo"),
        Triple("Polity Mock Test 8", "43/60", "CA 60+ 30 sec flagged"),
        Triple("Prelims Mock Test 7", "40/200", "Full Test")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("📋 Complete Test History", color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("SCORE", color = Color(0xFFA1AFC4), fontSize = 8.5.sp)
        }
        SpacerH(8)
        tests.forEach {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(it.first, color = Color(0xFF26365D), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                    if (it.third.isNotBlank()) {
                        Text(it.third, color = Color(0xFFA1AFC4), fontSize = 8.sp, lineHeight = 12.sp)
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(it.second, color = Color(0xFFD26F2A), fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
                    Text("View +", color = Color(0xFF4F69DF), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }
            }
            SpacerH(9)
        }
        Text("Showing 7 of 12 tests", color = Color(0xFFA1AFC4), fontSize = 8.5.sp)
        SpacerH(6)
        Text("View All +", color = Color(0xFF4F69DF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun InsightCard(title: String, badge: String, badgeColor: Color, body: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            if (badge.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .background(badgeColor.copy(alpha = 0.18f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(badge, color = badgeColor, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        SpacerH(7)
        Text(body, color = Color(0xFF75839B), fontSize = 9.5.sp, lineHeight = 14.sp)
    }
}

@Composable
private fun FullWidthAction(label: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
            .background(Brush.verticalGradient(listOf(Color(0xFF121F39), Color(0xFF172A4F))), RoundedCornerShape(12.dp))
            .clickable {}
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun SpacerH(height: Int) {
    Spacer(Modifier.height(height.dp))
}
