package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private data class VideoSubject(
    val emoji: String,
    val title: String,
    val meta: String,
    val views: String,
    val progress: Float,
    val border: Color,
    val background: Brush
)

private val videoSubjects = listOf(
    VideoSubject("⚖️", "Indian Polity", "41 videos · 28h", "3.2L views", 0.72f, Color(0xFFC0D9F5), Brush.linearGradient(listOf(Color(0xFFEEF2F8), Color(0xFFE4EBF6)))),
    VideoSubject("🏛️", "Modern History", "38 videos · 24h", "2.8L views", 0.54f, Color(0xFFFFD5A8), Brush.linearGradient(listOf(Color(0xFFFFF8EE), Color(0xFFFEF3E0)))),
    VideoSubject("🌍", "Geography", "35 videos · 22h", "2.1L views", 0.48f, Color(0xFFB2EDD0), Brush.linearGradient(listOf(Color(0xFFEDF9F3), Color(0xFFDFF5EA)))),
    VideoSubject("📈", "Indian Economy", "29 videos · 18h", "1.9L views", 0.38f, Color(0xFFE8E1FD), Brush.linearGradient(listOf(Color(0xFFF3EFFD), Color(0xFFEDE7FB)))),
    VideoSubject("🌿", "Environment", "31 videos · 20h", "2.4L views", 0.62f, Color(0xFFB2EDD0), Brush.linearGradient(listOf(Color(0xFFEDF9F3), Color(0xFFE0F5EA)))),
    VideoSubject("🔬", "Science & Tech", "21 videos · 13h", "1.2L views", 0.28f, Color(0xFFC0D9F5), Brush.linearGradient(listOf(Color(0xFFE0EBF9), Color(0xFFD4E4F7)))),
    VideoSubject("🏺", "Ancient History", "26 videos · 16h", "1.5L views", 0.46f, Color(0xFFFFD5A8), Brush.linearGradient(listOf(Color(0xFFFDF3E7), Color(0xFFFDEBD4)))),
    VideoSubject("🤝", "Ethics GS4", "18 videos · 11h", "95K views", 0.34f, Color(0xFFE9DDF8), Brush.linearGradient(listOf(Color(0xFFF6F0FF), Color(0xFFEDE3FB)))),
    VideoSubject("🛡️", "Internal Security", "14 videos · 9h", "75K views", 0.26f, Color(0xFFFFD0B8), Brush.linearGradient(listOf(Color(0xFFFFF0E8), Color(0xFFFCE3D8)))),
    VideoSubject("🌐", "Int'l Relations", "22 videos · 14h", "1.1L views", 0.44f, Color(0xFFE9DDF8), Brush.linearGradient(listOf(Color(0xFFF6F0FF), Color(0xFFEDE3FB)))),
    VideoSubject("🎭", "Art & Culture", "19 videos · 12h", "88K views", 0.30f, Color(0xFFC0D9F5), Brush.linearGradient(listOf(Color(0xFFECF3FC), Color(0xFFE0ECFA)))),
    VideoSubject("✍️", "Essay Writing", "16 videos · 10h", "1.3L views", 0.45f, Color(0xFFFFD5A8), Brush.linearGradient(listOf(Color(0xFFFEF5EC), Color(0xFFFEF0E0))))
)

