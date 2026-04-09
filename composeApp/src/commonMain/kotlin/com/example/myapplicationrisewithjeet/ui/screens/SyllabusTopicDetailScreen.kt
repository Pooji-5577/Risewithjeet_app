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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent

// ── Palette ──────────────────────────────────────────────────
private val TDBg     = Color(0xFF081328)
private val TDSurface= Color(0xFFEEF2F8)
private val TDCard   = Color.White
private val TDText   = Color(0xFF1A2744)
private val TDGray   = Color(0xFF8FA3C0)
private val TDBorder = Color(0xFFDDE5F0)

// ── Topic status ──────────────────────────────────────────────
enum class TopicStatus { DONE, ACTIVE, NOT_STARTED, REVISING }

data class TopicItem(
    val id: String,
    val name: String,
    val hasPyq: Boolean,
    val status: TopicStatus
)

data class SubTopicMeta(
    val emoji: String,
    val name: String,
    val total: Int,
    val done: Int,
    val active: Int,
    val revising: Int,
    val topics: List<TopicItem>
)

private val subTopicData: Map<String, SubTopicMeta> = mapOf(
    "ancient" to SubTopicMeta(
        emoji = "🏺", name = "Ancient India",
        total = 4, done = 2, active = 1, revising = 0,
        topics = listOf(
            TopicItem("indus",    "Indus Valley Civilization", hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("vedic",    "Vedic Period",              hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("mauryan",  "Mauryan Empire",            hasPyq = true,  status = TopicStatus.ACTIVE),
            TopicItem("gupta",    "Gupta Period",              hasPyq = true,  status = TopicStatus.NOT_STARTED),
        )
    ),
    "medieval" to SubTopicMeta(
        emoji = "🏰", name = "Medieval India",
        total = 8, done = 0, active = 0, revising = 0,
        topics = listOf(
            TopicItem("delhi",    "Delhi Sultanate",           hasPyq = true,  status = TopicStatus.NOT_STARTED),
            TopicItem("mughal",   "Mughal Empire",             hasPyq = true,  status = TopicStatus.NOT_STARTED),
            TopicItem("vijayanagar","Vijayanagara Empire",     hasPyq = false, status = TopicStatus.NOT_STARTED),
            TopicItem("bhakti",   "Bhakti & Sufi Movement",   hasPyq = true,  status = TopicStatus.NOT_STARTED),
        )
    ),
    "modern" to SubTopicMeta(
        emoji = "🇮🇳", name = "Modern History",
        total = 4, done = 2, active = 1, revising = 0,
        topics = listOf(
            TopicItem("1857",     "Revolt of 1857",            hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("congress", "Indian National Congress",  hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("gandhi",   "Gandhi Era",                hasPyq = true,  status = TopicStatus.ACTIVE),
            TopicItem("partition","Partition & Independence",  hasPyq = true,  status = TopicStatus.NOT_STARTED),
        )
    ),
    "indian_culture" to SubTopicMeta(
        emoji = "🏺", name = "Indian Culture & Heritage",
        total = 4, done = 2, active = 1, revising = 0,
        topics = listOf(
            TopicItem("indus",    "Indus Valley Civilization", hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("vedic",    "Vedic Period",              hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("mauryan",  "Mauryan Empire",            hasPyq = true,  status = TopicStatus.ACTIVE),
            TopicItem("gupta",    "Gupta Period",              hasPyq = true,  status = TopicStatus.NOT_STARTED),
        )
    ),
    "modern_history" to SubTopicMeta(
        emoji = "🇮🇳", name = "Modern History",
        total = 4, done = 2, active = 1, revising = 0,
        topics = listOf(
            TopicItem("indus",    "Indus Valley Civilization", hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("vedic",    "Vedic Period",              hasPyq = true,  status = TopicStatus.DONE),
            TopicItem("mauryan",  "Mauryan Empire",            hasPyq = true,  status = TopicStatus.ACTIVE),
            TopicItem("gupta",    "Gupta Period",              hasPyq = true,  status = TopicStatus.NOT_STARTED),
        )
    ),
)

private val defaultSubTopic = SubTopicMeta(
    emoji = "📚", name = "Topics",
    total = 0, done = 0, active = 0, revising = 0,
    topics = emptyList()
)

// Filter tabs
private val filterTabs = listOf("All", "Done", "Active", "To Do")

@Composable
fun SyllabusTopicDetailScreen(
    subTopicId: String,
    onBack: () -> Unit
) {
    val meta = subTopicData[subTopicId] ?: defaultSubTopic
    var selectedFilter by remember { mutableStateOf(0) }

    val filteredTopics = when (selectedFilter) {
        1 -> meta.topics.filter { it.status == TopicStatus.DONE }
        2 -> meta.topics.filter { it.status == TopicStatus.ACTIVE }
        3 -> meta.topics.filter { it.status == TopicStatus.NOT_STARTED }
        else -> meta.topics
    }

    Column(modifier = Modifier.fillMaxSize().background(TDBg)) {
        // ── Dark Header ──────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(TDBg)
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
                    color = Color(0xFF5A7096),
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onBack() }
                )
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(color = Color(0xFF6A7282))) { append("STEP ") }
                        withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("3") }
                        withStyle(SpanStyle(color = Color(0xFF6A7282))) { append(" OF 3") }
                    },
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
            Spacer(Modifier.height(10.dp))

            Text(meta.emoji, fontSize = 28.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text(
                meta.name,
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "${meta.total} topics  ·  ${meta.done} done",
                color = Color.White.copy(alpha = 0.45f),
                fontSize = 12.sp
            )
            Spacer(Modifier.height(12.dp))

            // Stats row
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White.copy(alpha = 0.06f))
                    .border(0.8.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(14.dp))
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    StatCell2(meta.total.toString(),    "TOTAL",    Color.White,           hasBorder = true,  modifier = Modifier.weight(1f))
                    StatCell2(meta.done.toString(),     "DONE",     Color.White,           hasBorder = true,  modifier = Modifier.weight(1f))
                    StatCell2(meta.active.toString(),   "ACTIVE",   Color.White,           hasBorder = true,  modifier = Modifier.weight(1f))
                    StatCell2(meta.revising.toString(), "REVISING", Color.White,           hasBorder = false, modifier = Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(12.dp))

            // Filter tabs
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White.copy(alpha = 0.06f))
                    .padding(2.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    filterTabs.forEachIndexed { idx, label ->
                        val isActive = idx == selectedFilter
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isActive) Color.White else Color.Transparent)
                                .clickable { selectedFilter = idx }
                                .padding(vertical = 7.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                label,
                                color = if (isActive) TDText else Color.White.copy(alpha = 0.45f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }

        // ── Topics list ──────────────────────────────────────
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(TDSurface),
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 10.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(TDCard)
                        .border(1.dp, TDBorder, RoundedCornerShape(16.dp))
                ) {
                    filteredTopics.forEachIndexed { idx, topic ->
                        TopicRow(topic)
                        if (idx < filteredTopics.lastIndex) {
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFF0F4F8)))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatCell2(value: String, label: String, valueColor: Color, hasBorder: Boolean, modifier: Modifier) {
    Box(
        modifier = modifier.padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = valueColor, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(2.dp))
            Text(label, color = Color.White.copy(alpha = 0.35f), fontSize = 9.sp, letterSpacing = 0.5.sp)
        }
    }
}

@Composable
private fun TopicRow(topic: TopicItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Checkbox
        val isDone = topic.status == TopicStatus.DONE
        Box(
            modifier = Modifier
                .size(22.dp)
                .clip(RoundedCornerShape(7.dp))
                .then(
                    when (topic.status) {
                        TopicStatus.DONE    -> Modifier.background(Color(0xFF0E8A56)).border(0.8.dp, Color(0xFF0E8A56), RoundedCornerShape(7.dp))
                        TopicStatus.ACTIVE  -> Modifier.background(Color.Transparent).border(0.8.dp, Color(0xFFD4881A), RoundedCornerShape(7.dp))
                        else                -> Modifier.background(Color.Transparent).border(0.8.dp, TDBorder, RoundedCornerShape(7.dp))
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isDone) Text("✓", color = Color.White, fontSize = 11.sp)
        }
        Spacer(Modifier.width(10.dp))

        // Name + PYQ tag
        Column(modifier = Modifier.weight(1f)) {
            Text(
                topic.name,
                color = if (isDone) Color(0xFF0E8A56) else TDText,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = if (isDone) TextDecoration.LineThrough else TextDecoration.None
            )
            if (topic.hasPyq) {
                Spacer(Modifier.height(3.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFC952120D))  // ~10% orange
                        .background(Color(0x1AC95212))
                        .border(0.8.dp, Color(0x40C95212), RoundedCornerShape(10.dp))
                        .padding(horizontal = 9.dp, vertical = 3.dp)
                ) {
                    Text("📄 PYQ", color = Color(0xFFC95212), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Status badge
        val (badgeBg, badgeBorder, badgeText) = when (topic.status) {
            TopicStatus.DONE        -> Triple(Color(0xFFEDF9F3), Color(0xFFB2EDD0), "✓ Done")
            TopicStatus.ACTIVE      -> Triple(GoldAccent.copy(alpha = 0.12f), GoldAccent.copy(alpha = 0.3f), "🔥 Active")
            TopicStatus.REVISING    -> Triple(Color(0xFFEFF6FF), Color(0xFFBFDBFE), "✎ Revising")
            TopicStatus.NOT_STARTED -> Triple(Color(0xFFEEF2F8), TDBorder, "Not Started")
        }
        val textColor = when (topic.status) {
            TopicStatus.DONE        -> Color(0xFF0E8A56)
            TopicStatus.ACTIVE      -> Color(0xFFD4881A)
            TopicStatus.REVISING    -> Color(0xFF3B82F6)
            TopicStatus.NOT_STARTED -> Color(0xFF8FA4BE)
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(badgeBg)
                .border(0.8.dp, badgeBorder, RoundedCornerShape(20.dp))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(badgeText, color = textColor, fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}
