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
fun PerformanceCompleteTestHistoryScreen(onBack: () -> Unit = {}) {
    val rows = listOf(
        HistoryEntry("Prelims Mock Test 8", "Full Mock", "100 Q · 2d ago", "94/200", Color(0xFFC95212)),
        HistoryEntry("Current Affairs Test 4", "CA Daily", "30 Q · 5d ago", "43/60", Color(0xFF1A56C4)),
        HistoryEntry("Prelims Mock Test 7", "Full Mock", "100 Q · 9d ago", "88/200", Color(0xFFC95212)),
        HistoryEntry("Economy Drill Test 3", "Sectional", "40 Q · 11d ago", "31/80", Color(0xFFE8950F)),
        HistoryEntry("Polity Master Test 5", "Sectional", "50 Q · 13d ago", "38/100", Color(0xFF0E8A56)),
        HistoryEntry("Current Affairs Test 3", "CA Daily", "30 Q · 16d ago", "39/60", Color(0xFF1A56C4)),
        HistoryEntry("Prelims Mock Test 6", "Full Mock", "100 Q · 19d ago", "81/200", Color(0xFFC95212)),
        HistoryEntry("History Capsule Test", "Sectional", "35 Q · 22d ago", "26/70", Color(0xFF7C3AED)),
        HistoryEntry("Prelims Mock Test 5", "Full Mock", "100 Q · 24d ago", "77/200", Color(0xFFC95212)),
        HistoryEntry("Current Affairs Test 2", "CA Daily", "30 Q · 27d ago", "34/60", Color(0xFF1A56C4)),
        HistoryEntry("Geography Drill Test 2", "Sectional", "40 Q · 29d ago", "27/80", Color(0xFFE8950F)),
        HistoryEntry("Prelims Mock Test 4", "Full Mock", "100 Q · 31d ago", "72/200", Color(0xFFC95212))
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
                        text = "📅 This Month ▾",
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
                    append("Complete Test ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("History") }
                },
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 25.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Review every attempted test with score trends, type-based filters,\nand quick access to detailed analysis.",
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
                HeaderMetric("12", "TESTS", Color.White, Modifier.weight(1f), withDivider = true)
                HeaderMetric("81.7", "AVG SCORE", Color(0xFFE8950F), Modifier.weight(1f), withDivider = true)
                HeaderMetric("94/200", "BEST", Color(0xFF22C55E), Modifier.weight(1f), withDivider = true)
                HeaderMetric("↑ 14%", "MONTH", Color(0xFF60A5FA), Modifier.weight(1f), withDivider = false)
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
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                        FilterChip("All", true, Modifier.weight(1f))
                        FilterChip("Full Mock", false, Modifier.weight(1f))
                        FilterChip("Sectional", false, Modifier.weight(1f))
                        FilterChip("CA Daily", false, Modifier.weight(1f))
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(16.dp))
                    ) {
                        Text(
                            text = "📋 Complete Test History",
                            color = Color(0xFF071326),
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp, 12.dp, 16.dp, 0.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .border(1.dp, Color(0xFFF0F4F8))
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("TEST NAME", color = Color(0xFF8FA4BE), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Text("SCORE", color = Color(0xFF8FA4BE), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Text("VIEW", color = Color(0xFF8FA4BE), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }

                        rows.forEachIndexed { index, row ->
                            if (index > 0) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color(0xFFF0F4F8))
                                )
                            }
                            FullHistoryRow(row = row)
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFEEF2F8))
                                .border(1.dp, Color(0xFFDDE5F0))
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Showing 12 of 12 tests", color = Color(0xFF5A7096), fontSize = 11.5.sp)
                            Text("Newest first", color = Color(0xFF1A56C4), fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

private data class HistoryEntry(
    val title: String,
    val tag: String,
    val meta: String,
    val score: String,
    val scoreColor: Color
)

@Composable
private fun HeaderMetric(
    value: String,
    label: String,
    valueColor: Color,
    modifier: Modifier = Modifier,
    withDivider: Boolean
) {
    Row(modifier = modifier.height(55.dp), verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = value, color = valueColor, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
            Text(
                text = label,
                color = Color.White.copy(alpha = 0.32f),
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.4.sp
            )
        }
        if (withDivider) {
            Box(
                modifier = Modifier
                    .height(55.dp)
                    .width(1.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )
        }
    }
}

@Composable
private fun FilterChip(text: String, selected: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (selected) Color(0xFF1A56C4) else Color.White)
            .border(1.dp, if (selected) Color(0xFF1A56C4) else Color(0xFFDDE5F0), RoundedCornerShape(20.dp))
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else Color(0xFF5A7096),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun FullHistoryRow(row: HistoryEntry) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(row.title, color = Color(0xFF1A2744), fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            when (row.tag) {
                                "CA Daily" -> Color(0xFFE8EEFA)
                                "Sectional" -> Color(0xFFF5F3FF)
                                else -> Color(0xFFF0F4F8)
                            }
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = row.tag,
                        color = when (row.tag) {
                            "CA Daily" -> Color(0xFF1A56C4)
                            "Sectional" -> Color(0xFF7C3AED)
                            else -> Color(0xFF0D1B2E)
                        },
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(row.meta, color = Color(0xFF5A7096), fontSize = 11.sp)
            }
        }
        Text(row.score, color = row.scoreColor, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.width(12.dp))
        Text("View →", color = Color(0xFF0E8A56), fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold)
    }
}
