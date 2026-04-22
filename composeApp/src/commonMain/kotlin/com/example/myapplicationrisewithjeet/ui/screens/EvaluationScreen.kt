package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
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

private enum class EvalPhase { LOADING, RESULTS }

private data class AnalysisStep(val icon: DrawableResource, val title: String, val subtitle: String, val done: Boolean)

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
        AnalysisStep(Res.drawable.icon_note, "Structural Analysis",         "Checking introduction-body-conclusion flow",    true),
        AnalysisStep(Res.drawable.icon_books, "Content Depth Assessment",    "Evaluating breadth and depth of dimensions",    true),
        AnalysisStep(Res.drawable.icon_scales, "Balance & Perspective Check", "Ensuring multi-dimensional viewpoint",           true),
        AnalysisStep(Res.drawable.icon_chart, "Fact & Example Validation",   "Cross-verifying with latest data",               countdown < 15),
        AnalysisStep(Res.drawable.icon_diamond_blue, "6-Pillar Rubric Scoring",     "Depth · Demand · Structure · Substantiation",   false),
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
                Spacer(Modifier.width(28.dp))
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
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(Modifier.weight(1f).height(4.dp).clip(RoundedCornerShape(2.dp)).background(GoldAccent))
                Box(Modifier.weight(1f).height(4.dp).clip(RoundedCornerShape(2.dp)).background(GoldAccent))
                Box(Modifier.weight(1f).height(4.dp).clip(RoundedCornerShape(2.dp)).background(White15))
            }
            Spacer(Modifier.height(12.dp))
            Text("GS Paper II Question", color = EVWhite, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        }

        Spacer(Modifier.height(8.dp))

        // Main white card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(EVWhite)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("🧠", fontSize = 52.sp)
            Spacer(Modifier.height(14.dp))
            Text("Evaluating Your Answer", color = Color(0xFF111827), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(4.dp))
            Text("Analyzing with UPSC examiner's lens", color = EVGray, fontSize = 13.sp)
            Spacer(Modifier.height(20.dp))

            // Analysis steps
            analysisSteps.forEach { step ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(step.icon),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp).width(28.dp)
                    )
                    Spacer(Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(step.title, color = Color(0xFF111827), fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        Text(step.subtitle, color = EVGray, fontSize = 11.sp)
                    }
                    when {
                        step.done -> Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF22C55E)),
                            contentAlignment = Alignment.Center
                        ) { Text("✓", color = EVWhite, fontSize = 12.sp, fontWeight = FontWeight.Bold) }
                        step.title.contains("Fact") -> Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(GoldGradient),
                            contentAlignment = Alignment.Center
                        ) { Text("◔", color = EVWhite, fontSize = 12.sp) }
                        else -> Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFE5E7EB)),
                            contentAlignment = Alignment.Center
                        ) { Text("○", color = EVGray, fontSize = 12.sp) }
                    }
                }
                HorizontalDivider(color = Color(0xFFF3F4F6), thickness = 1.dp)
            }

            Spacer(Modifier.height(16.dp))

            // Countdown box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFF8E1))
                    .padding(14.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.icon_timer),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            "$countdown Seconds Remaining",
                            color = Color(0xFF92400E),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "While you wait: This 60-second pause is deliberate. In the actual exam, this is the time you'd spend reviewing your answer. Use this moment to mentally note one improvement you could make.",
                        color = Color(0xFF78350F),
                        fontSize = 11.sp,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}

// ── Step 3: Results ──────────────────────────────────────────

private data class RubricItem(val icon: DrawableResource, val label: String, val score: Float, val max: Float, val color: Color)

@Composable
private fun EvaluationResultsContent(
    onBack: () -> Unit,
    onViewMarkup: () -> Unit,
    onWhatNext: () -> Unit
) {
    val rubricItems = listOf(
        RubricItem(Res.drawable.icon_note, "Introduction & Context", 1.8f, 2f, Color(0xFF22C55E)),
        RubricItem(Res.drawable.icon_books, "Content Depth",          1.6f, 2f, Color(0xFFF0A500)),
        RubricItem(Res.drawable.icon_search, "Critical Analysis",      1.5f, 2f, Color(0xFFF0A500)),
        RubricItem(Res.drawable.icon_chart, "Examples & Data",        0.7f, 1f, Color(0xFFEF4444)),
        RubricItem(Res.drawable.icon_way_forward, "Way Forward",            1.7f, 2f, Color(0xFF22C55E)),
        RubricItem(Res.drawable.icon_write, "Language & Presentation",0.9f, 1f, Color(0xFFF0A500)),
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
                Text("←", color = White70, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(12.dp))
                Text(
                    "DAILY ANSWER WRITING · STEP 3 OF 3",
                    color = GoldAccent,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                repeat(3) {
                    Box(Modifier.weight(1f).height(4.dp).clip(RoundedCornerShape(2.dp)).background(GoldAccent))
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        // Score badge
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .clip(RoundedCornerShape(55.dp))
                    .background(Color(0x33F0A500))
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(55.dp))
                        .background(Color(0x55F0A500)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "7.5/10",
                        color = GoldAccent,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
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

        Spacer(Modifier.height(20.dp))

        // Rubric breakdown card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(20.dp))
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
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(item.label, color = Color(0xFF374151), fontSize = 13.sp, fontWeight = FontWeight.Medium)
                        }
                        Text(
                            "${item.score}/${item.max.toInt()}",
                            color = item.color,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { item.score / item.max },
                        modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp)),
                        color = item.color,
                        trackColor = Color(0xFFF3F4F6)
                    )
                    if (i < rubricItems.size - 1) Spacer(Modifier.height(14.dp))
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
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(14.dp),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_clipboard),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("View Markup", color = Color(0xFF6B7280), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
            Box(
                modifier = Modifier.weight(1f).height(50.dp)
                    .clip(RoundedCornerShape(14.dp))
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
                    Text("What Next?", color = Color(0xFF111827), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}
