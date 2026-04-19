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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerformanceWeeklyLeaderboardScreen(onBack: () -> Unit = {}) {
    val rows = listOf(
        RankRow("1", "JD", "John Doe", "998", "↑ +0", Color(0xFFE8950F), Color(0xFF22C55E), true),
        RankRow("2", "SB", "Shubham Bharti", "948", "↑ +12", Color(0xFF8A94A9), Color(0xFF22C55E), true),
        RankRow("3", "PK", "Priya Kumar", "921", "↑ +8", Color(0xFF92400E), Color(0xFF22C55E), true),
        RankRow("4", "RS", "Rahul Sharma", "884", "↑ +5", Color(0xFF3B82F6), Color(0xFF22C55E), false),
        RankRow("5", "NP", "Nisha Patel", "861", "↓ -3", Color(0xFF7C3AED), Color(0xFFEF4444), false),
        RankRow("428", "AK", "You · Arjun Kumar", "742", "↑ +56 this week", Color(0xFFF59E0B), Color(0xFF22C55E), false, true),
        RankRow("429", "VN", "Vikram Nair", "739", "↓ -4", Color(0xFF3B82F6), Color(0xFFEF4444), false),
        RankRow("430", "DM", "Divya Menon", "736", "↑ +2", Color(0xFF2F855A), Color(0xFF22C55E), false)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(Color(0xFF0A1531), Color(0xFF0C1836))))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "←",
                color = Color(0xFF96ABCA),
                fontSize = 16.sp,
                modifier = Modifier.clickable { onBack() }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = buildAnnotatedString {
                    append("Arjun's ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Rank") }
                },
                color = Color.White,
                fontSize = 44.sp / 2,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas and smart notes.",
                color = Color.White.copy(alpha = 0.32f),
                fontSize = 10.5.sp,
                lineHeight = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(64.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color(0xFFE3E8F0))
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(17.dp))
                    .background(Color(0xFF111B34))
                    .padding(horizontal = 14.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("#428", color = Color(0xFFF5A623), fontSize = 38.sp / 2, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Your Rank This Week", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("Top 1.4% nationally · ↑ +56 from last\nweek", color = Color(0xFF8FA3C0), fontSize = 11.sp)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("↑ +56", color = Color(0xFF5ED269), fontSize = 33.sp / 2, fontWeight = FontWeight.ExtraBold)
                    Text("improvement", color = Color(0xFF8FA3C0), fontSize = 10.sp)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFF4F6FA))
                    .border(1.dp, Color(0xFFD5DEEA), RoundedCornerShape(18.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    PodiumPerson("SB", "Shubham B.", "948 pts", "🥈", Color(0xFF8A94A9), 52.dp)
                    PodiumPerson("JD", "John Doe", "998 pts", "🥇", Color(0xFFE0AA2D), 78.dp)
                    PodiumPerson("PK", "Priya Kumar", "921 pts", "🥉", Color(0xFF92400E), 42.dp)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFFF4F6FA))
                    .border(1.dp, Color(0xFFD5DEEA), RoundedCornerShape(18.dp))
            ) {
                items(rows.size) { index ->
                    if (index > 0) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color(0xFFDDE4EF))
                        )
                    }
                    LeaderboardRow(row = rows[index])
                    if (index == 4) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFEAF0F9))
                                .padding(vertical = 5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("... 422 ranks ...", color = Color(0xFF8FA3C0), fontSize = 11.sp)
                        }
                    }
                }
            }
        }
    }
}

private data class RankRow(
    val rank: String,
    val initials: String,
    val name: String,
    val score: String,
    val delta: String,
    val avatar: Color,
    val deltaColor: Color,
    val topThree: Boolean,
    val isUser: Boolean = false
)

@Composable
private fun PodiumPerson(initials: String, name: String, points: String, medal: String, color: Color, barHeight: androidx.compose.ui.unit.Dp) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Text(initials, color = Color.White, fontSize = 28.sp / 2, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(medal, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(name, color = Color(0xFF111827), fontSize = 14.sp / 2, fontWeight = FontWeight.Bold)
        Text(points, color = Color(0xFFE8950F), fontSize = 25.sp / 2, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .width(38.dp)
                .height(barHeight)
                .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                .background(color.copy(alpha = 0.92f))
        )
    }
}

@Composable
private fun LeaderboardRow(row: RankRow) {
    val background = if (row.isUser) Color(0xFFFFF8ED) else Color.Transparent
    val borderColor = if (row.isUser) Color(0xFFF5A623) else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .border(1.dp, borderColor)
            .padding(horizontal = 12.dp, vertical = 11.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val rankLabel = if (row.topThree) {
            when (row.rank) {
                "1" -> "🥇"
                "2" -> "🥈"
                else -> "🥉"
            }
        } else {
            row.rank
        }
        Text(
            rankLabel,
            color = if (row.isUser) Color(0xFFE8950F) else Color(0xFF8A9AB7),
            fontSize = if (row.topThree) 16.sp else 30.sp / 2,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(38.dp)
        )

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(row.avatar),
            contentAlignment = Alignment.Center
        ) {
            Text(row.initials, color = Color.White, fontSize = 30.sp / 2, fontWeight = FontWeight.ExtraBold)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            row.name,
            color = if (row.isUser) Color(0xFFD38909) else Color(0xFF111827),
            fontSize = 17.sp / 2,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Column(horizontalAlignment = Alignment.End) {
            Text(row.score, color = if (row.isUser) Color(0xFFE8950F) else Color(0xFF1F2937), fontSize = 17.sp / 2, fontWeight = FontWeight.ExtraBold)
            Text(row.delta, color = row.deltaColor, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
    }
}
