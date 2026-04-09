package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

// ── Shared palette ────────────────────────────────────────────
private val PBg      = Color(0xFF081328)
private val PSurface = Color(0xFFF0F4F8)
private val PCard    = Color.White
private val PText    = Color(0xFF0E1A2D)
private val PGray    = Color(0xFF8FA3C0)
private val PBorder  = Color(0xFFE2E8F0)
private val PDark    = Color(0xFF162240)

// ── Shared data ───────────────────────────────────────────────
private data class PYQSubject(
    val id: String, val emoji: String, val name: String,
    val subTopics: Int, val topics: Int, val pyqs: Int
)
private data class PYQMainsPaper(
    val id: String, val emoji: String, val name: String, val subtitle: String,
    val subTopics: Int, val topics: Int, val pyqs: Int
)
private data class PYQSubTopic(
    val id: String, val emoji: String, val name: String,
    val totalTopics: Int, val doneTopics: Int, val donePercent: Int,
    val check: PYQCheck
)
enum class PYQCheck { NONE, PARTIAL, FULL }

private data class PYQTopic(
    val id: String, val name: String, val hasPyq: Boolean, val status: PYQStatus
)
enum class PYQStatus { DONE, ACTIVE, NOT_STARTED }

private val pyqPrelimsSubjects = listOf(
    PYQSubject("history",  "🏛",  "History & Culture",       5,  39, 340),
    PYQSubject("geo",      "🌍",  "Geography",               6,  38, 289),
    PYQSubject("polity",   "⚖️", "Indian Polity",           8,  42, 220),
    PYQSubject("economy",  "💰",  "Indian Economy",          7,  27, 258),
    PYQSubject("env",      "🌿",  "Environment",             5,  34, 198),
    PYQSubject("scitech",  "🔬",  "Science & Technology",    4,  26,  55),
    PYQSubject("ir",       "🌐",  "International Relations", 4,  18, 138),
    PYQSubject("csat",     "📊",  "CSAT Paper II",           4,  24, 120),
)
private val pyqMainsPapers = listOf(
    PYQMainsPaper("gs1",  "🌐",  "GS Paper I",   "Indian Heritage, History, Geography",        6, 50, 180),
    PYQMainsPaper("gs2",  "⚖️", "GS Paper II",  "Governance, Polity, Social Justice, IR",     6, 46, 150),
    PYQMainsPaper("gs3",  "📈",  "GS Paper III", "Economy, Agriculture, Environment, Security",6, 48, 160),
    PYQMainsPaper("gs4",  "🤝",  "GS Paper IV",  "Ethics, Integrity, Aptitude",               4, 30, 120),
    PYQMainsPaper("essay","✍️", "Essay Paper",  "Essay writing frameworks & practice",         2, 20,  80),
)
private val pyqOptionalSubjects = listOf(
    PYQSubject("hist_opt",  "🏛",  "History & Culture", 5, 39, 340),
    PYQSubject("geo_opt",   "🌍",  "Geography",          6, 38, 289),
    PYQSubject("socio",     "👥",  "Sociology",          8, 42, 220),
    PYQSubject("econ_opt",  "💰",  "Economics",          7, 27, 258),
    PYQSubject("phil",      "🧘",  "Philosophy",         4, 26,  55),
)

