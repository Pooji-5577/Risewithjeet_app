package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
private val STPBg      = Brush.linearGradient(listOf(Color(0xFF081328), Color(0xFF081328)))
private val STPSurface = Color(0xFFF0F4F8)
private val STPCard    = Color.White
private val STPText    = Color(0xFF0E1A2D)
private val STPGray    = Color(0xFF8FA3C0)
private val STPBorder  = Color(0xFFE2E8F0)

// ── Data ──────────────────────────────────────────────────────
data class SubTopicItem(
    val id: String,
    val emoji: String,
    val name: String,
    val totalTopics: Int,
    val doneTopics: Int,
    val donePercent: Int,
    val checkState: CheckState   // NONE, PARTIAL, FULL
)

enum class CheckState { NONE, PARTIAL, FULL }

data class SubjectMeta(
    val emoji: String,
    val name: String,
    val subtitle: String,      // e.g. "5 sub-topics · 39 topics"
    val progressPercent: Int,
    val total: Int,
    val done: Int,
    val active: Int,
    val left: Int,
    val subTopics: List<SubTopicItem>
)

private val subjectData: Map<String, SubjectMeta> = mapOf(
    "history" to SubjectMeta(
        emoji = "🏛", name = "History & Culture",
        subtitle = "5 sub-topics · 39 topics",
        progressPercent = 21, total = 39, done = 8, active = 2, left = 31,
        subTopics = listOf(
            SubTopicItem("ancient",    "🏺", "Ancient India",           8, 1, 13, CheckState.PARTIAL),
            SubTopicItem("medieval",   "🏰", "Medieval India",          8, 0,  0, CheckState.NONE),
            SubTopicItem("modern",     "🇮🇳","Modern India",            9, 4, 44, CheckState.FULL),
            SubTopicItem("art",        "🎨", "Art & Architecture",      6, 2, 33, CheckState.PARTIAL),
            SubTopicItem("performing", "🎭", "Performing Arts & Crafts",8, 1, 13, CheckState.NONE),
        )
    ),
    "polity" to SubjectMeta(
        emoji = "⚖️", name = "Indian Polity",
        subtitle = "8 sub-topics · 42 topics",
        progressPercent = 38, total = 42, done = 16, active = 3, left = 23,
        subTopics = listOf(
            SubTopicItem("constitution", "📜", "Constitution Basics",     6, 3, 50, CheckState.PARTIAL),
            SubTopicItem("parliament",   "🏛", "Parliament & Legislature",5, 2, 40, CheckState.PARTIAL),
            SubTopicItem("executive",    "👔", "Executive",               4, 0,  0, CheckState.NONE),
            SubTopicItem("judiciary",    "⚖️","Judiciary",               5, 4, 80, CheckState.FULL),
            SubTopicItem("federalism",   "🌐", "Federalism",              4, 1, 25, CheckState.PARTIAL),
        )
    ),
    "gs1" to SubjectMeta(
        emoji = "📚", name = "GS Paper I",
        subtitle = "6 subjects · 50 sub-topics",
        progressPercent = 21, total = 39, done = 8, active = 2, left = 31,
        subTopics = listOf(
            SubTopicItem("indian_culture",  "🏺", "Indian Culture & Heritage",8, 1, 13, CheckState.PARTIAL),
            SubTopicItem("world_history",   "🏰", "World History",            8, 0,  0, CheckState.NONE),
            SubTopicItem("modern_history",  "🇮🇳","Modern History",           9, 4, 44, CheckState.FULL),
            SubTopicItem("geography",       "⛰", "Geography",               6, 2, 33, CheckState.PARTIAL),
            SubTopicItem("indian_society",  "👫", "Indian Society",          8, 1, 13, CheckState.PARTIAL),
        )
    ),
    // Default fallback
)

private val defaultMeta = SubjectMeta(
    emoji = "📚", name = "Subject",
    subtitle = "Topics",
    progressPercent = 0, total = 0, done = 0, active = 0, left = 0,
    subTopics = emptyList()
)

