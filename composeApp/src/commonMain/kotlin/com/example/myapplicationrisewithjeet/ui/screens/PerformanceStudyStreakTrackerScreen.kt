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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerformanceStudyStreakTrackerScreen(onBack: () -> Unit = {}) {
    val dayLabels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val weeks = listOf(
        listOf(null, null, null, null, null, 1 to 0, 2 to 0),
        listOf(3 to 0, 4 to 0, 5 to 0, 6 to 1, 7 to 1, 8 to 2, 9 to 2),
        listOf(10 to 3, 11 to 3, 12 to 3, 13 to 3, 14 to 2, 15 to 3, 16 to 3),
        listOf(17 to 3, 18 to 3, 19 to 3, 20 to 3, 21 to 3, 22 to 3, 23 to 3),
        listOf(24 to 3, 25 to 3, 26 to 3, 27 to 2, 28 to 3, null, null)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF071224))
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "←",
                    color = Color(0xFF96ABCA),
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onBack() }
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White.copy(alpha = 0.1f))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "📅 This Week ▾",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
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
                    text = "📊PERFORMANCE ANALYTICS DASHBOARD",
                    color = Color(0xFFF5A623),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.9.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = buildAnnotatedString {
                    append("Study Streak ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Tracker") }
                },
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 25.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Track your daily consistency with a detailed streak calendar,\nintensity levels, and month-wise productivity trends.",
                color = Color.White.copy(alpha = 0.4f),
                fontSize = 10.5.sp,
                lineHeight = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(13.dp))
                    .background(Color(0xFF192333))
                    .padding(horizontal = 13.dp, vertical = 13.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderStat("42", "CURRENT STREAK", Color(0xFFE8950F), Modifier.weight(1f), withDivider = true)
                HeaderStat("57", "BEST STREAK", Color.White, Modifier.weight(1f), withDivider = true)
                HeaderStat("26/28", "ACTIVE DAYS", Color(0xFF22C55E), Modifier.weight(1f), withDivider = false)
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFFF0F4FA))
                .padding(top = 8.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp))
                            .padding(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("📅 February 2026", color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(99.dp))
                                    .background(Color(0xFFF8FAFD))
                                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(99.dp))
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text("Monthly View ▾", color = Color(0xFF4A5568), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.height(9.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            LevelLegend("None", Color(0xFFF0F4F8))
                            LevelLegend("Light", Color(0xFFD1FAE5))
                            LevelLegend("Medium", Color(0xFF86EFAC))
                            LevelLegend("Intense", Color(0xFF22C55E))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.fillMaxWidth()) {
                            dayLabels.forEach {
                                Text(
                                    text = it,
                                    color = Color(0xFF8FA3C0),
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        weeks.forEach { week ->
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
                                            .height(30.dp)
                                            .clip(RoundedCornerShape(5.dp))
                                            .background(bg)
                                            .then(
                                                if (day?.first == 23) {
                                                    Modifier.border(2.dp, Color(0xFFF5A623), RoundedCornerShape(6.dp))
                                                } else {
                                                    Modifier
                                                }
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (day != null) {
                                            Text(
                                                text = day.first.toString(),
                                                color = when (level) {
                                                    0 -> Color(0xFFC5D3E8)
                                                    1 -> Color(0xFF065F46)
                                                    2 -> Color(0xFF14532D)
                                                    else -> Color.White
                                                },
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(3.dp))
                        }

                        Spacer(modifier = Modifier.height(7.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color(0xFFF0F4F8))
                                .padding(top = 11.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            BottomStat("4h 32m", "AVG DAILY", Color(0xFF071326), Modifier.weight(1f))
                            BottomStat("26/28", "ACTIVE DAYS", Color(0xFFE8950F), Modifier.weight(1f))
                            BottomStat("127h", "TOTAL FEB", Color(0xFF071224), Modifier.weight(1f))
                        }
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp))
                            .padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("🎯 Streak Milestones", color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        MilestoneRow("✅", "7-day streak completed", "Unlocked")
                        MilestoneRow("✅", "14-day streak completed", "Unlocked")
                        MilestoneRow("✅", "30-day streak completed", "Unlocked")
                        MilestoneRow("🔒", "60-day streak target", "18 days to go")
                    }
                }
            }
        }
    }
}

@Composable
private fun HeaderStat(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier,
    withDivider: Boolean
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, color = valueColor, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(text = label, color = Color.White.copy(alpha = 0.35f), fontSize = 8.sp, fontWeight = FontWeight.Bold)
        }
        if (withDivider) {
            Box(
                modifier = Modifier
                    .height(34.dp)
                    .width(1.dp)
                    .background(Color.White.copy(alpha = 0.1f))
            )
        }
    }
}

@Composable
private fun LevelLegend(label: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(10.dp).background(color, RoundedCornerShape(2.dp)))
        Spacer(modifier = Modifier.width(3.dp))
        Text(label, color = Color(0xFF8FA3C0), fontSize = 8.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun BottomStat(value: String, label: String, valueColor: Color, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(value, color = valueColor, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Color(0xFF8FA3C0), fontSize = 7.5.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun MilestoneRow(icon: String, title: String, status: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF8FAFD))
            .border(1.dp, Color(0xFFEDF2F7), RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(icon, fontSize = 12.sp)
        Text(title, color = Color(0xFF1F2937), fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
        Text(
            status,
            color = if (status == "Unlocked") Color(0xFF22C55E) else Color(0xFFE8950F),
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