private val pyqSubjectMeta: Map<String, Triple<String, String, List<PYQSubTopic>>> = mapOf(
    "history" to Triple("🏛", "History & Culture", listOf(
        PYQSubTopic("ancient",    "🏺", "Ancient India",            8, 1, 13, PYQCheck.PARTIAL),
        PYQSubTopic("medieval",   "🏰", "Medieval India",           8, 0,  0, PYQCheck.NONE),
        PYQSubTopic("modern",     "🇮🇳","Modern India",             9, 4, 44, PYQCheck.FULL),
        PYQSubTopic("art",        "🎨", "Art & Architecture",       6, 2, 33, PYQCheck.PARTIAL),
        PYQSubTopic("performing", "🎭", "Performing Arts & Crafts", 8, 1, 13, PYQCheck.NONE),
    )),
    "polity" to Triple("⚖️", "Indian Polity", listOf(
        PYQSubTopic("const",     "📜", "Constitution Basics",      6, 3, 50, PYQCheck.PARTIAL),
        PYQSubTopic("parliament","🏛", "Parliament & Legislature",  5, 2, 40, PYQCheck.PARTIAL),
        PYQSubTopic("executive", "👔", "Executive",                 4, 0,  0, PYQCheck.NONE),
        PYQSubTopic("judiciary", "⚖️","Judiciary",                 5, 4, 80, PYQCheck.FULL),
        PYQSubTopic("federalism","🌐", "Federalism",                4, 1, 25, PYQCheck.PARTIAL),
    )),
    "gs1" to Triple("📚", "GS Paper I", listOf(
        PYQSubTopic("indian_culture",  "🏺","Indian Culture & Heritage",8, 1, 13, PYQCheck.PARTIAL),
        PYQSubTopic("world_history",   "🏰","World History",            8, 0,  0, PYQCheck.NONE),
        PYQSubTopic("modern_pyq",      "🇮🇳","Modern History",          9, 4, 44, PYQCheck.FULL),
        PYQSubTopic("geography_mains", "⛰", "Geography",               6, 2, 33, PYQCheck.PARTIAL),
        PYQSubTopic("indian_society",  "👫","Indian Society",           8, 1, 13, PYQCheck.PARTIAL),
    )),
)
private val defaultSubTopics: Triple<String, String, List<PYQSubTopic>> =
    Triple("📚", "Subject", emptyList())

private val pyqTopics: Map<String, Pair<String, List<PYQTopic>>> = mapOf(
    "ancient" to Pair("🏺", listOf(
        PYQTopic("indus",   "Indus Valley Civilization", true, PYQStatus.DONE),
        PYQTopic("vedic",   "Vedic Period",              true, PYQStatus.DONE),
        PYQTopic("mauryan", "Mauryan Empire",            true, PYQStatus.ACTIVE),
        PYQTopic("gupta",   "Gupta Period",              true, PYQStatus.NOT_STARTED),
    )),
    "modern" to Pair("🇮🇳", listOf(
        PYQTopic("revolt",    "Revolt of 1857",          true, PYQStatus.DONE),
        PYQTopic("congress",  "Indian National Congress",true, PYQStatus.DONE),
        PYQTopic("gandhi",    "Gandhi Era",              true, PYQStatus.ACTIVE),
        PYQTopic("partition", "Partition & Independence",true, PYQStatus.NOT_STARTED),
    )),
    "modern_pyq" to Pair("🇮🇳", listOf(
        PYQTopic("revolt",    "Revolt of 1857",          true, PYQStatus.DONE),
        PYQTopic("congress",  "Indian National Congress",true, PYQStatus.DONE),
        PYQTopic("gandhi",    "Gandhi Era",              true, PYQStatus.ACTIVE),
        PYQTopic("partition", "Partition & Independence",true, PYQStatus.NOT_STARTED),
    )),
    "medieval" to Pair("🏰", listOf(
        PYQTopic("delhi",    "Delhi Sultanate",          true, PYQStatus.NOT_STARTED),
        PYQTopic("mughal",   "Mughal Empire",            true, PYQStatus.NOT_STARTED),
        PYQTopic("bhakti",   "Bhakti Movement",          true, PYQStatus.NOT_STARTED),
    )),
)
private val defaultTopics = Pair("📚", emptyList<PYQTopic>())

