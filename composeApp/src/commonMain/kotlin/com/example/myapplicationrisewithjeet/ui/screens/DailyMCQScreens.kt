package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient
import com.example.myapplicationrisewithjeet.ui.theme.White
import com.example.myapplicationrisewithjeet.ui.theme.White70
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_economy
import myapplicationrisewithjeet.composeapp.generated.resources.mains_current_affairs
import myapplicationrisewithjeet.composeapp.generated.resources.mains_mix_bag
import myapplicationrisewithjeet.composeapp.generated.resources.mains_ncert
import myapplicationrisewithjeet.composeapp.generated.resources.mains_pyq
import myapplicationrisewithjeet.composeapp.generated.resources.mains_sectional
import myapplicationrisewithjeet.composeapp.generated.resources.mains_trophy
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_mock_test
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_next_steps
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_prev_chart
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_prev_trophy
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_search
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_target
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_timer
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_trophy
import myapplicationrisewithjeet.composeapp.generated.resources.daily_mcq_view_analysis
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_editorial
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_flashcards
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_header_icon
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_practice_target
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_retry
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_star
import myapplicationrisewithjeet.composeapp.generated.resources.daily_next_study_plan
import myapplicationrisewithjeet.composeapp.generated.resources.question_review_icon
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

// ─── Color tokens ──────────────────────────────────────────
private val DarkBg      = Color(0xFF061123)
private val CardBg      = Color.White
private val LightBg     = Color(0xFFF0F4FA)
private val DarkNavy    = Color(0xFF0D1B2E)
private val LabelGray   = Color(0xFF8A97B0)
private val GreenOk     = Color(0xFF4CAF50)
private val RedWrong    = Color(0xFFEF4444)
private val GoldBtn     = Color(0xFFF5A623)

