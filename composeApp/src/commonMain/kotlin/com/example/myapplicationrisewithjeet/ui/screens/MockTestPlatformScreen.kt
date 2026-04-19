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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private enum class TestMode { Prelims, Mains }

@Composable
fun MockTestPlatformScreen(
    onPreviewTestSummary: (isMains: Boolean) -> Unit = {}
) {
    var mode by remember { mutableStateOf(TestMode.Prelims) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4FA))
    ) {
        item { MockHero() }
        item {
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                SpacerH(8)
                PrelimsMainsToggle(
                    mode = mode,
                    onSelect = { mode = it }
                )
                SpacerH(8)
                StepExamMode(mode = mode)
                SpacerH(8)
                StepFocusTopic(mode = mode)
                SpacerH(8)
                StepQuestionSource()
                SpacerH(8)
                StepQuestionCount()
                SpacerH(8)
                StepDifficulty()
                SpacerH(12)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(47.dp)
                        .background(GoldGradient, RoundedCornerShape(11.dp))
                        .clickable { onPreviewTestSummary(mode == TestMode.Mains) },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Preview Test Summary ➜", color = Color(0xFF1A2744), fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
                }
                SpacerH(16)
            }
        }
    }
}

@Composable
private fun MockHero() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(282.dp)
            .background(Color(0xFF071326))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0x2EF5A623), RoundedCornerShape(20.dp))
                    .border(0.8.dp, Color(0x52F5A623), RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text("📝 MOCK TEST PLATFORM", color = Color(0xFFF5A623), fontSize = 9.5.sp, fontWeight = FontWeight.Bold)
            }
            SpacerH(10)
            Text(
                buildAnnotatedString {
                    append("Build Your ")
                    withStyle(SpanStyle(color = Color(0xFFF5A623), fontStyle = FontStyle.Italic)) { append("Perfect") }
                    append(" Mock Test")
                },
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold
            )
            SpacerH(4)
            Text(
                "Adaptive questions · Real exam environment ·\nDetailed analytics. Add as much as it.",
                color = Color.White.copy(alpha = 0.55f),
                fontSize = 12.sp,
                lineHeight = 20.sp
            )
            SpacerH(10)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.07f), RoundedCornerShape(14.dp))
                    .border(0.8.dp, Color.White.copy(alpha = 0.09f), RoundedCornerShape(14.dp))
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HeroStat("50K", "TEST TAKEN", Color(0xFFF5A623))
                HeroStat("15K", "COMMUNITY", Color(0xFF4ADE80))
                HeroStat("10K+", "QUESTIONS", Color.White)
                HeroStat("86%", "Success Rate", Color(0xFFF5A623))
            }
        }
    }
}

@Composable
private fun HeroStat(value: String, label: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = color, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color.White.copy(alpha = 0.38f), fontSize = 9.sp)
    }
}

@Composable
private fun PrelimsMainsToggle(
    mode: TestMode,
    onSelect: (TestMode) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TogglePill(
            text = "🎯 Prelims",
            selected = mode == TestMode.Prelims,
            modifier = Modifier.weight(1f)
        ) { onSelect(TestMode.Prelims) }
        TogglePill(
            text = "✍️ Mains",
            selected = mode == TestMode.Mains,
            modifier = Modifier.weight(1f)
        ) { onSelect(TestMode.Mains) }
    }
}

