package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.mains_camera
import myapplicationrisewithjeet.composeapp.generated.resources.mains_climate
import myapplicationrisewithjeet.composeapp.generated.resources.mains_current_affairs
import myapplicationrisewithjeet.composeapp.generated.resources.mains_mix_bag
import myapplicationrisewithjeet.composeapp.generated.resources.mains_ncert
import myapplicationrisewithjeet.composeapp.generated.resources.mains_pyq
import myapplicationrisewithjeet.composeapp.generated.resources.mains_section_header
import myapplicationrisewithjeet.composeapp.generated.resources.mains_sectional
import myapplicationrisewithjeet.composeapp.generated.resources.mains_trophy
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val DmcBackdrop = Color(0xFF222429)
private val DmcSurface = Color(0xFFF2F3F8)
private val DmcCard = Color(0xFFFFFFFF)
private val DmcDarkCard = Color(0xFF0E1A34)
private val DmcBorder = Color(0xFFE5E7EB)
private val DmcText = Color(0xFF111827)
private val DmcMuted = Color(0xFF6B7280)
private val DmcChip = Color(0x1AD9D9D9)

@Composable
fun DailyMainsChallengeScreen(
    onBack: () -> Unit,
    onStartMockTest: () -> Unit
) {
    var selectedSource by remember { mutableStateOf(0) }
    var selectedCount by remember { mutableStateOf(1) }
    var selectedTime by remember { mutableStateOf(1) }

    val sourceOptions = listOf(
        Res.drawable.mains_sectional to "Sectional\nSingle subject",
        Res.drawable.mains_mix_bag to "Mix Bag\nAll subjects",
        Res.drawable.mains_pyq to "PYQ Based\nPast papers",
        Res.drawable.mains_trophy to "Full Length\nPLT · 100 Qs",
        Res.drawable.mains_ncert to "NCERT\nBook-wise",
        Res.drawable.mains_current_affairs to "Curr. Affairs\nLast 6 months",
    )
    val countOptions = listOf("1", "3", "5", "10", "20")
    val timeOptions = listOf("15 min", "30 min", "60 min", "No limit")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DmcBackdrop)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFFAEB5C2), fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
            Spacer(Modifier.width(8.dp))
            Text("Container", color = Color(0xFF8F949D), fontSize = 14.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(DmcSurface)
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(DmcDarkCard)
                    .padding(14.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF22C55E))
                        )
                        Spacer(Modifier.width(6.dp))
                        Text("LIVE TODAY", color = Color(0xFF22C55E), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(8.dp))
                    Text("✍️ Daily Mains Challenge", color = Color.White, fontSize = 27.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 31.sp)
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        HeroMetaChip("10 Questions")
                        HeroMetaChip("18 Minutes")
                        HeroMetaChip("Polity Focus")
                    }
                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(GoldGradient)
                            .clickable { onStartMockTest() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("⚡  Start Daily Challenge", color = DmcText, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, RoundedCornerShape(14.dp))
                    .clip(RoundedCornerShape(14.dp))
                    .background(DmcCard)
                    .padding(12.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.mains_section_header),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text("Evaluate Your Answer", color = DmcText, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(118.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color(0xFFD1D5DB), RoundedCornerShape(12.dp))
                            .background(Color(0xFFF8FAFC)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(Res.drawable.mains_camera),
                                contentDescription = null,
                                modifier = Modifier.size(44.dp)
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Tap to Click Photo", color = DmcText, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                            Spacer(Modifier.height(2.dp))
                            Text("Handwritten answer + OCR +\nEvaluation", color = DmcMuted, fontSize = 10.sp, textAlign = TextAlign.Center)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(GoldGradient)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Text("⚡  Evaluate Now →", color = DmcText, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.mains_section_header),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text("Mains Mock Test", color = DmcText, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(DmcCard)
                    .padding(12.dp)
            ) {
                Column {
                    StepHeader(1, "Question Source")
                    Spacer(Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        sourceOptions.chunked(3).forEachIndexed { rowIdx, row ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                row.forEachIndexed { colIdx, (icon, label) ->
                                    val idx = rowIdx * 3 + colIdx
                                    val selected = idx == selectedSource
                                    SourceCard(
                                        modifier = Modifier.weight(1f),
                                        icon = icon,
                                        label = label,
                                        selected = selected,
                                        onClick = { selectedSource = idx }
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    StepHeader(2, "No. of Questions")
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        countOptions.forEachIndexed { idx, label ->
                            val selected = idx == selectedCount
                            ChoiceChip(
                                label = label,
                                selected = selected,
                                square = true,
                                onClick = { selectedCount = idx }
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    StepHeader(3, "Subjects")
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SelectField(modifier = Modifier.weight(1f))
                        SelectField(modifier = Modifier.weight(1f))
                    }

                    Spacer(Modifier.height(12.dp))
                    StepHeader(4, "Time Limit")
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        timeOptions.forEachIndexed { idx, label ->
                            val selected = idx == selectedTime
                            ChoiceChip(
                                label = label,
                                selected = selected,
                                onClick = { selectedTime = idx }
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(GoldGradient)
                            .clickable { onStartMockTest() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("⚡  Start Mock Test", color = DmcText, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.mains_trophy),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("Previous Challenges", color = DmcText, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Text("See All →", color = GoldAccent, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFFFFF))
                    .border(1.dp, DmcBorder, RoundedCornerShape(12.dp))
            ) {
                Column {
                    PreviousRow(
                        icon = Res.drawable.mains_trophy,
                        title = "Mar 18 · Federalism in India",
                        subtitle = "GS-II · 248 words",
                        score = "7.5/10",
                        scoreBg = Color(0xFFE6EFFD),
                        scoreColor = Color(0xFF2456A6)
                    )
                    HorizontalDivider(color = DmcBorder, thickness = 1.dp, modifier = Modifier.padding(horizontal = 12.dp))
                    PreviousRow(
                        icon = Res.drawable.mains_climate,
                        title = "Mar 17 · Climate Policy",
                        subtitle = "GS-III · 280 words",
                        score = "8.0/10",
                        scoreBg = Color(0xFFE7F7E8),
                        scoreColor = Color(0xFF3F8B44)
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))
    }
}

@Composable
private fun StepHeader(step: Int, title: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .background(Color(0xFF111827)),
            contentAlignment = Alignment.Center
        ) {
            Text(step.toString(), color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.width(6.dp))
        Text(title, color = DmcText, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun HeroMetaChip(label: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(DmcChip)
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(label, color = Color(0xFFBBC4D4), fontSize = 11.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun SourceCard(
    modifier: Modifier,
    icon: DrawableResource,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(3.dp, RoundedCornerShape(16.dp))
            .shadow(1.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(if (selected) Color(0xFF0F1B35) else Color.White)
            .border(1.dp, if (selected) Color(0xFF0F1B35) else Color(0xFFEAECEF), RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .padding(horizontal = 6.dp, vertical = 8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.height(4.dp))
            val pieces = label.split("\n")
            Text(
                text = pieces[0],
                color = if (selected) Color.White else DmcText,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                lineHeight = 12.sp
            )
            if (pieces.size > 1) {
                Text(
                    text = pieces[1],
                    color = if (selected) Color(0xFFCBD5E1) else DmcMuted,
                    fontSize = 8.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 11.sp
                )
            }
        }
    }
}

@Composable
private fun ChoiceChip(
    label: String,
    selected: Boolean,
    square: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(9.dp))
            .background(if (selected) Color(0xFF111827) else DmcChip)
            .border(1.dp, if (selected) Color(0xFF111827) else DmcBorder, RoundedCornerShape(9.dp))
            .clickable { onClick() }
            .then(
                if (square) Modifier.size(52.dp)
                else Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            color = if (selected) Color.White else DmcMuted,
            fontSize = 11.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
        )
    }
}

@Composable
private fun SelectField(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(34.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF3F4F6))
            .border(1.dp, DmcBorder, RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Select...", color = DmcMuted, fontSize = 11.sp)
        Text("⌄", color = DmcMuted, fontSize = 12.sp)
    }
}

@Composable
private fun PreviousRow(
    icon: DrawableResource,
    title: String,
    subtitle: String,
    score: String,
    scoreBg: Color,
    scoreColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(26.dp)
        )
        Spacer(Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = DmcText, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            Text(subtitle, color = DmcMuted, fontSize = 9.sp)
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(scoreBg)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(score, color = scoreColor, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
    }
}
