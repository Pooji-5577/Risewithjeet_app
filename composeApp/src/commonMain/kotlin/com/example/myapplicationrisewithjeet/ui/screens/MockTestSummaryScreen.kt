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
    val paperLabel = if (isMains) "GS Paper I" else "GS Paper I"
    val topicLabel = "🗂️ All Topics"
    val sourceLabel = if (isMains) "Daily MCQ" else "Daily MCQ"
    val timeLabel = "~30 min"
    val guidelineTitle = if (isMains) "⚡ WRITING GUIDELINES" else "⚡ WRITING GUIDELINES"
    val guidelineBullets = if (isMains) {
        listOf(
            "• Clear introduction with statement understanding",
            "• Body with examples (2–3 from recent cases)",
            "• Balance both sides of the argument",
            "• Conclude with personal opinion backed by logic"
        )
    } else {
        listOf(
            "• Clear introduction with statement understanding",
            "• Body with examples (2–3 from recent cases)",
            "• Balance both sides of the argument",
            "• Conclude with personal opinion backed by logic"
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
                        .height(50.dp)
                        .background(GoldGradient, RoundedCornerShape(12.dp))
                        .clickable { onGenerateTestNow() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "⚡ Generate Test Now",
                        color = Color(0xFF14213D),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                SpacerH(10)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                        .background(Color(0xFF1A2744), RoundedCornerShape(12.dp))
                        .clickable { onEditConfiguration() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "← Edit Configuration",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
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
            .height(182.dp)
            .background(Color(0xFF08162A))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 14.dp)
        ) {
            Text(
                "←",
                color = Color(0xFF88A2C4),
                fontSize = 17.sp,
                modifier = Modifier.clickable { onBack() }
            )
            SpacerH(14)
            Box(
                modifier = Modifier
                    .background(Color(0xFFEAF8EE), RoundedCornerShape(16.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    "✅ TEST SUMMARY — READY TO BEGIN!",
                    color = Color(0xFF3E8F58),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            SpacerH(10)
            Text(
                buildAnnotatedString {
                    append("You're All Set!\nLet's ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Crush It.") }
                },
                color = Color.White,
                fontSize = 38.sp,
                lineHeight = 44.sp,
                fontWeight = FontWeight.ExtraBold
            )
            SpacerH(7)
            Text(
                "Review your configuration below then hit\nGenerate to start.",
                color = Color(0xFF6F8AAF),
                fontSize = 14.sp,
                lineHeight = 20.sp
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
            .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(22.dp))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0D1B2E), RoundedCornerShape(16.dp))
                .padding(horizontal = 10.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(Color(0xFF1A2744), RoundedCornerShape(11.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("⚡", color = Color(0xFFF5A623), fontSize = 18.sp)
            }
            Text(
                " Are you ready?",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        SpacerH(12)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SummaryTile("📄 PAPER", paperLabel, "History, Geography,\nSociety", Modifier.weight(1f))
            SummaryTile("📍 TOPIC", topicLabel, "Mixed across all\nchapters", Modifier.weight(1f))
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SummaryTile("❓ QUESTIONS", "25", "~30 min · Free tier", Modifier.weight(1f), highlight = true)
            SummaryTile("⚡ DIFFICULTY", "Medium", "UPSC standard level", Modifier.weight(1f), highlight = true)
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SummaryTile("📚 SOURCE", sourceLabel, "Curated daily picks", Modifier.weight(1f))
            SummaryTile("⏱ TIME", timeLabel, "Standard exam pace", Modifier.weight(1f))
        }
        SpacerH(10)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8EEF8), RoundedCornerShape(13.dp))
                .padding(horizontal = 10.dp, vertical = 9.dp)
        ) {
            Text(guidelineTitle, color = Color(0xFF5A7096), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
            SpacerH(5)
            guidelineBullets.forEach {
                Text(it, color = Color(0xFF1D2D4F), fontSize = 10.5.sp, lineHeight = 16.sp)
            }
        }
        SpacerH(10)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9FBFF), RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFFE3EAF5), RoundedCornerShape(12.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp),
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
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text("  ", fontSize = 10.sp)
            Text("💞", fontSize = 11.sp)
        }
    }
}

@Composable
private fun SummaryTile(
    title: String,
    value: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    highlight: Boolean = false
) {
    Column(
        modifier = modifier
            .height(95.dp)
            .background(Color(0xFFF2F5FB), RoundedCornerShape(12.dp))
            .padding(9.dp)
    ) {
        Text(title, color = Color(0xFFA3B3C8), fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
        SpacerH(5)
        Text(
            value,
            color = if (highlight) Color(0xFF1B3E9A) else Color(0xFF243B67),
            fontSize = if (highlight) 22.sp else 18.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            subtitle,
            color = Color(0xFF7E93AF),
            fontSize = 10.5.sp,
            lineHeight = 14.sp
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
