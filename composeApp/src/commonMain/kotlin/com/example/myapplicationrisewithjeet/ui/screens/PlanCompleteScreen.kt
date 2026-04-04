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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private val PcBg = Color(0xFF202327)
private val PcHero = Color(0xFF0D1A3A)
private val PcSurface = Color(0xFFECEFF5)
private val PcCard = Color(0xFFFFFFFF)
private val PcText = Color(0xFF2A3553)
private val PcMuted = Color(0xFF8A93AC)
private val PcBorder = Color(0xFFD9DFEA)

@Composable
fun PlanCompleteScreen(onDashboard: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PcBg)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(top = 10.dp)
                    .background(PcHero)
                    .padding(horizontal = 16.dp, vertical = 22.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Text("🎉", fontSize = 72.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("Plan Complete!", color = Color.White, fontSize = 50.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.height(6.dp))
                    Text("Incredible session, Rahul - all 5 tasks done!", color = Color(0xFFB3BED8), fontSize = 14.sp, textAlign = TextAlign.Center)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(PcSurface)
                    .padding(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatTile(Modifier.weight(1f), "⏱", "6.5h", "TOTAL STUDIED", Color(0xFF3E4A6C))
                    StatTile(Modifier.weight(1f), "✅", "5/5", "TASKS DONE", Color(0xFF4CA960))
                }
                Spacer(Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatTile(Modifier.weight(1f), "🎯", "88%", "MCQ ACCURACY", Color(0xFF4F75D2))
                    StatTile(Modifier.weight(1f), "🔥", "48", "DAY STREAK", Color(0xFFD7961F))
                }

                Spacer(Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(GoldGradient)
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            Text("🏆 New Achievement!", color = Color(0xFF1A223B), fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                            Text("First perfect study day this month", color = Color(0xFF404B68), fontSize = 12.sp)
                        }
                        Text("+35XP", color = Color(0xFF1A223B), fontSize = 42.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }

                Spacer(Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .width(136.dp)
                        .height(40.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(1.dp, PcBorder, RoundedCornerShape(12.dp))
                        .clickable { onDashboard() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("← Dashboard", color = PcText, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(Modifier.height(18.dp))
    }
}

@Composable
private fun StatTile(
    modifier: Modifier,
    emoji: String,
    value: String,
    label: String,
    valueColor: Color
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(PcCard)
            .border(1.dp, PcBorder, RoundedCornerShape(12.dp))
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(emoji, fontSize = 24.sp)
        Spacer(Modifier.height(4.dp))
        Text(value, color = valueColor, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = PcMuted, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}
