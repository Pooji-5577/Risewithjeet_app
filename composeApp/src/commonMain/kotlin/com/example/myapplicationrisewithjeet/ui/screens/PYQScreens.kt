package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private val PyqBg = Color(0xFF0D1737)
private val PyqHero = Color(0xFF1D284D)
private val PyqSurface = Color(0xFFF1F4FA)
private val PyqCard = Color(0xFFFFFFFF)
private val PyqText = Color(0xFF27314E)
private val PyqMuted = Color(0xFF7F8AA9)
private val PyqBorder = Color(0xFFD7DEEA)
private val PyqBlue = Color(0xFF1E2C53)
private val PyqGreen = Color(0xFF46A95E)
private val PyqGold = Color(0xFFD49527)
private val PyqRed = Color(0xFFD96464)

@Composable
fun PYQHomeScreen(onBack: () -> Unit, onStart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PyqBg)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFB3BED8), fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(8.dp))
                Text("PYQ HOME", color = Color(0xFFA7B4D2), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            Text("RiseWithJeet", color = Color(0xFFF4C14B), fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(10.dp))
            Text("Previous Year", color = Color.White, fontSize = 44.sp, fontWeight = FontWeight.ExtraBold)
            Text("Questions 📚", color = Color(0xFFF0B43A), fontSize = 44.sp, fontWeight = FontWeight.ExtraBold)
            Text(
                "Every UPSC question ever asked - Prelims & Mains - with AI-powered explanations.",
                color = Color(0xFF9FACCB),
                fontSize = 12.sp,
                lineHeight = 17.sp
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                HeroMetric("12,400", "QUESTIONS")
                HeroMetric("14 yrs", "COVERAGE")
                HeroMetric("100%", "MAPPED")
                HeroMetric("AI", "MAINS")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                .background(PyqSurface)
                .padding(12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                TopModeCard(Modifier.weight(1f), "🎯", "Prelims", "10,200 questions", true)
                TopModeCard(Modifier.weight(1f), "✍️", "Mains", "2,200 questions", false)
            }
            Spacer(Modifier.height(10.dp))
            Text("YOUR PROGRESS", color = Color(0xFFA2AEC7), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(6.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                ProgressCard("✅", "284", "Qs Attempted", 0.35f, Color(0xFF51B267), Modifier.weight(1f))
                ProgressCard("🎯", "76%", "Accuracy", 0.76f, PyqGold, Modifier.weight(1f))
            }
            Spacer(Modifier.height(10.dp))
            Text("RECENTLY PRACTICED", color = Color(0xFFA2AEC7), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(6.dp))
            RecentRow("⚖️", "Polity — Fundamental Rights", "2024 · 10 Qs · 2 hours ago", "8/10", Color(0xFF4BA45D))
            Spacer(Modifier.height(6.dp))
            RecentRow("💰", "Economy — RBI & Monetary Policy", "2023 · 10 Qs · Yesterday", "6/10", Color(0xFFD05A5A))
            Spacer(Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(GoldGradient)
                    .clickable { onStart() },
                contentAlignment = Alignment.Center
            ) {
                Text("📚 Start Practicing PYQs →", color = Color(0xFF1A223B), fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun PYQSubjectSelectScreen(onBack: () -> Unit, onOpenSubject: () -> Unit) {
    val subjects = listOf(
        Triple("🏛", "History & Culture", "5 sub-topics · 39 topics · 340 PYQs") to 0.21f,
        Triple("🌍", "Geography", "6 sub-topics · 38 topics · 289 PYQs") to 0.0f,
        Triple("⚖️", "Indian Polity", "8 sub-topics · 42 topics · 220 PYQs") to 0.38f,
        Triple("💰", "Indian Economy", "7 sub-topics · 27 topics · 258 PYQs") to 0.12f,
        Triple("🌿", "Environment", "5 sub-topics · 34 topics · 198 PYQs") to 0.0f,
        Triple("🔬", "Science & Technology", "4 sub-topics · 26 topics · 55 PYQs") to 0.0f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PyqBg)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .background(PyqHero)
                .padding(14.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("PYQ Bank", color = Color(0xFFAFC0E3), fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text("Step 1 of 3 · Pick Subject", color = Color(0xFF9FB1D6), fontSize = 11.sp)
            }
            Spacer(Modifier.height(6.dp))
            Text("📋 Subjects", color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.ExtraBold)
            Text("Select a subject to explore its topics", color = Color(0xFF9FB1D6), fontSize = 12.sp)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Chip("🎯 Prelims", true)
                Chip("✍️ Mains", false)
                Chip("🗂 Optional", false)
            }
        }

        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp)) {
            Text("PRELIMS GENERAL STUDIES", color = Color(0xFF9FAAC5), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            subjects.forEachIndexed { idx, (meta, progress) ->
                SubjectRow(
                    icon = meta.first,
                    title = meta.second,
                    sub = meta.third,
                    progress = progress,
                    onClick = { if (idx == 0) onOpenSubject() }
                )
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun PYQSubjectTopicsScreen(onBack: () -> Unit, onStartQuestions: () -> Unit) {
    val topics = listOf(
        Triple("🏺", "Ancient India", "1 / 8") to 0.13f,
        Triple("🏰", "Medieval India", "0 / 8") to 0.0f,
        Triple("🇮🇳", "Modern India", "4 / 9") to 0.44f,
        Triple("🎨", "Art & Architecture", "2 / 6") to 0.33f,
        Triple("🎭", "Performing Arts & Crafts", "1 / 8") to 0.13f
    )

    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .background(PyqHero)
                .padding(14.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("Subjects", color = Color(0xFFAFC0E3), fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text("Step 2 of 3", color = Color(0xFF9FB1D6), fontSize = 11.sp)
            }
            Spacer(Modifier.height(6.dp))
            Text("🏛  History & Culture", color = Color.White, fontSize = 31.sp, fontWeight = FontWeight.ExtraBold)
            Text("5 sub-topics · 8 done · 21%", color = Color(0xFF9FB1D6), fontSize = 12.sp)
            Spacer(Modifier.height(8.dp))
            Text("Subject Progress", color = Color(0xFF9FB1D6), fontSize = 11.sp)
            LinearProgressIndicator(
                progress = { 0.21f },
                modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp)),
                color = PyqGold,
                trackColor = Color(0xFF344061)
            )
        }

        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(14.dp)).padding(12.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    topics.forEachIndexed { idx, (meta, progress) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (idx == 3) Color(0xFFFFF8EC) else Color.Transparent)
                                .clickable { if (idx == 3) onStartQuestions() }
                                .padding(horizontal = 4.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(meta.first, fontSize = 20.sp)
                            Spacer(Modifier.width(8.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(meta.second, color = PyqText, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                                Text("${(progress * 100).toInt()}% complete", color = PyqMuted, fontSize = 11.sp)
                            }
                            Text(meta.third, color = if (progress > 0f) PyqGold else PyqMuted, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFFFF6E4))
                    .border(1.dp, Color(0xFFF0DEB5), RoundedCornerShape(12.dp))
                    .padding(10.dp)
            ) {
                Text("🤖  Jeet AI Insight  ·  Art & Architecture — 12 PYQs in last 5 years. Practice it next!", color = PyqGold, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
fun PYQQuestionScreen(onBack: () -> Unit, onSubmit: () -> Unit) {
    var selected by remember { mutableStateOf("C") }
    val options = listOf("1 only", "1 and 2 only", "2 and 3 only", "1, 2 and 3 all")

    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding().background(PyqHero).padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 16.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("Back", color = Color(0xFFAFC0E3), fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text("Question 1/9", color = Color(0xFFB5C4E2), fontSize = 12.sp)
                Spacer(Modifier.width(8.dp))
                Text("01:42", color = Color(0xFFF0B43A), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.fillMaxWidth()) {
                (1..9).forEach {
                    Box(
                        modifier = Modifier.size(28.dp).clip(RoundedCornerShape(8.dp)).background(if (it == 3) Color(0xFF1E2C53) else Color(0xFF30406A)),
                        contentAlignment = Alignment.Center
                    ) { Text("$it", color = Color.White, fontSize = 11.sp) }
                }
            }
        }

        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(14.dp)).padding(12.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("HISTORY  ·  PRELIMS QUESTION #19", color = PyqMuted, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    Text("With reference to Mauryan Empire, consider the following statements:", color = PyqText, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    Text("Ashoka was the first ruler to issue rock edicts.\nPataliputra was the Mauryan capital.\nArthashastra was written by Chanakya.", color = PyqMuted, fontSize = 11.sp, lineHeight = 15.sp)
                    options.forEachIndexed { idx, text ->
                        val letter = listOf("A", "B", "C", "D")[idx]
                        val isSel = selected == letter
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSel) Color(0xFFE9EEF9) else Color(0xFFF8FAFE))
                                .border(1.dp, if (isSel) PyqBlue else PyqBorder, RoundedCornerShape(10.dp))
                                .clickable { selected = letter }
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.size(22.dp).clip(RoundedCornerShape(6.dp)).background(if (isSel) PyqBlue else Color(0xFFDDE3F0)), contentAlignment = Alignment.Center) {
                                Text(letter, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                            Spacer(Modifier.width(8.dp))
                            Text(text, color = PyqText, fontSize = 12.sp)
                        }
                    }
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                ActionBtn("← Prev", Color(0xFFE1E7F2), PyqText, Modifier.weight(1f)) { onBack() }
                ActionBtn("Skip", Color(0xFFFFF2DA), PyqGold, Modifier.weight(1f)) {}
                ActionBtn("Submit Test ✓", Color.Transparent, Color(0xFF1A223B), Modifier.weight(1f), gradient = true) { onSubmit() }
            }
        }
    }
}

@Composable
fun PYQSessionResultScreen(onBack: () -> Unit, onReview: () -> Unit, onMainsEval: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("PYQ Session Complete!", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(8.dp))
            Box(modifier = Modifier.size(92.dp).clip(CircleShape).background(Color(0xFF1B2749)).border(3.dp, PyqGold, CircleShape), contentAlignment = Alignment.Center) {
                Text("8/10", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                StatMini("80%", "ACCURACY", Modifier.weight(1f))
                StatMini("8m 42s", "TIME", Modifier.weight(1f))
                StatMini("1.1 /Q", "SPEED", Modifier.weight(1f))
                StatMini("Top 28%", "RANK", Modifier.weight(1f))
            }
        }
        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(14.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(14.dp)).padding(12.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Score Breakdown", color = PyqText, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Breakdown("Correct", PyqGreen, 0.8f)
                    Breakdown("Wrong", PyqRed, 0.2f)
                    Breakdown("Skipped", Color(0xFFB3BDD2), 0.1f)
                }
            }
            Spacer(Modifier.height(10.dp))
            ActionBtn("Review Answers", Color(0xFFE1E7F2), PyqText, Modifier.fillMaxWidth()) { onReview() }
            Spacer(Modifier.height(8.dp))
            ActionBtn("AI Evaluating...", Color.Transparent, Color(0xFF1A223B), Modifier.fillMaxWidth(), gradient = true) { onMainsEval() }
        }
    }
}

@Composable
fun PYQReviewScreen(onBack: () -> Unit, onAIScore: () -> Unit) {
    val items = listOf(
        Triple("Doctrine of Basic Structure - which statement/s correct?", false, "2 and 3 only"),
        Triple("Which article is 'heart and soul' of the Constitution?", true, "Article 32")
    )

    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("QUESTION REVIEW", color = Color(0xFFAFC0E3), fontSize = 11.sp)
            }
            Spacer(Modifier.height(6.dp))
            Text("Question Review", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                Chip("All (10)", true)
                Chip("Wrong (3)", false)
                Chip("Correct (6)", false)
                Chip("Skipped (1)", false)
            }
        }

        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items.forEachIndexed { idx, item ->
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(12.dp)).padding(12.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("${idx + 1}  POLITY · UPSC 2024  ${if (item.second) "✓ CORRECT" else "✗ INCORRECT"}", color = if (item.second) PyqGreen else PyqRed, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Text(item.first, color = PyqText, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        Text("Correct answer: ${item.third}", color = PyqGreen, fontSize = 11.sp)
                    }
                }
            }
            Spacer(Modifier.height(4.dp))
            ActionBtn("AI Score Results", Color.Transparent, Color(0xFF1A223B), Modifier.fillMaxWidth(), gradient = true) { onAIScore() }
        }
    }
}

