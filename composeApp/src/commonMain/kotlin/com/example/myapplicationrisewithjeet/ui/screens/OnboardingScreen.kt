package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.upsc_2027_calendar
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val PageBg      = Color(0xFFEEF0FB)
private val CardBg      = Color(0xFFFFFFFF)
private val DarkSelected= Color(0xFF1A1F3A)
private val BorderColor = Color(0xFFE2E5F0)
private val BackgroundOptionBg = Color(0xFFF5F5F5)
private val BackgroundOptionBorder = Color(0xFFE0E0E0)
private val LabelGray   = Color(0xFF6B7280)
private val TitleDark   = Color(0xFF111827)

private data class YearOptionItem(
    val iconEmoji: String? = null,
    val iconRes: DrawableResource? = null,
    val label: String,
    val sublabel: String = ""
)

@Composable
fun OnboardingScreen(onContinue: () -> Unit) {
    var currentStep by remember { mutableStateOf(0) }

    when (currentStep) {
        0 -> StepName      { currentStep = 1 }
        1 -> StepBackground{ currentStep = 2 }
        2 -> StepPrepLevel { onContinue() }
    }
}

// ─────────────────────────────────────────────
// Shared scaffold
// ─────────────────────────────────────────────

@Composable
private fun OnboardingScaffold(
    step: Int,
    totalSteps: Int = 3,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(20.dp))

            // Progress indicator bars
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                repeat(totalSteps) { i ->
                    val isActive = i == step
                    Box(
                        modifier = Modifier
                            .height(4.dp)
                            .width(if (isActive) 36.dp else 20.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(if (isActive) GoldAccent else Color(0xFFD1D5DB))
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            // White card with shadow
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .shadow(elevation = 12.dp, shape = RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp))
                    .background(CardBg)
                    .padding(horizontal = 22.dp, vertical = 28.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = content
                )
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

// ─────────────────────────────────────────────
// Step 1 — What's your name?
// ─────────────────────────────────────────────

@Composable
private fun StepName(onNext: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var selectedYear by remember { mutableStateOf(0) }

    val years = listOf(
        YearOptionItem(iconEmoji = "🎯", label = "UPSC 2026"),
        YearOptionItem(iconRes = Res.drawable.upsc_2027_calendar, label = "UPSC 2027"),
        YearOptionItem(iconEmoji = "📚", label = "UPSC 2028"),
        YearOptionItem(iconEmoji = "🌱", label = "Exploring", sublabel = "Just starting out"),
    )

    OnboardingScaffold(step = 0) {
        Text("🌟", fontSize = 52.sp)
        Spacer(Modifier.height(14.dp))
        Text(
            "What's your name?",
            color = TitleDark,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(6.dp))
        Text(
            "Let us personalize your journey",
            color = LabelGray,
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        // Name field
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Text(
                "YOUR NAME",
                color = LabelGray,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.6.sp
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("e.g. Rahul Sharma", color = Color(0xFFB0B7C3), fontSize = 14.sp)
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = GoldAccent,
                    unfocusedBorderColor = BorderColor,
                    focusedContainerColor = CardBg,
                    unfocusedContainerColor = CardBg,
                    focusedTextColor = TitleDark,
                    unfocusedTextColor = TitleDark,
                    cursorColor = GoldAccent
                )
            )
        }

        Spacer(Modifier.height(20.dp))

        // Year selector
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Text(
                "TARGET YEAR (optional)",
                color = LabelGray,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.6.sp
            )
            Spacer(Modifier.height(10.dp))
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                years.chunked(2).forEachIndexed { rowIdx, row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        row.forEachIndexed { colIdx, option ->
                            val index = rowIdx * 2 + colIdx
                            val selected = index == selectedYear
                            YearOptionCard(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1.05f),
                                iconEmoji = option.iconEmoji,
                                iconRes = option.iconRes,
                                label = option.label,
                                sublabel = option.sublabel,
                                selected = selected,
                                onClick = { selectedYear = index }
                            )
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(26.dp))

        OnboardingButton(text = "Next →", onClick = onNext)
    }
}

@Composable
private fun YearOptionCard(
    modifier: Modifier,
    iconEmoji: String?,
    iconRes: DrawableResource?,
    label: String,
    sublabel: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) Color(0xFFFFF8E6) else CardBg)
            .border(
                width = if (selected) 2.dp else 1.dp,
                color = if (selected) GoldAccent else BorderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (iconRes != null) {
                Image(
                    painter = painterResource(iconRes),
                    contentDescription = label,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(iconEmoji.orEmpty(), fontSize = 24.sp)
            }
            Spacer(Modifier.height(6.dp))
            Text(
                label,
                color = if (selected) GoldAccent else TitleDark,
                fontSize = 13.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            if (sublabel.isNotEmpty()) {
                Spacer(Modifier.height(2.dp))
                Text(
                    sublabel,
                    color = LabelGray,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// ─────────────────────────────────────────────
// Step 2 — Your Background
// ─────────────────────────────────────────────

@Composable
private fun StepBackground(onNext: () -> Unit) {
    var selected by remember { mutableStateOf(0) }

    val options = listOf(
        "🎒" to "College\nStudent",
        "💼" to "Working\nProfessional",
        "🏠" to "Full-time\nAspirant",
        "⚡" to "Hybrid\nLearner",
    )

    OnboardingScaffold(step = 1) {
        Text("🎓", fontSize = 42.sp)
        Spacer(Modifier.height(14.dp))
        Text(
            "Your Background",
            color = TitleDark,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(6.dp))
        Text(
            "Help us tailor the right plan for you",
            color = LabelGray,
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            options.chunked(2).forEachIndexed { rowIdx, row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    row.forEachIndexed { colIdx, (emoji, label) ->
                        val index = rowIdx * 2 + colIdx
                        val isSelected = index == selected
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1.05f)
                                .clip(RoundedCornerShape(14.dp))
                                .background(if (isSelected) DarkSelected else BackgroundOptionBg)
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) DarkSelected else BackgroundOptionBorder,
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .clickable { selected = index },
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(emoji, fontSize = 30.sp)
                                Spacer(Modifier.height(8.dp))
                                Text(
                                    label,
                                    color = if (isSelected) Color.White else TitleDark,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(26.dp))

        OnboardingButton(text = "Next →", onClick = onNext)
    }
}

// ─────────────────────────────────────────────
// Step 3 — Preparation Level?
// ─────────────────────────────────────────────

@Composable
private fun StepPrepLevel(onFinish: () -> Unit) {
    var selected by remember { mutableStateOf(3) }

    val options = listOf(
        "🌱" to "Just Starting",
        "📚" to "6+ Months in",
        "🎯" to "Appeared\nOnce",
        "🏆" to "Multiple\nAttempts",
    )

    OnboardingScaffold(step = 2) {
        Text("🚀", fontSize = 42.sp)
        Spacer(Modifier.height(14.dp))
        Text(
            "Preparation Level?",
            color = TitleDark,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(6.dp))
        Text(
            "So we know where to begin",
            color = LabelGray,
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(24.dp))

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            options.chunked(2).forEachIndexed { rowIdx, row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    row.forEachIndexed { colIdx, (emoji, label) ->
                        val index = rowIdx * 2 + colIdx
                        val isSelected = index == selected
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1.05f)
                                .clip(RoundedCornerShape(14.dp))
                                .background(if (isSelected) DarkSelected else BackgroundOptionBg)
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) DarkSelected else BackgroundOptionBorder,
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .clickable { selected = index },
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(emoji, fontSize = 30.sp)
                                Spacer(Modifier.height(8.dp))
                                Text(
                                    label,
                                    color = if (isSelected) Color.White else TitleDark,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(26.dp))

        OnboardingButton(text = "Let's Start Rising! 🔥", onClick = onFinish)
    }
}

// ─────────────────────────────────────────────
// Shared button
// ─────────────────────────────────────────────

@Composable
private fun OnboardingButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(GoldGradient)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = Color(0xFF1A1A1A),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}
