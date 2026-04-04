package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*

private val FTBg    = Color(0xFF111827)
private val FTCard  = Color(0xFF1F2937)
private val FTWhite = Color.White
private val FTGray  = Color(0xFF9CA3AF)

@Composable
fun FlashcardTopicsScreen(
    subjectId: String,
    onBack: () -> Unit,
    onTopicClick: (String) -> Unit
) {
    val subject = revisionSubjects.find { it.id == subjectId } ?: revisionSubjects[1]

    Column(modifier = Modifier.fillMaxSize().background(FTBg)) {
        // ── Dark header ──────────────────────────────────────
        Column(
            modifier = Modifier.fillMaxWidth().background(FTBg).statusBarsPadding().padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text("←", color = White70, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
            }
            Spacer(Modifier.height(8.dp))
            Text(subject.emoji, fontSize = 36.sp)
            Spacer(Modifier.height(6.dp))
            Text(subject.name, color = FTWhite, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(4.dp))
            Text("5 sub-topics · 39 done · 0%", color = FTGray, fontSize = 13.sp)

            Spacer(Modifier.height(16.dp))

            // Progress card
            Box(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(FTCard).padding(16.dp)
            ) {
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Subject Progress", color = FTGray, fontSize = 12.sp)
                        Text("21%", color = GoldAccent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(6.dp))
                    LinearProgressIndicator(progress = { 0.21f }, modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp)), color = GoldAccent, trackColor = Color(0xFF374151))
                    Spacer(Modifier.height(14.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        ProgressStat(Modifier.weight(1f), "39", "TOTAL",  FTWhite)
                        ProgressStat(Modifier.weight(1f), "8",  "DONE",   Color(0xFF22C55E))
                        ProgressStat(Modifier.weight(1f), "2",  "ACTIVE", GoldAccent)
                        ProgressStat(Modifier.weight(1f), "29", "LEFT",   FTGray)
                    }
                }
            }
        }

        // ── White topic grid ─────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color(0xFFF4F6FB))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Spacer(Modifier.height(4.dp))
            val rows = polityTopics.chunked(2)
            rows.forEach { row ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    row.forEach { topic ->
                        TopicCard(
                            modifier = Modifier.weight(1f),
                            topic = topic,
                            onClick = { onTopicClick(topic.id) }
                        )
                    }
                    if (row.size == 1) {
                        AddTopicCard(Modifier.weight(1f))
                    }
                }
                Spacer(Modifier.height(12.dp))
            }
            if (polityTopics.size % 2 == 0) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    AddTopicCard(Modifier.weight(1f))
                    Spacer(Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun TopicCard(modifier: Modifier, topic: RevisionTopic, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(14.dp)
    ) {
        Text(topic.emoji, fontSize = 26.sp)
        Spacer(Modifier.height(8.dp))
        Text(topic.name, color = Color(0xFF111827), fontSize = 13.sp, fontWeight = FontWeight.Bold, lineHeight = 18.sp)
        Spacer(Modifier.height(2.dp))
        Text("${topic.nodeCount} nodes", color = Color(0xFF6B7280), fontSize = 11.sp)
        if (topic.badge.isNotEmpty()) {
            Spacer(Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(topic.badgeColor.copy(0.15f))
                    .padding(horizontal = 10.dp, vertical = 3.dp)
            ) {
                Text(topic.badge, color = topic.badgeColor, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun AddTopicCard(modifier: Modifier) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(16.dp)).background(Color(0xFFF9FAFB)).border(2.dp, Color(0xFFE5E7EB), RoundedCornerShape(16.dp)).clickable {}.padding(14.dp).height(110.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("+", color = Color(0xFFD1D5DB), fontSize = 26.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.height(4.dp))
        Text("Add a Topic", color = Color(0xFF9CA3AF), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun ProgressStat(modifier: Modifier, value: String, label: String, valueColor: Color) {
    Column(modifier = modifier.clip(RoundedCornerShape(8.dp)).background(Color(0xFF374151)).padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = valueColor, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = FTGray, fontSize = 9.sp, letterSpacing = 0.3.sp)
    }
}
