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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerformanceAchievementBadgesScreen(onBack: () -> Unit = {}) {
    val earnedBadges = listOf(
        EarnedBadge("🔥", "30-Day\nStreak"),
        EarnedBadge("⚡", "Quick Learner"),
        EarnedBadge("🧠", "1000 Qs Club"),
        EarnedBadge("⚖️", "Polity Master"),
        EarnedBadge("🏆", "Mock Champ"),
        EarnedBadge("📰", "News Reader"),
        EarnedBadge("🌅", "Early Bird"),
        EarnedBadge("🎯", "Sharpshooter")
    )

    val lockedBadges = listOf(
        LockedBadge("🌍", "Geo Warrior", "42% done"),
        LockedBadge("👑", "Top 100", "#428 now"),
        LockedBadge("📋", "Mock King", "18/25"),
        LockedBadge("💯", "Perfect Score", "Best: 123"),
        LockedBadge("🔥", "60-Day Fire", "Day 42/60"),
        LockedBadge("💰", "Eco Ace", "48% done"),
        LockedBadge("🌿", "Env Master", "51% done"),
        LockedBadge("🎓", "Scholar", "847/5000")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF071224))
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

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("••••", color = Color.White, fontSize = 10.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("WiFi", color = Color.White, fontSize = 10.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("🔋", color = Color.White, fontSize = 10.sp)
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = buildAnnotatedString {
                    append("Arjun's ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Achievement") }
                },
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 25.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas and smart notes.",
                color = Color.White.copy(alpha = 0.4f),
                fontSize = 10.5.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFFF0F4F8)),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 10.dp)
        ) {
            item {
                AchievementProgressCard()
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "✅ EARNED (8)",
                    color = Color(0xFF8FA3C0),
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.15.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                earnedBadges.chunked(4).forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        row.forEach { badge ->
                            EarnedBadgeCard(badge = badge, modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "🔒 TO UNLOCK (20)",
                    color = Color(0xFF8FA3C0),
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.15.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                lockedBadges.chunked(4).forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        row.forEach { badge ->
                            LockedBadgeCard(badge = badge, modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

private data class EarnedBadge(
    val icon: String,
    val title: String
)

private data class LockedBadge(
    val icon: String,
    val title: String,
    val progressText: String
)

@Composable
private fun AchievementProgressCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF071224))
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Text(
            text = "🏅",
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "8  /  28",
            color = Color(0xFFF5A623),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Badges Earned",
            color = Color.White,
            fontSize = 12.sp,
            lineHeight = 13.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "20 more to unlock · Keep grinding!",
            color = Color.White.copy(alpha = 0.45f),
            fontSize = 10.sp,
            lineHeight = 11.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color.White.copy(alpha = 0.1f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.285f)
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Color(0xFFF5A623))
            )
        }
    }
}

@Composable
private fun EarnedBadgeCard(badge: EarnedBadge, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(98.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(Color(0xFFFFF8ED))
            .border(1.dp, Color(0xFFF5A623).copy(alpha = 0.28f), RoundedCornerShape(13.dp))
            .padding(horizontal = 9.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(text = badge.icon, color = Color(0xFF071326), fontSize = 24.sp)
        Text(
            text = badge.title,
            color = Color(0xFF071326),
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 12.6.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "✓ Earned",
            color = Color(0xFF22C55E),
            fontSize = 8.sp,
            lineHeight = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun LockedBadgeCard(badge: LockedBadge, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(102.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF3F6FB))
            .border(1.dp, Color(0xFFE6EBF2), RoundedCornerShape(16.dp))
            .alpha(0.72f)
            .padding(horizontal = 9.dp, vertical = 11.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(text = badge.icon, color = Color(0xFF8F98A8), fontSize = 29.sp)
        Text(
            text = badge.title,
            color = Color(0xFF7E8795),
            fontSize = 9.5.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 12.8.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = badge.progressText,
            color = Color(0xFFB7C1D0),
            fontSize = 7.8.sp,
            lineHeight = 8.8.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
