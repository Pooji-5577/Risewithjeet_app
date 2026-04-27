package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import kotlinx.coroutines.delay
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.icon_bolt
import myapplicationrisewithjeet.composeapp.generated.resources.icon_books
import myapplicationrisewithjeet.composeapp.generated.resources.icon_chart
import myapplicationrisewithjeet.composeapp.generated.resources.icon_clipboard
import myapplicationrisewithjeet.composeapp.generated.resources.icon_diamond_blue
import myapplicationrisewithjeet.composeapp.generated.resources.icon_note
import myapplicationrisewithjeet.composeapp.generated.resources.icon_scales
import myapplicationrisewithjeet.composeapp.generated.resources.icon_search
import myapplicationrisewithjeet.composeapp.generated.resources.icon_timer
import myapplicationrisewithjeet.composeapp.generated.resources.icon_way_forward
import myapplicationrisewithjeet.composeapp.generated.resources.icon_write
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val EVBg    = Color(0xFF0F1629)
private val EVCard  = Color(0xFF1A2540)
private val EVWhite = Color.White
private val EVGray  = Color(0xFF9CA3AF)
private val EVLight = Color(0xFFF4F6FB)
private val EVLoadingBg = Color(0xFFF0F4FA)

private enum class EvalPhase { LOADING, RESULTS }

private enum class AnalysisStatus { DONE, IN_PROGRESS, TODO }

private data class AnalysisStep(
    val icon: DrawableResource,
    val title: String,
    val subtitle: String,
    val status: AnalysisStatus
)

@Composable
fun EvaluationScreen(
    onBack: () -> Unit,
    onViewMarkup: () -> Unit,
    onWhatNext: () -> Unit
) {
    var phase by remember { mutableStateOf(EvalPhase.LOADING) }
    var countdown by remember { mutableStateOf(27) }

    // Simulate evaluation completion after countdown
    LaunchedEffect(Unit) {
        while (countdown > 0) {
            delay(1000L)
            countdown--
        }
        phase = EvalPhase.RESULTS
    }

    AnimatedContent(targetState = phase) { currentPhase ->
        when (currentPhase) {
            EvalPhase.LOADING -> EvaluationLoadingContent(countdown = countdown)
            EvalPhase.RESULTS -> EvaluationResultsContent(
                onBack = onBack,
                onViewMarkup = onViewMarkup,
                onWhatNext = onWhatNext
            )
        }
    }
}

// ── Step 2: Loading ──────────────────────────────────────────

