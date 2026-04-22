package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MockTestGeneratingScreen(
    onBack: () -> Unit,
    onDone: () -> Unit
) {
    val latestOnDone by rememberUpdatedState(onDone)

    LaunchedEffect(Unit) {
        delay(10_000L)
        latestOnDone()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF071326))
    ) {
        Text(
            "←",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 10.dp, top = 25.dp)
                .clickable { onBack() }
        )

        Text(
            buildAnnotatedString {
                append("Generating")
                withStyle(SpanStyle(color = Color(0xFFF5A623))) { append(" Mock Test") }
            },
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 27.dp, top = 33.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 31.dp)
                .background(Color(0xFFF0F4FA), RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .padding(horizontal = 20.dp)
        ) {
            Text(
                "🧠",
                color = Color(0xFF0D1B2E),
                fontSize = 55.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                textAlign = TextAlign.Center
            )
            Text(
                "Selecting the best 25 questions\nfrom 10,000+ questions matched to your profile",
                color = Color(0xFF666666),
                fontSize = 13.sp,
                lineHeight = 19.5.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 42.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                GeneratingStepCard("📝", "Analysing your weak areas\nfrom history", done = true)
                GeneratingStepCard("📚", "Selecting questions by\ndifficulty", done = true)
                GeneratingStepCard("⚖️", "Matching PYQ patterns...", done = true, tall = false)
                GeneratingStepCard("📊", "Finalising answer options &\nexplanations", done = false, tall = false)
            }
        }
    }
}

@Composable
private fun GeneratingStepCard(
    icon: String,
    text: String,
    done: Boolean,
    tall: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (tall) 88.dp else 71.5.dp)
            .background(Color.White, RoundedCornerShape(14.dp))
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(icon, color = Color(0xFF0D1B2E), fontSize = 18.sp)

        Text(
            text,
            color = Color(0xFF0D1B2E),
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        if (done) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color(0xFFE8F5E9), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("✓", color = Color(0xFF4CAF50), fontSize = 14.sp)
            }
        } else {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.6.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(Color(0xFFF5A623), RoundedCornerShape(6.dp))
                )
            }
        }
    }
}