@Composable
fun PYQAIScoreScreen(onBack: () -> Unit, onDone: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("AI SCORE RESULTS", color = Color(0xFFAFC0E3), fontSize = 11.sp)
            }
            Spacer(Modifier.height(6.dp))
            Box(modifier = Modifier.size(104.dp).clip(CircleShape).background(Color(0xFF1E2C53)).border(4.dp, PyqGreen, CircleShape), contentAlignment = Alignment.Center) {
                Text("8.5", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(6.dp))
            Text("Excellent Answer!", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ScoreLine("Content & Accuracy", "4.5 / 5")
            ScoreLine("Structure", "4 / 5")
            ScoreLine("Constitutional Provisions", "3.5 / 5")
            ScoreLine("AI Recommendation", "Add Art. 247 + Panchayat citations")
            ActionBtn("Done →", Color.Transparent, Color(0xFF1A223B), Modifier.fillMaxWidth(), gradient = true) { onDone() }
        }
    }
}

@Composable
fun PYQMainsEvalScreen(onBack: () -> Unit, onWhatNext: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding().background(PyqHero).padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("Home", color = Color(0xFFAFC0E3), fontSize = 11.sp)
                Spacer(Modifier.weight(1f))
                Text("Step 1/3", color = Color(0xFFF0B43A), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(4.dp))
            Text("Mains Evaluation", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
        }
        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(PyqBlue).padding(10.dp)) {
                Column {
                    Text("The collegium system has more advantages than disadvantages. (Critically examine)", color = Color.White, fontSize = 12.sp)
                    Text("250 words · 2024 · Judiciary", color = Color(0xFFB2C0DF), fontSize = 10.sp)
                }
            }
            Box(modifier = Modifier.fillMaxWidth().height(140.dp).clip(RoundedCornerShape(12.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("📸", fontSize = 28.sp)
                    Text("Tap to Click Photo of your Answer", color = PyqText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text("OCR + AI evaluation", color = PyqMuted, fontSize = 10.sp)
                }
            }
            Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(12.dp)).padding(10.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("Previous Challenges", color = PyqText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    PrevChallenge("RTI vs Privacy Balance", "9.0/10")
                    PrevChallenge("Cooperative Federalism in GST", "8.2/10")
                    PrevChallenge("Electoral Bonds Controversy", "7.5/10")
                }
            }
            ActionBtn("Next: AI Evaluation →", Color.Transparent, Color(0xFF1A223B), Modifier.fillMaxWidth(), gradient = true) { onWhatNext() }
        }
    }
}

