package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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

private val FSDark  = Color(0xFF111827)
private val FSLight = Color(0xFFF4F6FB)
private val FSGray  = Color(0xFF9CA3AF)
private val FSWhite = Color.White

@Composable
fun FlashcardStudyScreen(topicId: String, onBack: () -> Unit) {
    val topic = polityTopics.find { it.id == topicId } ?: polityTopics[1]

    var flipped      by remember { mutableStateOf(false) }
    var cardIndex    by remember { mutableStateOf(0) }
    var questionText by remember { mutableStateOf("") }
    var answerText   by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(FSLight).verticalScroll(rememberScrollState())
    ) {
        // ── Dark header ──────────────────────────────────────
        Column(
            modifier = Modifier.fillMaxWidth().background(FSDark).statusBarsPadding().padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("←", color = White70, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(topic.emoji, fontSize = 18.sp)
                    Spacer(Modifier.width(6.dp))
                    Text(topic.name.replace("\n", " "), color = FSWhite, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(Modifier.width(24.dp))
            }

            Spacer(Modifier.height(10.dp))

            // Progress bar + counter
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                LinearProgressIndicator(
                    progress = { (cardIndex + 1) / topic.nodeCount.toFloat() },
                    modifier = Modifier.weight(1f).height(4.dp).clip(RoundedCornerShape(2.dp)),
                    color = GoldAccent,
                    trackColor = Color(0xFF374151)
                )
                Spacer(Modifier.width(10.dp))
                Text("${cardIndex + 1} / ${topic.nodeCount}", color = FSGray, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(16.dp))

        // ── Flashcard ────────────────────────────────────────
        AnimatedContent(
            targetState = flipped,
            transitionSpec = { fadeIn(tween(200)) togetherWith fadeOut(tween(200)) }
        ) { isFlipped ->
            if (!isFlipped) {
                // Question side
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(FSWhite)
                        .clickable { flipped = true }
                        .padding(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xFFFFF8E1))
                                .padding(horizontal = 12.dp, vertical = 5.dp)
                        ) {
                            Text("🔖 INDIAN POLITY · TAP TO FLIP ▼", color = Color(0xFF92400E), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }

                        Spacer(Modifier.height(16.dp))

                        Text(
                            "What is the \"Basic Structure Doctrine\" and which landmark case established it in Indian constitutional law?",
                            color = FSDark,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            lineHeight = 25.sp
                        )

                        Spacer(Modifier.height(14.dp))

                        Text(
                            "💡 Hint: 1973 · 13-Judge Bench · Changed everything",
                            color = GoldAccent,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )

                        Spacer(Modifier.height(12.dp))

                        Text("17 / 48 cards reviewed today", color = FSGray, fontSize = 12.sp)
                        Spacer(Modifier.height(6.dp))
                        LinearProgressIndicator(
                            progress = { 17f / 48f },
                            modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                            color = GoldAccent,
                            trackColor = Color(0xFFE5E7EB)
                        )

                        Spacer(Modifier.height(14.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("↺", color = FSGray, fontSize = 14.sp)
                            Spacer(Modifier.width(4.dp))
                            Text("Tap card to flip", color = FSGray, fontSize = 13.sp)
                        }
                    }
                }
            } else {
                // Answer side
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(FSDark)
                        .clickable { flipped = false }
                        .padding(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(Color(0xFF166534)).padding(horizontal = 12.dp, vertical = 5.dp)
                        ) {
                            Text("✅ ANSWER", color = Color(0xFF22C55E), fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
                        }
                        Spacer(Modifier.height(14.dp))
                        Text("Kesavananda Bharati Case\n(1973)", color = GoldAccent, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, lineHeight = 25.sp)
                        Spacer(Modifier.height(12.dp))
                        Text(
                            "The Basic Structure Doctrine holds that Parliament cannot amend the Constitution in a way that destroys its essential features — federalism, judicial review, fundamental rights, free elections, and democratic governance. The 13-judge bench ruled 7–6.",
                            color = FSWhite,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 21.sp
                        )
                        Spacer(Modifier.height(14.dp))
                        Text("17 / 48 cards reviewed today", color = FSGray, fontSize = 12.sp)
                    }
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        // ── Rating buttons ───────────────────────────────────
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            RatingButton(Modifier.weight(1f), "😤", "Nope",   Color(0xFFFEF2F2), Color(0xFFEF4444)) { flipped = false; if (cardIndex > 0) cardIndex-- }
            RatingButton(Modifier.weight(1f), "🤔", "Hmm",    Color(0xFFFFFBEB), GoldAccent)          { flipped = false }
            RatingButton(Modifier.weight(1f), "😎", "Got It!", Color(0xFFF0FDF4), Color(0xFF22C55E))  { flipped = false; if (cardIndex < topic.nodeCount - 1) cardIndex++ }
        }

        Spacer(Modifier.height(20.dp))

        // ── Add New Card section ──────────────────────────────
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("+", color = FSDark, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.width(6.dp))
                Text("Add New Card to This Topic", color = FSDark, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = questionText,
                onValueChange = { questionText = it },
                placeholder = { Text("Question / Term (front of card)", color = FSGray, fontSize = 13.sp) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = FSWhite, unfocusedContainerColor = FSWhite, focusedBorderColor = GoldAccent, unfocusedBorderColor = Color(0xFFE5E7EB)),
                singleLine = true
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = answerText,
                onValueChange = { answerText = it },
                placeholder = { Text("Answer / Definition (back of card)", color = FSGray, fontSize = 13.sp) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = FSWhite, unfocusedContainerColor = FSWhite, focusedBorderColor = GoldAccent, unfocusedBorderColor = Color(0xFFE5E7EB)),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))
            Button(
                onClick = { questionText = ""; answerText = "" },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FSDark)
            ) {
                Text("Add Card →", color = FSWhite, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth().clickable {},
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("+", color = FSGray, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(6.dp))
                Text("Add New Topic / Card Set", color = FSGray, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun RatingButton(modifier: Modifier, emoji: String, label: String, bg: Color, labelColor: Color, onClick: () -> Unit) {
    Column(
        modifier = modifier.clip(RoundedCornerShape(14.dp)).background(bg).clickable { onClick() }.padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(emoji, fontSize = 24.sp)
        Spacer(Modifier.height(4.dp))
        Text(label, color = labelColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}