// ─────────────────────────────────────────────────────────────
// 1. PYQ Home Screen
// ─────────────────────────────────────────────────────────────
@Composable
fun PYQNewHomeScreen(onBack: () -> Unit, onSubjectSelected: (String) -> Unit) {
    var selectedTab by remember { mutableStateOf(0) } // 0=Prelims, 1=Mains, 2=Optional

    Column(modifier = Modifier.fillMaxSize().background(PBg)) {
        // ── Dark header ──────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(PBg)
                .statusBarsPadding()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(14.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("←", color = Color.White.copy(alpha = 0.7f), fontSize = 22.sp,
                    modifier = Modifier.clickable { onBack() })
            }
            Spacer(Modifier.height(12.dp))
            Text("🎯", fontSize = 32.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(10.dp))
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)) {
                        append("Previous Year\n")
                    }
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)) {
                        append("Questions")
                    }
                },
                textAlign = TextAlign.Center,
                lineHeight = 28.sp
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Every UPSC question ever asked Prelims & Mains with detailed\nexplanations and model answers.",
                color = Color.White.copy(alpha = 0.42f),
                fontSize = 11.5.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
            Spacer(Modifier.height(14.dp))

            // Stats row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                listOf(
                    Triple("12,400", "QUESTIONS", GoldAccent),
                    Triple("30 yrs", "COVERAGE",  Color.White),
                    Triple("100%",   "MAPPED",     Color(0xFF22C55E)),
                    Triple("130",    "SUB-TOPICS", Color(0xFF60A5FA)),
                ).forEach { (value, label, color) ->
                    PYQStatBox(value, label, color, modifier = Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(18.dp))
        }

        // ── Tab pill bar ─────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(PCard)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 11.dp, vertical = 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFF1F4FA))
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PYQTabItem("🎯 Prelims",  selectedTab == 0, Modifier.weight(1f)) { selectedTab = 0 }
                    PYQTabItem("✍️ Mains",   selectedTab == 1, Modifier.weight(1f)) { selectedTab = 1 }
                    PYQTabItem("📖 Optional", selectedTab == 2, Modifier.weight(1f)) { selectedTab = 2 }
                }
            }
        }

        // ── Subject list card ────────────────────────────────
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(PCard)
                .border(1.dp, PBorder, RoundedCornerShape(0.dp)),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            val subjects: List<Any> = when (selectedTab) {
                1    -> pyqMainsPapers
                2    -> pyqOptionalSubjects
                else -> pyqPrelimsSubjects
            }
            items(subjects) { item ->
                when (item) {
                    is PYQSubject    -> PYQSubjectRow(item) { onSubjectSelected(item.id) }
                    is PYQMainsPaper -> PYQPaperRow(item)  { onSubjectSelected(item.id) }
                }
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFF0F4F8)))
            }
        }
    }
}

@Composable
private fun PYQStatBox(value: String, label: String, color: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White.copy(alpha = 0.07f))
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(value, color = color, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(label, color = Color.White.copy(alpha = 0.28f), fontSize = 7.5.sp,
                fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
        }
    }
}

@Composable
private fun PYQTabItem(label: String, active: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(28.dp))
            .background(if (active) PDark else Color.Transparent)
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = if (active) Color.White else Color(0xFF666666),
            fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
private fun PYQSubjectRow(subject: PYQSubject, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(42.dp).clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF0F4F8)).border(1.dp, PBorder, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) { Text(subject.emoji, fontSize = 21.sp) }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(subject.name, color = PText, fontSize = 13.5.sp, fontWeight = FontWeight.Bold)
            Text("${subject.subTopics} sub-topics · ${subject.topics} topics · ${subject.pyqs} PYQs",
                color = PGray, fontSize = 10.sp)
        }
        Spacer(Modifier.width(8.dp))
        Text("›", color = PGray, fontSize = 14.sp)
    }
}

@Composable
private fun PYQPaperRow(paper: PYQMainsPaper, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(42.dp).clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF0F4F8)).border(1.dp, PBorder, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) { Text(paper.emoji, fontSize = 21.sp) }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(paper.name, color = PText, fontSize = 13.5.sp, fontWeight = FontWeight.Bold)
            Text(paper.subtitle, color = PGray, fontSize = 10.sp)
        }
        Spacer(Modifier.width(8.dp))
        Text("›", color = PGray, fontSize = 14.sp)
    }
}

