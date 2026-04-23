package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private data class RankRow(
    val rank: String,
    val initials: String,
    val name: String,
    val score: String,
    val delta: String,
    val avatarBrush: Brush,
    val deltaColor: Color,
    val topThree: Boolean,
    val isUser: Boolean = false
)

private data class PodiumItem(
    val initials: String,
    val name: String,
    val points: String,
    val medal: String,
    val ringColor: Color,
    val avatarBrush: Brush,
    val pointsColor: Color,
    val barBrush: Brush,
    val avatarSize: Dp,
    val barHeight: Dp,
    val initialsSize: Float
)

@Composable
fun PerformanceWeeklyLeaderboardScreen(onBack: () -> Unit = {}) {
    val rows = listOf(
        RankRow("1", "JD", "John Doe", "998", "↑ +0", Brush.linearGradient(listOf(Color(0xFFF5A623), Color(0xFFE8950F))), Color(0xFF22C55E), true),
        RankRow("2", "SB", "Shubham Bharti", "948", "↑ +12", Brush.linearGradient(listOf(Color(0xFF94A3B8), Color(0xFF64748B))), Color(0xFF22C55E), true),
        RankRow("3", "PK", "Priya Kumar", "921", "↑ +8", Brush.linearGradient(listOf(Color(0xFF92400E), Color(0xFFB45309))), Color(0xFF22C55E), true),
        RankRow("4", "RS", "Rahul Sharma", "884", "↑ +5", Brush.linearGradient(listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8))), Color(0xFF22C55E), false),
        RankRow("5", "NP", "Nisha Patel", "861", "↓ -3", Brush.linearGradient(listOf(Color(0xFF8B5CF6), Color(0xFF6D28D9))), Color(0xFFEF4444), false),
        RankRow("#428", "AK", "You · Arjun Kumar", "742", "↑ +56 this week", Brush.linearGradient(listOf(Color(0xFFF5A623), Color(0xFFEF4444))), Color(0xFF22C55E), false, true),
        RankRow("429", "VN", "Vikram Nair", "739", "↓ -4", Brush.linearGradient(listOf(Color(0xFF0369A1), Color(0xFF0284C7))), Color(0xFFEF4444), false),
        RankRow("430", "DM", "Divya Menon", "736", "↑ +2", Brush.linearGradient(listOf(Color(0xFF047857), Color(0xFF059669))), Color(0xFF22C55E), false)
    )

    val podium = listOf(
        PodiumItem(
            initials = "SB",
            name = "Shubham B.",
            points = "948 pts",
            medal = "🥈",
            ringColor = Color(0xFF94A3B8),
            avatarBrush = Brush.linearGradient(listOf(Color(0xFF94A3B8), Color(0xFF64748B))),
            pointsColor = Color(0xFF8FA3C0),
            barBrush = Brush.verticalGradient(listOf(Color(0xFFCBD5E1), Color(0xFF94A3B8))),
            avatarSize = 40.dp,
            barHeight = 40.dp,
            initialsSize = 13f
        ),
        PodiumItem(
            initials = "JD",
            name = "John Doe",
            points = "998 pts",
            medal = "🥇",
            ringColor = Color(0xFFF5A623),
            avatarBrush = Brush.linearGradient(listOf(Color(0xFFF5A623), Color(0xFFE8950F))),
            pointsColor = Color(0xFFE8950F),
            barBrush = Brush.verticalGradient(listOf(Color(0xFFFBBF24), Color(0xFFF5A623))),
            avatarSize = 50.dp,
            barHeight = 60.dp,
            initialsSize = 16f
        ),
        PodiumItem(
            initials = "PK",
            name = "Priya Kumar",
            points = "921 pts",
            medal = "🥉",
            ringColor = Color(0xFF92400E),
            avatarBrush = Brush.linearGradient(listOf(Color(0xFF92400E), Color(0xFFB45309))),
            pointsColor = Color(0xFF8FA3C0),
            barBrush = Brush.verticalGradient(listOf(Color(0xFFB45309), Color(0xFF92400E))),
            avatarSize = 36.dp,
            barHeight = 32.dp,
            initialsSize = 12f
        )
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
                .padding(horizontal = 14.dp, vertical = 10.dp)
        ) {
            Text(
                text = "←",
                color = Color(0xFF96ABCA),
                fontSize = 12.5.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { onBack() }
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.White)) { append("Arjun's ") }
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Rank") }
                },
                color = Color.White,
                fontSize = 21.sp,
                lineHeight = 25.2.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas and smart notes.",
                color = Color.White.copy(alpha = 0.4f),
                fontSize = 10.5.sp,
                lineHeight = 16.27.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(44.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFFF0F4FA))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF071326))
                    .padding(horizontal = 14.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("#428", color = Color(0xFFF5A623), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text("Your Rank This Week", color = Color.White, fontSize = 13.5.sp, fontWeight = FontWeight.Bold)
                    Text("Top 1.4% nationally · ↑ +56 from last\nweek", color = Color.White.copy(alpha = 0.4f), fontSize = 10.sp)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("↑ +56", color = Color(0xFF22C55E), fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    Text("improvement", color = Color.White.copy(alpha = 0.4f), fontSize = 9.sp)
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(12.dp, RoundedCornerShape(14.dp), ambientColor = Color(0x14162240), spotColor = Color(0x14162240))
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp))
                    .padding(horizontal = 17.dp, vertical = 13.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                PodiumItemView(podium[0])
                PodiumItemView(podium[1])
                PodiumItemView(podium[2])
            }

            Spacer(modifier = Modifier.height(14.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(12.dp, RoundedCornerShape(14.dp), ambientColor = Color(0x14162240), spotColor = Color(0x14162240))
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp)),
                contentPadding = PaddingValues(1.dp)
            ) {
                items(rows.size) { index ->
                    if (index > 0) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color(0xFFF0F4F8))
                        )
                    }
                    LeaderboardRow(rows[index])
                    if (index == 4) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .background(Color(0xFFF0F4F8)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("· · · 422 ranks · · ·", color = Color(0xFF8FA3C0), fontSize = 9.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PodiumItemView(item: PodiumItem) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Box(
            modifier = Modifier
                .size(item.avatarSize)
                .clip(RoundedCornerShape(item.avatarSize / 2))
                .background(item.avatarBrush)
                .border(3.dp, item.ringColor, RoundedCornerShape(item.avatarSize / 2)),
            contentAlignment = Alignment.Center
        ) {
            Text(item.initials, color = Color.White, fontSize = item.initialsSize.sp, fontWeight = FontWeight.Bold)
        }
        Text(item.medal, color = Color(0xFF071326), fontSize = 16.sp)
        Text(item.name, color = Color(0xFF071326), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
        Text(item.points, color = item.pointsColor, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .width(26.dp)
                .height(item.barHeight)
                .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                .background(item.barBrush)
        )
    }
}

@Composable
private fun LeaderboardRow(row: RankRow) {
    val rowBackground = if (row.isUser) Color(0xFFFFF8ED) else Color.White
    val accentColor = Color(0xFFF5A623)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(rowBackground)
            .drawBehind {
                if (row.isUser) {
                    val leftStroke = 3.dp.toPx()
                    val bottomStroke = 1.dp.toPx()
                    drawRect(
                        color = accentColor,
                        topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
                        size = androidx.compose.ui.geometry.Size(leftStroke, size.height)
                    )
                    drawRect(
                        color = accentColor,
                        topLeft = androidx.compose.ui.geometry.Offset(0f, size.height - bottomStroke),
                        size = androidx.compose.ui.geometry.Size(size.width, bottomStroke)
                    )
                }
            }
            .padding(horizontal = if (row.isUser) 16.dp else 13.dp, vertical = 10.dp)
            .then(Modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val rankLabel = when {
            row.topThree && row.rank == "1" -> "🥇"
            row.topThree && row.rank == "2" -> "🥈"
            row.topThree && row.rank == "3" -> "🥉"
            else -> row.rank
        }

        Text(
            text = rankLabel,
            color = if (row.isUser) Color(0xFFE8950F) else Color(0xFF8FA3C0),
            fontSize = if (row.topThree) 18.sp else 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(if (row.topThree) 24.dp else 26.dp)
        )

        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(row.avatarBrush),
            contentAlignment = Alignment.Center
        ) {
            Text(row.initials, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
        }

        Text(
            row.name,
            color = if (row.isUser) Color(0xFFE8950F) else Color(0xFF071326),
            fontSize = 12.sp,
            fontWeight = if (row.isUser) FontWeight.ExtraBold else FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = row.score,
                color = if (row.isUser || row.rank == "1") Color(0xFFE8950F) else Color(0xFF071326),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = row.delta, color = row.deltaColor, fontSize = 9.sp, fontWeight = FontWeight.Bold)
        }
    }
}