@Composable
private fun EvaluationLoadingContent(countdown: Int) {
    val analysisSteps = listOf(
        AnalysisStep(Res.drawable.icon_note, "Structural Analysis", "Checking introduction-body-conclusion flow", AnalysisStatus.DONE),
        AnalysisStep(Res.drawable.icon_books, "Content Depth Assessment", "Evaluating breadth and depth of dimensions", AnalysisStatus.DONE),
        AnalysisStep(Res.drawable.icon_scales, "Balance & Perspective Check", "Ensuring multi-dimensional viewpoint", AnalysisStatus.DONE),
        AnalysisStep(Res.drawable.icon_chart, "Fact & Example Validation", "Cross-verifying with latest data", if (countdown <= 27) AnalysisStatus.IN_PROGRESS else AnalysisStatus.DONE),
        AnalysisStep(Res.drawable.icon_diamond_blue, "6-Pillar Rubric Scoring", "Depth · Demand · Structure · Substantiation", AnalysisStatus.TODO),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(EVBg)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = White70, fontSize = 20.sp)
                Spacer(Modifier.width(8.dp))
                Text(
                    "DAILY ANSWER WRITING · STEP 2 OF 3",
                    color = GoldAccent,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(Modifier.width(80.dp).height(4.dp).clip(RoundedCornerShape(4.dp)).background(GoldAccent))
                Box(Modifier.width(80.dp).height(4.dp).clip(RoundedCornerShape(4.dp)).background(GoldAccent))
                Box(Modifier.width(80.dp).height(4.dp).clip(RoundedCornerShape(4.dp)).background(White15))
            }
            Spacer(Modifier.height(12.dp))
            Text("GS Paper II Question", color = EVWhite, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-0.3).sp)
        }

        Spacer(Modifier.height(6.dp))

        // Main white card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(EVLoadingBg)
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("🧠", fontSize = 44.sp)
            Spacer(Modifier.height(16.dp))
            Text("Evaluating Your Answer", color = Color(0xFF111827), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(4.dp))
            Text("Analyzing with UPSC examiner's lens", color = Color(0xFF666666), fontSize = 13.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(20.dp))

            // Analysis steps
            analysisSteps.forEach { step ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(EVWhite)
                        .padding(horizontal = 18.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(step.icon),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp).width(28.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(step.title, color = Color(0xFF0D1B2E), fontSize = 14.sp, fontWeight = FontWeight.Bold, lineHeight = 21.sp)
                        Spacer(Modifier.height(2.dp))
                        Text(step.subtitle, color = Color(0xFF999999), fontSize = 11.sp, lineHeight = 16.5.sp)
                    }
                    when (step.status) {
                        AnalysisStatus.DONE -> Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFE8F5E9)),
                            contentAlignment = Alignment.Center
                        ) { Text("✓", color = Color(0xFF4CAF50), fontSize = 14.sp, fontWeight = FontWeight.Normal) }
                        AnalysisStatus.IN_PROGRESS -> Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .border(1.6.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFF5A623))
                            )
                        }
                        AnalysisStatus.TODO -> Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF5F5F5))
                                .border(1.6.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
                        )
                    }
                }
                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.height(8.dp))

            // Countdown box
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFFEFCE8))
            ) {
                Box(
                    modifier = Modifier
                        .width(3.dp)
                        .fillMaxHeight()
                        .background(Color(0xFFFDC700))
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 13.dp, vertical = 10.dp)
                ) {
                    Text(
                        "⏱ $countdown Seconds Remaining",
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFD9D9D9))
                    ) {
                        val progress = (countdown / 50f).coerceIn(0f, 1f)
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(progress)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF101828))
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "While you wait:",
                        color = Color(0xFF101828),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        " This 60-second pause is deliberate. In the actual exam, this is the time you'd spend reviewing your answer. Use this moment to mentally note one improvement you could make.",
                        color = Color(0xFF999999),
                        fontSize = 11.sp,
                        lineHeight = 16.5.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}

// ── Step 3: Results ──────────────────────────────────────────

private data class RubricItem(
    val icon: DrawableResource,
    val label: String,
    val score: Float,
    val max: Float,
    val scoreColor: Color,
    val barStart: Color,
    val barEnd: Color
)