@Composable
fun PYQWhatNextScreen(onBack: () -> Unit, onHome: () -> Unit) {
    val cards = listOf(
        "Practice Weak Topics — PYQs",
        "Add to Today's Study Plan",
        "Add Weak Topics to Flashcards",
        "Try Medieval India Next",
        "Read Today's Editorial",
        "Retry Today's Session"
    )

    Column(modifier = Modifier.fillMaxSize().background(PyqBg).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth().statusBarsPadding().background(PyqHero).padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFAFC0E3), fontSize = 18.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(6.dp))
                Text("Back to Results", color = Color(0xFFAFC0E3), fontSize = 11.sp)
            }
            Spacer(Modifier.height(6.dp))
            Text("What next, Arjun?", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
            Text("Smart AI recommendations based on your performance", color = Color(0xFF9FB1D6), fontSize = 12.sp)
        }
        Column(modifier = Modifier.fillMaxWidth().background(PyqSurface).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            cards.forEach { c ->
                Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(12.dp)).padding(12.dp)) {
                    Text(c, color = PyqText, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            ActionBtn("Go Home →", Color.Transparent, Color(0xFF1A223B), Modifier.fillMaxWidth(), gradient = true) { onHome() }
        }
    }
}

@Composable
private fun HeroMetric(value: String, label: String) {
    Column(
        modifier = Modifier
            .widthIn(min = 74.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF2A3558))
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = Color(0xFFF0B43A), fontSize = 21.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = Color(0xFF98A6C6), fontSize = 9.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun TopModeCard(modifier: Modifier, icon: String, title: String, sub: String, selected: Boolean) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) PyqBlue else PyqCard)
            .border(1.dp, if (selected) PyqBlue else PyqBorder, RoundedCornerShape(12.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon, fontSize = 18.sp)
        Spacer(Modifier.width(6.dp))
        Column {
            Text(title, color = if (selected) Color.White else PyqText, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(sub, color = if (selected) Color(0xFFB6C2DF) else PyqMuted, fontSize = 10.sp)
        }
    }
}

