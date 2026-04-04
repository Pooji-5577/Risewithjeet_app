package com.example.myapplicationrisewithjeet.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

@Composable
fun SplashScreen(
    onGetStarted: () -> Unit,
    onSignIn: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFEEF0FB), Color(0xFFF5F6FF))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("🔥", fontSize = 64.sp)
                Spacer(Modifier.height(12.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(color = Color(0xFF1A1A2E), fontWeight = FontWeight.ExtraBold)) {
                            append("Rise")
                        }
                        withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) {
                            append("WithJeet")
                        }
                    },
                    fontSize = 32.sp
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "UPSC 2026 Intelligence Platform",
                    color = Color(0xFF6B7280),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(28.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard(modifier = Modifier.weight(1f), value = "50K+", label = "STUDENTS")
                    StatCard(modifier = Modifier.weight(1f), value = "1,240", label = "SELECTIONS")
                    StatCard(modifier = Modifier.weight(1f), value = "4.9★", label = "RATING")
                }

                Spacer(Modifier.height(20.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FeatureRow(
                        emoji = "🤖",
                        bgColor = Color(0xFFE8F4FD),
                        title = "Jeet AI Tutor",
                        subtitle = "24/7 UPSC intelligence"
                    )
                    FeatureRow(
                        emoji = "✏️",
                        bgColor = Color(0xFFFFF3CD),
                        title = "AI Mains Evaluation",
                        subtitle = "Score in 60s · 6 rubrics"
                    )
                    FeatureRow(
                        emoji = "📊",
                        bgColor = Color(0xFFE8F8EF),
                        title = "Smart Analytics",
                        subtitle = "Track vs toppers, beat your rank"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(GoldGradient)
                        .clickable { onGetStarted() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "🚀 Get Started — It's Free",
                        color = Color(0xFF1A1A1A),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                TextButton(
                    onClick = onSignIn,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        "Sign In to My Account",
                        color = Color(0xFF374151),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1A1A2E))
                    .padding(horizontal = 24.dp, vertical = 14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("🎯", fontSize = 22.sp)
                    Column {
                        Text(
                            "89 days to UPSC Prelims 2026",
                            color = GoldAccent,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Text(
                            "Every day you delay is a day gained by your competitor",
                            color = Color(0xFF9CA3AF),
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatCard(modifier: Modifier, value: String, label: String) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(12.dp))
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = Color(0xFF1A1A2E), fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(2.dp))
            Text(label, color = Color(0xFF6B7280), fontSize = 10.sp, fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
        }
    }
}

@Composable
private fun FeatureRow(emoji: String, bgColor: Color, title: String, subtitle: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(14.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(bgColor),
                contentAlignment = Alignment.Center
            ) {
                Text(emoji, fontSize = 20.sp)
            }
            Spacer(Modifier.width(14.dp))
            Column {
                Text(title, color = Color(0xFF1A1A2E), fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Text(subtitle, color = Color(0xFF6B7280), fontSize = 12.sp)
            }
        }
    }
}
