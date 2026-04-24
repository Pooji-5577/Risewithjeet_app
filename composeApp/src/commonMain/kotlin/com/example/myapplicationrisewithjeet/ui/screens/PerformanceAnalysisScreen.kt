package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val HistoryScoreColumnWidth = 72.dp
private val HistoryActionColumnWidth = 52.dp

@Composable
fun PerformanceAnalysisScreen(
    onBack: () -> Unit = {},
    onNeedsWorkView: () -> Unit = {},
    onStudyStreakView: () -> Unit = {},
    onDailyTrioView: () -> Unit = {},
    onTestHistoryView: () -> Unit = {},
    onAchievementAllView: () -> Unit = {},
    onWeeklyLeaderboardView: () -> Unit = {},
    onJeetAIReportView: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
    ) {
        Header(onBack = onBack)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF071326))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
                    .padding(top = 8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            KpiCards()
                            StudyTimeCard()
                            TimeDistributionCard()
                            SectionLabel("STRONG & WEAK AREAS")
                            StrongWeakCards(onNeedsWorkView = onNeedsWorkView)
                            StudyStreakCard(onViewAll = onStudyStreakView)
                            DailyTrioCard(onViewAll = onDailyTrioView)
                            TestHistoryCard(onViewAll = onTestHistoryView)
                            AchievementSection(onAllClick = onAchievementAllView)
                            SectionLabel("WEEKLY LEADERBOARD")
                            WeeklyLeaderboardCard(onViewAll = onWeeklyLeaderboardView)
                            AiInsightsCard(onFullReport = onJeetAIReportView)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun Header(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF071326))
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFF96ABCA), fontSize = 16.sp, modifier = Modifier.clickable { onBack() })
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.1f))
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text("📅 This Week ▾", color = Color.White.copy(alpha = 0.7f), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFF5A623).copy(alpha = 0.18f))
                .border(1.dp, Color(0xFFF5A623).copy(alpha = 0.32f), RoundedCornerShape(20.dp))
                .padding(horizontal = 13.dp, vertical = 4.dp)
        ) {
            Text(
                "📊PERFORMANCE ANALYTICS DASHBOARD",
                color = Color(0xFFF5A623),
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.9.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            buildAnnotatedString {
                append("Arjun's ")
                withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Progress.") }
            },
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 25.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas, spaced repetition & smart notes.",
            color = Color.White.copy(alpha = 0.4f),
            fontSize = 10.5.sp,
            lineHeight = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun KpiCards() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        KpiCard("🔥 Day Streak", "38", "↑ 8 days this month", Color(0xFFFFA500), Color(0xFFE8950F), Modifier.weight(1f))
        KpiCard("🎯 Qs Attempted", "847", "↑ 162 this week", Color(0xFFFF0000), Color(0xFF071224), Modifier.weight(1f))
        KpiCard("⏱️ Study Time", "124h", "↑ 18h this week", Color(0xFF1A56C4), Color(0xFF3B82F6), Modifier.weight(1f))
    }
}

