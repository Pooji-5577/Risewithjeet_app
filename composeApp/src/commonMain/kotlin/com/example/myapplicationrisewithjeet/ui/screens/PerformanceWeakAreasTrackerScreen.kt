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
fun PerformanceWeakAreasTrackerScreen(onBack: () -> Unit = {}) {
    val trackerRows = listOf(
        TrackerRow("⚖️", "Polity & Governance", 84, Color(0xFF071224), Color(0xFF22C55E), "Strong", Color(0xFFDCFCE7), Color(0xFF15803D), "162 Qs · ↑ +5% this month"),
        TrackerRow("🏛️", "Modern History", 79, Color(0xFF3B82F6), Color(0xFF22C55E), "Strong", Color(0xFFDCFCE7), Color(0xFF15803D), "118 Qs · Consistent"),
        TrackerRow("🎨", "Art & Culture", 76, Color(0xFFF5A623), Color(0xFFE8950F), "Good", Color(0xFFFFF8ED), Color(0xFFE8950F), "64 Qs · Practice more"),
        TrackerRow("🔬", "Science & Technology", 73, Color(0xFF8B5CF6), Color(0xFFE8950F), "Good", Color(0xFFFFF8ED), Color(0xFFE8950F), "88 Qs · ↑ +4% this week"),
        TrackerRow("🌐", "Intl. Relations", 71, Color(0xFF06B6D4), Color(0xFFE8950F), "Good", Color(0xFFFFF8ED), Color(0xFFE8950F), "55 Qs"),
        TrackerRow("🏺", "Ancient History", 54, Color(0xFFF5A623), Color(0xFFE8950F), "Average", Color(0xFFFFF8ED), Color(0xFFE8950F), "48 Qs · Improve needed"),
        TrackerRow("🌿", "Environment & Ecology", 51, Color(0xFFF97316), Color(0xFFEF4444), "Weak", Color(0xFFFEF2F2), Color(0xFFEF4444), "72 Qs · Needs revision"),
        TrackerRow("💰", "Indian Economy", 48, Color(0xFFF97316), Color(0xFFEF4444), "Weak", Color(0xFFFEF2F2), Color(0xFFEF4444), "84 Qs · HIGH IMPACT"),
        TrackerRow("🗺️", "Geography", 42, Color(0xFFEF4444), Color(0xFFEF4444), "Critical", Color(0xFFFEF2F2), Color(0xFFEF4444), "96 Qs · Needs revision NOW")
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
                    append("Strong & Weak Areas ")
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
                text = "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas, spaced repetition & smart notes.",
                color = Color.White.copy(alpha = 0.4f),
                fontSize = 10.5.sp,
                lineHeight = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OverviewStatsCard()

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
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 10.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp))
                    ) {
                        trackerRows.forEachIndexed { index, row ->
                            TrackerSubjectRow(
                                row = row,
                                showDivider = index != trackerRows.lastIndex
                            )
                        }
                    }
                }
            }
        }
    }
}

private data class TrackerRow(
    val icon: String,
    val title: String,
    val score: Int,
    val progressColor: Color,
    val scoreColor: Color,
    val badgeText: String,
    val badgeBg: Color,
    val badgeTextColor: Color,
    val meta: String
)

@Composable
private fun OverviewStatsCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(13.dp))
            .background(Color(0xFF192333))
            .padding(horizontal = 13.dp, vertical = 13.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OverviewStat(value = "72%", label = "OVERALL ACCURACY", valueColor = Color(0xFF22C55E), modifier = Modifier.weight(1f), withDivider = true)
        OverviewStat(value = "847", label = "TOTAL QS", valueColor = Color.White, modifier = Modifier.weight(1f), withDivider = true)
        OverviewStat(value = "8/10", label = "SUBJECTS", valueColor = Color(0xFFF5A623), modifier = Modifier.weight(1f), withDivider = false)
    }
}

@Composable
private fun OverviewStat(
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
            Text(
                text = value,
                color = valueColor,
                fontSize = 31.sp / 2,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = label,
                color = Color.White.copy(alpha = 0.35f),
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold
            )
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
private fun TrackerSubjectRow(row: TrackerRow, showDivider: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp, vertical = 11.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            Text(text = row.icon, fontSize = 17.sp)
            Text(
                text = row.title,
                color = Color(0xFF071326),
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "${row.score}%",
                color = row.scoreColor,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFFEEF2F8))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(row.score / 100f)
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(row.progressColor)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(row.badgeBg)
                    .padding(horizontal = 8.dp, vertical = 2.5.dp)
            ) {
                Text(
                    text = row.badgeText,
                    color = row.badgeTextColor,
                    fontSize = 8.5.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = row.meta,
                color = Color(0xFF8FA3C0),
                fontSize = 9.5.sp
            )
        }
    }

    if (showDivider) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFF0F4F8))
        )
    }
}
