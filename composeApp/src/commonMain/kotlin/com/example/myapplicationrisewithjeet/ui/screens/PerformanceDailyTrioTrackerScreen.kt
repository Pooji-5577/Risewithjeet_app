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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerformanceDailyTrioTrackerScreen(onBack: () -> Unit = {}) {
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

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = buildAnnotatedString {
                    append("Daily Trio ")
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
                text = "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas and smart notes.",
                color = Color.White.copy(alpha = 0.4f),
                fontSize = 10.5.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.07f))
                    .border(1.dp, Color.White.copy(alpha = 0.09f), RoundedCornerShape(14.dp))
                    .padding(1.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TrioHeaderStat(value = "6/7", label = "MCQ", valueColor = Color(0xFFF5A623), modifier = Modifier.weight(1f), withDivider = true)
                TrioHeaderStat(value = "5/7", label = "MAINS", valueColor = Color(0xFF1A56C4), modifier = Modifier.weight(1f), withDivider = true)
                TrioHeaderStat(value = "4/7", label = "NEWS", valueColor = Color(0xFF0E8A56), modifier = Modifier.weight(1f), withDivider = true)
                TrioHeaderStat(value = "15/21", label = "OVERALL", valueColor = Color(0xFF7C3AED), modifier = Modifier.weight(1f), withDivider = false)
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFFF0F4F8))
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
                            .padding(13.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "⚡ Daily Trio — This Week",
                            color = Color(0xFF071326),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )

                        TrioTrackerCard(
                            title = "Daily MCQ Challenge",
                            subtitle = "Polity, Economy, Geography",
                            icon = "🎯",
                            score = "6/7",
                            scoreColor = Color(0xFF22C55E),
                            cardBackground = Color(0xFFF0FDF4),
                            cardBorder = Color(0xFF86EFAC),
                            iconBg = Color(0xFFDCFCE7),
                            progressColor = Color(0xFF22C55E),
                            progress = 0.86f,
                            dayStates = listOf(true, true, true, true, false, true, true),
                            activeDayColor = Color(0xFF22C55E)
                        )

                        TrioTrackerCard(
                            title = "Daily Mains Challenge",
                            subtitle = "Answer Writing, AI Evaluated",
                            icon = "✍️",
                            score = "5/7",
                            scoreColor = Color(0xFF1A56C4),
                            cardBackground = Color(0xFFE8EEFA),
                            cardBorder = Color(0xFF1A56C4),
                            iconBg = Color(0xFFEDE9FE),
                            progressColor = Color(0xFF1A56C4),
                            progress = 0.71f,
                            dayStates = listOf(true, true, true, false, true, true, false),
                            activeDayColor = Color(0xFF1A56C4)
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(13.dp))
                                .background(Color(0xFFFFF8ED))
                                .border(1.dp, Color(0xFFF5A623).copy(alpha = 0.28f), RoundedCornerShape(13.dp))
                                .padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(7.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(11.dp))
                                        .background(Color(0xFFFDE68A).copy(alpha = 0.2f))
                                        .padding(horizontal = 10.dp, vertical = 7.dp)
                                ) {
                                    Text("📰", fontSize = 18.sp)
                                }
                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(0.dp)
                                ) {
                                    Text("Daily News Analysis", color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                    Text("The Hindu, Indian Express", color = Color(0xFF8FA3C0), fontSize = 9.5.sp, lineHeight = 10.sp)
                                }
                                Column(
                                    horizontalAlignment = Alignment.End,
                                    verticalArrangement = Arrangement.spacedBy((-1).dp)
                                ) {
                                    Text("4/7", color = Color(0xFFEF4444), fontSize = 15.sp, lineHeight = 16.sp, fontWeight = FontWeight.Bold)
                                    Text("days", color = Color(0xFF8FA3C0), fontSize = 9.sp, lineHeight = 10.sp)
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(Color(0xFFEEF2F8))
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.57f)
                                        .height(5.dp)
                                        .clip(RoundedCornerShape(3.dp))
                                        .background(Color(0xFFF5A623))
                                )
                            }

                            Text(
                                text = "📍 Missed Thu–Sun. News is tested heavily in CA section — aim 7/7\nnext week.",
                                color = Color(0xFF4A5568),
                                fontSize = 10.sp,
                                lineHeight = 15.5.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TrioHeaderStat(
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
private fun TrioTrackerCard(
    title: String,
    subtitle: String,
    icon: String,
    score: String,
    scoreColor: Color,
    cardBackground: Color,
    cardBorder: Color,
    iconBg: Color,
    progressColor: Color,
    progress: Float,
    dayStates: List<Boolean>,
    activeDayColor: Color
) {
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(13.dp))
            .background(cardBackground)
            .border(1.dp, cardBorder, RoundedCornerShape(13.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(11.dp))
                    .background(iconBg)
                    .padding(horizontal = 10.dp, vertical = 7.dp)
            ) {
                Text(icon, fontSize = 18.sp)
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Text(title, color = Color(0xFF071326), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Text(subtitle, color = Color(0xFF8FA3C0), fontSize = 9.5.sp, lineHeight = 10.sp)
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy((-1).dp)
            ) {
                Text(score, color = scoreColor, fontSize = 15.sp, lineHeight = 16.sp, fontWeight = FontWeight.Bold)
                Text("days", color = Color(0xFF8FA3C0), fontSize = 9.sp, lineHeight = 10.sp)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFFEEF2F8))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(progressColor)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.fillMaxWidth()) {
            days.forEachIndexed { index, day ->
                val done = dayStates.getOrNull(index) == true
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (done) activeDayColor else Color(0xFFF0F4F8))
                        .padding(vertical = 2.5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        color = if (done) Color.White else Color(0xFF8FA3C0),
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
