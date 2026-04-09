package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.myapplicationrisewithjeet.ui.theme.*
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.icon_reset
import myapplicationrisewithjeet.composeapp.generated.resources.icon_retry_today
import myapplicationrisewithjeet.composeapp.generated.resources.icon_note
import myapplicationrisewithjeet.composeapp.generated.resources.icon_books
import myapplicationrisewithjeet.composeapp.generated.resources.icon_star
import myapplicationrisewithjeet.composeapp.generated.resources.icon_target
import myapplicationrisewithjeet.composeapp.generated.resources.icon_trophy
import myapplicationrisewithjeet.composeapp.generated.resources.icon_write
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val WNBg    = Color(0xFFF2F3F8)
private val WNDark  = Color(0xFF0F1629)
private val WNCard  = Color(0xFF1A2540)
private val WNWhite = Color.White
private val WNGray  = Color(0xFF9CA3AF)

@Composable
fun WhatNextScreen(
    onBack: () -> Unit,
    onTryAnother: () -> Unit,
    onDashboard: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WNBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Header ─────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(WNWhite)
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFF374151), fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
        }

        Spacer(Modifier.height(20.dp))

        // ── Title ──────────────────────────────────────────────
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("💡", fontSize = 36.sp)
            Spacer(Modifier.height(10.dp))
            Text(
                buildAnnotatedString {
                    append("What would you like to do ")
                    withStyle(SpanStyle(color = GoldAccent)) { append("next?") }
                },
                color = WNDark,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                "Smart recommendations based on your performance",
                color = WNGray,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(24.dp))

        // ── 2x2 Action grid ────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(3.dp, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(WNWhite)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_reset,
                    title = "Rewrite with Feedback",
                    subtitle = "Apply suggestions immediately",
                    onClick = {}
                )
                ActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_note,
                    title = "Save to Notes",
                    subtitle = "Add to personalised revision",
                    onClick = {}
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_books,
                    title = "Discuss with Mentor",
                    subtitle = "Get expert guidance",
                    onClick = {}
                )
                ActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_star,
                    title = "View Model Answer",
                    subtitle = "See perfect structure & content",
                    onClick = {}
                )
            }

            // Practice Similar – full width
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF9FAFB))
                    .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(12.dp))
                    .clickable {}
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFFF3E0)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.icon_target),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Practice Similar Question", color = WNDark, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("Continue your streak & improve", color = WNGray, fontSize = 12.sp)
                }
                Text("›", color = WNGray, fontSize = 20.sp)
            }

            // Retry today's challenge
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFFCF5))
                    .border(1.dp, GoldAccent, RoundedCornerShape(12.dp))
                    .clickable {}
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFFF3E0)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.icon_retry_today),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Retry Today's Challenge", color = GoldAccent, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text("Improve your score from 6/10 — daily challenges can be retried", color = WNGray, fontSize = 12.sp)
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // ── Past Challenges ────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.icon_trophy),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text("Past Challenges", color = WNDark, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Text("View All →", color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.clickable {})
        }

        Spacer(Modifier.height(10.dp))

        val pastChallenges = listOf(
            PastChallenge(
                tags = listOf("GS-II" to Color(0xFF3B82F6), "Science & Tech" to Color(0xFF8B5CF6)),
                question = "What are biosimilars? Discuss how the Biopharma Shakti initiative can help improve access to biological therapies in India.",
                score = "8/10",
                words = "242 words",
                dateNote = "Your best this week!",
                dateColor = Color(0xFF22C55E)
            ),
            PastChallenge(
                tags = listOf("GS-III" to Color(0xFF3B82F6), "Environment & Ecology" to Color(0xFF22C55E)),
                question = "\"India's stance on biodiversity reserves reflects the complex trade-off between developmental needs and wildlife conservation.\" Discuss with reference to the Kopra irrigation project in India.",
                score = "6.5/10",
                words = "240 words",
                dateNote = "9 Feb, 2026",
                dateColor = WNGray
            ),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(3.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(WNWhite)
        ) {
            pastChallenges.forEachIndexed { i, item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(16.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        item.tags.forEach { (tag, color) ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(color.copy(alpha = 0.12f))
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Text(tag, color = color, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(item.question, color = WNDark, fontSize = 13.sp, lineHeight = 19.sp, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(item.score, color = GoldAccent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text(item.words, color = WNGray, fontSize = 12.sp)
                        Text(item.dateNote, color = item.dateColor, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    }
                }
                if (i < pastChallenges.size - 1)
                    HorizontalDivider(color = Color(0xFFF3F4F6), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
            }
        }

        Spacer(Modifier.height(20.dp))

        // ── Bottom buttons ─────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onTryAnother,
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(14.dp),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_write),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("Try Another", color = Color(0xFF374151), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
            Button(
                onClick = onDashboard,
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = WNDark)
            ) {
                Text("← Dashboard", color = WNWhite, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
        }

        Spacer(Modifier.height(40.dp))
    }
}

@Composable
private fun ActionCard(
    modifier: Modifier,
    icon: DrawableResource,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFFF9FAFB))
            .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(title, color = WNDark, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, lineHeight = 18.sp)
        Spacer(Modifier.height(4.dp))
        Text(subtitle, color = WNGray, fontSize = 11.sp, textAlign = TextAlign.Center, lineHeight = 16.sp)
    }
}

private data class PastChallenge(
    val tags: List<Pair<String, Color>>,
    val question: String,
    val score: String,
    val words: String,
    val dateNote: String,
    val dateColor: Color
)
