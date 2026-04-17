package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private enum class AnalyticsTab { Prelims, Mains, MockTests }

@Composable
fun TestAnalyticsScreen(onBack: () -> Unit = {}) {
    var tab by remember { mutableStateOf(AnalyticsTab.Prelims) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFF3FA))
    ) {
        item {
            AnalyticsHeader(onBack = onBack)
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
            .background(Color(0xFF08162C))
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFF9CB0CA), fontSize = 16.sp, modifier = Modifier.clickable { onBack() })
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TopBubble("🧠")
                TopBubble("🔔")
            }
        }
        SpacerH(10)
        Box(
            modifier = Modifier
                .background(Color(0xFF1B2744), RoundedCornerShape(999.dp))
                .border(1.dp, Color(0xFF2C3B5D), RoundedCornerShape(999.dp))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text("🏁 TEST ANALYTICS · DASHBOARD", color = Color(0xFFE2B768), fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
        }
        SpacerH(8)
        Text(
            buildAnnotatedString {
                append("Rahul's ")
                withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Progress.") }
            },
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 40.sp
        )
        SpacerH(4)
        Text(
            "Your complete UPSC test analytics · score trends, subject\nmastery, rank history, time management and AI-powered next steps.",
            color = Color(0xFF6D84A6),
            fontSize = 10.5.sp,
            lineHeight = 16.sp
        )
        SpacerH(10)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF121F39), RoundedCornerShape(12.dp))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            HeaderStat("34", "TESTS TAKEN", Color(0xFFE2B768))
            HeaderStat("127", "AV SCORE", Color(0xFF6B8BFF))
            HeaderStat("87%", "ACCURACY", Color(0xFF65D68A))
            HeaderStat("42", "DAY STREAK", Color(0xFF7D69E3))
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
private fun HeaderStat(value: String, label: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = valueColor, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color(0xFF6D84A6), fontSize = 8.sp)
    }
}

@Composable
private fun TabSwitch(tab: AnalyticsTab, onSelect: (AnalyticsTab) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        TabChip("🫀 Prelims", tab == AnalyticsTab.Prelims, Modifier.weight(1f)) { onSelect(AnalyticsTab.Prelims) }
        TabChip("✍️ Mains", tab == AnalyticsTab.Mains, Modifier.weight(1f)) { onSelect(AnalyticsTab.Mains) }
        TabChip("🎯 Mock Tests", tab == AnalyticsTab.MockTests, Modifier.weight(1f)) { onSelect(AnalyticsTab.MockTests) }
    }
}

@Composable
private fun TabChip(label: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(36.dp)
            .background(if (selected) Color(0xFF121F39) else Color(0xFFF4F6FB), RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            color = if (selected) Color.White else Color(0xFF6D7F97),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun PrelimsTab() {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MetricCard("QUESTION ATTEMPTED", "4,218", "across all tests", Color(0xFFF2942C), Modifier.weight(1f))
            MetricCard("OVERALL ACCURACY", "82.4%", "↗ Target: 85%", Color(0xFF60B977), Modifier.weight(1f))
        }
        TrendCard(
            title = "📊 Daily MCQ Performance Trend",
            subtitle = "8-week rolling accuracy",
            metrics = listOf(
                Triple("1,842", "Correct", Color(0xFF4CAF50)),
                Triple("513", "Wrong", Color(0xFFE54B64)),
                Triple("187", "Skipped", Color(0xFF7F8FA8)),
                Triple("78.4%", "Net Acc.", Color(0xFFF0A330))
            ),
            lineColor = Color(0xFF5A78FF)
        )
        NumberOfQuestionsCard()
        SubjectAccuracyCard()
        FocusAreasCard(
            "⚠️ FOCUS AREAS",
            "Economy (44%) and Geography (38%) need\nimmediate attention. Dedicate 30 min daily this\nweek to these subjects."
        )
        BottomActions()
    }
}

@Composable
private fun MainsTab() {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MetricCard("ANSWERS WRITTEN", "38", "this month", Color(0xFF60B977), Modifier.weight(1f))
            MetricCard("AVG SCORE", "7.4", "/10", Color(0xFFF09C2B), Modifier.weight(1f))
            MetricCard("AVERAGE TIME", "12m", "per answer", Color(0xFF5A78FF), Modifier.weight(1f))
        }
        TrendCard(
            title = "📈 Daily Mains Challenge Trend",
            subtitle = "Performance across 8 tests",
            metrics = listOf(
                Triple("8.2", "Latest Score", Color(0xFF6F63FF)),
                Triple("+0.8", "Improvement", Color(0xFF4CAF50)),
                Triple("38", "Answers Written", Color(0xFFF0A330))
            ),
            lineColor = Color(0xFFF0B13A)
        )
        NumberOfQuestionsCard()
        TimePerQuestionCard()
        RecentMainsCard()
        BottomActions()
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                metrics.forEach { m ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(m.first, color = m.third, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                        Text(m.second, color = Color(0xFF9AA8BE), fontSize = 9.sp)
                    }
                }
            }
        }
        SpacerH(10)
        Sparkline(lineColor)
    }
}

@Composable
private fun Sparkline(lineColor: Color) {
    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(Color(0xFFF8FAFF), RoundedCornerShape(10.dp))
            .padding(horizontal = 6.dp, vertical = 6.dp)
    ) {
        val points = listOf(
            0.12f to 0.72f,
            0.24f to 0.65f,
            0.36f to 0.61f,
            0.48f to 0.52f,
            0.60f to 0.45f,
            0.72f to 0.35f,
            0.86f to 0.24f,
            0.96f to 0.20f,
        )

        val grid = Color(0xFFDCE4F0)
        repeat(4) { idx ->
            val y = size.height * (idx + 1) / 5f
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

        drawPath(path = path, color = lineColor, style = Stroke(width = 5f, cap = StrokeCap.Round))

        mapped.forEachIndexed { index, pt ->
            if (index % 2 == 0 || index == mapped.lastIndex) {
                drawCircle(Color.White, radius = 6f, center = pt)
                drawCircle(lineColor, radius = 4.2f, center = pt)
            }
        }
    }
}

@Composable
private fun NumberOfQuestionsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE4F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("🗓️ Number Of Questions", color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("Total: 287", color = Color(0xFF6581FF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
        SpacerH(10)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            val bars = listOf(
                "Mon" to 12,
                "Tue" to 16,
                "Wed" to 11,
                "Thu" to 28,
                "Fri" to 25,
                "Sat" to 25,
                "Sun" to 25,
            )
            bars.forEachIndexed { idx, (d, value) ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .width(16.dp)
                            .height((18 + (value / 2)).dp)
                            .background(
                                if (idx == 3) Color(0xFFF0A330) else Color(0xFFD8DEE9),
                                RoundedCornerShape(4.dp)
                            )
                    )
                    SpacerH(4)
                    Text(d, color = Color(0xFF9AA8BE), fontSize = 8.sp)
                    Text(value.toString(), color = Color(0xFF9AA8BE), fontSize = 8.sp)
                }
            }
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            LegendDot(Color(0xFF111827), "Completed")
            LegendDot(Color(0xFFF0A330), "Target")
        }
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
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("📍 Subject Accuracy", color = Color(0xFF26365D), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("Across all MCQ's", color = Color(0xFFA1AFC4), fontSize = 9.sp)
        }
        SpacerH(8)
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
            SpacerH(7)
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
