package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.myapplicationrisewithjeet.data.model.Question
import com.example.myapplicationrisewithjeet.data.model.sampleQuestions
import com.example.myapplicationrisewithjeet.ui.theme.*

@Composable
fun QuizScreen(subjectFilter: String? = null) {
    val questions = remember(subjectFilter) {
        if (subjectFilter != null)
            sampleQuestions.filter { it.subjectId == subjectFilter }.ifEmpty { sampleQuestions }
        else sampleQuestions
    }

    var currentIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var showExplanation by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }

    if (quizFinished) {
        QuizResultScreen(
            score = score,
            total = questions.size,
            onRetry = {
                currentIndex = 0
                selectedOption = null
                showExplanation = false
                score = 0
                quizFinished = false
            }
        )
        return
    }

    val question = questions[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(NavyBlue)
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "❓ Quiz",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Score: $score",
                        color = Gold,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LinearProgressIndicator(
                        progress = { (currentIndex + 1).toFloat() / questions.size },
                        modifier = Modifier
                            .weight(1f)
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = Saffron,
                        trackColor = Color.White.copy(0.3f)
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        "${currentIndex + 1}/${questions.size}",
                        color = Color.White.copy(0.85f),
                        fontSize = 13.sp
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            // Question card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    DifficultyBadge(question)
                    Spacer(Modifier.height(10.dp))
                    Text(
                        question.question,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = OnSurface,
                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            // Options
            question.options.forEachIndexed { index, option ->
                OptionItem(
                    text = option,
                    index = index,
                    selectedIndex = selectedOption,
                    correctIndex = question.correctIndex,
                    showResult = selectedOption != null,
                    onClick = {
                        if (selectedOption == null) {
                            selectedOption = index
                            if (index == question.correctIndex) score++
                            showExplanation = true
                        }
                    }
                )
                Spacer(Modifier.height(10.dp))
            }

            // Explanation
            AnimatedVisibility(visible = showExplanation) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedOption == question.correctIndex)
                            GreenContainer else Color(0xFFFFEBEE)
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            if (selectedOption == question.correctIndex) "✅ Correct!" else "❌ Incorrect",
                            fontWeight = FontWeight.Bold,
                            color = if (selectedOption == question.correctIndex) GreenIndia else WrongRed
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(question.explanation, fontSize = 13.sp, color = OnSurface, lineHeight = 20.sp)
                    }
                }
            }
        }

        // Next button
        if (selectedOption != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SurfaceLight)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        if (currentIndex < questions.size - 1) {
                            currentIndex++
                            selectedOption = null
                            showExplanation = false
                        } else {
                            quizFinished = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Saffron)
                ) {
                    Text(
                        if (currentIndex < questions.size - 1) "Next Question →" else "See Results",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun DifficultyBadge(question: Question) {
    val (color, label) = when (question.difficulty) {
        com.example.myapplicationrisewithjeet.data.model.Difficulty.EASY -> Pair(GreenContainer, "Easy")
        com.example.myapplicationrisewithjeet.data.model.Difficulty.MEDIUM -> Pair(GoldContainer, "Medium")
        com.example.myapplicationrisewithjeet.data.model.Difficulty.HARD -> Pair(Color(0xFFFFEBEE), "Hard")
    }
    val textColor = when (question.difficulty) {
        com.example.myapplicationrisewithjeet.data.model.Difficulty.EASY -> GreenIndia
        com.example.myapplicationrisewithjeet.data.model.Difficulty.MEDIUM -> Gold
        com.example.myapplicationrisewithjeet.data.model.Difficulty.HARD -> WrongRed
    }
    Box(
        modifier = Modifier
            .background(color, RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(label, fontSize = 11.sp, color = textColor, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun OptionItem(
    text: String,
    index: Int,
    selectedIndex: Int?,
    correctIndex: Int,
    showResult: Boolean,
    onClick: () -> Unit
) {
    val optionLabels = listOf("A", "B", "C", "D")

    val (bgColor, borderColor, textColor) = when {
        !showResult -> Triple(SurfaceLight, Outline, OnSurface)
        index == correctIndex -> Triple(GreenContainer, GreenIndia, GreenIndia)
        index == selectedIndex -> Triple(Color(0xFFFFEBEE), WrongRed, WrongRed)
        else -> Triple(SurfaceLight, Outline, OnSurfaceVariant)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
            .clickable(enabled = !showResult) { onClick() }
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(borderColor.copy(alpha = 0.15f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                optionLabels[index],
                fontWeight = FontWeight.Bold,
                color = borderColor,
                fontSize = 13.sp
            )
        }
        Spacer(Modifier.width(12.dp))
        Text(text, fontSize = 14.sp, color = textColor, modifier = Modifier.weight(1f))
    }
}

@Composable
fun QuizResultScreen(score: Int, total: Int, onRetry: () -> Unit) {
    val percentage = (score.toFloat() / total * 100).toInt()
    val (emoji, message) = when {
        percentage >= 80 -> Pair("🏆", "Excellent! Keep it up!")
        percentage >= 60 -> Pair("👍", "Good effort! Practice more.")
        percentage >= 40 -> Pair("📖", "Keep studying, you can do it!")
        else -> Pair("💪", "Don't give up! Revise & retry.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(emoji, fontSize = 64.sp)
        Spacer(Modifier.height(16.dp))
        Text("Quiz Complete!", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = OnSurface)
        Spacer(Modifier.height(8.dp))
        Text(message, fontSize = 16.sp, color = OnSurfaceVariant, textAlign = TextAlign.Center)
        Spacer(Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = SaffronContainer),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "$score / $total",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Saffron
                )
                Text("Correct Answers", fontSize = 14.sp, color = OnSurfaceVariant)
                Spacer(Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = { score.toFloat() / total },
                    modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
                    color = Saffron,
                    trackColor = Outline
                )
                Spacer(Modifier.height(6.dp))
                Text("$percentage% Score", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = SaffronDark)
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onRetry,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Saffron)
        ) {
            Text("Try Again 🔄", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}
