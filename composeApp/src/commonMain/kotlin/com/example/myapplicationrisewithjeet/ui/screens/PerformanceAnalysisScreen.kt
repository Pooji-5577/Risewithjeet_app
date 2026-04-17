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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerformanceAnalysisScreen(onBack: () -> Unit = {}) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4FA))
    ) {
        item { Header(onBack = onBack) }
        item {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OverviewMetrics()
                DailyTrendCard()
                TimeDistributionCard()
                AccuracyMatrixCard()
                StudyStreakCard()
                DailyTrioCard()
                CompleteHistoryCard()
                AchievementsCard()
                StrengthLeaderboardCard()
                AiInsightsCard()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun Header(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF08162A))
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFF96ABCA), fontSize = 16.sp, modifier = Modifier.clickable { onBack() })
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                CircleIcon("🧠")
                CircleIcon("🔔")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .background(Color(0xFF1A2744), RoundedCornerShape(99.dp))
                .border(1.dp, Color(0xFF2B3D61), RoundedCornerShape(99.dp))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text("📊 PERFORMANCE ANALYSIS · DASHBOARD", color = Color(0xFFE2B768), fontSize = 8.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            buildAnnotatedString {
                append("Arjun's ")
                withStyle(SpanStyle(color = Color(0xFFF5A623))) { append("Progress.") }
            },
            color = Color.White,
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 36.sp
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            "Your complete UPSC test analytics, score trends, subject mastery, time management and AI-powered next steps.",
            color = Color(0xFF7088AA),
            fontSize = 9.5.sp,
            lineHeight = 14.sp
        )
    }
}

@Composable
private fun CircleIcon(text: String) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(Color.White, RoundedCornerShape(7.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text, fontSize = 10.sp)
    }
}

@Composable
private fun OverviewMetrics() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        TopMetric("38", "ANSWERS WRITTEN", Color(0xFF66C788), Modifier.weight(1f))
        TopMetric("84.7", "AVG SCORE", Color(0xFFF0A52D), Modifier.weight(1f))
        TopMetric("12.4h", "STUDY TIME", Color(0xFF6C88FF), Modifier.weight(1f))
    }
}

@Composable
private fun TopMetric(value: String, label: String, accent: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(74.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFDCE5F1), RoundedCornerShape(12.dp))
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(accent, RoundedCornerShape(3.dp))
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(value, color = Color(0xFF273760), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color(0xFF8FA1BB), fontSize = 8.sp, lineHeight = 10.sp)
    }
}

@Composable
private fun DailyTrendCard() {
    CardShell("📈 Daily Trend") {
        Text("Score distribution over 8 tests", color = Color(0xFFA2B0C5), fontSize = 8.5.sp)
        Spacer(modifier = Modifier.height(8.dp))
        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp)
                .background(Color(0xFFF8FAFF), RoundedCornerShape(9.dp))
                .padding(6.dp)
        ) {
            val grid = Color(0xFFDCE5F1)
            repeat(4) { idx ->
                val y = size.height * (idx + 1) / 5f
                drawLine(
                    color = grid,
                    start = androidx.compose.ui.geometry.Offset(0f, y),
                    end = androidx.compose.ui.geometry.Offset(size.width, y),
                    strokeWidth = 1f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 6f), 0f)
                )
            }
            val pts = listOf(
                0.08f to 0.74f,
                0.20f to 0.66f,
                0.34f to 0.58f,
                0.47f to 0.49f,
                0.62f to 0.42f,
                0.75f to 0.30f,
                0.93f to 0.19f
            ).map { androidx.compose.ui.geometry.Offset(it.first * size.width, it.second * size.height) }

            val path = androidx.compose.ui.graphics.Path().apply {
                moveTo(pts.first().x, pts.first().y)
                for (i in 1 until pts.size) lineTo(pts[i].x, pts[i].y)
            }
            drawPath(path, color = Color(0xFF6A82FF), style = Stroke(width = 4f, cap = StrokeCap.Round))
            pts.forEachIndexed { i, p ->
                if (i % 2 == 0 || i == pts.lastIndex) {
                    drawCircle(Color.White, radius = 5f, center = p)
                    drawCircle(Color(0xFF6A82FF), radius = 3.6f, center = p)
                }
            }
        }
    }
}

