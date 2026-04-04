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

private val RSBg   = Color(0xFF0F1629)
private val RSCard = Color(0xFF1A2540)
private val RSWhite = Color.White
private val RSGray  = Color(0xFF9CA3AF)
private val RSLight = Color(0xFFF4F6FB)

@Composable
fun RevisionSuiteScreen(
    onBack: () -> Unit,
    onOpenFlashcards: () -> Unit,
    onOpenMindMaps: () -> Unit,
    onOpenSpacedRep: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RSBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Dark hero ──────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(RSBg)
                .statusBarsPadding()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Badge
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF2A3555))
                    .padding(horizontal = 16.dp, vertical = 7.dp)
            ) {
                Text("🧠 REVISION SUITE", color = RSGray, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
            }

            Spacer(Modifier.height(18.dp))
            Text("Master Your", color = RSWhite, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Text("Knowledge 🧠", color = RSWhite, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Spacer(Modifier.height(10.dp))
            Text("Flashcards · Mindmaps · Spaced Repetition", color = RSGray, fontSize = 13.sp, textAlign = TextAlign.Center)

            Spacer(Modifier.height(24.dp))

            // Top stats
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                HeroStat(Modifier.weight(1f), "342", "CARDS DUE")
                HeroStat(Modifier.weight(1f), "18",  "MINDMAPS")
                HeroStat(Modifier.weight(1f), "47",  "DAY STREAK")
            }

            Spacer(Modifier.height(20.dp))
        }

        // ── White content ──────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(6.dp, RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(RSLight)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // ── Flashcard Vault ──────────────────────────
            RevisionCard {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)).background(Color(0xFFFFEBEB)),
                        contentAlignment = Alignment.Center
                    ) { Text("📚", fontSize = 24.sp) }
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text("Flashcard Vault", color = Color(0xFF111827), fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                        Text("Smart spaced learning with instant recall rating", color = RSGray, fontSize = 12.sp, lineHeight = 17.sp)
                    }
                }
                Spacer(Modifier.height(14.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    RSStatBox(Modifier.weight(1f), "1,248", "TOTAL\nCARDS",   Color(0xFF111827), RSLight)
                    RSStatBox(Modifier.weight(1f), "74",    "DUE\nTODAY",    GoldAccent,         Color(0xFFFFFBEB))
                    RSStatBox(Modifier.weight(1f), "84%",   "MASTERED",      Color(0xFF22C55E),  Color(0xFFF0FDF4))
                }
                Spacer(Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Overall mastery", color = RSGray, fontSize = 12.sp)
                    Text("84%", color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(4.dp))
                LinearProgressIndicator(progress = { 0.84f }, modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)), color = GoldAccent, trackColor = Color(0xFFE5E7EB))
                Spacer(Modifier.height(12.dp))
                Box(
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(GoldGradient)
                        .clickable { onOpenFlashcards() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("📚  Open Flashcard Vault →", color = Color(0xFF111827), fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                }
            }

            // ── Mindmap Library ──────────────────────────
            RevisionCard {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)).background(Color(0xFFEDE9FE)), contentAlignment = Alignment.Center) { Text("🧠", fontSize = 24.sp) }
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text("Mindmap Library", color = Color(0xFF111827), fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                        Text("Visual concept maps for fast topic revision", color = RSGray, fontSize = 12.sp, lineHeight = 17.sp)
                    }
                }
                Spacer(Modifier.height(14.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    RSStatBox(Modifier.weight(1f), "18", "MAPS",     Color(0xFF111827), RSLight)
                    RSStatBox(Modifier.weight(1f), "6",  "SUBJECTS", Color(0xFF3B82F6), Color(0xFFEFF6FF))
                    RSStatBox(Modifier.weight(1f), "3",  "NEW",      GoldAccent,        Color(0xFFFFFBEB))
                }
                Spacer(Modifier.height(12.dp))
                Button(onClick = onOpenMindMaps, modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(14.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF111827))) {
                    Text("🧠  Explore Mindmaps →", color = RSWhite, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                }
            }

            // ── Spaced Repetition ────────────────────────
            RevisionCard {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)).background(Color(0xFFD1FAE5)), contentAlignment = Alignment.Center) { Text("🔄", fontSize = 24.sp) }
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text("Spaced Repetition", color = Color(0xFF111827), fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                        Text("Schedule reminders from MCQ, PYQ, Mains & more", color = RSGray, fontSize = 12.sp, lineHeight = 17.sp)
                    }
                }
                Spacer(Modifier.height(14.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    RSStatBox(Modifier.weight(1f), "23", "SCHEDULED", Color(0xFF22C55E), Color(0xFFF0FDF4))
                    RSStatBox(Modifier.weight(1f), "8",  "OVERDUE",   Color(0xFFEF4444), Color(0xFFFEF2F2))
                    RSStatBox(Modifier.weight(1f), "15", "THIS\nWEEK", GoldAccent,       Color(0xFFFFFBEB))
                }
                Spacer(Modifier.height(12.dp))
                Button(onClick = onOpenSpacedRep, modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(14.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF166534))) {
                    Text("🔄  Open Spaced Rep →", color = RSWhite, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                }
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun HeroStat(modifier: Modifier, value: String, label: String) {
    Column(modifier = modifier.clip(RoundedCornerShape(14.dp)).background(RSCard).padding(vertical = 14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = GoldAccent, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(2.dp))
        Text(label, color = RSGray, fontSize = 10.sp, letterSpacing = 0.4.sp, textAlign = TextAlign.Center)
    }
}

@Composable
private fun RevisionCard(content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(RSWhite).padding(18.dp), content = content)
}

@Composable
private fun RSStatBox(modifier: Modifier, value: String, label: String, valueColor: Color, bg: Color) {
    Column(modifier = modifier.clip(RoundedCornerShape(12.dp)).background(bg).padding(vertical = 12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = valueColor, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(2.dp))
        Text(label, color = RSGray, fontSize = 9.sp, letterSpacing = 0.3.sp, textAlign = TextAlign.Center, lineHeight = 12.sp)
    }
}