@Composable
private fun TogglePill(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(62.dp)
            .background(if (selected) Color(0xFF121B33) else Color.White, RoundedCornerShape(32.dp))
            .border(1.dp, if (selected) Color(0xFF1A2542) else Color(0xFFC9D2DE), RoundedCornerShape(32.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else Color(0xFF5D6B8C),
            fontSize = 22.sp / 2,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun StepExamMode(mode: TestMode) {
    StepCard("1", "EXAM MODE — SELECT PAPER TYPE") {
        if (mode == TestMode.Prelims) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OptionCard("📘", "GS Paper I", "General Studies –\nGeography, Society", Modifier.weight(1f), selected = true)
                OptionCard("🧮", "CSAT — Paper II", "Aptitude, Comprehension,\nLogical Reasoning", Modifier.weight(1f))
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OptionCard("📖", "GS Paper I", "History, Culture,\nGeography, Society", Modifier.weight(1f), selected = true)
                OptionCard("⚡", "GS Paper II", "Governance, Polity,\nConstitution, Social Issues", Modifier.weight(1f))
            }
            SpacerH(8)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OptionCard("📈", "GS Paper III", "Economy, Science & Tech,\nEnvironment, Internal Sec.", Modifier.weight(1f))
                OptionCard("⚖️", "GS Paper IV", "Ethics, Integrity &\nAptitude — Case Studies", Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun StepFocusTopic(mode: TestMode) {
    if (mode == TestMode.Prelims) {
        StepCard("2", "FOCUS ON A SPECIFIC TOPIC") {
            val chips = listOf(
                "🗂️ All Subjects", "🏛️ History 340", "🌍 Geography 280", "⚖️ Polity 310",
                "📈 Economy 250", "🔬 Science & Tech 220", "🌿 Environment 190", "📰 Current Affairs 410",
                "🎨 Art & Culture 160", "🌐 Int'l Relations 130", "🛡️ Security & Defence 95", "🏺 Ancient History 180"
            )
            FlowChips(chips, selected = "🗂️ All Subjects")
        }
    } else {
        StepCard("2", "FOCUS ON A SUBJECT (OPTIONAL)") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp)
                    .background(Color(0xFFEEF2F8), RoundedCornerShape(10.dp))
                    .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(10.dp))
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Choose subject...", color = Color(0xFF6B7C93), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text("⌄", color = Color(0xFF6B7C93), fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
private fun StepQuestionSource() {
    StepCard("3", "QUESTION SOURCE") {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SourceCard("📁", "Sectional", "Single subject", Modifier.weight(1f))
            SourceCard("🎲", "Mix Bag", "All subjects", Modifier.weight(1f))
            SourceCard("📅", "PYQ Based", "Past papers", Modifier.weight(1f))
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            SourceCard("🏆", "Full Length", "P1 + 100 Q's", Modifier.weight(1f))
            SourceCard("📚", "NCERT", "Book-wise", Modifier.weight(1f))
            SourceCard("🗞️", "Curr. Affairs", "Last 6 months", Modifier.weight(1f))
        }
    }
}

@Composable
private fun StepQuestionCount() {
    StepCard("4", "NUMBER OF QUESTIONS") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CountBtn("−")
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 20.dp)) {
                Text("25", color = Color(0xFF0D1B2A), fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 40.sp)
                Text("questions", color = Color(0xFF6B7C93), fontSize = 10.sp)
            }
            CountBtn("+")
        }
        SpacerH(6)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(Color(0xFFE4ECF6), RoundedCornerShape(3.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .height(6.dp)
                    .background(Brush.horizontalGradient(listOf(Color(0xFF0D1B2A), Color(0xFF1A3A5C))), RoundedCornerShape(3.dp))
            )
        }
        SpacerH(8)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MiniPill("⚡ Quick 5", true)
            MiniPill("🔒 Standard 10")
            MiniPill("🔒 25 Q")
            MiniPill("🔒 50 Q")
        }
        SpacerH(6)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MiniPill("🔒 75 Q")
            MiniPill("🔒 Full 100")
        }
        SpacerH(8)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFEF8ED), RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFFFDE68A), RoundedCornerShape(8.dp))
                .padding(horizontal = 10.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "⚠️ Guidelines: 10 questions/day. Upgrade to unlock\nunlimited tests from full our question bank.",
                color = Color(0xFFC47D10),
                fontSize = 10.sp,
                lineHeight = 15.sp
            )
            Box(
                modifier = Modifier
                    .background(Color(0xFF0D1B2A), RoundedCornerShape(7.dp))
                    .padding(horizontal = 9.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Unlock →", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}

@Composable
private fun StepDifficulty() {
    StepCard("5", "DIFFICULTY LEVEL") {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DiffCard("🌱", "Easy", "Build confidence", Modifier.weight(1f))
            DiffCard("⚡", "Medium", "UPSC standard", Modifier.weight(1f), selected = true)
            DiffCard("🔥", "Hard", "Push limits", Modifier.weight(1f))
            DiffCard("🎲", "Mixed", "Real exam feel", Modifier.weight(1f))
        }
    }
}

@Composable
private fun StepCard(step: String, title: String, body: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(18.dp))
            .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(18.dp))
            .padding(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(7.dp)) {
            Box(
                modifier = Modifier
                    .size(22.dp)
                    .background(Color(0xFF1A2744), RoundedCornerShape(11.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(step, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
            }
            Text(title, color = Color(0xFF5A7096), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
        SpacerH(10)
        body()
    }
}

@Composable
private fun OptionCard(
    emoji: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    Column(
        modifier = modifier
            .height(99.dp)
            .background(if (selected) Color(0xFFFEF8ED) else Color(0xFFEEF2F8), RoundedCornerShape(14.dp))
            .border(1.dp, if (selected) Color(0xFFFDE68A) else Color(0xFFDDE5F0), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Text(emoji, fontSize = 26.sp)
        Text(title, color = Color(0xFF1A2744), fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)
        Text(subtitle, color = Color(0xFF5A7096), fontSize = 10.5.sp, lineHeight = 16.sp)
    }
}

@Composable
private fun FlowChips(chips: List<String>, selected: String) {
    val rows = chips.chunked(2)
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        rows.forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                row.forEach { chip ->
                    val isSelected = chip == selected
                    Box(
                        modifier = Modifier
                            .background(if (isSelected) Color(0xFF1A2744) else Color.White, RoundedCornerShape(22.dp))
                            .border(1.dp, if (isSelected) Color(0xFF1A2744) else Color(0xFFDDE5F0), RoundedCornerShape(22.dp))
                            .padding(horizontal = 13.dp, vertical = 7.dp)
                    ) {
                        Text(chip, color = if (isSelected) Color.White else Color(0xFF5A7096), fontSize = 12.sp, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun SourceCard(icon: String, title: String, sub: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(79.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFDDE5F0), RoundedCornerShape(12.dp))
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(icon, fontSize = 20.sp)
        Text(title, color = Color(0xFF1A2744), fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
        Text(sub, color = Color(0xFF8FA4BE), fontSize = 8.sp)
    }
}

@Composable
private fun CountBtn(sign: String) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
            .border(2.dp, Color(0xFFD6E2F0), RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(sign, color = Color(0xFF2C3E52), fontSize = 18.sp)
    }
}

@Composable
private fun MiniPill(text: String, active: Boolean = false) {
    Box(
        modifier = Modifier
            .height(27.dp)
            .background(if (active) Color(0xFF0F172B) else Color(0xFFF3F4F6), RoundedCornerShape(999.dp))
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = if (active) Color.White else Color(0xFF364153), fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun DiffCard(emoji: String, title: String, sub: String, modifier: Modifier = Modifier, selected: Boolean = false) {
    Column(
        modifier = modifier
            .height(75.dp)
            .background(if (selected) Color(0x17F5A623) else Color.White, RoundedCornerShape(12.dp))
            .padding(horizontal = 7.dp, vertical = 11.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(emoji, fontSize = 20.sp)
        Text(title, color = if (selected) Color(0xFFE8952A) else Color(0xFF0D1B2A), fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
        Text(sub, color = Color(0xFF6B7C93), fontSize = 8.sp)
    }
}

@Composable
private fun SpacerH(h: Int) = Box(modifier = Modifier.height(h.dp))
