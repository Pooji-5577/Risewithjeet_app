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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainsMockQuestionsScreen(
    onBack: () -> Unit,
    onWriteEvaluate: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF061123))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color.White.copy(alpha = 0.7f), fontSize = 14.sp, modifier = Modifier.clickable { onBack() })
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("✍️", color = Color(0xFF0D1B2E), fontSize = 50.sp)
            Text("Mains Questions", color = Color(0xFFF0F4FA), fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
            Text("Governance", color = Color(0xFFF5A623), fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .background(Color(0xFFF5F7FA), RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MainsQuestionCard(1, onWriteEvaluate)
            MainsQuestionCard(2, onWriteEvaluate)
            MainsQuestionCard(3, onWriteEvaluate)
        }
    }
}

@Composable
private fun MainsQuestionCard(
    number: Int,
    onWriteEvaluate: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(229.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            HeaderChip("GOVERNANCE", Color(0xFFFFEBEE), Color(0xFFE74C3C))
            HeaderChip("GS Paper II", Color(0xFFE3F2FD), Color(0xFF1976D2))
            HeaderChip("15 marks", Color(0xFFF3E5F5), Color(0xFF7B1FA2))
            HeaderChip("2024", Color(0xFF1C398E), Color.White)
        }

        Text(
            "QUESTION #$number",
            color = Color(0xFF666666),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 9.dp)
        )

        Text(
            "\"The role of civil society organisations in policy-making has\nincreased significantly in India, yet their accountability\nremains a critical concern.\" Examine with relevant examples.",
            color = Color.Black,
            fontSize = 10.sp,
            lineHeight = 19.2.sp,
            modifier = Modifier.padding(top = 4.dp)
        )

        Row(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MetaText("📝 150 words")
            MetaText("📊 Characters")
            MetaText("📅 2024")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(34.dp)
                    .background(Color(0xFF0D1B2E), RoundedCornerShape(10.dp))
                    .clickable { onWriteEvaluate() },
                contentAlignment = Alignment.Center
            ) {
                Text("✨  Write & Evaluate", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
            Box(
                modifier = Modifier
                    .weight(0.8f)
                    .height(34.dp)
                    .background(Color(0xFF0D1B2E), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Model Answer", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .size(width = 37.dp, height = 34.dp)
                    .background(Color(0xFFF5F7FA), RoundedCornerShape(10.dp))
                    .border(0.5.dp, Color(0xFFFF6900), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("✏️", color = Color(0xFF666666), fontSize = 12.sp, textAlign = TextAlign.Center)
            }
        }

        Text(
            "🔒  Full model answer on login",
            color = Color(0xFF8FA3C0),
            fontSize = 9.5.sp,
            modifier = Modifier.align(Alignment.End).padding(top = 4.dp)
        )
    }
}

@Composable
private fun HeaderChip(text: String, bg: Color, fg: Color) {
    Box(
        modifier = Modifier
            .background(bg, RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = fg, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun MetaText(text: String) {
    Text(text, color = Color(0xFF8FA3C0), fontSize = 9.5.sp)
}