// ─────────────────────────────────────────────────────────────
// 2. PYQ Sub-Topics Screen  (Step 1 of 3)
// ─────────────────────────────────────────────────────────────
@Composable
fun PYQNewSubTopicsScreen(
    subjectId: String,
    onBack: () -> Unit,
    onSubTopicSelected: (String) -> Unit
) {
    val (emoji, name, subTopics) = pyqSubjectMeta[subjectId] ?: defaultSubTopics
    val total  = subTopics.sumOf { it.totalTopics }
    val done   = subTopics.sumOf { it.doneTopics }
    val active = subTopics.count { it.check == PYQCheck.PARTIAL }
    val left   = total - done
    val pct    = if (total > 0) (done * 100 / total) else 0

    Column(modifier = Modifier.fillMaxSize().background(PBg)) {
        Column(
            modifier = Modifier.fillMaxWidth().background(PBg)
                .statusBarsPadding().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color.White.copy(alpha = 0.7f), fontSize = 22.sp,
                    modifier = Modifier.clickable { onBack() })
                Text(buildAnnotatedString {
                    append("Step ")
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("1") }
                    append(" of 3")
                }, color = Color.White.copy(alpha = 0.35f), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.height(12.dp))
            Text(emoji, fontSize = 30.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text(name, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(14.dp))

            // Progress card
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp))
                .background(Color.White.copy(alpha = 0.05f)).padding(14.dp)) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Subject Progress", color = Color.White.copy(alpha = 0.45f),
                            fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold)
                        Text("$pct%", color = GoldAccent, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(6.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp))
                        .background(Color.White.copy(alpha = 0.1f))) {
                        Box(modifier = Modifier.fillMaxWidth(pct / 100f).fillMaxHeight()
                            .background(Brush.linearGradient(listOf(GoldAccent, Color(0xFFE8950F)))))
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        PYQStatBlock(total.toString(),  "TOTAL",  Color.White,        Modifier.weight(1f))
                        PYQStatBlock(done.toString(),   "DONE",   Color(0xFF22C55E),  Modifier.weight(1f))
                        PYQStatBlock(active.toString(), "ACTIVE", GoldAccent,         Modifier.weight(1f))
                        PYQStatBlock(left.toString(),   "LEFT",   Color(0xFFEF4444),  Modifier.weight(1f))
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(PSurface),
            contentPadding = PaddingValues(top = 8.dp, bottom = 32.dp)
        ) {
            item { Spacer(Modifier.height(6.dp)) }
            item {
                Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp)
                    .clip(RoundedCornerShape(16.dp)).background(PCard)
                    .border(1.dp, PBorder, RoundedCornerShape(16.dp))) {
                    subTopics.forEachIndexed { idx, st ->
                        PYQSubTopicRow(st) { onSubTopicSelected(st.id) }
                        if (idx < subTopics.lastIndex)
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(PBorder))
                    }
                }
            }
        }
    }
}

@Composable
private fun PYQStatBlock(value: String, label: String, color: Color, modifier: Modifier) {
    Box(modifier = modifier.padding(vertical = 6.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = color, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(2.dp))
            Text(label, color = Color.White.copy(alpha = 0.28f), fontSize = 7.5.sp,
                fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
        }
    }
}