@Composable
fun SyllabusSubTopicsScreen(
    subjectId: String,
    onBack: () -> Unit,
    onSubTopicSelected: (String) -> Unit
) {
    val meta = subjectData[subjectId] ?: defaultMeta

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF081328))) {
        // ── Dark Header ──────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF081328))
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
                        append("Step ")
                        withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("2") }
                        append(" of 3")
                    },
                    color = Color.White.copy(alpha = 0.35f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(12.dp))

            Text(meta.emoji, fontSize = 30.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text(meta.name, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(meta.subtitle + " · 0%", color = Color.White.copy(alpha = 0.5f), fontSize = 12.sp)
            Spacer(Modifier.height(14.dp))

            // Progress bar container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White.copy(alpha = 0.05f))
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Subject Progress",
                            color = Color.White.copy(alpha = 0.45f),
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            "${meta.progressPercent}%",
                            color = GoldAccent,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(5.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(Color.White.copy(alpha = 0.1f))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(meta.progressPercent / 100f)
                                .fillMaxHeight()
                                .background(
                                    Brush.linearGradient(listOf(GoldAccent, Color(0xFFE8950F)))
                                )
                        )
                    }
                    Spacer(Modifier.height(10.dp))

                    // Stats
                    Row(modifier = Modifier.fillMaxWidth()) {
                        StatBlock(meta.total.toString(), "TOTAL",  Color.White, hasBorder = true,  modifier = Modifier.weight(1f))
                        StatBlock(meta.done.toString(),  "DONE",   Color(0xFF22C55E), hasBorder = true,  modifier = Modifier.weight(1f))
                        StatBlock(meta.active.toString(),"ACTIVE", GoldAccent,  hasBorder = true,  modifier = Modifier.weight(1f))
                        StatBlock(meta.left.toString(),  "LEFT",   Color(0xFFEF4444), hasBorder = false, modifier = Modifier.weight(1f))
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }

        // ── Sub-topics card ──────────────────────────────────
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(STPSurface),
            contentPadding = PaddingValues(top = 8.dp, bottom = 32.dp)
        ) {
            item { Spacer(Modifier.height(6.dp)) }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(STPCard)
                        .border(1.dp, STPBorder, RoundedCornerShape(16.dp))
                ) {
                    meta.subTopics.forEachIndexed { idx, subTopic ->
                        SubTopicRow(subTopic, onSubTopicSelected)
                        if (idx < meta.subTopics.lastIndex) {
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(STPBorder))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatBlock(value: String, label: String, valueColor: Color, hasBorder: Boolean, modifier: Modifier) {
    Box(
        modifier = modifier.padding(vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = valueColor, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(2.dp))
            Text(label, color = Color.White.copy(alpha = 0.28f), fontSize = 7.5.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
        }
    }
}

@Composable
private fun SubTopicRow(subTopic: SubTopicItem, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(subTopic.id) }
            .padding(horizontal = 16.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Checkbox indicator
        Box(
            modifier = Modifier
                .size(22.dp)
                .clip(RoundedCornerShape(6.dp))
                .then(
                    when (subTopic.checkState) {
                        CheckState.FULL    -> Modifier.background(Color(0xFF0E8A56)).border(1.dp, Color(0xFF0E8A56), RoundedCornerShape(6.dp))
                        CheckState.PARTIAL -> Modifier.background(Color(0xFFFFF8ED)).border(1.dp, GoldAccent.copy(alpha = 0.28f), RoundedCornerShape(6.dp))
                        CheckState.NONE    -> Modifier.background(Color.Transparent).border(1.dp, STPBorder, RoundedCornerShape(6.dp))
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            when (subTopic.checkState) {
                CheckState.FULL    -> Text("✓", color = Color.White, fontSize = 11.sp)
                CheckState.PARTIAL -> Text("◐", color = Color(0xFFE8950F), fontSize = 11.sp)
                CheckState.NONE    -> {}
            }
        }
        Spacer(Modifier.width(11.dp))

        // Emoji icon
        Text(subTopic.emoji, fontSize = 17.sp)
        Spacer(Modifier.width(11.dp))

        // Name + subtitle
        Column(modifier = Modifier.weight(1f)) {
            Text(subTopic.name, color = STPText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text(
                buildString {
                    append("${subTopic.totalTopics} topics · ${subTopic.doneTopics} done")
                    if (subTopic.donePercent > 0) append(" · ${subTopic.donePercent}%")
                },
                color = STPGray, fontSize = 10.sp
            )
        }

        // Fraction
        Column(horizontalAlignment = Alignment.End) {
            Text(
                "${subTopic.doneTopics}/${subTopic.totalTopics}",
                color = when {
                    subTopic.doneTopics == subTopic.totalTopics -> Color(0xFF22C55E)
                    subTopic.doneTopics > 0                     -> Color(0xFFE8950F)
                    else                                         -> STPGray
                },
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Text("topics", color = STPGray, fontSize = 9.sp)
        }
        Spacer(Modifier.width(6.dp))
        Text("›", color = STPGray, fontSize = 14.sp)
    }
}
