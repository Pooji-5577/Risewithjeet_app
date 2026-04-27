package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.icon_books
import myapplicationrisewithjeet.composeapp.generated.resources.icon_note
import myapplicationrisewithjeet.composeapp.generated.resources.icon_reset
import myapplicationrisewithjeet.composeapp.generated.resources.icon_star
import myapplicationrisewithjeet.composeapp.generated.resources.icon_target
import myapplicationrisewithjeet.composeapp.generated.resources.icon_trophy
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private data class PastChallenge(
    val tag1: String,
    val tag1Bg: Color,
    val tag1Text: Color,
    val tag2: String,
    val tag2Bg: Color,
    val tag2Text: Color,
    val question: String,
    val score: String,
    val scoreBg: Color,
    val scoreText: Color,
    val words: String,
    val thirdStat: String,
    val thirdStatColor: Color
)

@Composable
fun WhatNextScreen(
    onBack: () -> Unit,
    onTryAnother: () -> Unit,
    onDashboard: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDCE1EA))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF08162A))
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                "←",
                color = Color(0xFFB7C6DB),
                fontSize = 18.sp,
                modifier = Modifier.clickable { onBack() }
            )
            Spacer(Modifier.height(12.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("💡", fontSize = 30.sp)
                Spacer(Modifier.height(8.dp))
                Text(
                    buildAnnotatedString {
                        append("What would you like to do ")
                        withStyle(SpanStyle(color = Color(0xFFF5B335))) { append("next?") }
                    },
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Smart recommendations based on your performance",
                    color = Color(0xFF9FAEC3),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.height(10.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFFF0F4FA))
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_reset,
                    title = "Rewrite with\nFeedback",
                    subtitle = "Apply suggestions\nimmediately",
                    onClick = onTryAnother
                )
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_note,
                    title = "Save to Notes",
                    subtitle = "Add to personalised\nrevision",
                    onClick = onDashboard
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_books,
                    title = "Discuss with\nMentor",
                    subtitle = "Get expert guidance",
                    onClick = {}
                )
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_star,
                    title = "View Model\nAnswer",
                    subtitle = "See perfect structure\n& content",
                    onClick = {}
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .border(1.dp, Color(0xFFE3E7EF), RoundedCornerShape(14.dp))
                    .clickable { onTryAnother() }
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(RoundedCornerShape(9.dp))
                        .background(Color(0xFFFFF0F3)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.icon_target),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(Modifier.size(6.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Practice Similar Question", color = Color(0xFF1F2937), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text("Continue your streak & improve", color = Color(0xFF8B95A5), fontSize = 12.sp)
                }
                Text("›", color = Color(0xFF9CA3AF), fontSize = 20.sp)
            }

            PastChallengesSection()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(49.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
                        .clickable { onTryAnother() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("✍️ Try Another", color = Color(0xFF666666), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(49.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
                        .clickable { onDashboard() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("← Dashboard", color = Color(0xFF0D1B2E), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun PastChallengesSection() {
    val challenges = listOf(
        PastChallenge(
            tag1 = "GS-II",
            tag1Bg = Color(0xFFE3F2FD),
            tag1Text = Color(0xFF1976D2),
            tag2 = "Science & Tech",
            tag2Bg = Color(0xFFF3E5F5),
            tag2Text = Color(0xFF7B1FA2),
            question = "What are biosimilars? Discuss how the Biopharma Shakti initiative can help improve access to biological therapies in India.",
            score = "8/10",
            scoreBg = Color(0xFFE8F5E9),
            scoreText = Color(0xFF4CAF50),
            words = "242 words",
            thirdStat = "Your best this week!",
            thirdStatColor = Color(0xFF4CAF50)
        ),
        PastChallenge(
            tag1 = "GS-III",
            tag1Bg = Color(0xFFE8F5E9),
            tag1Text = Color(0xFF4CAF50),
            tag2 = "Environment & Ecology",
            tag2Bg = Color(0xFFFFF4E6),
            tag2Text = Color(0xFFF5A623),
            question = "\"India's stance on biodiversity reserves reflects the complex trade-off between developmental needs and wildlife conservation.\" Discuss with reference to the Kopra irrigation project in India.",
            score = "6.5/10",
            scoreBg = Color(0xFFFFF4E6),
            scoreText = Color(0xFFF5A623),
            words = "240 words",
            thirdStat = "9 Feb, 2026",
            thirdStatColor = Color(0xFF999999)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(18.dp))
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)
            .padding(horizontal = 12.dp, vertical = 18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(Res.drawable.icon_trophy),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text("Past Challenges", color = Color(0xFF0D1B2E), fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
            }
            Text("View All →", color = Color(0xFFF5A623), fontSize = 13.sp, fontWeight = FontWeight.Bold)
        }

        challenges.forEach { challenge ->
            PastChallengeCard(challenge)
        }
    }
}

@Composable
private fun PastChallengeCard(item: PastChallenge) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF5F7FA))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TagPill(item.tag1, item.tag1Bg, item.tag1Text)
            TagPill(item.tag2, item.tag2Bg, item.tag2Text)
        }

        Text(
            item.question,
            color = Color(0xFF0D1B2E),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 21.sp
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(item.scoreBg)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(item.score, color = item.scoreText, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            Text(item.words, color = Color(0xFF999999), fontSize = 11.sp)
            Text(item.thirdStat, color = item.thirdStatColor, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
private fun TagPill(text: String, bg: Color, fg: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(bg)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text, color = fg, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun NextActionCard(
    modifier: Modifier,
    icon: DrawableResource,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .height(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFDCE2EC), RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(title, color = Color(0xFF1F2937), fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(Modifier.height(6.dp))
        Text(subtitle, color = Color(0xFF9CA3AF), fontSize = 12.sp, textAlign = TextAlign.Center, lineHeight = 16.sp)
    }
}
