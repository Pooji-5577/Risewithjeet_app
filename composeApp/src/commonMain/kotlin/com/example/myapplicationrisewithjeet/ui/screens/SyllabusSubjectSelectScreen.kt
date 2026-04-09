package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent

// ── Palette ──────────────────────────────────────────────────
private val SSBg      = Brush.linearGradient(listOf(Color(0xFF060E1D), Color(0xFF08162E)))
private val SSSurface = Color(0xFFF4F6FB)
private val SSCard    = Color.White
private val SSText    = Color(0xFF0E1A2D)
private val SSGray    = Color(0xFF8FA3C0)
private val SSBorder  = Color(0xFFE2E8F0)

// ── Data ──────────────────────────────────────────────────────
data class SyllabusSubjectItem(
    val id: String,
    val emoji: String,
    val name: String,
    val subTopics: Int,
    val topics: Int,
    val pyqs: Int,
    val donePercent: Int,
    val progressColor: Color
)

private val prelimsSubjects = listOf(
    SyllabusSubjectItem("history",  "🏛",  "History & Culture",       5, 39,  340, 21,  Color(0xFF7C3AED)),
    SyllabusSubjectItem("geo",      "🌍",  "Geography",               6, 38,  289, 0,   Color(0xFF9CA3AF)),
    SyllabusSubjectItem("polity",   "⚖️", "Indian Polity",           8, 42,  220, 38,  Color(0xFF22C55E)),
    SyllabusSubjectItem("economy",  "💰",  "Indian Economy",          7, 27,  258, 12,  Color(0xFFEF4444)),
    SyllabusSubjectItem("env",      "🌿",  "Environment",             5, 34,  198, 0,   Color(0xFF9CA3AF)),
    SyllabusSubjectItem("scitech",  "🔬",  "Science & Technology",   4, 26,   55, 0,   Color(0xFF9CA3AF)),
    SyllabusSubjectItem("ir",       "🌐",  "International Relations", 4, 18,  138, 0,   Color(0xFF9CA3AF)),
    SyllabusSubjectItem("csat",     "📊",  "CSAT Paper II",           4, 24,  120, 0,   Color(0xFF9CA3AF)),
)

data class MainsPaperItem(
    val id: String,
    val emoji: String,
    val name: String,
    val subtitle: String,
    val donePercent: Int,
    val progressColor: Color
)

private val mainsPapers = listOf(
    MainsPaperItem("gs1",   "🌐",  "GS Paper I",   "Indian Heritage, History, Geography",     21, Color(0xFF7C3AED)),
    MainsPaperItem("gs2",   "⚖️", "GS Paper II",  "Governance, Polity, Social Justice, IR",   0, Color(0xFF9CA3AF)),
    MainsPaperItem("gs3",   "📈",  "GS Paper III", "Economy, Agriculture, Environment, Security", 38, Color(0xFF22C55E)),
    MainsPaperItem("gs4",   "🤝",  "GS Paper IV",  "Ethics, Integrity, Aptitude",             12, Color(0xFFEF4444)),
    MainsPaperItem("essay", "✍️", "Essay Paper",  "Essay writing frameworks & practice",      0, Color(0xFF9CA3AF)),
)

private val optionalSubjects = listOf(
    SyllabusSubjectItem("hist_opt",  "🏛",  "History & Culture", 5, 39, 340, 21, Color(0xFF7C3AED)),
    SyllabusSubjectItem("geo_opt",   "🌍",  "Geography",          6, 38, 289,  0, Color(0xFF9CA3AF)),
    SyllabusSubjectItem("socio",     "👥",  "Sociology",          8, 42, 220, 38, Color(0xFF22C55E)),
    SyllabusSubjectItem("econ_opt",  "💰",  "Economics",          7, 27, 258, 12, Color(0xFFEF4444)),
    SyllabusSubjectItem("econ_opt2", "📊",  "Economics",          5, 34, 198,  0, Color(0xFF9CA3AF)),
    SyllabusSubjectItem("phil",      "🧘",  "Philosophy",         4, 26,  55,  0, Color(0xFF9CA3AF)),
)