@Composable
private fun TimeDistributionCard() {
    CardShell("⏱️ Time Distribution") {
        val rows = listOf(
            Triple("Easy", "18m", Color(0xFF63C084)),
            Triple("Medium", "25m", Color(0xFFF0A330)),
            Triple("Hard", "14m", Color(0xFFE97136)),
            Triple("Review", "8m", Color(0xFF6F63FF))
        )
        rows.forEach {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(7.dp).background(it.third, CircleShape))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(it.first, color = Color(0xFF52627E), fontSize = 10.sp)
                }
                Text(it.second, color = it.third, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

@Composable
private fun AccuracyMatrixCard() {
    CardShell("📊 Accuracy Matrix") {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text("✅ Strong Areas", color = Color(0xFF63C084), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                MiniBar("Polity", 0.84f, Color(0xFF63C084))
                MiniBar("History", 0.78f, Color(0xFF6A82FF))
                MiniBar("Environment", 0.66f, Color(0xFF6F63FF))
            }
            Column(modifier = Modifier.weight(1f)) {
                Text("⚠️ Focus Areas", color = Color(0xFFE0A22C), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                MiniBar("Economy", 0.44f, Color(0xFFE97136))
                MiniBar("Geo", 0.38f, Color(0xFFCF4B4B))
                MiniBar("CA", 0.58f, Color(0xFFF0A330))
            }
        }
    }
}

@Composable
private fun MiniBar(label: String, pct: Float, color: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = Color(0xFF52627E), fontSize = 9.sp, modifier = Modifier.width(52.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(5.dp)
                .background(Color(0xFFE6ECF5), RoundedCornerShape(4.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(pct)
                    .height(5.dp)
                    .background(color, RoundedCornerShape(4.dp))
            )
        }
        Text("${(pct * 100).toInt()}%", color = color, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.height(6.dp))
}

@Composable
private fun StudyStreakCard() {
    CardShell("📅 Study Streak — Feb 2026") {
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            repeat(7) { idx ->
                Text(listOf("M", "T", "W", "T", "F", "S", "S")[idx], color = Color(0xFF9AA9BF), fontSize = 7.5.sp, modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        repeat(4) { r ->
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                repeat(7) { c ->
                    val hot = (r + c) % 3 != 0
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(if (hot) Color(0xFF63C084) else Color(0xFFE4EBF5))
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("🔥 23 day streak", color = Color(0xFF63C084), fontSize = 9.sp, fontWeight = FontWeight.Bold)
            Text("12%", color = Color(0xFF6A82FF), fontSize = 9.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun DailyTrioCard() {
    CardShell("🗂️ Daily Trio") {
        trioRow("Daily MCQ Challenge", "8.7")
        trioRow("Daily Mains Challenge", "7.2")
        trioRow("Daily News Analysis", "6.9")
    }
}

@Composable
private fun trioRow(label: String, score: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, color = Color(0xFF4E5E79), fontSize = 10.sp)
        Text(score, color = Color(0xFF6A82FF), fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun CompleteHistoryCard() {
    CardShell("🧾 Complete Test History") {
        val rows = listOf(
            "Polity Mock Test 8" to "44/200",
            "Current Affairs Test 4" to "43/60",
            "Prelims Mock Test 7" to "40/200",
            "Polity Mock Test 7" to "43/60",
            "Prelims Mock Test 6" to "40/200"
        )
        rows.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(it.first, color = Color(0xFF445572), fontSize = 9.5.sp)
                Text(it.second, color = Color(0xFFD87528), fontSize = 9.5.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text("View all +", color = Color(0xFF5471E2), fontSize = 9.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun AchievementsCard() {
    CardShell("🏆 Achievement Ring") {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            Badge("🔥", "Streak 21", modifier = Modifier.width(96.dp))
            Badge("🎯", "Accuracy 84", modifier = Modifier.width(96.dp))
            Badge("📘", "100 tests", modifier = Modifier.width(96.dp))
        }
    }
}

@Composable
private fun Badge(emoji: String, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFFF8FAFF), RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFDCE5F1), RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(emoji, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(3.dp))
        Text(label, color = Color(0xFF4E5E79), fontSize = 8.5.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun StrengthLeaderboardCard() {
    CardShell("🥇 Strength Leaderboard") {
        val rows = listOf(
            Triple("#1", "Polity", "+84"),
            Triple("#2", "History", "+79"),
            Triple("#3", "Environment", "+66"),
            Triple("#4", "Economy", "+44")
        )
        rows.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(it.first, color = Color(0xFFF0A330), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(it.second, color = Color(0xFF445572), fontSize = 9.5.sp)
                }
                Text(it.third, color = Color(0xFF63C084), fontSize = 9.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun AiInsightsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(listOf(Color(0xFF111F39), Color(0xFF15284B))), RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFF2B3D61), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🧠 Jeet AI Next Steps", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .background(Color(0xFF21345A), RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
                Text("Updated", color = Color(0xFFE2B768), fontSize = 8.sp)
            }
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            "• Geography is your weakest area.\n• Reduce overthinking in Economy.\n• Keep Polity momentum with daily 15-minute revision.",
            color = Color(0xFFB8C7DD),
            fontSize = 9.5.sp,
            lineHeight = 14.sp
        )
    }
}

@Composable
private fun CardShell(title: String, body: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFFDCE5F1), RoundedCornerShape(14.dp))
            .padding(10.dp)
    ) {
        Text(title, color = Color(0xFF273760), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(6.dp))
        body()
    }
}
