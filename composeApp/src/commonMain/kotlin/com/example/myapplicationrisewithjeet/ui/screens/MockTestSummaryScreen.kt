package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

@Composable
fun MockTestSummaryScreen(
    isMains: Boolean,
    onBack: () -> Unit,
    onGenerateTestNow: () -> Unit,
    onEditConfiguration: () -> Unit
) {
    val paperLabel = if (isMains) "GS Paper II" else "GS Paper I"
    val topicLabel = if (isMains) "Governance" else "🗂️ All Topics"
    val sourceLabel = if (isMains) "Mains PYQ Mix" else "Daily MCQ"
    val timeLabel = if (isMains) "~45 min" else "~30 min"
    val guidelineTitle = if (isMains) "⚡ WRITING GUIDELINES" else "⚡ TEST GUIDELINES"
    val guidelineBullets = if (isMains) {
        listOf(
            "• Clear introduction with statement understanding",
            "• Body with examples (2–3 from recent cases)",
            "• Balance both sides of the argument",
            "• Conclude with personal opinion backed by logic"
        )
    } else {
        listOf(
            "• Read each question fully before answering",
            "• Skip and revisit uncertain questions",
            "• Eliminate clearly incorrect options first",
            "• Maintain speed with accuracy balance"
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4FA))
    ) {
        item {
            SummaryHeader(onBack = onBack)
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 10.dp, bottom = 18.dp)
            ) {
                SummaryCard(
                    paperLabel = paperLabel,
                    topicLabel = topicLabel,
                    sourceLabel = sourceLabel,
                    timeLabel = timeLabel,
                    guidelineTitle = guidelineTitle,
                    guidelineBullets = guidelineBullets
                )
                SpacerH(12)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.5.dp)
                        .background(GoldGradient, RoundedCornerShape(14.dp))
                        .clickable { onGenerateTestNow() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "⚡ Generate Test Now",
                        color = Color(0xFF14213D),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                SpacerH(8)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.25.dp)
                        .background(Color(0xFF1A2744), RoundedCornerShape(14.dp))
                        .clickable { onEditConfiguration() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "← Edit Configuration",
                        color = Color.White,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun SummaryHeader(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(182.375.dp)
            .background(Color(0xFF08162A))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "←",
                color = Color(0xFF5A7096),
                fontSize = 12.5.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { onBack() }
            )
            SpacerH(12)
            Box(
                modifier = Modifier
                    .background(Color(0xFFEDF9F3), RoundedCornerShape(20.dp))
                    .border(0.8.dp, Color(0xFFB2EDD0), RoundedCornerShape(20.dp))
                    .padding(horizontal = 13.dp, vertical = 4.dp)
            ) {
                Text(
                    "✅ TEST SUMMARY — READY TO BEGIN!",
                    color = Color(0xFF0E8A56),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            SpacerH(11)
            Text(
                buildAnnotatedString {
                    append("You're All Set!\nLet's ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Crush It.") }
                },
                color = Color.White,
                fontSize = 23.sp,
                lineHeight = 27.6.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            SpacerH(6)
            Text(
                "Review your configuration below then hit\nGenerate to start.",
                color = Color(0xFF6F8AAF),
                fontSize = 12.5.sp,
                lineHeight = 20.6.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
private fun SummaryCard(
    paperLabel: String,
    topicLabel: String,
    sourceLabel: String,
    timeLabel: String,
    guidelineTitle: String,
    guidelineBullets: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(22.dp))
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(22.dp))
            .padding(0.8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0D1B2E), RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(15.dp))
                    .border(0.8.dp, Color.White.copy(alpha = 0.15f), RoundedCornerShape(15.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("⚡", color = Color(0xFFF5A623), fontSize = 25.sp)
            }
            Text(
                " Are you ready?",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Column(modifier = Modifier.padding(16.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            SummaryTile("📄 PAPER", paperLabel, "History, Geography,\nSociety", Modifier.weight(1f))
            SummaryTile("📍 TOPIC", topicLabel, "Mixed across all\nchapters", Modifier.weight(1f))
        }
        SpacerH(10)
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            SummaryTile("❓ QUESTIONS", "25", "~30 min · Free tier", Modifier.weight(1f), valueColor = Color(0xFF1A56C4), valueSize = 33.sp, tileHeight = 98.1.dp)
            SummaryTile("⚡ DIFFICULTY", "Medium", "UPSC standard level", Modifier.weight(1f), valueColor = Color(0xFFD4881A), valueSize = 14.sp, tileHeight = 98.1.dp)
        }
        SpacerH(10)
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            SummaryTile("📚 SOURCE", sourceLabel, "Curated daily picks", Modifier.weight(1f), tileHeight = 86.1.dp)
            SummaryTile("⏱ TIME", timeLabel, "Standard exam pace", Modifier.weight(1f), tileHeight = 86.1.dp)
        }
        SpacerH(12)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0EBF9), RoundedCornerShape(16.dp))
                .border(0.8.dp, Color(0xFFC0D9F5), RoundedCornerShape(16.dp))
                .padding(horizontal = 13.8.dp, vertical = 13.8.dp)
        ) {
            Text(guidelineTitle, color = Color(0xFF1A56C4), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
            SpacerH(8)
            guidelineBullets.forEach {
                Text(it, color = Color(0xFF1A2744), fontSize = 12.sp, lineHeight = 20.4.sp)
            }
        }
        }
        SpacerH(12)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.35.dp)
                .background(Color.White, RoundedCornerShape(15.dp))
                .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(15.dp))
                .padding(horizontal = 13.8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Participant("R", Color(0xFF6378FF))
                Participant("A", Color(0xFF45A86E))
                Participant("M", Color(0xFF7F4BDB))
            }
            Text(
                " 247 students are taking tests right now",
                color = Color(0xFF1E2C49),
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Bold
            )
            Text(" 🎯", color = Color(0xFF5A7096), fontSize = 12.5.sp, fontWeight = FontWeight.Normal)
        }
    }
}

@Composable
private fun SummaryTile(
    title: String,
    value: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    valueColor: Color = Color(0xFF1A2744),
    valueSize: androidx.compose.ui.unit.TextUnit = 14.sp,
    tileHeight: androidx.compose.ui.unit.Dp = 102.6.dp
) {
    Column(
        modifier = modifier
            .height(tileHeight)
            .background(Color(0xFFEEF2F8), RoundedCornerShape(13.dp))
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(13.dp))
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Text(title, color = Color(0xFF8FA4BE), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        SpacerH(4)
        Text(
            value,
            color = valueColor,
            fontSize = valueSize,
            fontWeight = FontWeight.ExtraBold
        )
        SpacerH(1)
        Text(
            subtitle,
            color = Color(0xFF5A7096),
            fontSize = 11.sp,
            lineHeight = 16.5.sp
        )
    }
}

@Composable
private fun Participant(letter: String, color: Color) {
    Box(
        modifier = Modifier
            .size(22.dp)
            .background(color, RoundedCornerShape(11.dp))
            .border(1.2.dp, Color.White, RoundedCornerShape(11.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(letter, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun SpacerH(h: Int) = Box(modifier = Modifier.height(h.dp))
