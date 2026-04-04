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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

private val AiBg = Color(0xFF0C1631)
private val AiSurface = Color(0xFFF0F3F9)
private val AiCard = Color(0xFFFFFFFF)
private val AiBorder = Color(0xFFD9DFEA)
private val AiText = Color(0xFF24314F)
private val AiMuted = Color(0xFF7E88A5)

private const val DailyFreeLimit = 5

private data class ChatMessage(
    val fromUser: Boolean,
    val text: String
)

@Composable
fun JeetAIScreen(onBack: () -> Unit) {
    var inputText by remember { mutableStateOf("") }
    var usedQueries by remember { mutableStateOf(3) }
    var isPremium by remember { mutableStateOf(false) }

    val messages = remember {
        mutableStateListOf(
            ChatMessage(fromUser = true, text = "Explain Indian federalism in detail"),
            ChatMessage(
                fromUser = false,
                text = "Indian federalism blends federal and unitary features.\n• Art 1 defines Union of States\n• Strong Union with 3 lists\n• GST Council supports cooperative federalism"
            )
        )
    }

    val remainingQueries = if (isPremium) Int.MAX_VALUE else (DailyFreeLimit - usedQueries).coerceAtLeast(0)
    val canSend = inputText.isNotBlank() && (isPremium || remainingQueries > 0)

    fun sendPrompt(text: String) {
        val cleaned = text.trim()
        if (cleaned.isEmpty()) return
        if (!isPremium && remainingQueries <= 0) return

        messages.add(ChatMessage(fromUser = true, text = cleaned))
        messages.add(ChatMessage(fromUser = false, text = generateJeetAIReply(cleaned)))
        if (!isPremium) usedQueries += 1
        inputText = ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AiBg)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("←", color = Color(0xFFB3BED8), fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
                Spacer(Modifier.width(8.dp))
                Text("JEET AI", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(8.dp))
            Text("16  JEET AI CHAT", color = Color(0xFFA4B0CD), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp))
                .background(AiSurface)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(AiCard)
                    .border(1.dp, AiBorder, RoundedCornerShape(14.dp))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(30.dp).clip(CircleShape).background(Color(0xFF1D2A4C)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🤖", fontSize = 14.sp)
                        }
                        Spacer(Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Jeet AI Tutor", color = AiText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Text("AI UPSC Tutor • Always on", color = AiMuted, fontSize = 10.sp)
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF121A31))
                                .clickable { isPremium = true }
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Text(if (isPremium) "Premium" else "Upgrade", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFAFBFF))
                            .border(1.dp, AiBorder, RoundedCornerShape(10.dp))
                            .padding(10.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                if (isPremium) "Unlimited queries available" else "$remainingQueries queries left today",
                                color = AiText,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text("I can explain topics, analyze PYQs, review answers, create plans, and much more.", color = AiMuted, fontSize = 10.sp)
                        }
                    }

                    messages.takeLast(6).forEach { message ->
                        if (message.fromUser) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFF172242))
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text(message.text, color = Color.White, fontSize = 10.sp)
                            }
                        } else {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFF6F8FD))
                                    .border(1.dp, AiBorder, RoundedCornerShape(10.dp))
                                    .padding(10.dp)
                            ) {
                                Text(message.text, color = AiMuted, fontSize = 10.sp, lineHeight = 14.sp)
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf(
                            "# Federalism" to "Explain Indian federalism in detail",
                            "# Polity" to "Summarize core Polity topics for prelims revision",
                            "# Review answer" to "Review this mains answer and suggest improvements",
                            "# PYQ 2026" to "Give me 5 PYQ-style questions on governance"
                        ).forEach { (chip, prompt) ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFE7ECF8))
                                    .clickable { inputText = prompt }
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(chip, color = AiMuted, fontSize = 9.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = inputText,
                            onValueChange = { inputText = it },
                            modifier = Modifier.weight(1f),
                            placeholder = { Text("Ask anything about UPSC...", color = Color(0xFFA0A9BF), fontSize = 10.sp) },
                            textStyle = androidx.compose.ui.text.TextStyle(color = AiText, fontSize = 11.sp),
                            shape = RoundedCornerShape(12.dp),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = AiBorder,
                                unfocusedBorderColor = AiBorder,
                                focusedContainerColor = Color(0xFFF3F5FB),
                                unfocusedContainerColor = Color(0xFFF3F5FB)
                            )
                        )
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(if (canSend) Color(0xFF172242) else Color(0xFFB5BDD0))
                                .clickable(enabled = canSend) { sendPrompt(inputText) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text("➤", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Spacer(Modifier.height(12.dp))
            Text("17  JEET AI LIMIT", color = Color(0xFFA4B0CD), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(AiCard)
                    .border(1.dp, AiBorder, RoundedCornerShape(14.dp))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(30.dp).clip(CircleShape).background(Color(0xFF1D2A4C)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🤖", fontSize = 14.sp)
                        }
                        Spacer(Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Jeet AI Tutor", color = AiText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Text(if (isPremium) "Premium Active" else "AI UPSC Tutor • Always on", color = AiMuted, fontSize = 10.sp)
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF121A31))
                                .clickable { isPremium = true }
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Text(if (isPremium) "Premium" else "Upgrade", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    if (isPremium || remainingQueries > 0) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFEFF8EF))
                                .border(1.dp, Color(0xFFC9E8CB), RoundedCornerShape(10.dp))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("✅", fontSize = 18.sp)
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    if (isPremium) "Unlimited AI queries enabled" else "$remainingQueries free queries remaining",
                                    color = AiText,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    if (isPremium) "You can ask as many questions as you want." else "Use your remaining queries for today.",
                                    color = AiMuted,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFFFF6E8))
                                .border(1.dp, Color(0xFFF2DDAF), RoundedCornerShape(10.dp))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("🔒", fontSize = 20.sp)
                                Spacer(Modifier.height(4.dp))
                                Text("You've used all 5 free queries", color = AiText, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                Text("Upgrade to Premium for unlimited access to AI.", color = AiMuted, fontSize = 10.sp)
                                Spacer(Modifier.height(8.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(GoldGradient)
                                        .clickable { isPremium = true }
                                        .padding(vertical = 8.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Upgrade to Pro - Unlimited Queries", color = Color(0xFF1A223B), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun generateJeetAIReply(prompt: String): String {
    val lower = prompt.lowercase()
    return when {
        "federal" in lower -> {
            "Indian federalism is quasi-federal.\n• Constitution creates a Union of States (Art 1)\n• Union has stronger powers during emergencies\n• Cooperative mechanisms like GST Council improve Centre-State coordination"
        }
        "polity" in lower -> {
            "Focus on these Polity buckets:\n• Constitutional framework and amendments\n• Parliament, President, PM, Judiciary\n• Federalism, Local governance, Constitutional bodies\nUse PYQs to identify recurring themes before revision."
        }
        "review" in lower || "answer" in lower -> {
            "Quick review: strengthen structure.\n1. Start with a 2-line intro and definition\n2. Add 3-4 balanced arguments with examples\n3. End with a practical way forward linked to governance outcomes"
        }
        else -> {
            "Good question. I can break this into prelims facts, mains arguments, and PYQ angles. Share your target exam stage and I will tailor a focused answer."
        }
    }
}