@Composable
private fun PYQSubTopicRow(st: PYQSubTopic, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().clickable { onClick() }
        .padding(horizontal = 16.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(22.dp).clip(RoundedCornerShape(6.dp)).then(
            when (st.check) {
                PYQCheck.FULL    -> Modifier.background(Color(0xFF0E8A56)).border(1.dp, Color(0xFF0E8A56), RoundedCornerShape(6.dp))
                PYQCheck.PARTIAL -> Modifier.background(Color(0xFFFFF8ED)).border(1.dp, GoldAccent.copy(alpha = 0.28f), RoundedCornerShape(6.dp))
                PYQCheck.NONE    -> Modifier.background(Color.Transparent).border(1.dp, PBorder, RoundedCornerShape(6.dp))
            }
        ), contentAlignment = Alignment.Center) {
            when (st.check) {
                PYQCheck.FULL    -> Text("✓", color = Color.White, fontSize = 11.sp)
                PYQCheck.PARTIAL -> Text("◐", color = Color(0xFFE8950F), fontSize = 11.sp)
                PYQCheck.NONE    -> {}
            }
        }
        Spacer(Modifier.width(11.dp))
        Text(st.emoji, fontSize = 17.sp)
        Spacer(Modifier.width(11.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(st.name, color = PText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text(buildString {
                append("${st.totalTopics} topics · ${st.doneTopics} done")
                if (st.donePercent > 0) append(" · ${st.donePercent}%")
            }, color = PGray, fontSize = 10.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text("${st.doneTopics}/${st.totalTopics}",
                color = when {
                    st.doneTopics == st.totalTopics -> Color(0xFF22C55E)
                    st.doneTopics > 0               -> Color(0xFFE8950F)
                    else                             -> PGray
                }, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text("topics", color = PGray, fontSize = 9.sp)
        }
        Spacer(Modifier.width(6.dp))
        Text("›", color = PGray, fontSize = 14.sp)
    }
}

// ─────────────────────────────────────────────────────────────
// 3. PYQ Topic Detail Screen  (Step 2 of 3)
// ─────────────────────────────────────────────────────────────
@Composable
fun PYQNewTopicDetailScreen(
    subTopicId: String,
    onBack: () -> Unit,
    onTopicSelected: (String) -> Unit
) {
    val (emoji, topics) = pyqTopics[subTopicId] ?: defaultTopics
    val name    = pyqTopicName(subTopicId)
    val done    = topics.count { it.status == PYQStatus.DONE }
    val active  = topics.count { it.status == PYQStatus.ACTIVE }
    var filter  by remember { mutableStateOf(0) }

    val shown = when (filter) {
        1 -> topics.filter { it.status == PYQStatus.DONE }
        2 -> topics.filter { it.status == PYQStatus.ACTIVE }
        3 -> topics.filter { it.status == PYQStatus.NOT_STARTED }
        else -> topics
    }

    Column(modifier = Modifier.fillMaxSize().background(PBg)) {
        Column(modifier = Modifier.fillMaxWidth().background(PBg)
            .statusBarsPadding().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFF5A7096), fontSize = 16.sp,
                    modifier = Modifier.clickable { onBack() })
                Text(buildAnnotatedString {
                    withStyle(SpanStyle(color = Color(0xFF6A7282))) { append("STEP ") }
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("2") }
                    withStyle(SpanStyle(color = Color(0xFF6A7282))) { append(" OF 3") }
                }, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
            }
            Spacer(Modifier.height(10.dp))
            Text(emoji, fontSize = 28.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text(name, color = Color.White, fontSize = 19.sp,
                fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Spacer(Modifier.height(4.dp))
            Text("${topics.size} topics  ·  $done done",
                color = Color.White.copy(alpha = 0.45f), fontSize = 12.sp)
            Spacer(Modifier.height(12.dp))

            // Stats
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp))
                .background(Color.White.copy(alpha = 0.06f))
                .border(0.8.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(14.dp))) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    PYQStatCell(topics.size.toString(), "TOTAL",    Color.White, Modifier.weight(1f))
                    PYQStatCell(done.toString(),         "DONE",     Color.White, Modifier.weight(1f))
                    PYQStatCell(active.toString(),       "ACTIVE",   Color.White, Modifier.weight(1f))
                    PYQStatCell("0",                     "REVISING", Color.White, Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(12.dp))

            // Filter tabs
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
                .background(Color.White.copy(alpha = 0.06f)).padding(2.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    listOf("All", "Done", "Active", "To Do").forEachIndexed { idx, lbl ->
                        Box(modifier = Modifier.weight(1f).clip(RoundedCornerShape(10.dp))
                            .background(if (idx == filter) Color.White else Color.Transparent)
                            .clickable { filter = idx }.padding(vertical = 7.dp),
                            contentAlignment = Alignment.Center) {
                            Text(lbl, color = if (idx == filter) PText else Color.White.copy(alpha = 0.45f),
                                fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
        }

        LazyColumn(modifier = Modifier.fillMaxSize()
            .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .background(PSurface),
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 10.dp)) {
            item {
                Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))
                    .background(PCard).border(1.dp, PBorder, RoundedCornerShape(16.dp))) {
                    shown.forEachIndexed { idx, topic ->
                        PYQTopicRow(topic) { onTopicSelected(topic.id) }
                        if (idx < shown.lastIndex)
                            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFF0F4F8)))
                    }
                }
            }
        }
    }
}

@Composable
private fun PYQStatCell(value: String, label: String, color: Color, modifier: Modifier) {
    Box(modifier = modifier.padding(vertical = 10.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = color, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(2.dp))
            Text(label, color = Color.White.copy(alpha = 0.35f), fontSize = 9.sp, letterSpacing = 0.5.sp)
        }
    }
}