@Composable
fun VideoLecturesScreen(
    onBack: () -> Unit = {},
    onIndianPolityClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF071224))
    ) {
        item {
            HeroSection(onBack = onBack)
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
                    .padding(horizontal = 18.dp, vertical = 12.dp)
            ) {
                CategoryChips()
                Spacer(Modifier.height(10.dp))
                FeaturedVideoCard()
                Spacer(Modifier.height(12.dp))
                SubjectHeading()
                Spacer(Modifier.height(8.dp))
                SubjectGrid(onIndianPolityClick = onIndianPolityClick)
                Spacer(Modifier.height(14.dp))
                YoutubeBanner()
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun HeroSection(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF071224))
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("9:41", color = Color.White, fontSize = 12.sp)
                Text("••••  🔋", color = Color.White.copy(alpha = 0.55f), fontSize = 11.sp)
            }
            Spacer(Modifier.height(4.dp))
            Text(
                "←",
                color = Color.White.copy(alpha = 0.55f),
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { onBack() }
            )
            Spacer(Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0x2EF5A623))
                    .border(0.8.dp, Color(0x52F5A623), RoundedCornerShape(18.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text("🎥 VIDEO LECTURES", color = Color(0xFFF5A623), fontSize = 9.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            Text(
                buildAnnotatedString {
                    append("Master Your ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623), fontStyle = FontStyle.Italic)) { append("UPSC Journey") }
                    append("\nwith Expert Video Lectures")
                },
                color = Color.White,
                fontSize = 30.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Every editorial, every perspective mapped to what UPSC asks. Learn from Jeet Sir & IAS toppers.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                color = Color.White.copy(alpha = 0.48f),
                fontSize = 12.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(14.dp))
                    .background(GoldGradient)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text("▶ Start Learning", color = Color(0xFF1A2744), fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.07f))
                    .border(0.8.dp, Color.White.copy(alpha = 0.09f), RoundedCornerShape(14.dp))
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HeroStat("500+", "FREE\nLECTURES", Color(0xFFF5A623))
                HeroStat("12+", "CORE\nSUBJECTS", Color(0xFF4ADE80))
                HeroStat("1L+", "SUBSCRIBERS", Color.White)
                HeroStat("∞", "ALWAYS FREE", Color(0xFFF5A623))
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
private fun HeroStat(value: String, label: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = valueColor, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color.White.copy(alpha = 0.38f), fontSize = 9.sp, lineHeight = 12.sp)
    }
}

@Composable
private fun CategoryChips() {
    val chips = listOf("All Categories", "Polity", "History", "Geography", "Economy", "Environment", "Science & Tech", "Ethics")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        chips.forEachIndexed { i, label ->
            val selected = i == 0
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(if (selected) Color(0xFF1A2744) else Color.White)
                    .border(
                        0.8.dp,
                        if (selected) Color(0xFF1A2744) else Color(0xFFDDE5F0),
                        RoundedCornerShape(18.dp)
                    )
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(
                    label,
                    color = if (selected) Color.White else Color(0xFF5A7096),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun FeaturedVideoCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .clip(RoundedCornerShape(34.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF202C4F),
                        Color(0xFF19284A),
                        Color(0xFF020A1B)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 43.dp)
                .size(52.dp)
                .shadow(9.dp, CircleShape, clip = false)
                .clip(CircleShape)
                .background(Color(0xEBF5A623)),
            contentAlignment = Alignment.Center
        ) {
            Text("▶", color = Color(0xFF0A0A0A), fontSize = 22.sp, lineHeight = 33.sp)
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Text(
                "Polity Simplified — Complete Series",
                color = Color.White,
                fontSize = 16.sp,
                lineHeight = 20.8.sp,
                letterSpacing = (-0.3).sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(9.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("📺 41 videos", color = Color.White.copy(alpha = 0.6f), fontSize = 11.5.sp, lineHeight = 17.25.sp)
                Text("⏱ 28 hours", color = Color.White.copy(alpha = 0.6f), fontSize = 11.5.sp, lineHeight = 17.25.sp)
                Text("👁 3.2L views", color = Color.White.copy(alpha = 0.6f), fontSize = 11.5.sp, lineHeight = 17.25.sp)
            }
        }
    }
}

@Composable
private fun SubjectHeading() {
    Column {
        Text("BROWSE BY SUBJECT", color = Color(0xFFC95212), fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.9.sp)
        Text("Pick Your Subject,", color = Color(0xFF1A2744), fontSize = 20.sp, lineHeight = 25.sp, letterSpacing = (-0.4).sp, fontWeight = FontWeight.ExtraBold)
        Text("Start Learning.", color = Color(0xFFF5A623), fontSize = 20.sp, lineHeight = 25.sp, letterSpacing = (-0.4).sp, fontStyle = FontStyle.Italic, fontWeight = FontWeight.ExtraBold)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SubjectGrid(
    onIndianPolityClick: () -> Unit
) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        val cardWidth = (maxWidth - 12.dp) / 2

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            maxItemsInEachRow = 2
        ) {
            videoSubjects.forEach { subject ->
                VideoSubjectCard(
                    subject = subject,
                    modifier = Modifier.width(cardWidth),
                    onClick = {
                        if (subject.title == "Indian Polity") onIndianPolityClick()
                    }
                )
            }
        }
    }
}

@Composable
private fun VideoSubjectCard(
    subject: VideoSubject,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(subject.background)
            .border(0.8.dp, subject.border, RoundedCornerShape(18.dp))
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Text(subject.emoji, fontSize = 28.sp)
        Spacer(Modifier.height(4.dp))
        Text(subject.title, color = Color(0xFF1A2744), fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(2.dp))
        Text(subject.meta, color = Color(0xFF5A7096), fontSize = 11.sp)
        Spacer(Modifier.height(2.dp))
        Text("👁 ${subject.views}", color = Color(0xFF8FA4BE), fontSize = 10.sp)
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(Color(0xFFDDE5F0))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(subject.progress.coerceIn(0f, 1f))
                    .height(4.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(Color(0xFFD79B24))
            )
        }
    }
}

@Composable
private fun YoutubeBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(216.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF071224))
            .border(0.8.dp, Color.White.copy(alpha = 0.07f), RoundedCornerShape(20.dp))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 28.dp, y = (-40).dp)
                .size(100.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0x1AF5A623), Color.Transparent),
                        radius = 140f
                    )
                )
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 19.dp, end = 19.dp, top = 19.dp, bottom = 19.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.width(187.dp)) {
                Text(
                    "Never Miss a",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 22.5.sp,
                    letterSpacing = (-0.3).sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    "Lecture Again.",
                    color = Color(0xFFF5A623),
                    fontSize = 15.sp,
                    lineHeight = 22.5.sp,
                    letterSpacing = (-0.3).sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Subscribe to Rise With Jeet on\nYouTube for instant\nnotifications.",
                    color = Color.White.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    lineHeight = 19.2.sp
                )
                Spacer(Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .width(186.dp)
                        .height(36.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFF0000)),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.padding(start = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("▶", color = Color.White, fontSize = 15.sp, lineHeight = 20.sp, fontWeight = FontWeight.Bold)
                        Text(" Join Our YouTube Family", color = Color.White, fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(Modifier.height(7.dp))
                Text(
                    "Join 14K+ UPSC Aspirants Now",
                    color = Color.White.copy(alpha = 0.3f),
                    fontSize = 11.sp,
                    lineHeight = 16.5.sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 41.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.06f))
                        .border(1.6.dp, Color.White.copy(alpha = 0.1f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🔔", color = Color(0xFF0A0A0A), fontSize = 38.sp, lineHeight = 57.sp)
                }
                Spacer(Modifier.height(5.dp))
                Text(
                    "@RiseWithJeet",
                    color = Color.White.copy(alpha = 0.35f),
                    fontSize = 11.sp,
                    lineHeight = 16.5.sp
                )
            }
        }
    }
}