// ═══════════════════════════════════════════════════════════
// SCREEN 1 — Daily MCQ Setup  (Image #12)
// ═══════════════════════════════════════════════════════════
@Composable
fun DailyMCQSetupScreen(
    onBack: () -> Unit = {},
    onStartChallenge: () -> Unit = {},
    onStartMockTest: () -> Unit = {}
) {
    var selectedSource   by remember { mutableStateOf("Sectional") }
    var selectedCount    by remember { mutableStateOf(25) }
    var selectedSubjects by remember { mutableStateOf(setOf("Polity", "Economy")) }
    var selectedTime     by remember { mutableStateOf("30 min") }

    val sources = listOf(
        Triple(Res.drawable.mains_sectional, "Sectional", "Single subject"),
        Triple(Res.drawable.mains_mix_bag, "Mix Bag", "All subjects"),
        Triple(Res.drawable.mains_pyq, "PYQ Based", "Past papers"),
        Triple(Res.drawable.mains_trophy, "Full Length", "PLT · 100 Qs"),
        Triple(Res.drawable.mains_ncert, "NCERT", "Book-wise"),
        Triple(Res.drawable.mains_current_affairs, "Curr. Affairs", "Last 6 months"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBg)
            .verticalScroll(rememberScrollState())
    ) {
        // Status bar spacer
        Spacer(Modifier.statusBarsPadding())

        // ── LIVE TODAY banner ─────────────────────────────
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(DarkBg)
                .padding(horizontal = 16.dp, vertical = 18.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(8.dp).clip(CircleShape)
                        .background(GreenOk)
                )
                Spacer(Modifier.width(6.dp))
                Text("LIVE TODAY", color = GreenOk, fontSize = 11.sp,
                    fontWeight = FontWeight.Bold, letterSpacing = 0.8.sp)
            }
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🎯", fontSize = 20.sp)
                Spacer(Modifier.width(8.dp))
                Text("Daily Prelims Challenge", color = White, fontSize = 19.sp,
                    fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ChipTag("10 Questions")
                ChipTag("18 Minutes")
                ChipTag("Polity Focus")
            }
            Spacer(Modifier.height(14.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(56.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(GoldGradient)
                    .clickable { onStartChallenge() },
                contentAlignment = Alignment.Center
            ) {
                Text("🚀  Start Daily Challenge", color = Color(0xFF1A1A1A),
                    fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }

        Spacer(Modifier.height(16.dp))

        // ── Prelims Mock Test heading on light background ─
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.daily_mcq_mock_test),
                contentDescription = "Prelims Mock Test",
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("Prelims Mock Test", color = DarkNavy, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(10.dp))

        // ── Prelims Mock Test card ────────────────────────
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFF7F8FC))
                .border(1.dp, Color(0xFFE2E8F2), RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            // Step 1: Question Source
            StepLabel("1", "Question Source")
            Spacer(Modifier.height(10.dp))
            val cols = sources.chunked(3)
            cols.forEach { row ->
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    row.forEach { (iconRes, label, sub) ->
                        val sel = selectedSource == label
                        Column(
                            modifier = Modifier.weight(1f)
                                .shadow(
                                    elevation = if (sel) 0.dp else 1.dp,
                                    shape = RoundedCornerShape(12.dp),
                                    clip = false
                                )
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (sel) DarkNavy else Color(0xFFFFFFFF))
                                .clickable { selectedSource = label }
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SourceIcon(icon = iconRes)
                            Spacer(Modifier.height(4.dp))
                            Text(label, color = if (sel) White else DarkNavy,
                                fontSize = 11.sp, fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center)
                            Text(sub, color = if (sel) White70 else LabelGray,
                                fontSize = 9.sp, textAlign = TextAlign.Center)
                        }
                    }
                    // fill remaining cells if row < 3
                    repeat(3 - row.size) { Spacer(Modifier.weight(1f)) }
                }
                Spacer(Modifier.height(8.dp))
            }

            Spacer(Modifier.height(8.dp))

            // Step 2: No. of Questions
            StepLabel("2", "No. of Questions")
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf(10, 25, 50, 75, 100).forEach { n ->
                    val sel = selectedCount == n
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (sel) DarkNavy else Color(0xFFF5F5F5))
                            .border(1.dp, if (sel) Color.Transparent else Color(0xFFE2EAF4),
                                RoundedCornerShape(12.dp))
                            .clickable { selectedCount = n }
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                    ) {
                        Text("$n", color = if (sel) White else DarkNavy,
                            fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Step 3: Subjects
            StepLabel("3", "Subjects")
            Spacer(Modifier.height(10.dp))
            val subjects = listOf(
                "⚖️" to "Polity", "🏛" to "History", "🔬" to "Sci&Tech",
                "💰" to "Economy", "🌍" to "Geography", "🌿" to "Env."
            )
            val subjectRows = subjects.chunked(3)
            subjectRows.forEach { row ->
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    row.forEach { (emoji, name) ->
                        val sel = selectedSubjects.contains(name)
                        Row(
                            modifier = Modifier.weight(1f)
                                .clip(RoundedCornerShape(50.dp))
                                .background(if (sel) DarkNavy else Color(0xFFF5F7FB))
                                .border(1.dp, if (sel) Color.Transparent else Color(0xFFE2EAF4),
                                    RoundedCornerShape(50.dp))
                                .clickable {
                                    selectedSubjects = if (sel)
                                        selectedSubjects - name
                                    else
                                        selectedSubjects + name
                                }
                                .padding(horizontal = 10.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            if (name == "Economy") {
                                Image(
                                    painter = painterResource(Res.drawable.daily_mcq_economy),
                                    contentDescription = "Economy",
                                    modifier = Modifier.size(14.dp)
                                )
                            } else {
                                Text(emoji, fontSize = 13.sp)
                            }
                            Spacer(Modifier.width(4.dp))
                            Text(name, color = if (sel) White else DarkNavy,
                                fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

            Spacer(Modifier.height(8.dp))

            // Step 4: Time Limit
            StepLabel("4", "Time Limit")
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("15 min", "30 min", "60 min", "No limit").forEach { t ->
                    val sel = selectedTime == t
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (sel) DarkNavy else Color(0xFFF5F7FB))
                            .border(1.dp, if (sel) Color.Transparent else Color(0xFFE2EAF4),
                                RoundedCornerShape(12.dp))
                            .clickable { selectedTime = t }
                            .padding(horizontal = 14.dp, vertical = 10.dp)
                    ) {
                        Text(t, color = if (sel) White else DarkNavy,
                            fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            // Start Mock Test button
            Box(
                modifier = Modifier.fillMaxWidth().height(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(GoldGradient)
                    .clickable { onStartMockTest() },
                contentAlignment = Alignment.Center
            ) {
                Text("⚡  Start Mock Test", color = Color(0xFF1A1A1A),
                    fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }

        Spacer(Modifier.height(16.dp))

        // ── Previous Challenges ───────────────────────────
        PreviousChallengesCard()

        Spacer(Modifier.height(40.dp))
    }
}

@Composable
private fun SourceIcon(icon: DrawableResource) {
    Image(
        painter = painterResource(icon),
        contentDescription = null,
        modifier = Modifier.size(26.dp)
    )
}

// ═══════════════════════════════════════════════════════════
// SCREEN 2 — Daily MCQ Challenge  (Image #13)
// ═══════════════════════════════════════════════════════════
@Composable
fun DailyMCQChallengeScreen(
    startImmediately: Boolean = false,
    onBack: () -> Unit = {},
    onSubmit: () -> Unit = {}
) {
    var started         by remember { mutableStateOf(startImmediately) }
    var currentQuestion by remember { mutableStateOf(0) }
    var selectedAnswer  by remember { mutableStateOf<String?>(null) }
    var answers         by remember { mutableStateOf(mapOf<Int, String>()) }

    val questions = sampleQuestions()

    if (!started) {
        // ── "Are You Ready?" screen ───────────────────────
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBg)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBg)
                    .statusBarsPadding()
                    .padding(top = 8.dp, bottom = 22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("←", color = White70, fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 20.dp)
                        .clickable { onBack() })
                Image(
                    painter = painterResource(Res.drawable.daily_mcq_target),
                    contentDescription = "Daily MCQ Challenge",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text("Daily MCQ Challenge", color = White, fontSize = 22.sp,
                    fontWeight = FontWeight.Bold)
                Text("10 questions · 12 minutes · Mixed",
                    color = White70, fontSize = 13.sp)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
                    .padding(top = 14.dp, bottom = 24.dp)
            ) {
                // Ready card
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(28.dp))
                        .background(CardBg)
                        .padding(horizontal = 20.dp, vertical = 22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFFFF3DC))
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Text("🔥 TODAY'S CHALLENGE – LIVE",
                            color = Color(0xFFB97A10), fontSize = 11.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(14.dp))
                    Text("Are You Ready?", color = DarkNavy, fontSize = 22.sp,
                        fontWeight = FontWeight.Bold)
                    Text("10 questions · Mixed subjects · 12 minutes",
                        color = LabelGray, fontSize = 12.sp)
                    Spacer(Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatBox("10",  "Questions")
                        StatBox("12",  "Minutes")
                        StatBox("847", "Attempted")
                    }
                    Spacer(Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth().height(52.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(GoldGradient)
                            .clickable { started = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🚀  Start Challenge", color = Color(0xFF1A1A1A),
                            fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }

                Spacer(Modifier.height(14.dp))
                PreviousChallengesCard()
                Spacer(Modifier.height(8.dp))
            }
        }
    } else {
        // ── MCQ Question screen ───────────────────────────
        val q = questions[currentQuestion]
        val answered = answers[currentQuestion]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBg)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.statusBarsPadding())

            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBFCFF))
                    .border(1.dp, Color(0xFFE8ECF3))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("←", color = Color(0xFF6B7280), fontSize = 16.sp,
                    modifier = Modifier.clickable {
                        if (currentQuestion == 0) {
                            if (startImmediately) onBack() else started = false
                        }
                        else currentQuestion--
                    })
                Spacer(Modifier.weight(1f))
                Text("Question ${currentQuestion + 1}/${questions.size}",
                    color = DarkNavy, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFEFF2F8))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.daily_mcq_timer),
                            contentDescription = "Timer",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text("9:11", color = Color(0xFF1F2937), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            HorizontalDivider(color = Color(0xFFE8ECF3), thickness = 1.dp)

            // Question number dots
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFBFCFF))
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                questions.take(8).forEachIndexed { idx, _ ->
                    Box(
                        modifier = Modifier.size(36.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                when {
                                    idx == currentQuestion -> DarkNavy
                                    answers.containsKey(idx) -> Color(0xFFDDE4F3)
                                    else -> Color(0xFFF0F2F6)
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("${idx + 1}",
                            color = if (idx == currentQuestion) White else DarkNavy,
                            fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            HorizontalDivider(color = Color(0xFFE8ECF3), thickness = 1.dp)

            Spacer(Modifier.height(16.dp))

            // Question content on page background (no outer card)
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(q.subject, color = LabelGray, fontSize = 10.sp,
                    fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                Spacer(Modifier.height(8.dp))
                Text(q.text, color = DarkNavy, fontSize = 14.sp,
                    lineHeight = 22.sp, fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(16.dp))

                q.options.forEachIndexed { idx, option ->
                    val letter = listOf("A", "B", "C", "D")[idx]
                    val isSelected = answered == letter
                    val isCorrect  = letter == q.correctAnswer
                    val showResult = answered != null

                    val bgColor = when {
                        showResult && isCorrect  -> Color(0xFFEAF6E8)
                        showResult && isSelected && !isCorrect -> Color(0xFFFDF1F1)
                        isSelected -> Color(0xFFFFFFFF)
                        else -> Color(0xFFFFFFFF)
                    }
                    val borderColor = when {
                        showResult && isCorrect  -> Color(0xFF79BC64)
                        showResult && isSelected && !isCorrect -> Color(0xFFE46153)
                        isSelected -> Color(0xFFE0E0E0)
                        else -> Color(0xFFE0E0E0)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(94.dp)
                            .padding(bottom = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(bgColor)
                            .border(1.6.dp, borderColor, RoundedCornerShape(12.dp))
                            .clickable {
                                if (answered == null) {
                                    answers = answers + (currentQuestion to letter)
                                }
                            }
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.size(28.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    when {
                                        showResult && isCorrect -> Color(0xFF6DB34E)
                                        showResult && isSelected && !isCorrect -> Color(0xFFF6E7E7)
                                        else -> Color(0xFFF1F3F6)
                                    }
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(letter, color = when {
                                showResult && isCorrect -> White
                                showResult && isSelected && !isCorrect -> Color(0xFFD35A4B)
                                else -> Color(0xFF6B7280)
                            }, fontSize = 12.sp,
                                fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.width(12.dp))
                        Text(option, color = DarkNavy, fontSize = 13.sp,
                            modifier = Modifier.weight(1f))
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Navigation buttons
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(87.dp)
                        .height(39.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFEAEFF6), RoundedCornerShape(12.dp))
                        .clickable { if (currentQuestion > 0) currentQuestion-- },
                    contentAlignment = Alignment.Center
                ) {
                    Text("← Prev", color = Color(0xFF6B7280), fontWeight = FontWeight.SemiBold)
                }
                Box(
                    modifier = Modifier.weight(1f).height(46.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(DarkNavy)
                        .clickable {
                            if (currentQuestion < questions.size - 1) currentQuestion++
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Next", color = White, fontWeight = FontWeight.SemiBold)
                }
            }

            Spacer(Modifier.height(8.dp))

            // Submit button (always visible at bottom)
            Row(
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(87.dp)
                        .height(39.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFEAEFF6), RoundedCornerShape(12.dp))
                        .clickable { if (currentQuestion > 0) currentQuestion-- },
                    contentAlignment = Alignment.Center
                ) {
                    Text("← Prev", color = Color(0xFF6B7280), fontWeight = FontWeight.SemiBold)
                }
                Box(
                    modifier = Modifier.weight(1f).height(46.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(GoldGradient)
                        .clickable { onSubmit() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Submit Test ✓", color = Color(0xFF1A1A1A),
                        fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(40.dp))
        }
    }
}

// ═══════════════════════════════════════════════════════════
// SCREEN 3 — Daily MCQ Result  (Image #14)
// ═══════════════════════════════════════════════════════════
@Composable
fun DailyMCQResultScreen(
    onBack: () -> Unit = {},
    onViewAnalysis: () -> Unit = {},
    onNextSteps: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.statusBarsPadding())

        Text("←", color = White70, fontSize = 16.sp,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
                .clickable { onBack() })

        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.size(94.dp)
                    .clip(CircleShape)
                    .border(3.dp, GoldBtn, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("6/10", color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("Score", color = White70, fontSize = 11.sp)
                }
            }
            Spacer(Modifier.height(14.dp))
            Text("Daily MCQs Completed!", color = White, fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text("Great effort! Here's your performance analysis",
                color = White70, fontSize = 12.sp)
        }

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(LightBg)
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Column {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    StatCard(modifier = Modifier.weight(1f), label = "ACCURACY", value = "60%", valueColor = Color(0xFF3D6FA3))
                    StatCard(modifier = Modifier.weight(1f), label = "TIME TAKEN", value = "8m 42s", valueColor = DarkNavy)
                }
                Spacer(Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    StatCard(modifier = Modifier.weight(1f), label = "SPEED", value = "1.74/Q", valueColor = Color(0xFF3D6FA3))
                    StatCard(modifier = Modifier.weight(1f), label = "RANK", value = "Top 42%", valueColor = Color(0xFFC68A22))
                }
            }

            Spacer(Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)).background(CardBg)
                    .padding(16.dp)
            ) {
                Text("Score Breakdown", color = DarkNavy, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(12.dp))
                BreakdownRow("Correct", GreenOk, 0.6f, "6")
                Spacer(Modifier.height(8.dp))
                BreakdownRow("Wrong", Color(0xFFC73D3D), 0.3f, "3")
                Spacer(Modifier.height(8.dp))
                BreakdownRow("Skipped", Color(0xFFD9DFEA), 0.1f, "1")
            }

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                ResultInsightCard(
                    modifier = Modifier.weight(1f),
                    title = "Strong in:",
                    titleColor = Color(0xFF4C8A53),
                    leadingEmoji = "💪",
                    items = listOf("Fundamental Rights", "Right to Equality", "Judicial Review"),
                    markerText = "✓",
                    markerColor = Color(0xFF4C8A53),
                )
                ResultInsightCard(
                    modifier = Modifier.weight(1f),
                    title = "Needs revision:",
                    titleColor = Color(0xFFB03A3A),
                    leadingIcon = Res.drawable.daily_mcq_search,
                    items = listOf("Const. Remedies", "DPSP Principles", "Writs Art. 32"),
                    markerText = "!",
                    markerColor = Color(0xFFD85D4E),
                )
            }

            Spacer(Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    modifier = Modifier.weight(1f).height(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(1.dp, Color(0xFFD5DCE8), RoundedCornerShape(12.dp))
                        .background(CardBg)
                        .clickable { onViewAnalysis() },
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.daily_mcq_view_analysis),
                            contentDescription = "View Analysis",
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text("View Analysis", color = DarkNavy, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
                Box(
                    modifier = Modifier.weight(1f).height(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(GoldGradient)
                        .clickable { onNextSteps() },
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.daily_mcq_next_steps),
                            contentDescription = "Next Steps",
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text("Next Steps", color = Color(0xFF1A1A1A), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(28.dp))
        }
    }
}

// ═══════════════════════════════════════════════════════════
// SCREEN 4 — Question Review  (Image #15)
// ═══════════════════════════════════════════════════════════
@Composable
fun DailyMCQReviewScreen(
    onBack: () -> Unit = {},
    onNextSteps: () -> Unit = {}
) {
    var filter by remember { mutableStateOf("All") }

    val reviewItems = listOf(
        ReviewItem(1, "POLITY", false,
            "With reference to the \"Doctrine of Basic Structure\" — which is/are correct?",
            userAnswer = "A", correctAnswer = "D",
            userAnswerText = "Golaknath case (1967)",
            correctAnswerText = "Both B and C are correct",
            explanation = "Established in Kesavananda Bharati (1973). Golaknath restricted FR amendment — a different doctrine. Parliament cannot destroy the basic structure via amendments."
        ),
        ReviewItem(2, "POLITY", true,
            "Which article grants the right to constitutional remedies — the \"heart and soul\" of the Constitution?",
            userAnswer = "B", correctAnswer = "B",
            userAnswerText = "Article 32",
            correctAnswerText = "Article 32",
            explanation = "Article 32 allows citizens to approach the Supreme Court directly for enforcement of Fundamental Rights. Dr. Ambedkar called it the \"heart and soul of the Constitution.\""
        ),
        ReviewItem(3, "ECONOMY", false,
            "Which of the following is NOT a function of the Reserve Bank of India?",
            userAnswer = "B", correctAnswer = "C",
            userAnswerText = "Regulating insurance companies",
            correctAnswerText = "Regulating stock exchanges",
            explanation = "Stock exchanges are regulated by SEBI, not RBI. Insurance is regulated by IRDAI. Both are outside RBI's jurisdiction."
        ),
    )

    val filtered = when (filter) {
        "Wrong"   -> reviewItems.filter { !it.isCorrect }
        "Correct" -> reviewItems.filter { it.isCorrect }
        else      -> reviewItems
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.statusBarsPadding())

        Text("←", color = White70, fontSize = 16.sp,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
                .clickable { onBack() })

        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.question_review_icon),
                contentDescription = "Question Review",
                modifier = Modifier.size(54.dp)
            )
            Spacer(Modifier.height(6.dp))
            Text("Question Review", color = White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            listOf("All (10)", "Wrong (3)", "Correct (6)").forEach { tab ->
                val key = tab.substringBefore(" ")
                val sel = filter == key
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .background(if (sel) GoldBtn else Color(0xFF2A3348))
                        .clickable { filter = key }
                        .padding(horizontal = 22.dp, vertical = 11.dp)
                ) {
                    Text(
                        tab,
                        color = if (sel) Color(0xFF0F172A) else Color(0xFFE5E7EB),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(LightBg)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                filtered.forEach { item ->
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp)).background(CardBg)
                            .padding(14.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(
                                        if (item.isCorrect) Color(0xFFEAF6E8)
                                        else Color(0xFFF3E7E9)
                                    )
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    "${item.number}",
                                    color = if (item.isCorrect) Color(0xFF4FA25B) else Color(0xFFC95445),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(Modifier.width(8.dp))
                            Text("${item.subject} · ${if (item.isCorrect) "CORRECT" else "INCORRECT"}", color = if (item.isCorrect) Color(0xFF4FA25B) else Color(0xFFC95445), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(item.question, color = DarkNavy, fontSize = 13.sp, lineHeight = 19.sp)
                        Spacer(Modifier.height(10.dp))

                        if (!item.isCorrect) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFFEF2F2))
                                    .border(1.dp, Color(0xFFE46153), RoundedCornerShape(10.dp))
                                    .padding(horizontal = 10.dp, vertical = 9.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    item.userAnswer,
                                    color = RedWrong,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(item.userAnswerText, color = DarkNavy, fontSize = 14.sp, modifier = Modifier.weight(1f), lineHeight = 20.sp)
                                Text("✗ Your\nanswer", color = Color(0xFFD65546), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            }
                            Spacer(Modifier.height(6.dp))
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFF0F9ED))
                                .border(1.dp, Color(0xFF79BC64), RoundedCornerShape(10.dp))
                                .padding(horizontal = 10.dp, vertical = 9.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                item.correctAnswer,
                                color = GreenOk,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(item.correctAnswerText, color = DarkNavy, fontSize = 14.sp, modifier = Modifier.weight(1f), lineHeight = 20.sp)
                            Text("✓ Correct", color = Color(0xFF5CA552), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }

                        Spacer(Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFF5F7FA))
                                .padding(12.dp)
                        ) {
                            Column {
                                Text("EXPLANATION", color = LabelGray, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                                Spacer(Modifier.height(4.dp))
                                Text(item.explanation, color = Color(0xFF4B5563), fontSize = 11.sp, lineHeight = 19.sp)
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .border(1.dp, Color(0xFFD5DCE8), RoundedCornerShape(12.dp))
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                Text("← Back to Results", color = DarkNavy, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.height(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(50.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(GoldGradient)
                    .clickable { onNextSteps() },
                contentAlignment = Alignment.Center
            ) {
                Text("View Smart Next Steps", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
        }
    }
}

private data class ReviewItem(
    val number: Int, val subject: String, val isCorrect: Boolean,
    val question: String, val userAnswer: String, val correctAnswer: String,
    val userAnswerText: String, val correctAnswerText: String, val explanation: String
)

// ═══════════════════════════════════════════════════════════
// SCREEN 5 — What to do Next  (Image #16)
// ═══════════════════════════════════════════════════════════
@Composable
fun DailyMCQNextStepsScreen(
    onBack: () -> Unit = {},
    onHome: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.statusBarsPadding())

        Text("←", color = White70, fontSize = 16.sp,
            modifier = Modifier.padding(start = 20.dp, top = 8.dp)
                .clickable { onBack() })

        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.daily_next_header_icon),
                contentDescription = "Next steps",
                modifier = Modifier.size(36.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                buildAnnotatedString {
                    append("What would you like to do")
                    withStyle(SpanStyle(color = GoldAccent)) { append(" next?") }
                },
                color = White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
            Spacer(Modifier.height(4.dp))
            Text("Smart recommendations based on your performance", color = White70, fontSize = 13.sp, textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp))
        }

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(LightBg)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            NextStepCard(
                icon = Res.drawable.daily_next_practice_target,
                title = "Practice Weak Topics",
                subtitle = "10 mixed-level questions on Constitutional\nRemedies & DPSP to improve overall accuracy",
                tag = "Recommended", tagBg = Color(0xFFFFF3DC), tagColor = Color(0xFFB97A10),
                tagIcon = Res.drawable.daily_next_star,
                highlighted = false
            )
            NextStepCard(
                icon = Res.drawable.daily_next_study_plan,
                title = "Add to Today's Study Plan",
                subtitle = "Schedule 30 mins for Polity revision in your\ndaily calendar",
                tag = "+30 min", tagBg = Color(0xFFEEF2FF), tagColor = Color(0xFF6366F1),
                highlighted = false
            )
            NextStepCard(
                icon = Res.drawable.daily_next_flashcards,
                title = "Add to Flashcards",
                subtitle = "Focus on Constitutional Remedies & DPSP\nwith targeted flashcard practice",
                tag = "3 new cards", tagBg = Color(0xFFDCFCE7), tagColor = GreenOk,
                highlighted = false
            )
            NextStepCard(
                icon = Res.drawable.daily_next_editorial,
                title = "Read Today's Editorial",
                subtitle = "Today's editorial on DPSP: \"The Right-Duty\nBalance\"",
                tag = "5 min read", tagBg = Color(0xFFF0F9FF), tagColor = Color(0xFF0EA5E9),
                highlighted = false
            )
            NextStepCard(
                icon = Res.drawable.daily_next_retry,
                title = "Retry Today's Challenge",
                subtitle = "Today's score from 6/10 —\ndaily challenges can be retried",
                tag = "Improve score", tagBg = Color(0xFFFFF3DC), tagColor = Color(0xFFB97A10),
                highlighted = true,
                onClick = onHome
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}

// ═══════════════════════════════════════════════════════════
// Shared components
// ═══════════════════════════════════════════════════════════

@Composable
private fun ChipTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0xFF1B2741))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text, color = Color(0xFFB8C1D3), fontSize = 12.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun StepLabel(number: String, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier.size(22.dp).clip(CircleShape).background(DarkNavy),
            contentAlignment = Alignment.Center
        ) { Text(number, color = White, fontSize = 11.sp, fontWeight = FontWeight.Bold) }
        Spacer(Modifier.width(8.dp))
        Text(label, color = DarkNavy, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun PreviousChallengesCard() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp).fillMaxWidth()
            .clip(RoundedCornerShape(22.dp)).background(Color(0xFFFFFFFF))
            .border(1.dp, Color(0xFFEDEFF4), RoundedCornerShape(22.dp))
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(Res.drawable.daily_mcq_trophy),
                contentDescription = "Previous Challenges",
                modifier = Modifier.size(16.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("Previous Challenges", color = DarkNavy, fontSize = 15.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
            Text("See All →", color = GoldAccent, fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold)
        }
        Spacer(Modifier.height(12.dp))
        PrevChallengeRow(Res.drawable.daily_mcq_prev_trophy, "Mar 18 · Tuesday", "History & Polity · 12 min",
            "9/10", Color(0xFFDCE9FF), Color(0xFF3E6BC2))
        Spacer(Modifier.height(8.dp))
        PrevChallengeRow(Res.drawable.daily_mcq_prev_chart, "Mar 17 · Monday", "Economy & Env · 10 min",
            "7/10", Color(0xFFF0E5FF), Color(0xFF7A4BB0))
    }
}

@Composable
private fun PrevChallengeRow(
    icon: DrawableResource, title: String, sub: String,
    score: String, scoreBg: Color, scoreColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFFF9F9F9))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = title,
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = DarkNavy, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            Text(sub, color = LabelGray, fontSize = 11.sp)
        }
        Box(
            modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(scoreBg)
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Text(score, color = scoreColor, fontSize = 13.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun StatBox(value: String, label: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp)).background(Color(0xFFF5F7FB))
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = DarkNavy, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(label, color = LabelGray, fontSize = 11.sp)
    }
}

