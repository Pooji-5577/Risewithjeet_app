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

private val FVBg    = Color(0xFF111827)
private val FVCard  = Color(0xFF1F2937)
private val FVWhite = Color.White
private val FVGray  = Color(0xFF9CA3AF)
private val FVLight = Color(0xFFF4F6FB)

@Composable
fun FlashcardVaultScreen(
    onBack: () -> Unit,
    onSubjectClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(FVBg)
    ) {
        // ── Header ──────────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(FVBg)
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("←", color = FVWhite, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                Text("Flashcards", color = FVWhite, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(GoldGradient)
                        .clickable {}
                        .padding(horizontal = 14.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("+ Add Card", color = Color(0xFF111827), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }

            // Stats
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FVTopStat(Modifier.weight(1f), "48",   "Due\ntoday",  GoldAccent)
                FVTopStat(Modifier.weight(1f), "124",  "Mastered",    FVWhite)
                FVTopStat(Modifier.weight(1f), "23",   "Learning",    FVWhite)
                FVTopStat(Modifier.weight(1f), "92%",  "Retention",   Color(0xFF22C55E))
            }
        }

        // ── White scrollable content ─────────────────────────
        Column(
            modifier = Modifier
                .fillMaxSize()
                .shadow(6.dp, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(FVLight)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Spacer(Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("My Decks", color = Color(0xFF111827), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Text("+ New", color = GoldAccent, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.clickable {})
            }
            Spacer(Modifier.height(14.dp))

            // Subject grid (2 cols)
            val rows = revisionSubjects.chunked(2)
            rows.forEach { row ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    row.forEach { subject ->
                        SubjectDeckCard(
                            modifier = Modifier.weight(1f),
                            subject = subject,
                            suffix = "cards",
                            onClick = { onSubjectClick(subject.id) }
                        )
                    }
                    // If odd count, add "Add Subject" placeholder
                    if (row.size == 1) {
                        AddSubjectCard(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(Modifier.height(12.dp))
            }

            // Add Subject as last card if even count
            if (revisionSubjects.size % 2 == 0) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    AddSubjectCard(modifier = Modifier.weight(1f))
                    Spacer(Modifier.weight(1f))
                }
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
internal fun SubjectDeckCard(modifier: Modifier, subject: RevisionSubject, suffix: String, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(subject.emoji, fontSize = 28.sp)
        Spacer(Modifier.height(8.dp))
        Text(subject.name, color = Color(0xFF111827), fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 19.sp)
        Spacer(Modifier.height(2.dp))
        Text("${subject.cardCount} $suffix", color = Color(0xFF6B7280), fontSize = 12.sp)
        Spacer(Modifier.height(2.dp))
        if (subject.dueToday > 0)
            Text("${subject.dueToday} due today", color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        else
            Text("0 due", color = Color(0xFF9CA3AF), fontSize = 12.sp)
    }
}

@Composable
internal fun AddSubjectCard(modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF9FAFB))
            .border(2.dp, Color(0xFFE5E7EB), RoundedCornerShape(16.dp))
            .clickable {}
            .padding(16.dp)
            .height(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("+", color = Color(0xFFD1D5DB), fontSize = 28.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.height(4.dp))
        Text("Add Subject", color = Color(0xFF9CA3AF), fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
        Text("Create new deck", color = Color(0xFFD1D5DB), fontSize = 11.sp)
    }
}

@Composable
private fun FVTopStat(modifier: Modifier, value: String, label: String, valueColor: Color) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(10.dp)).background(FVCard).padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = valueColor, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(2.dp))
        Text(label, color = FVGray, fontSize = 9.sp, textAlign = TextAlign.Center, lineHeight = 12.sp)
    }
}
