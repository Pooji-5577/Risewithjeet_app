package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private data class PolityVideo(
    val emoji: String,
    val duration: String,
    val title: String,
    val stats: String,
    val badge: String? = null,
    val badgeColor: Color = Color(0xFFC95212),
    val badgeBg: Color = Color(0xFFFEF5EC)
)

private val polityVideos = listOf(
    PolityVideo("⚖️", "28:14", "Fundamental Rights - Article 12 to 35 | Complete Deep Dive", "👁 1.1L   ⏱ 28 min   📅 1 week ago", "35% watched"),
    PolityVideo("🏛️", "42:08", "Introduction to Indian Constitution | Historical Background | Jeet Sir", "👁 2.2L   ⏱ 42 min   📅 2 days ago"),
    PolityVideo("📜", "35:22", "Directive Principles & Fundamental Duties | GS2 Mains", "👁 89K   ⏱ 35 min   📅 2 weeks ago", "✓ Watched", Color(0xFF0E8A56), Color(0xFFEDF9F3)),
    PolityVideo("🗳️", "51:17", "Election Commission of India - Powers, Functions & PYQs", "👁 67K   ⏱ 51 min   📅 3 weeks ago")
)

@Composable
fun IndianPolityVideosScreen(
    onBack: () -> Unit = {},
    onWatch: () -> Unit = {},
    onPdf: () -> Unit = {}
) {
    var showAskMentor by remember { mutableStateOf(false) }
    var selectedLectureTitle by remember { mutableStateOf(polityVideos.first().title) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEF2F8))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item { PolityHeader(onBack = onBack) }
            item { FilterRow() }
            items(polityVideos.size) { idx ->
                val lecture = polityVideos[idx]
                PolityLectureCard(
                    video = lecture,
                    onAskMentor = {
                        selectedLectureTitle = lecture.title
                        showAskMentor = true
                    },
                    onWatch = onWatch,
                    onPdf = onPdf
                )
                Spacer(Modifier.height(12.dp))
            }
            item { Spacer(Modifier.height(12.dp)) }
        }

        if (showAskMentor) {
            AskMentorBottomSheet(
                lectureTitle = selectedLectureTitle,
                onClose = { showAskMentor = false }
            )
        }
    }
}

@Composable
private fun PolityHeader(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF071224))
            .padding(horizontal = 14.dp, vertical = 16.dp)
    ) {
        Text("←", color = Color.White.copy(alpha = 0.52f), fontSize = 13.sp, modifier = Modifier.clickable { onBack() })
        Spacer(Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0x2EF5A623))
                .border(0.8.dp, Color(0x52F5A623), RoundedCornerShape(20.dp))
                .padding(horizontal = 11.dp, vertical = 4.dp)
        ) {
            Text("GS PAPER II · POLITY", color = Color(0xFFF5A623), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(8.dp))
        Text("⚖️", color = Color.White, fontSize = 26.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text("Indian Polity", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.align(Alignment.CenterHorizontally))
        Text("41 videos · 28h · 3.2L views", color = Color.White.copy(alpha = 0.5f), fontSize = 12.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White.copy(alpha = 0.08f))
                .border(0.8.dp, Color.White.copy(alpha = 0.09f), RoundedCornerShape(16.dp))
                .padding(12.dp)
        ) {
            Column {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Your Progress", color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text("12/41 videos watched", color = Color(0xFFF5A623), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White.copy(alpha = 0.1f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.35f)
                            .height(5.dp)
                            .background(GoldGradient)
                    )
                }
                Spacer(Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Next: Fundamental Rights - Article 12 to 35", color = Color.White.copy(alpha = 0.4f), fontSize = 11.sp)
                    Text("Continue →", color = Color(0xFFF5A623), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(Modifier.height(10.dp))
    }
}

@Composable
private fun FilterRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PolityChip("All Videos", true)
        PolityChip("🎯 Prelims", false)
        PolityChip("✍️ Mains", false)
    }
}