@Composable
fun SyllabusSubjectSelectScreen(
    onBack: () -> Unit,
    onSubjectSelected: (String) -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) } // 0=Prelims, 1=Mains, 2=Optional

    val titleEmoji = when (selectedTab) { 1 -> "📝"; else -> "📚" }
    val titleText  = when (selectedTab) { 1 -> "GS Papers"; else -> "Subjects" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = SSBg)
    ) {
        // ── Dark header ──────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = SSBg)
                .statusBarsPadding()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "←",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 22.sp,
                    modifier = Modifier.clickable { onBack() }
                )
                Text(
                    buildAnnotatedString {
                        append("STEP ")
                        withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("1") }
                        append(" OF 3")
                    },
                    color = Color.White.copy(alpha = 0.35f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(16.dp))

            Text(titleEmoji, fontSize = 30.sp)
            Spacer(Modifier.height(8.dp))
            Text(titleText, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(6.dp))
            Text(
                "Select a ${if (selectedTab == 1) "paper" else "subject"} to explore its topics",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))

            // Tabs
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TabChip("🎯 Prelims",  selectedTab == 0) { selectedTab = 0 }
                TabChip("✍️ Mains",   selectedTab == 1) { selectedTab = 1 }
                TabChip("📚 Optional", selectedTab == 2) { selectedTab = 2 }
            }
            Spacer(Modifier.height(20.dp))
        }

        // ── Scrollable white card ────────────────────────────
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(SSCard)
                .border(1.dp, SSBorder, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            when (selectedTab) {
                0, 2 -> {
                    val subjects = if (selectedTab == 0) prelimsSubjects else optionalSubjects
                    items(subjects) { subject ->
                        SubjectRow(subject, onSubjectSelected)
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(SSBorder))
                    }
                }
                1 -> {
                    items(mainsPapers) { paper ->
                        PaperRow(paper, onSubjectSelected)
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(SSBorder))
                    }
                }
            }
        }
    }
}

@Composable
private fun TabChip(label: String, active: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (active) GoldAccent
                else Color.White.copy(alpha = 0.12f)
            )
            .border(
                1.dp,
                if (active) GoldAccent else Color.White.copy(alpha = 0.3f),
                RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            label,
            color = if (active) Color(0xFF101828) else Color.White,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun SubjectRow(subject: SyllabusSubjectItem, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(subject.id) }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon box
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF4F6FB))
                .border(1.dp, SSBorder, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(subject.emoji, fontSize = 18.sp)
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(subject.name, color = SSText, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(
                "${subject.subTopics} sub-topics · ${subject.topics} topics · ${subject.pyqs} PYQs",
                color = SSGray, fontSize = 11.sp
            )
            Spacer(Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(3.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFFE5E7EB))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(subject.donePercent / 100f)
                        .fillMaxHeight()
                        .background(subject.progressColor)
                )
            }
        }
        Spacer(Modifier.width(8.dp))
        Column(horizontalAlignment = Alignment.End) {
            Text(
                "${subject.donePercent}%",
                color = if (subject.donePercent > 0) subject.progressColor else SSGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.width(6.dp))
        Text("›", color = SSGray, fontSize = 16.sp)
    }
}

@Composable
private fun PaperRow(paper: MainsPaperItem, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(paper.id) }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF4F6FB))
                .border(1.dp, SSBorder, RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(paper.emoji, fontSize = 18.sp)
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(paper.name, color = SSText, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(paper.subtitle, color = SSGray, fontSize = 11.sp)
            Spacer(Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(3.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFFE5E7EB))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(paper.donePercent / 100f)
                        .fillMaxHeight()
                        .background(paper.progressColor)
                )
            }
        }
        Spacer(Modifier.width(8.dp))
        Text(
            "${paper.donePercent}%",
            color = if (paper.donePercent > 0) paper.progressColor else SSGray,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.width(6.dp))
        Text("›", color = SSGray, fontSize = 16.sp)
    }
}
