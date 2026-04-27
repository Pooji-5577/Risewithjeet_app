package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import kotlinx.coroutines.delay
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.icon_browse
import myapplicationrisewithjeet.composeapp.generated.resources.icon_camera
import myapplicationrisewithjeet.composeapp.generated.resources.icon_note
import myapplicationrisewithjeet.composeapp.generated.resources.icon_reset
import myapplicationrisewithjeet.composeapp.generated.resources.icon_scales
import myapplicationrisewithjeet.composeapp.generated.resources.icon_timer
import myapplicationrisewithjeet.composeapp.generated.resources.icon_upload
import org.jetbrains.compose.resources.painterResource

private val MTBg     = Color(0xFFEFF3F9)
private val MTContentBg = Color(0xFFF0F4FA)
private val MTDark   = Color(0xFF0D1B2E)
private val MTCard   = Color(0xFF0D1B2E)
private val MTWhite  = Color.White
private val MTGray   = Color(0xFF999999)
private val MTLight  = Color(0xFFF5F5F5)
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
    val timerText = "${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}"

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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(MTContentBg)
        ) {
            Spacer(Modifier.height(12.dp))

            // ── White main card ──────────────────────────────────
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(MTContentBg)
                    .padding(18.dp)
            ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFFF4E6)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.icon_scales),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    "Evaluating Your Answer",
                    color = MTDark,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(Modifier.height(12.dp))

            // Question dark box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MTCard)
                    .padding(horizontal = 18.dp, vertical = 18.dp)
            ) {
                Column {
                    Text(
                        "DETAILED QUESTIONS",
                        color = MTWhite,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 24.sp
                    )
                    Text(
                        "GOVERNANCE & POLITY",
                        color = MTWhite,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 24.sp
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "\"Panchayati Raj Institutions have remained a constitutional formality rather than a functional reality.\" Critically examine with reference to 73rd and 74th Constitutional Amendments.",
                        color = MTWhite,
                        fontSize = 14.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                        StatChip("📝 250 words")
                        StatChip("⏱ 15 min suggested")
                        StatChip("🔖 10 marks")
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Timer card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(28.dp))
                    .background(MTWhite)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "WRITING TIMER",
                        color = MTGray,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.6.sp
                    )
                    Spacer(Modifier.height(12.dp))

                    // Circular timer display
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .border(10.dp, MTDark, RoundedCornerShape(60.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            timerText,
                            color = MTDark,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = (-1).sp
                        )
                    }

                    Spacer(Modifier.height(12.dp))
                    Text(
                        if (timerRunning) "RUNNING" else "READY TO START",
                        color = MTGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Box(
                            modifier = Modifier.weight(1f).height(44.dp)
                                .shadow(6.dp, RoundedCornerShape(12.dp))
                                .clip(RoundedCornerShape(12.dp))
                                .background(GoldGradient)
                                .clickable { timerRunning = !timerRunning },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                if (timerRunning) "⏸ Pause" else "▶ Start Timer",
                                color = MTDark,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp
                            )
                        }
                        OutlinedButton(
                            onClick = {
                                timerRunning = false
                                secondsLeft = 15 * 60
                            },
                            modifier = Modifier.weight(1f).height(44.dp),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, Color(0xFF99A1AF)),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = MTLight)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(Res.drawable.icon_reset),
                                    contentDescription = null,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text("Reset", color = Color(0xFF666666), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            }
                        }
                    }

                    Spacer(Modifier.height(10.dp))
                    Text(
                        buildAnnotatedString {
                            append("Suggested: 250 words · ")
                            pushStyle(SpanStyle(color = MTDark, fontWeight = FontWeight.Bold))
                            append("$wordCount / 250 words")
                            pop()
                        },
                        color = MTGray,
                        fontSize = 11.sp
                    )
                }
            }
            Spacer(Modifier.height(12.dp))

            // ── Drop zone ─────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MTWhite)
                    .drawBehind {
                        val stroke = 1.dp.toPx()
                        drawRoundRect(
                            color = Color(0xFF99A1AF),
                            style = Stroke(
                                width = stroke,
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(14f, 10f), 0f)
                            ),
                            cornerRadius = androidx.compose.ui.geometry.CornerRadius(16.dp.toPx(), 16.dp.toPx())
                        )
                    }
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(Res.drawable.icon_upload),
                        contentDescription = null,
                        modifier = Modifier.size(38.dp)
                    )
                    Spacer(Modifier.height(8.dp))
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
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(12.dp))
                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier.height(45.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = MTWhite)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(Res.drawable.icon_browse),
                                contentDescription = null,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text("Browse Files", color = Color(0xFF666666), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }
            }

            Spacer(Modifier.height(14.dp))

            // ── Submit button ─────────────────────────────────
            Button(
                onClick = onSubmit,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MTDark)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_camera),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "Submit Answer for Evaluation",
                        color = MTWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
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
}

@Composable
private fun StatChip(label: String) {
    Text(label, color = Color.White.copy(alpha = 0.6f), fontSize = 11.sp, fontWeight = FontWeight.Normal)
}