@Composable
private fun PolityChip(text: String, active: Boolean) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (active) Color(0xFF1A2744) else Color.White)
            .border(0.8.dp, if (active) Color(0xFF1A2744) else Color(0xFFDDE5F0), RoundedCornerShape(20.dp))
            .padding(horizontal = 13.dp, vertical = 6.dp)
    ) {
        Text(text, color = if (active) Color.White else Color(0xFF5A7096), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun PolityLectureCard(
    video: PolityVideo,
    onAskMentor: () -> Unit = {},
    onWatch: () -> Unit = {},
    onPdf: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(18.dp))
            .padding(0.8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(182.dp)
                .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                .background(Brush.linearGradient(listOf(Color(0xFF0F1F3D), Color(0xFF223256))))
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xD91A56C4))
                    .padding(horizontal = 9.dp, vertical = 3.dp)
            ) {
                Text("HD", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(video.emoji, fontSize = 40.sp)
                Spacer(Modifier.height(4.dp))
                Text("INDIAN POLITY", color = Color.White.copy(alpha = 0.35f), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black.copy(alpha = 0.8f))
                    .padding(horizontal = 7.dp, vertical = 2.dp)
            ) {
                Text(video.duration, color = Color.White, fontSize = 11.sp)
            }
        }

        if (video.badge == "35% watched") {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .height(3.dp)
                    .background(Color(0xFFC02828))
            )
        }

        Column(modifier = Modifier.padding(12.dp)) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFE0EBF9))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text("INDIAN POLITY", color = Color(0xFF1A56C4), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(8.dp))
            Text(video.title, color = Color(0xFF1A2744), fontSize = 14.sp, lineHeight = 19.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(video.stats, color = Color(0xFF5A7096), fontSize = 11.5.sp)
                if (video.badge != null) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(video.badgeBg)
                            .padding(horizontal = 9.dp, vertical = 3.dp)
                    ) {
                        Text(video.badge, color = video.badgeColor, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(Modifier.height(9.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ActionButton("📄 PDF", Color(0xFFEEF2F8), Color(0xFFDDE5F0), Color(0xFF5A7096), Modifier.weight(1f), onClick = onPdf)
                ActionButton("👨‍🏫 Ask Mentor", Color(0xFFE0EBF9), Color(0xFFC0D9F5), Color(0xFF1A56C4), Modifier.weight(1f), onClick = onAskMentor)
                ActionButton("▶ Watch", Color(0xFFFF0000), Color(0xFFFF0000), Color.White, Modifier.weight(1f), onClick = onWatch)
            }
        }
    }
}

@Composable
private fun ActionButton(
    text: String,
    bg: Color,
    border: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bg)
            .border(0.8.dp, border, RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = textColor, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun AskMentorBottomSheet(
    lectureTitle: String,
    onClose: () -> Unit
) {
    var question by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x66000000))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClose() }
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 34.dp, topEnd = 34.dp))
                .background(Color(0xFFF7F8FB))
                .padding(horizontal = 18.dp, vertical = 16.dp)
                .imePadding()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {}
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(width = 50.dp, height = 6.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(Color(0xFFD8E0EE))
                )
                Spacer(Modifier.height(14.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🧑‍🏫 Ask the Mentor", color = Color(0xFF242E4D), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(Color(0xFFE6EBF3))
                            .border(1.dp, Color(0xFFD2DAE7), RoundedCornerShape(14.dp))
                            .clickable { onClose() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("✕", color = Color(0xFF414C64), fontSize = 20.sp)
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    "Have any doubt about ${lectureTitle.trim()}? Our team responds within 24 hours.",
                    color = Color(0xFF6C7C9B),
                    fontSize = 12.sp,
                    lineHeight = 18.sp
                )
                Spacer(Modifier.height(12.dp))
                Text("YOUR DOUBT OR QUESTION", color = Color(0xFF9BA8C1), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                InputBox(
                    value = question,
                    placeholder = "e.g. At 18:32, I didn't understand why Article 370 had been amended u...",
                    onValueChange = { question = it },
                    height = 136.dp
                )
                Spacer(Modifier.height(12.dp))
                Text("YOUR NAME (OPTIONAL)", color = Color(0xFF9BA8C1), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                InputBox(
                    value = name,
                    placeholder = "e.g. Rahul from Delhi",
                    onValueChange = { name = it },
                    height = 68.dp
                )
                Spacer(Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(76.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(GoldGradient),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Submit Doubt ➜", color = Color(0xFF1A2744), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(Modifier.height(12.dp))
                Text(
                    "Answer posted on YouTube Community & Telegram",
                    color = Color(0xFF8FA0BF),
                    fontSize = 11.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(6.dp))
            }
        }
    }
}

@Composable
private fun InputBox(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    height: androidx.compose.ui.unit.Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0xFFE6EBF3))
            .border(1.dp, Color(0xFFD5DDEB), RoundedCornerShape(18.dp))
            .padding(14.dp),
        contentAlignment = Alignment.TopStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = androidx.compose.ui.text.TextStyle(
                color = Color(0xFF414C64),
                fontSize = 13.sp,
                lineHeight = 20.sp
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (value.isBlank()) {
            Text(placeholder, color = Color(0xFF8A96AF), fontSize = 12.sp, lineHeight = 18.sp)
        }
    }
}
