package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import kotlinx.coroutines.delay

private val LoadBg = Brush.linearGradient(
    listOf(Color(0xFF060E1D), Color(0xFF08162E))
)
private val LoadSurface = Color(0xFFF0F4FA)
private val LoadCard    = Color.White
private val LoadText    = Color(0xFF0D1B2E)

private data class LoadStep(
    val emoji: String,
    val label: String
)

private val steps = listOf(
    LoadStep("📚", "Reading full article"),
    LoadStep("🔍", "Extracting key arguments"),
    LoadStep("🧠", "Mapping to UPSC syllabus"),
    LoadStep("📝", "Generating Practice Question"),
)

@Composable
fun JeetAILoadingScreen(
    onViewSummary: () -> Unit,
    onBack: () -> Unit
) {
    // completedSteps: 0..4, currentStep animates the spinner
    var completedSteps by remember { mutableStateOf(0) }
    var showButton     by remember { mutableStateOf(false) }

    // Animate through steps automatically
    LaunchedEffect(Unit) {
        delay(600L)
        completedSteps = 1
        delay(700L)
        completedSteps = 2
        delay(900L)
        completedSteps = 3
        delay(1000L)
        completedSteps = 4
        showButton = true
    }

    // Spinner rotation for the in-progress step
    val infiniteTransition = rememberInfiniteTransition()
    val spinAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = LoadBg)
    ) {
        // Back arrow
        Text(
            "←",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 22.sp,
            modifier = Modifier
                .statusBarsPadding()
                .padding(start = 20.dp, top = 16.dp)
                .clickable { onBack() }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.statusBarsPadding())
            Spacer(Modifier.height(40.dp))

            // Brain icon
            Text("🧠", fontSize = 36.sp)
            Spacer(Modifier.height(12.dp))

            // Title
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) {
                        append("Jeet AI ")
                    }
                    withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold)) {
                        append("Summary")
                    }
                },
                fontSize = 22.sp
            )

            Spacer(Modifier.height(28.dp))

            // Steps card panel
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(LoadSurface)
                    .padding(horizontal = 19.dp, vertical = 18.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    steps.forEachIndexed { index, step ->
                        val isDone       = completedSteps > index
                        val isInProgress = completedSteps == index && !showButton

                        StepRow(
                            emoji       = step.emoji,
                            label       = step.label,
                            isDone      = isDone,
                            isInProgress= isInProgress,
                            spinAngle   = spinAngle
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    // Button
                    if (showButton) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(GoldAccent)
                                .clickable { onViewSummary() }
                                .padding(vertical = 15.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "View Summary Now →",
                                color = Color(0xFF101828),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(GoldAccent.copy(alpha = 0.45f))
                                .padding(vertical = 15.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "Analysing article...",
                                color = Color(0xFF101828).copy(alpha = 0.7f),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StepRow(
    emoji: String,
    label: String,
    isDone: Boolean,
    isInProgress: Boolean,
    spinAngle: Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(LoadCard)
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Emoji icon
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(emoji, fontSize = 16.sp)
            }
            Spacer(Modifier.width(12.dp))
            Text(
                label,
                color = LoadText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            // Status indicator
            when {
                isDone -> {
                    Text(
                        "✓",
                        color = Color(0xFF1976D2),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                isInProgress -> {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(Color.Transparent)
                        )
                        // Gold ring spinner
                        androidx.compose.foundation.Canvas(Modifier.size(20.dp)) {
                            drawArc(
                                color = GoldAccent,
                                startAngle = spinAngle,
                                sweepAngle = 270f,
                                useCenter = false,
                                style = androidx.compose.ui.graphics.drawscope.Stroke(
                                    width = 2.4.dp.toPx(),
                                    cap   = androidx.compose.ui.graphics.StrokeCap.Round
                                )
                            )
                        }
                    }
                }
                else -> {
                    // Pending: empty gold ring
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color.Transparent)
                    ) {
                        androidx.compose.foundation.Canvas(Modifier.size(20.dp)) {
                            drawCircle(
                                color = Color(0xFFE5E7EB),
                                style = androidx.compose.ui.graphics.drawscope.Stroke(
                                    width = 2.dp.toPx()
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