@Composable
private fun KpiCard(label: String, value: String, note: String, topColor: Color, valueColor: Color, modifier: Modifier = Modifier) {
    val cardShape = RoundedCornerShape(13.dp)
    Column(
        modifier = modifier
            .heightIn(min = 78.dp)
            .performanceCardShadow(cardShape)
            .clip(cardShape)
            .background(Color.White, cardShape)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(topColor)
        )
        Column(modifier = Modifier.padding(horizontal = 11.dp, vertical = 10.dp)) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(label, color = Color(0xFF8FA3C0), fontSize = 8.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.8.sp)
            Text(value, color = valueColor, fontSize = 22.sp, fontWeight = FontWeight.Bold, lineHeight = 22.sp)
            Text(note, color = Color(0xFF22C55E), fontSize = 8.5.sp, lineHeight = 9.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun StudyTimeCard() {
    CardShell {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("⏱️ Study Time", color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("↑ +22% vs last", color = Color(0xFF22C55E), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            StatBlock("3h12m", "TODAY", Color(0xFF071326), Modifier.weight(1f))
            StatBlock("4h22m", "BEST DAY", Color(0xFFE8950F), Modifier.weight(1f))
            StatBlock("2h38m", "DAILY AVG", Color(0xFF071326), Modifier.weight(1f))
            StatBlock("18h", "TOTAL", Color(0xFFE8950F), Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(10.dp))

        val bars = listOf(
            Triple("Mon", "1.5h", Color(0xFFDCE8FF) to 28.dp),
            Triple("Tue", "2.2h", Color(0xFFC5D8F8) to 36.dp),
            Triple("Wed", "2.5h", Color(0xFFB8CEF0) to 40.dp),
            Triple("Thu", "4.4h", Color(0xFFF5A623) to 42.dp),
            Triple("Fri", "-", Color(0xFFF0F4F8) to 22.dp),
            Triple("Sat", "-", Color(0xFFF0F4F8) to 22.dp),
            Triple("Sun", "-", Color(0xFFF0F4F8) to 22.dp)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
            bars.forEach { (day, time, bar) ->
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(bar.second)
                            .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                            .background(bar.first)
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(day, color = if (day == "Thu") Color(0xFFE8950F) else Color(0xFF8FA3C0), fontSize = 8.sp, lineHeight = 8.sp, fontWeight = FontWeight.Bold)
                    Text(time, color = if (day == "Thu") Color(0xFFE8950F) else Color(0xFF8FA3C0), fontSize = 7.5.sp, lineHeight = 7.5.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun StatBlock(value: String, label: String, color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(value, color = color, fontSize = 16.sp, lineHeight = 16.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Color(0xFF8FA3C0), fontSize = 8.sp, lineHeight = 8.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun TimeDistributionCard() {
    val pieces = listOf(
        Triple("GS I", 0.28f, Color(0xFF071224)),
        Triple("GS II", 0.22f, Color(0xFF3B82F6)),
        Triple("GS III", 0.20f, Color(0xFF22C55E)),
        Triple("GS IV", 0.15f, Color(0xFFF59E0B)),
        Triple("Essay", 0.10f, Color(0xFF8B5CF6)),
        Triple("Curr. Affairs", 0.05f, Color(0xFF06B6D4))
    )

    CardShell {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🥧 Time Distribution", color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("18h total", color = Color(0xFFE8950F), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    var startAngle = -90f
                    pieces.forEach { (_, pct, color) ->
                        val sweep = pct * 360f
                        drawArc(
                            color = color,
                            startAngle = startAngle,
                            sweepAngle = sweep,
                            useCenter = false,
                            style = Stroke(width = 18f, cap = StrokeCap.Butt)
                        )
                        startAngle += sweep
                    }
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("18h", color = Color(0xFF071326), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("TOTAL", color = Color(0xFF8FA3C0), fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
            }

            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                pieces.forEach { (name, pct, color) ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(8.dp).background(color, RoundedCornerShape(4.dp)))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(name, color = Color(0xFF4A5568), fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold)
                        }
                        Text("${(pct * 100).toInt()}%", color = Color(0xFF071326), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.weight(1f).height(1.dp).background(Color(0xFFE0E8F2)))
        Text(text, modifier = Modifier.padding(horizontal = 8.dp), color = Color(0xFF8FA3C0), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Box(modifier = Modifier.weight(1f).height(1.dp).background(Color(0xFFE0E8F2)))
    }
}

@Composable
private fun StrongWeakCards(onNeedsWorkView: () -> Unit) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SubjectStrengthCard(
            title = "💪 Strong Areas",
            showView = false,
            rows = listOf(
                SubjectRow("Polity & Gov.", 84, "162 Qs", Color(0xFF071224), Color(0xFF22C55E)),
                SubjectRow("Modern History", 79, "118 Qs", Color(0xFF3B82F6), Color(0xFF22C55E)),
                SubjectRow("Art & Culture", 76, "64 Qs", Color(0xFFF5A623), Color(0xFFE8950F)),
                SubjectRow("Science & Tech", 73, "88 Qs", Color(0xFF8B5CF6), Color(0xFFE8950F))
            ),
            modifier = Modifier.weight(1f)
        )

        SubjectStrengthCard(
            title = "⚠️ Needs Work",
            showView = true,
            rows = listOf(
                SubjectRow("Geography", 42, "96 Qs", Color(0xFFEF4444), Color(0xFFEF4444), "Needs Rev."),
                SubjectRow("Indian Economy", 48, "84 Qs", Color(0xFFF97316), Color(0xFFEF4444)),
                SubjectRow("Environment", 51, "72 Qs", Color(0xFFF97316), Color(0xFFEF4444)),
                SubjectRow("Ancient History", 54, "48 Qs", Color(0xFFF5A623), Color(0xFFE8950F))
            ),
            onView = onNeedsWorkView,
            modifier = Modifier.weight(1f)
        )
    }
}

data class SubjectRow(
    val title: String,
    val score: Int,
    val questions: String,
    val bar: Color,
    val scoreColor: Color,
    val badge: String? = null
)

@Composable
private fun SubjectStrengthCard(
    title: String,
    showView: Boolean,
    rows: List<SubjectRow>,
    modifier: Modifier = Modifier,
    onView: (() -> Unit)? = null
) {
    val cardShape = RoundedCornerShape(14.dp)
    Column(
        modifier = modifier
            .fillMaxHeight()
            .performanceCardShadow(cardShape)
            .background(Color.White, cardShape)
            .border(1.dp, Color(0xFFE2E8F0), cardShape)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(title, color = Color(0xFF071326), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            if (showView) {
                Text(
                    text = "View →",
                    color = Color(0xFF071224),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = if (onView != null) Modifier.clickable { onView() } else Modifier
                )
            }
        }
        rows.forEach {
            Text(it.title, color = Color(0xFF4A5568), fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(Color(0xFFEEF2F8), RoundedCornerShape(3.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(it.score / 100f)
                        .height(5.dp)
                        .background(it.bar, RoundedCornerShape(3.dp))
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (it.badge != null) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xFFFEF2F2))
                                .padding(horizontal = 6.dp, vertical = 1.dp)
                        ) {
                            Text(it.badge, color = Color(0xFFEF4444), fontSize = 7.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                    Text(it.questions, color = Color(0xFF8FA3C0), fontSize = 8.sp, lineHeight = 8.sp)
                }
                Text("${it.score}%", color = it.scoreColor, fontSize = 10.sp, lineHeight = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun StudyStreakCard(onViewAll: () -> Unit) {
    val dayLabels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val weeks = listOf(
        listOf(null, null, null, null, null, 1 to 0, 2 to 0),
        listOf(3 to 0, 4 to 0, 5 to 0, 6 to 1, 7 to 1, 8 to 2, 9 to 2),
        listOf(10 to 3, 11 to 3, 12 to 3, 13 to 3, 14 to 2, 15 to 3, 16 to 3),
        listOf(17 to 3, 18 to 3, 19 to 3, 20 to 3, 21 to 3, 22 to 3, 23 to 3),
        listOf(24 to 3, 25 to 3, 26 to 3, 27 to 2, 28 to 3, null, null)
    )

    CardShell {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("📅 Study Streak — Feb 2026", color = Color(0xFF071326), fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "View All →",
                color = Color(0xFF071224),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onViewAll() }
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Text("🔥 42 Days!", color = Color(0xFFE8950F), fontSize = 12.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(7.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            LegendItem("None", Color(0xFFF0F4F8))
            LegendItem("Light", Color(0xFFD1FAE5))
            LegendItem("Medium", Color(0xFF86EFAC))
            LegendItem("Intense", Color(0xFF22C55E))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.fillMaxWidth()) {
            dayLabels.forEach {
                Text(
                    it,
                    color = Color(0xFF8FA3C0),
                    fontSize = 7.5.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                )
            }
        }

        Spacer(modifier = Modifier.height(3.dp))

        weeks.forEachIndexed { index, week ->
            Row(horizontalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.fillMaxWidth()) {
                week.forEach { day ->
                    val level = day?.second ?: -1
                    val bg = when (level) {
                        0 -> Color(0xFFF0F4F8)
                        1 -> Color(0xFFD1FAE5)
                        2 -> Color(0xFF86EFAC)
                        3 -> Color(0xFF22C55E)
                        else -> Color.Transparent
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(26.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(bg)
                            .then(
                                if (day?.first == 23) {
                                    Modifier.border(2.dp, Color(0xFFF5A623), RoundedCornerShape(6.dp))
                                } else Modifier
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (day != null) {
                            Text(
                                day.first.toString(),
                                color = when (level) {
                                    0 -> Color(0xFFC5D3E8)
                                    1 -> Color(0xFF065F46)
                                    2 -> Color(0xFF14532D)
                                    else -> Color.White
                                },
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            if (index < weeks.lastIndex) {
                Spacer(modifier = Modifier.height(2.dp))
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFF0F4F8)))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BottomMetric("4h 32m", "AVG DAILY", Color(0xFF071326), Modifier.weight(1f))
            BottomMetric("26/28", "ACTIVE DAYS", Color(0xFFE8950F), Modifier.weight(1f))
            BottomMetric("127h", "TOTAL FEB", Color(0xFF071224), Modifier.weight(1f))
        }
    }
}

@Composable
private fun LegendItem(text: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(10.dp).background(color, RoundedCornerShape(2.dp)))
        Spacer(modifier = Modifier.width(3.dp))
        Text(text, color = Color(0xFF8FA3C0), fontSize = 8.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun BottomMetric(value: String, label: String, valueColor: Color, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp),
        modifier = modifier
    ) {
        Text(value, color = valueColor, fontSize = 15.sp, lineHeight = 15.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Color(0xFF8FA3C0), fontSize = 7.5.sp, lineHeight = 7.5.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun DailyTrioCard(onViewAll: () -> Unit) {
    CardShell(
        modifier = Modifier.clickable { onViewAll() }
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("⚡ Daily Trio", color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "View All →",
                color = Color(0xFF071224),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onViewAll() }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        TrioRow("✍️", "Daily MCQ Challenge", "All Prelims Subject", "6/7", Color(0xFF22C55E), Color(0xFFFFF8ED))
        Spacer(modifier = Modifier.height(8.dp))
        TrioRow("✏️", "Daily Mains Challenge", "Mains Answer Writing", "5/7", Color(0xFFE8950F), Color(0xFFF5F3FF))
        Spacer(modifier = Modifier.height(8.dp))
        TrioRow("📰", "Daily News Analysis", "The Hindu, Indian Express", "4/7", Color(0xFFEF4444), Color(0xFFF0FDF4))
    }
}

@Composable
private fun TrioRow(icon: String, title: String, subtitle: String, value: String, valueColor: Color, iconBg: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF0F4F8))
            .padding(horizontal = 13.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(modifier = Modifier.size(36.dp).clip(RoundedCornerShape(10.dp)).background(iconBg), contentAlignment = Alignment.Center) {
            Text(icon, fontSize = 17.sp)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = Color(0xFF071326), fontSize = 12.sp, lineHeight = 12.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Color(0xFF8FA3C0), fontSize = 9.5.sp, lineHeight = 9.5.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(value, color = valueColor, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("days", color = Color(0xFF8FA3C0), fontSize = 9.sp)
        }
    }
}

@Composable
private fun TestHistoryCard(onViewAll: () -> Unit) {
    val cardShape = RoundedCornerShape(16.dp)
    val rows = listOf(
        TestRow("Prelims Mock Test 8", "Full Mock", "100 Q · 2d ago", "94/200", Color(0xFFC95212)),
        TestRow("Current Affairs Test 4", "CA Daily", "30 Q · 5d ago", "43/60", Color(0xFF1A56C4)),
        TestRow("Prelims Mock Test 7", "Full Mock", "100 Q · 9 d ago", "88/200", Color(0xFFC95212)),
        TestRow("Prelims Mock Test 8", "Full Mock", "100 Q · 2d ago", "94/200", Color(0xFFC95212)),
        TestRow("Current Affairs Test 4", "CA Daily", "30 Q · 5d ago", "43/60", Color(0xFF1A56C4)),
        TestRow("Prelims Mock Test 7", "Full Mock", "100 Q · 9 d ago", "88/200", Color(0xFFC95212))
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .performanceCardShadow(cardShape)
            .clip(cardShape)
            .background(Color.White)
            .border(1.dp, Color(0xFFDDE5F0), cardShape)
    ) {
        Text("📋 Complete Test History", color = Color(0xFF071326), fontSize = 12.5.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp, 12.dp, 16.dp, 0.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .border(1.dp, Color(0xFFF0F4F8), RoundedCornerShape(0.dp))
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "TEST NAME",
                color = Color(0xFF8FA4BE),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "SCORE",
                color = Color(0xFF8FA4BE),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.width(HistoryScoreColumnWidth)
            )
            Text(
                text = "VIEW",
                color = Color(0xFF8FA4BE),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.width(HistoryActionColumnWidth)
            )
        }

        rows.forEachIndexed { idx, row ->
            if (idx > 0) Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFF0F4F8)))
            HistoryRow(row)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEEF2F8))
                .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(0.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Showing 6 of 12 tests", color = Color(0xFF5A7096), fontSize = 11.5.sp)
            Text(
                text = "View All →",
                color = Color(0xFF1A56C4),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onViewAll() }
            )
        }
    }
}

data class TestRow(val title: String, val tag: String, val meta: String, val score: String, val scoreColor: Color)

@Composable
private fun HistoryRow(row: TestRow) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(row.title, color = Color(0xFF1A2744), fontSize = 12.5.sp, lineHeight = 12.5.sp, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(if (row.tag == "CA Daily") Color(0xFFFEF5EC) else Color(0xFFF0F4F8)).padding(horizontal = 8.dp, vertical = 2.dp)) {
                    Text(row.tag, color = if (row.tag == "CA Daily") Color(0xFFC95212) else Color(0xFF0D1B2E), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(row.meta, color = Color(0xFF5A7096), fontSize = 11.sp, lineHeight = 11.sp)
            }
        }
        Text(
            text = row.score,
            color = row.scoreColor,
            fontSize = 13.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.End,
            modifier = Modifier.width(HistoryScoreColumnWidth)
        )
        Text(
            text = "View →",
            color = Color(0xFF0E8A56),
            fontSize = 11.5.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.End,
            modifier = Modifier.width(HistoryActionColumnWidth)
        )
    }
}

@Composable
private fun AchievementSection(onAllClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text("🏅 Achievement Badges", color = Color(0xFF071326), fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFFFF8ED))
                    .border(1.dp, Color(0x47F5A623), RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text("8 Earned", color = Color(0xFFE8950F), fontSize = 9.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "All →",
                color = Color(0xFF071224),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onAllClick() }
            )
        }
    }

    Spacer(modifier = Modifier.height(4.dp))

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
        AchievementBadge("🔥", "30-Day Streak", "✓ Earned", true, Modifier.weight(1f))
        AchievementBadge("⚡", "Quick Learner", "✓ Earned", true, Modifier.weight(1f))
        AchievementBadge("🧠", "1000 Qs Club", "✓ Earned", true, Modifier.weight(1f))
        AchievementBadge("🌍", "Geo Warrior", "🔒 Locked", false, Modifier.weight(1f))
    }
}

@Composable
private fun AchievementBadge(icon: String, title: String, status: String, earned: Boolean, modifier: Modifier = Modifier) {
    val cardShape = RoundedCornerShape(13.dp)
    Column(
        modifier = modifier
            .height(98.dp)
            .performanceCardShadow(cardShape)
            .then(if (!earned) Modifier.alpha(0.45f) else Modifier)
            .clip(cardShape)
            .background(if (earned) Color(0xFFFFF8ED) else Color.White)
            .border(1.dp, if (earned) Color(0x47F5A623) else Color(0xFFE2E8F0), cardShape)
            .padding(horizontal = 9.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(icon, fontSize = 24.sp)
        Text(title, color = Color(0xFF071326), fontSize = 9.sp, lineHeight = 12.6.sp, fontWeight = FontWeight.Bold)
        Text(status, color = if (earned) Color(0xFF22C55E) else Color(0xFF8FA3C0), fontSize = 8.sp, lineHeight = 9.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun WeeklyLeaderboardCard(onViewAll: () -> Unit) {
    val cardShape = RoundedCornerShape(14.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .performanceCardShadow(cardShape)
            .clip(cardShape)
            .background(Color.White)
            .border(1.dp, Color(0xFFE2E8F0), cardShape)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 13.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("🏆 Weekly Leaderboard", color = Color(0xFF071326), fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "View All →",
                color = Color(0xFF071224),
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onViewAll() }
            )
        }
        LeaderRow("🥇", "JD", "John Doe", "998", Color(0xFFE8950F), Brush.linearGradient(listOf(Color(0xFFF5A623), Color(0xFFE8950F))))
        LeaderRow("🥈", "SB", "Shubham Bharti", "948", Color(0xFF071326), Brush.linearGradient(listOf(Color(0xFF94A3B8), Color(0xFF64748B))))
        LeaderRow("🥉", "PK", "Priya Kumar", "921", Color(0xFF071326), Brush.linearGradient(listOf(Color(0xFF92400E), Color(0xFFB45309))))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF8ED))
                .drawBehind {
                    // Mixed inside stroke: left = 3dp, bottom = 1dp, top/right = 0dp
                    val leftStroke = 3.dp.toPx()
                    val bottomStroke = 1.dp.toPx()
                    val strokeColor = Color(0xFFF5A623)
                    drawRect(
                        color = strokeColor,
                        topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
                        size = androidx.compose.ui.geometry.Size(leftStroke, size.height)
                    )
                    drawRect(
                        color = strokeColor,
                        topLeft = androidx.compose.ui.geometry.Offset(0f, size.height - bottomStroke),
                        size = androidx.compose.ui.geometry.Size(size.width, bottomStroke)
                    )
                }
                .padding(horizontal = 13.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("#428", color = Color(0xFFE8950F), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier.size(32.dp).background(Brush.linearGradient(listOf(Color(0xFFF5A623), Color(0xFFEF4444))), RoundedCornerShape(9.dp)), contentAlignment = Alignment.Center) {
                Text("AK", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text("You · Arjun K.", color = Color(0xFFE8950F), fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.End) {
                Text("742", color = Color(0xFFE8950F), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("↑ +12", color = Color(0xFF22C55E), fontSize = 9.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun LeaderRow(rank: String, initials: String, name: String, score: String, scoreColor: Color, avatarBrush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFFF0F4F8), RoundedCornerShape(0.dp))
            .padding(horizontal = 13.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(rank, color = Color(0xFF071326), fontSize = 18.sp)
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.size(32.dp).background(avatarBrush, RoundedCornerShape(9.dp)), contentAlignment = Alignment.Center) {
            Text(initials, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(name, color = Color(0xFF071326), fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Text(score, color = scoreColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun AiInsightsCard(onFullReport: () -> Unit) {
    val cardShape = RoundedCornerShape(14.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .performanceCardShadow(cardShape)
            .clip(cardShape)
            .background(Brush.linearGradient(listOf(Color(0xFF162240), Color(0xFF1C2E50))))
            .padding(top = 8.dp, bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(0.dp))
                .padding(horizontal = 14.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🤖", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(9.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Text("Jeet AI Weekly Insights", color = Color.White, fontSize = 13.sp, lineHeight = 14.sp, fontWeight = FontWeight.Bold)
                Text("Auto-generated · 8 Mar 2026", color = Color.White.copy(alpha = 0.4f), fontSize = 9.5.sp, lineHeight = 10.sp)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFF5A623).copy(alpha = 0.2f))
                    .clickable { onFullReport() }
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text("Full Report →", color = Color(0xFFF5A623), fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }

        InsightRow("🗺️", Color(0xFFEF4444).copy(alpha = 0.15f), "Geography is your biggest gap", "42% accuracy on 96 Qs. Spend 45 min daily on maps, rivers,\nand climate for 2 weeks.", "HIGH IMPACT", Color(0xFFEF4444).copy(alpha = 0.2f), Color(0xFFFCA5A5))
        InsightRow("🔥", Color(0xFF22C55E).copy(alpha = 0.15f), "42-day streak — exceptional!", "You're in the top 3% of consistent studiers. Your Polity\naccuracy has jumped 12% this month.", "STRENGTH", Color(0xFF22C55E).copy(alpha = 0.2f), Color(0xFF86EFAC))
        InsightRow("⚡", Color(0xFFF5A623).copy(alpha = 0.15f), "Economy speed issue detected", "Avg 2m 44s on Economy Qs vs recommended 90s. Skip early\nand return in last 20 min.", "STRATEGY FIX", Color(0xFFF5A623).copy(alpha = 0.2f), Color(0xFFFDE68A), isLast = true)
    }
}

@Composable
private fun InsightRow(icon: String, iconBg: Color, title: String, desc: String, tag: String, tagBg: Color, tagColor: Color, isLast: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(if (!isLast) Modifier.border(1.dp, Color.White.copy(alpha = 0.06f), RoundedCornerShape(0.dp)) else Modifier)
            .padding(horizontal = 14.dp, vertical = 11.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(modifier = Modifier.size(30.dp).clip(RoundedCornerShape(9.dp)).background(iconBg), contentAlignment = Alignment.Center) {
            Text(icon, fontSize = 14.sp)
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Text(title, color = Color.White, fontSize = 12.sp, lineHeight = 13.sp, fontWeight = FontWeight.Bold)
            Text(desc, color = Color.White.copy(alpha = 0.5f), fontSize = 10.sp, lineHeight = 14.sp)
            Box(modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(tagBg).padding(horizontal = 8.dp, vertical = 2.dp)) {
                Text(tag, color = tagColor, fontSize = 8.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun CardShell(
    modifier: Modifier = Modifier,
    body: @Composable () -> Unit
) {
    val cardShape = RoundedCornerShape(14.dp)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .performanceCardShadow(cardShape)
            .background(Color.White, cardShape)
            .border(1.dp, Color(0xFFE2E8F0), cardShape)
            .padding(14.dp)
    ) {
        body()
    }
}

private fun Modifier.performanceCardShadow(shape: Shape): Modifier =
    this.shadow(
        elevation = 12.dp,
        shape = shape,
        clip = false,
        ambientColor = Color(0x14162240),
        spotColor = Color(0x14162240)
    )
