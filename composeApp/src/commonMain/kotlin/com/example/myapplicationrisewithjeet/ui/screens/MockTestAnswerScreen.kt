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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import kotlinx.coroutines.delay

private val MTBg     = Color(0xFFF2F3F8)
private val MTDark   = Color(0xFF0F1629)
private val MTCard   = Color(0xFF1A2540)
private val MTWhite  = Color.White
private val MTGray   = Color(0xFF9CA3AF)
private val MTLight  = Color(0xFFF4F6FB)
private val MTBorder = Color(0xFFE5E7EB)

@Composable
fun MockTestAnswerScreen(
    onBack: () -> Unit,
    onSubmit: () -> Unit
) {
    var timerRunning by remember { mutableStateOf(false) }
    var secondsLeft  by remember { mutableStateOf(15 * 60) }
    var wordCount    by remember { mutableStateOf(0) }

    LaunchedEffect(timerRunning) {
        if (timerRunning) {
            while (secondsLeft > 0) {
                delay(1000L)
                secondsLeft--
            }
            timerRunning = false
        }
    }

    val minutes = secondsLeft / 60
    val seconds = secondsLeft % 60
    val timerText = "%02d:%02d".format(minutes, seconds)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MTBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Top header bar ──────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MTDark)
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "←",
                    color = White70,
                    fontSize = 20.sp,
                    modifier = Modifier.clickable { onBack() }
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    "DAILY MAINS CHALLENGE · STEP 1 OF 3",
                    color = GoldAccent,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
            Spacer(Modifier.height(10.dp))
            // Progress segments
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(GoldGradient)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(White15)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(White15)
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                "GS Paper II Question",
                color = MTWhite,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(Modifier.height(16.dp))

        // ── White main card ──────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MTWhite)
                .padding(20.dp)
        ) {
            // Evaluating header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("⚖️", fontSize = 18.sp)
                Spacer(Modifier.width(8.dp))
                Text(
                    "Evaluating Your Answer",
                    color = MTDark,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(14.dp))

            // Question dark box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(MTCard)
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        "DETAILED QUESTIONS",
                        color = GoldAccent,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.8.sp
                    )
                    Text(
                        "GOVERNANCE & POLITY",
                        color = GoldAccent,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.8.sp
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "\"Panchayati Raj Institutions have remained a constitutional formality rather than a functional reality.\" Critically examine with reference to 73rd and 74th Constitutional Amendments.",
                        color = MTWhite,
                        fontSize = 14.sp,
                        lineHeight = 21.sp
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                        StatChip("📝", "250 words")
                        StatChip("🕐", "15 min suggested")
                        StatChip("💎", "10 marks")
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Timer card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(MTLight)
                    .border(1.dp, MTBorder, RoundedCornerShape(14.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "WRITING TIMER",
                        color = MTGray,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.6.sp
                    )
                    Spacer(Modifier.height(12.dp))

                    // Circular timer display
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(RoundedCornerShape(45.dp))
                            .border(3.dp, MTDark, RoundedCornerShape(45.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            timerText,
                            color = MTDark,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(Modifier.height(8.dp))
                    Text(
                        if (timerRunning) "RUNNING" else "READY TO START",
                        color = MTGray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Box(
                            modifier = Modifier.weight(1f).height(44.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(GoldGradient)
                                .clickable { timerRunning = !timerRunning },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                if (timerRunning) "⏸ Pause" else "▶ Start Timer",
                                color = MTDark,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        }
                        OutlinedButton(
                            onClick = {
                                timerRunning = false
                                secondsLeft = 15 * 60
                            },
                            modifier = Modifier.weight(1f).height(44.dp),
                            shape = RoundedCornerShape(10.dp),
                            border = ButtonDefaults.outlinedButtonBorder
                        ) {
                            Text("↺ Reset", color = MTDark, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        }
                    }

                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Suggested: 250 words    $wordCount / 250 words",
                        color = MTGray,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // ── Drop zone ─────────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MTWhite)
                .border(2.dp, MTBorder, RoundedCornerShape(16.dp))
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("📤", fontSize = 40.sp)
                Spacer(Modifier.height(10.dp))
                Text(
                    "Drop your answer script here",
                    color = MTDark,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Upload handwritten answers, text files, etc.",
                    color = MTGray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(14.dp))
                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(10.dp),
                    border = ButtonDefaults.outlinedButtonBorder
                ) {
                    Text("📎  Browse Files", color = MTDark, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // ── Submit button ─────────────────────────────────────
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Button(
                onClick = onSubmit,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MTDark)
            ) {
                Text(
                    "🏆  Submit Answer for Evaluation",
                    color = MTWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
            Spacer(Modifier.height(6.dp))
            Text(
                "Get detailed feedback in 60 seconds",
                color = MTGray,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun StatChip(emoji: String, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(emoji, fontSize = 12.sp)
        Spacer(Modifier.width(3.dp))
        Text(label, color = White70, fontSize = 11.sp)
    }
}