@Composable
private fun PYQTopicRow(topic: PYQTopic, onClick: () -> Unit) {
    val isDone = topic.status == PYQStatus.DONE
    Row(modifier = Modifier.fillMaxWidth().clickable { onClick() }
        .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(22.dp).clip(RoundedCornerShape(7.dp)).then(
            when (topic.status) {
                PYQStatus.DONE   -> Modifier.background(Color(0xFF0E8A56)).border(0.8.dp, Color(0xFF0E8A56), RoundedCornerShape(7.dp))
                PYQStatus.ACTIVE -> Modifier.background(Color.Transparent).border(0.8.dp, Color(0xFFD4881A), RoundedCornerShape(7.dp))
                else             -> Modifier.background(Color.Transparent).border(0.8.dp, PBorder, RoundedCornerShape(7.dp))
            }
        ), contentAlignment = Alignment.Center) {
            if (isDone) Text("✓", color = Color.White, fontSize = 11.sp)
        }
        Spacer(Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(topic.name,
                color = if (isDone) Color(0xFF0E8A56) else PText,
                fontSize = 13.sp, fontWeight = FontWeight.SemiBold,
                textDecoration = if (isDone) TextDecoration.LineThrough else TextDecoration.None)
            if (topic.hasPyq) {
                Spacer(Modifier.height(3.dp))
                Box(modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    .background(Color(0x1AC95212))
                    .border(0.8.dp, Color(0x40C95212), RoundedCornerShape(10.dp))
                    .padding(horizontal = 9.dp, vertical = 3.dp)) {
                    Text("📄 PYQ", color = Color(0xFFC95212), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        val (bg, border, txt, textColor) = when (topic.status) {
            PYQStatus.DONE        -> listOf(Color(0xFFEDF9F3), Color(0xFFB2EDD0), "✓ Done",      Color(0xFF0E8A56))
            PYQStatus.ACTIVE      -> listOf(GoldAccent.copy(0.12f), GoldAccent.copy(0.3f), "🔥 Active", Color(0xFFD4881A))
            PYQStatus.NOT_STARTED -> listOf(Color(0xFFEEF2F8), PBorder, "Not Started", Color(0xFF8FA4BE))
        }
        Box(modifier = Modifier.clip(RoundedCornerShape(20.dp))
            .background(bg as Color).border(0.8.dp, border as Color, RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)) {
            Text(txt as String, color = textColor as Color,
                fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold)
        }
        Spacer(Modifier.width(4.dp))
        Text("›", color = PGray, fontSize = 13.sp)
    }
}

private fun pyqTopicName(id: String) = when (id) {
    "ancient"       -> "Ancient India"
    "medieval"      -> "Medieval India"
    "modern", "modern_pyq" -> "Modern History"
    "art"           -> "Art & Architecture"
    "performing"    -> "Performing Arts & Crafts"
    "indian_culture"-> "Indian Culture & Heritage"
    "world_history" -> "World History"
    "geography_mains" -> "Geography"
    "indian_society"-> "Indian Society"
    "const"         -> "Constitution Basics"
    "parliament"    -> "Parliament & Legislature"
    "judiciary"     -> "Judiciary"
    else            -> "Topics"
}

// ─────────────────────────────────────────────────────────────
// 4. PYQ Setup Screen  (Step 3 of 3)
// ─────────────────────────────────────────────────────────────
private val yearOptions = listOf("All Years", "Last 5 yrs",
    "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016")
private val questionCounts = listOf("10", "20", "30", "50", "All (84)")

@Composable
fun PYQNewSetupScreen(
    topicId: String,
    onBack: () -> Unit,
    onContinue: () -> Unit
) {
    val topicName = pyqTopicForSetup(topicId)
    val topicEmoji = pyqEmojiForTopic(topicId)
    var selectedYear   by remember { mutableStateOf(0) }  // index in yearOptions
    var selectedMode   by remember { mutableStateOf(0) }  // 0=Exam, 1=Revision
    var selectedCount  by remember { mutableStateOf(0) }  // index in questionCounts

    Column(modifier = Modifier.fillMaxSize().background(PBg)) {
        // Header
        Column(modifier = Modifier.fillMaxWidth().background(PBg)
            .statusBarsPadding().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFF5A7096), fontSize = 16.sp,
                    modifier = Modifier.clickable { onBack() })
                Text(buildAnnotatedString {
                    withStyle(SpanStyle(color = Color(0xFF6A7282))) { append("STEP ") }
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("3") }
                    withStyle(SpanStyle(color = Color(0xFF6A7282))) { append(" OF 3") }
                }, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
            }
            Spacer(Modifier.height(10.dp))
            Text(topicEmoji, fontSize = 28.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(8.dp))
            Text(topicName, color = Color.White, fontSize = 19.sp,
                fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Spacer(Modifier.height(16.dp))
        }

        // Light surface with scrollable content
        Column(modifier = Modifier.fillMaxSize()
            .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .background(PSurface)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 13.dp),
            verticalArrangement = Arrangement.spacedBy(9.dp)) {

            // Year range
            Text("📅 Select Year Range", color = PText, fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            // 4-column grid
            for (row in 0..2) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    for (col in 0..3) {
                        val idx = row * 4 + col
                        if (idx < yearOptions.size) {
                            YearChip(yearOptions[idx], idx == selectedYear, Modifier.weight(1f)) {
                                selectedYear = idx
                            }
                        }
                    }
                }
            }

            // Count info
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFEEF2F8)).padding(horizontal = 12.dp, vertical = 9.dp)) {
                Text(buildAnnotatedString {
                    append("📊 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = PText)) {
                        append(yearOptions[selectedYear])
                    }
                    append(" → ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = PDark)) { append("84 questions") }
                    append(" for $topicName")
                }, color = Color(0xFF4A5568), fontSize = 11.5.sp)
            }

            // Practice mode
            Text("⚙️ Choose Practice Mode", color = PText, fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                ModeCard("⏱️", "Exam Mode",     "Timed. No hints. Real UPSC conditions.", "Recommended",
                    selected = selectedMode == 0, dark = true, modifier = Modifier.weight(1f)) { selectedMode = 0 }
                ModeCard("📖", "Revision Mode", "See explanation after each question.",   "Learn Mode",
                    selected = selectedMode == 1, dark = false, modifier = Modifier.weight(1f)) { selectedMode = 1 }
            }

            // Question count
            Text("🔢 Number of Questions", color = PText, fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                questionCounts.forEachIndexed { idx, lbl ->
                    val isLast = idx == questionCounts.lastIndex
                    val isSelected = idx == selectedCount
                    Box(modifier = Modifier
                        .then(if (!isLast) Modifier.width(44.dp) else Modifier.wrapContentWidth())
                        .clip(RoundedCornerShape(10.dp))
                        .background(when {
                            isSelected && isLast  -> Color(0xFFFFF8ED)
                            isSelected            -> PDark
                            else                  -> PCard
                        })
                        .border(1.dp, when {
                            isSelected && isLast  -> GoldAccent.copy(alpha = 0.28f)
                            isSelected            -> PDark
                            else                  -> PBorder
                        }, RoundedCornerShape(10.dp))
                        .clickable { selectedCount = idx }
                        .padding(horizontal = if (isLast) 10.dp else 0.dp, vertical = 11.dp),
                        contentAlignment = Alignment.Center) {
                        Text(lbl, color = when {
                            isSelected && isLast  -> Color(0xFFE8950F)
                            isSelected            -> Color.White
                            else                  -> Color(0xFF4A5568)
                        }, fontSize = 11.5.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                            modifier = if (!isLast) Modifier.fillMaxWidth() else Modifier)
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // CTA button
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(13.dp))
                .background(GoldGradient).clickable { onContinue() }
                .padding(vertical = 13.dp),
                contentAlignment = Alignment.Center) {
                Text("Continue → Are You Ready?", color = Color.White,
                    fontSize = 13.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun YearChip(label: String, selected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Box(modifier = modifier.clip(RoundedCornerShape(10.dp))
        .background(when {
            selected && label == "All Years"  -> PDark
            selected && label == "Last 5 yrs" -> Color(0xFFFFF8ED)
            selected                           -> PDark
            else                               -> PCard
        })
        .border(1.dp, when {
            selected && label == "Last 5 yrs" -> GoldAccent.copy(alpha = 0.28f)
            selected                           -> PDark
            else                               -> PBorder
        }, RoundedCornerShape(10.dp))
        .clickable { onClick() }
        .padding(vertical = 11.dp),
        contentAlignment = Alignment.Center) {
        Text(label, color = when {
            selected && label == "Last 5 yrs" -> Color(0xFFE8950F)
            selected                           -> Color.White
            else                               -> Color(0xFF4A5568)
        }, fontSize = 11.5.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
private fun ModeCard(
    emoji: String, title: String, subtitle: String, badgeLabel: String,
    selected: Boolean, dark: Boolean, modifier: Modifier, onClick: () -> Unit
) {
    Box(modifier = modifier.height(150.dp).clip(RoundedCornerShape(15.dp))
        .background(if (dark) PDark else PCard)
        .border(2.dp, if (dark) PDark else PBorder, RoundedCornerShape(15.dp))
        .clickable { onClick() }) {
        Column(modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(2.dp))
            Text(emoji, fontSize = 26.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(6.dp))
            Text(title, color = if (dark) Color.White else PText,
                fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(Modifier.height(4.dp))
            Text(subtitle, color = if (dark) Color.White.copy(0.45f) else PGray,
                fontSize = 10.sp, textAlign = TextAlign.Center, lineHeight = 15.sp)
            Spacer(Modifier.weight(1f))
            Box(modifier = Modifier.clip(RoundedCornerShape(20.dp))
                .background(if (dark) GoldAccent else Color(0xFFFFF8ED))
                .border(1.dp, if (dark) GoldAccent else GoldAccent.copy(0.28f), RoundedCornerShape(20.dp))
                .padding(horizontal = 10.dp, vertical = 4.dp)) {
                Text(badgeLabel, color = if (dark) Color.White else Color(0xFFE8950F),
                    fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

private fun pyqTopicForSetup(id: String) = when (id) {
    "indus"  -> "Indus Valley Civilization"
    "vedic"  -> "Vedic Period"
    "mauryan"-> "Mauryan Empire"
    "gupta"  -> "Gupta Period"
    "revolt" -> "Revolt of 1857"
    "gandhi" -> "Gandhi Era"
    else     -> "Topic"
}

private fun pyqEmojiForTopic(id: String) = when (id) {
    "indus", "vedic", "mauryan", "gupta" -> "🏺"
    "revolt", "gandhi", "congress", "partition" -> "🇮🇳"
    else -> "📚"
}

// ─────────────────────────────────────────────────────────────
// 5. PYQ Ready Screen  ("Are You Ready?")
// ─────────────────────────────────────────────────────────────
@Composable
fun PYQNewReadyScreen(onBack: () -> Unit, onStartChallenge: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(PBg)) {
        Column(modifier = Modifier.fillMaxWidth().background(PBg)
            .statusBarsPadding().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(14.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("←", color = Color.White.copy(alpha = 0.7f), fontSize = 22.sp,
                    modifier = Modifier.clickable { onBack() })
            }
            Spacer(Modifier.height(12.dp))
            Text("🎯", fontSize = 36.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(10.dp))
            Text("Previous Year Questions", color = Color.White,
                fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Spacer(Modifier.height(20.dp))
        }

        Box(modifier = Modifier.fillMaxSize()
            .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .background(PSurface)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                // Challenge card
                Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp))
                    .background(PCard).border(1.dp, PBorder, RoundedCornerShape(20.dp))
                    .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    // Live badge
                    Box(modifier = Modifier.clip(RoundedCornerShape(20.dp))
                        .background(GoldAccent.copy(alpha = 0.1f))
                        .border(1.dp, GoldAccent.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 5.dp)) {
                        Text("🔥 TODAY'S CHALLENGE – LIVE", color = GoldAccent,
                            fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
                    }
                    Spacer(Modifier.height(16.dp))

                    Text("Are You Ready?", color = PText, fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.height(8.dp))
                    Text("10 questions · Indus Valley Civilization · 12 minutes",
                        color = PGray, fontSize = 12.sp, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(20.dp))

                    // Stat boxes
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        ReadyStatBox("10",  "Questions", Modifier.weight(1f))
                        ReadyStatBox("12",  "Minutes",   Modifier.weight(1f))
                        ReadyStatBox("847", "Attempted", Modifier.weight(1f))
                    }
                    Spacer(Modifier.height(20.dp))

                    // Start button
                    Box(modifier = Modifier.fillMaxWidth().height(52.dp)
                        .clip(RoundedCornerShape(14.dp)).background(GoldGradient)
                        .clickable { onStartChallenge() },
                        contentAlignment = Alignment.Center) {
                        Text("🚀  Start Challenge", color = Color.White,
                            fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
private fun ReadyStatBox(value: String, label: String, modifier: Modifier) {
    Column(modifier = modifier.clip(RoundedCornerShape(12.dp))
        .background(Color(0xFFF4F6FB)).border(1.dp, PBorder, RoundedCornerShape(12.dp))
        .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = PText, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(4.dp))
        Text(label, color = PGray, fontSize = 11.sp)
    }
}