@Composable
private fun EvaluationResultsContent(
    onBack: () -> Unit,
    onViewMarkup: () -> Unit,
    onWhatNext: () -> Unit
) {
    val rubricItems = listOf(
        RubricItem(
            icon = Res.drawable.icon_note,
            label = "Introduction & Context",
            score = 1.8f,
            max = 2f,
            scoreColor = Color(0xFF0D1B2E), // node 1697:624
            barStart = Color(0xFFF5A623),   // node 1697:626
            barEnd = Color(0xFFD4881A)
        ),
        RubricItem(
            icon = Res.drawable.icon_books,
            label = "Content Depth",
            score = 1.6f,
            max = 2f,
            scoreColor = Color(0xFF0D1B2E),
            barStart = Color(0xFFF5A623),
            barEnd = Color(0xFFD4881A)
        ),
        RubricItem(
            icon = Res.drawable.icon_search,
            label = "Critical Analysis",
            score = 1.5f,
            max = 2f,
            scoreColor = Color(0xFF0D1B2E),
            barStart = Color(0xFFF5A623),
            barEnd = Color(0xFFD4881A)
        ),
        RubricItem(
            icon = Res.drawable.icon_chart,
            label = "Examples & Data",
            score = 0.7f,
            max = 1f,
            scoreColor = Color(0xFFE74C3C), // node 1697:654
            barStart = Color(0xFFE74C3C),   // node 1697:656
            barEnd = Color(0xFFFF6B6B)
        ),
        RubricItem(
            icon = Res.drawable.icon_way_forward,
            label = "Way Forward",
            score = 1.7f,
            max = 2f,
            scoreColor = Color(0xFF0D1B2E),
            barStart = Color(0xFFF5A623),
            barEnd = Color(0xFFD4881A)
        ),
        RubricItem(
            icon = Res.drawable.icon_write,
            label = "Language & Presentation",
            score = 0.9f,
            max = 1f,
            scoreColor = Color(0xFF0D1B2E),
            barStart = Color(0xFFF5A623),
            barEnd = Color(0xFFD4881A)
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4FA))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(EVBg)
        ) {
            // Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("←", color = White70, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                    Spacer(Modifier.width(12.dp))
                    Text(
                        "DAILY ANSWER WRITING · STEP 3 OF 3",
                        color = GoldAccent,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(3) {
                        Box(Modifier.width(80.dp).height(4.dp).clip(RoundedCornerShape(4.dp)).background(GoldAccent))
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                // Score badge
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ScoreRingBadge(score = "7.5", suffix = "/10")
                    Spacer(Modifier.height(14.dp))
                    Text("Very Good Answer! 🎉", color = EVWhite, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.height(6.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Top 18th percentile", color = EVGray, fontSize = 12.sp)
                        Text("·", color = EVGray, fontSize = 12.sp)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xFF1A2540))
                                .padding(horizontal = 10.dp, vertical = 3.dp)
                        ) {
                            Text("+15 XP", color = GoldAccent, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                        Text("·", color = EVGray, fontSize = 12.sp)
                        Text("Rank Improved", color = Color(0xFF22C55E), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(EVBg)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
                    .padding(top = 16.dp, bottom = 32.dp)
            ) {
                // Rubric breakdown card
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(EVWhite)
                        .padding(20.dp)
                ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_chart),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Rubric Breakdown", color = Color(0xFF111827), fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(Modifier.height(16.dp))

                rubricItems.forEachIndexed { i, item ->
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                Image(
                                    painter = painterResource(item.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(Modifier.width(10.dp))
                                Text(item.label, color = Color(0xFF0D1B2E), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            }
                            Text(
                                "${item.score}/${item.max.toInt()}",
                                color = item.scoreColor,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        RubricProgressBar(
                            progress = item.score / item.max,
                            barBrush = Brush.linearGradient(listOf(item.barStart, item.barEnd)),
                            dotColor = item.barEnd
                        )
                        if (i < rubricItems.size - 1) Spacer(Modifier.height(16.dp))
                    }
                }
            }

                Spacer(Modifier.height(20.dp))

                // Action buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onViewMarkup,
                        modifier = Modifier.weight(1f).height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(Res.drawable.icon_clipboard),
                                contentDescription = null,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text("View Markup", color = Color(0xFF666666), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                    Box(
                        modifier = Modifier.weight(1f).height(48.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(GoldGradient)
                            .clickable { onWhatNext() },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(Res.drawable.icon_bolt),
                                contentDescription = null,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text("What Next?", color = Color(0xFF111827), fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RubricProgressBar(progress: Float, barBrush: Brush, dotColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFF5F5F5)) // node 1697:625 / 1697:655
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(progress.coerceIn(0f, 0.96f))
                .clip(RoundedCornerShape(6.dp))
                .background(barBrush)
        )
    }
}

@Composable
private fun ScoreRingBadge(score: String, suffix: String) {
    Box(
        modifier = Modifier.size(124.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(100.dp)) {
            // Base ring
            drawCircle(
                color = Color(0xFF2E323A),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 10.dp.toPx())
            )

            val stroke = androidx.compose.ui.graphics.drawscope.Stroke(
                width = 10.dp.toPx(),
                cap = androidx.compose.ui.graphics.StrokeCap.Round
            )
            val ringBrush = Brush.linearGradient(listOf(Color(0xFFF5A623), Color(0xFFD4881A)))
            val topLeft = androidx.compose.ui.geometry.Offset(5.dp.toPx(), 5.dp.toPx())
            val arcSize = androidx.compose.ui.geometry.Size(size.width - 10.dp.toPx(), size.height - 10.dp.toPx())
            val starts = listOf(-90f, 0f, 90f, 180f)
            starts.forEach { start ->
                drawArc(
                    brush = ringBrush,
                    startAngle = start,
                    sweepAngle = 42f,
                    useCenter = false,
                    topLeft = topLeft,
                    size = arcSize,
                    style = stroke
                )
            }
        }

        Row(verticalAlignment = Alignment.Bottom) {
            Text(score, color = GoldAccent, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = (-1).sp)
            Text(suffix, color = GoldAccent, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 5.dp))
        }
    }
}
