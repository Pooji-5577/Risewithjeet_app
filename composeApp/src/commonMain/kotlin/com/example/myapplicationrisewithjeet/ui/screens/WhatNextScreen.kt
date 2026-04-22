package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.icon_books
import myapplicationrisewithjeet.composeapp.generated.resources.icon_note
import myapplicationrisewithjeet.composeapp.generated.resources.icon_reset
import myapplicationrisewithjeet.composeapp.generated.resources.icon_star
import myapplicationrisewithjeet.composeapp.generated.resources.icon_target
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun WhatNextScreen(
    onBack: () -> Unit,
    onTryAnother: () -> Unit,
    onDashboard: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDCE1EA))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF08162A))
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                "←",
                color = Color(0xFFB7C6DB),
                fontSize = 18.sp,
                modifier = Modifier.clickable { onBack() }
            )
            Spacer(Modifier.height(12.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("💡", fontSize = 30.sp)
                Spacer(Modifier.height(8.dp))
                Text(
                    buildAnnotatedString {
                        append("What would you like to do ")
                        withStyle(SpanStyle(color = Color(0xFFF5B335))) { append("next?") }
                    },
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Smart recommendations based on your performance",
                    color = Color(0xFF9FAEC3),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.height(10.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFFF1F3F8))
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_reset,
                    title = "Rewrite with\nFeedback",
                    subtitle = "Apply suggestions\nimmediately",
                    onClick = onTryAnother
                )
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_note,
                    title = "Save to Notes",
                    subtitle = "Add to personalised\nrevision",
                    onClick = onDashboard
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_books,
                    title = "Discuss with\nMentor",
                    subtitle = "Get expert guidance",
                    onClick = {}
                )
                NextActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Res.drawable.icon_star,
                    title = "View Model\nAnswer",
                    subtitle = "See perfect structure\n& content",
                    onClick = {}
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .border(1.dp, Color(0xFFE3E7EF), RoundedCornerShape(14.dp))
                    .clickable { onTryAnother() }
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(RoundedCornerShape(9.dp))
                        .background(Color(0xFFFFF0F3)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.icon_target),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(Modifier.size(6.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Practice Similar Question", color = Color(0xFF1F2937), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text("Continue your streak & improve", color = Color(0xFF8B95A5), fontSize = 12.sp)
                }
                Text("›", color = Color(0xFF9CA3AF), fontSize = 20.sp)
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun NextActionCard(
    modifier: Modifier,
    icon: DrawableResource,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .height(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFDCE2EC), RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(title, color = Color(0xFF1F2937), fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(Modifier.height(6.dp))
        Text(subtitle, color = Color(0xFF9CA3AF), fontSize = 12.sp, textAlign = TextAlign.Center, lineHeight = 16.sp)
    }
}
