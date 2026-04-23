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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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

private data class WeeklyInsight(
    val icon: String,
    val iconBg: Color,
    val title: String,
    val body: String,
    val tag: String,
    val tagBg: Color,
    val tagText: Color
)

@Composable
fun PerformanceJeetAIReportScreen(onBack: () -> Unit = {}) {
    val fixFirst = listOf(
        WeeklyInsight(
            icon = "🗺️",
            iconBg = Color(0xFFFFE4E6),
            title = "Geography is your biggest score gap",
            body = "42% accuracy on 96 Qs. Drain of Wealth, river systems, and climate — these 3 topics appear in 15+ Qs annually. Spend 45 min daily for 2 weeks → expect +8–12 marks in mock.",
            tag = "HIGH IMPACT",
            tagBg = Color(0x33EF4444),
            tagText = Color(0xFFFCA5A5)
        ),
        WeeklyInsight(
            icon = "⚡",
            iconBg = Color(0x33F5A623),
            title = "Economy time management crisis",
            body = "Spending 2m 44s avg on Economy Qs — 3x the recommended time. Try: flag Economy Qs and return in last 20 min. Your instincts on Economy are better than your over-analysis.",
            tag = "STRATEGY FIX",
            tagBg = Color(0x33F5A623),
            tagText = Color(0xFFFDE68A)
        ),
        WeeklyInsight(
            icon = "🔁",
            iconBg = Color(0x33EF4444),
            title = "Dyarchy concept — 3rd time wrong",
            body = "Wrong in Mock 2, 3, and 9. Core fact: Got Act 1919 = Dyarchy. Create one flashcard tonight. You cannot afford to lose 2 marks on the same concept in the real exam.",
            tag = "REPEAT ERROR",
            tagBg = Color(0x338B5CF6),
            tagText = Color(0xFFC4B5FD)
        )
    )

    val working = listOf(
        WeeklyInsight(
            icon = "🔥",
            iconBg = Color(0x3322C55E),
            title = "42-day streak — top 3% globally",
            body = "You haven't missed a day since Jan 10. Your retention is 22% better than aspirants who study sporadically.",
            tag = "STRENGTH",
            tagBg = Color(0x3322C55E),
            tagText = Color(0xFF86EFAC)
        ),
        WeeklyInsight(
            icon = "⚖️",
            iconBg = Color(0x3322C55E),
            title = "Polity is your anchor — 84% accuracy",
            body = "Consistent across all 9 mocks. NCERT Chapters 1–10 clearly internalised. This alone contributes 35–40 marks in real Prelims.",
            tag = "ANCHOR TOPIC",
            tagBg = Color(0x3322C55E),
            tagText = Color(0xFF86EFAC)
        ),
        WeeklyInsight(
            icon = "⏱️",
            iconBg = Color(0x3322C55E),
            title = "Speed management improving fast",
            body = "Avg time dropped from 2m 12s (Mock 1) to 1m 18s (Mock 9). Finished Mock 9 with 18 min spare.",
            tag = "SMART TECHNIQUE",
            tagBg = Color(0x3306B6D4),
            tagText = Color(0xFF67E8F9)
        )
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
                    withStyle(SpanStyle(color = Color.White)) {
                        append("Jeet AI Intelligence ")
                    }
                    withStyle(SpanStyle(color = Color(0xFFF5A623))) {
                        append("Report")
                    }
                },
                color = Color.White,
                fontSize = 21.sp,
                lineHeight = 25.2.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Your complete UPSC preparation analytics — streaks, subject mastery,\nweak areas and smart notes.",
                color = Color.White.copy(alpha = 0.4f),
                fontSize = 10.5.sp,
                lineHeight = 16.2.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFFF0F4F8)),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                AiSummaryCard()
            }
            item {
                SectionHeader("⚠️ FIX THESE FIRST — HIGHEST IMPACT", Color(0xFFEF4444))
            }
            item {
                InsightGroupCard(items = fixFirst)
            }
            item {
                SectionHeader("✅ WHAT'S WORKING — KEEP DOING", Color(0xFF22C55E))
            }
            item {
                InsightGroupCard(items = working)
            }
        }
    }
}

@Composable
private fun AiSummaryCard() {
    val cardShape = RoundedCornerShape(14.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, cardShape, ambientColor = Color(0x1A000000), spotColor = Color(0x1A000000))
            .clip(cardShape)
            .background(Color.White)
            .border(1.dp, Color(0xFFDDE5F0), cardShape)
            .padding(14.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0x33F5A623))
                    .border(1.dp, Color(0x4DF5A623), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("🤖", fontSize = 20.sp)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Jeet AI Intelligence Report",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Analysed 847 answers, 18 mocks, 42-day streak data",
                    color = Color.Black,
                    fontSize = 10.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Based on your complete learning history, here's exactly what will\nmove your score the most:",
            color = Color.Black,
            fontSize = 10.5.sp,
            lineHeight = 17.3.sp
        )
    }
}

@Composable
private fun SectionHeader(text: String, color: Color) {
    Text(
        text = text,
        color = color,
        fontSize = 11.sp,
        letterSpacing = 1.1.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 2.dp, vertical = 2.dp)
    )
}

@Composable
private fun InsightGroupCard(items: List<WeeklyInsight>) {
    val cardShape = RoundedCornerShape(14.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, cardShape, ambientColor = Color(0x26000000), spotColor = Color(0x1A000000))
            .clip(cardShape)
            .background(Color.White)
            .border(1.dp, Color(0xFFDDE5F0), cardShape)
    ) {
        items.forEachIndexed { index, item ->
            if (index > 0) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0x0FFFFFFF))
                )
            }
            InsightRow(item = item)
        }
    }
}

@Composable
private fun InsightRow(item: WeeklyInsight) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 11.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .padding(top = 1.dp)
                .size(30.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(item.iconBg),
            contentAlignment = Alignment.Center
        ) {
            Text(item.icon, fontSize = 14.sp)
        }

        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.body,
                color = Color.Black,
                fontSize = 10.sp,
                lineHeight = 16.sp
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(item.tagBg)
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    text = item.tag,
                    color = item.tagText,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