@Composable
private fun ProgressCard(icon: String, value: String, label: String, progress: Float, color: Color, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(PyqCard)
            .border(1.dp, PyqBorder, RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Text(icon, fontSize = 16.sp)
        Text(value, color = PyqText, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = PyqMuted, fontSize = 10.sp)
        Spacer(Modifier.height(6.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth().height(5.dp).clip(RoundedCornerShape(3.dp)),
            color = color,
            trackColor = Color(0xFFE5EAF4)
        )
    }
}

@Composable
private fun RecentRow(icon: String, title: String, sub: String, score: String, scoreColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(PyqCard)
            .border(1.dp, PyqBorder, RoundedCornerShape(12.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(36.dp).clip(RoundedCornerShape(10.dp)).background(Color(0xFFF0F3FA)), contentAlignment = Alignment.Center) {
            Text(icon, fontSize = 16.sp)
        }
        Spacer(Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = PyqText, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(sub, color = PyqMuted, fontSize = 10.sp)
        }
        Text(score, color = scoreColor, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
private fun SubjectRow(icon: String, title: String, sub: String, progress: Float, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(PyqCard)
            .border(1.dp, PyqBorder, RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(38.dp).clip(RoundedCornerShape(10.dp)).background(Color(0xFFF0F3FA)), contentAlignment = Alignment.Center) {
            Text(icon, fontSize = 18.sp)
        }
        Spacer(Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = PyqText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text(sub, color = PyqMuted, fontSize = 10.sp)
        }
        Text("${(progress * 100).toInt()}%", color = if (progress > 0f) Color(0xFF6A61D1) else PyqMuted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.width(6.dp))
        Text("›", color = Color(0xFFBBC4D8), fontSize = 16.sp)
    }
}

@Composable
private fun Chip(text: String, selected: Boolean) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(if (selected) Color(0xFFF2B139) else Color(0xFF29385F))
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(text, color = if (selected) Color(0xFF1A223B) else Color(0xFFCAD4EA), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun ActionBtn(label: String, bg: Color, fg: Color, modifier: Modifier, gradient: Boolean = false, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(46.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (gradient) Color.Transparent else bg)
            .let {
                if (gradient) it.background(GoldGradient) else it
            }
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = fg, fontSize = 12.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
private fun StatMini(value: String, label: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(PyqCard)
            .border(1.dp, PyqBorder, RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = PyqText, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
        Text(label, color = PyqMuted, fontSize = 8.sp)
    }
}

@Composable
private fun Breakdown(label: String, color: Color, progress: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = PyqMuted, fontSize = 11.sp, modifier = Modifier.width(60.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.weight(1f).height(5.dp).clip(RoundedCornerShape(3.dp)),
            color = color,
            trackColor = Color(0xFFE5EAF4)
        )
    }
}

@Composable
private fun ScoreLine(title: String, value: String) {
    Box(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)).background(PyqCard).border(1.dp, PyqBorder, RoundedCornerShape(10.dp)).padding(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(title, color = PyqText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            Text(value, color = PyqGreen, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun PrevChallenge(title: String, score: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(title, color = PyqText, fontSize = 11.sp)
        Text(score, color = PyqGold, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}