@Composable
private fun StatCard(modifier: Modifier, label: String, value: String, valueColor: Color) {
    Column(
        modifier = modifier
            .height(130.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(CardBg)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label, color = LabelGray, fontSize = 10.sp,
            fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp, textAlign = TextAlign.Center)
        Spacer(Modifier.height(8.dp))
        Text(value, color = valueColor, fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
private fun BreakdownRow(label: String, color: Color, fraction: Float, count: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = color, fontSize = 13.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.width(60.dp))
        Spacer(Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(10.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFFE6EBF3))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction.coerceIn(0f, 1f))
                    .clip(RoundedCornerShape(6.dp))
                    .background(color)
            )
        }
        Spacer(Modifier.width(8.dp))
        Text(count, color = DarkNavy, fontSize = 13.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.width(20.dp), textAlign = TextAlign.End)
    }
}

@Composable
private fun ResultInsightCard(
    modifier: Modifier = Modifier,
    title: String,
    titleColor: Color,
    leadingIcon: DrawableResource? = null,
    leadingEmoji: String? = null,
    items: List<String>,
    markerText: String,
    markerColor: Color,
) {
    Column(
        modifier = modifier
            .shadow(7.dp, RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(CardBg)
            .border(1.dp, Color(0xFFD6DEEB), RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                Image(
                    painter = painterResource(leadingIcon),
                    contentDescription = title,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                Text(leadingEmoji ?: "", fontSize = 22.sp)
            }
            Spacer(Modifier.width(8.dp))
            Text(title, color = titleColor, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(10.dp))
        items.forEachIndexed { index, item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(markerText, color = markerColor, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(8.dp))
                Text(item, color = Color(0xFF3C4962), fontSize = 16.sp)
            }
            if (index < items.lastIndex) {
                HorizontalDivider(
                    color = Color(0xFFD4DCE8),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun NextStepCard(
    icon: DrawableResource, title: String, subtitle: String,
    tag: String, tagBg: Color, tagColor: Color,
    highlighted: Boolean,
    tagIcon: DrawableResource? = null,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .then(
                if (highlighted) Modifier.border(1.5.dp, GoldBtn, RoundedCornerShape(16.dp))
                else Modifier
            )
            .background(CardBg)
            .clickable { onClick() }
            .border(1.dp, if (highlighted) Color(0xFFE2A532) else Color(0xFFE3E8F1), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF7F2E8)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = title,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, color = if (highlighted) Color(0xFFD89A24) else DarkNavy, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(2.dp))
                Text(subtitle, color = Color(0xFF7A8499), fontSize = 13.sp, lineHeight = 20.sp)
                Spacer(Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(tagBg)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (tagIcon != null) {
                            Image(
                                painter = painterResource(tagIcon),
                                contentDescription = tag,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                        }
                        Text(tag, color = tagColor, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

// ─── Sample data ───────────────────────────────────────────
private data class MCQQuestion(
    val subject: String, val text: String,
    val options: List<String>, val correctAnswer: String
)

private fun sampleQuestions() = listOf(
    MCQQuestion(
        "POLITY · UPSC 2024 STYLE",
        "With reference to the \"Doctrine of Basic Structure\" in the Indian Constitution, which of the following statements is/are correct?",
        listOf(
            "It was first propounded in the Golaknath case (1967)",
            "Parliament cannot amend the basic features of the Constitution",
            "It was established in Kesavananda Bharati case (1973)",
            "Both B and C are correct"
        ),
        "D"
    ),
    MCQQuestion(
        "POLITY · UPSC 2023 STYLE",
        "Which article grants the right to constitutional remedies — the \"heart and soul\" of the Constitution?",
        listOf("Article 19", "Article 32", "Article 21", "Article 226"),
        "B"
    ),
    MCQQuestion(
        "ECONOMY · UPSC 2022 STYLE",
        "Which of the following is NOT a function of the Reserve Bank of India?",
        listOf("Banker to the Government", "Regulating insurance companies",
            "Regulating stock exchanges", "Issue of currency notes"),
        "C"
    ),
)
