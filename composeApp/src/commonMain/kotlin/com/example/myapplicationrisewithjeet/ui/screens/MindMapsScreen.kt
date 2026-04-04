package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
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

private val MMBg    = Color(0xFF111827)
private val MMCard  = Color(0xFF1F2937)
private val MMWhite = Color.White
private val MMGray  = Color(0xFF9CA3AF)

@Composable
fun MindMapsScreen(
    onBack: () -> Unit,
    onSubjectClick: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().background(MMBg)) {
        // ── Header ──────────────────────────────────────────
        Column(
            modifier = Modifier.fillMaxWidth().background(MMBg).statusBarsPadding()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("←", color = MMWhite, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                Text("Mind Maps", color = MMWhite, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.width(28.dp))
            }
            Text(
                "Visual concept maps for deep retention",
                color = MMGray,
                fontSize = 13.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(14.dp))

            // Stats row
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MMTopStat(Modifier.weight(1f), "48",   "Due\ntoday",  GoldAccent)
                MMTopStat(Modifier.weight(1f), "124",  "Mastered",    MMWhite)
                MMTopStat(Modifier.weight(1f), "23",   "Learning",    MMWhite)
                MMTopStat(Modifier.weight(1f), "92%",  "Retention",   Color(0xFF22C55E))
            }
        }

        // ── White scrollable content ─────────────────────────
        Column(
            modifier = Modifier
                .fillMaxSize()
                .shadow(6.dp, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color(0xFFF4F6FB))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Spacer(Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("My Decks", color = Color(0xFF111827), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Text("+ New", color = GoldAccent, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.clickable {})
            }
            Spacer(Modifier.height(14.dp))

            val rows = revisionSubjects.chunked(2)
            rows.forEach { row ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    row.forEach { subject ->
                        SubjectDeckCard(
                            modifier = Modifier.weight(1f),
                            subject = subject,
                            suffix = "mindmap",
                            onClick = { onSubjectClick(subject.id) }
                        )
                    }
                    if (row.size == 1) AddSubjectCard(Modifier.weight(1f))
                }
                Spacer(Modifier.height(12.dp))
            }
            if (revisionSubjects.size % 2 == 0) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    AddSubjectCard(Modifier.weight(1f))
                    Spacer(Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun MMTopStat(modifier: Modifier, value: String, label: String, valueColor: Color) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(10.dp)).background(MMCard).padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = valueColor, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(2.dp))
        Text(label, color = MMGray, fontSize = 9.sp, textAlign = TextAlign.Center, lineHeight = 12.sp)
    }
}
