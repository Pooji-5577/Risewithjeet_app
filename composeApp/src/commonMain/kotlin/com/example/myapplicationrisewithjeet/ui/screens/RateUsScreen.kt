package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import com.example.myapplicationrisewithjeet.ui.theme.dmSansFamily
import com.example.myapplicationrisewithjeet.ui.theme.playfairDisplayFamily
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.profile_rate_us
import myapplicationrisewithjeet.composeapp.generated.resources.rate_star
import org.jetbrains.compose.resources.painterResource

@Composable
fun RateUsScreen(onBack: () -> Unit) {
    var selectedStars by remember { mutableStateOf(0) }
    var reviewText by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    val playfair = playfairDisplayFamily()
    val dmSans = dmSansFamily()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Dark header ─────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 20.dp)
                .padding(top = 16.dp, bottom = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Back button
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Text(
                    "←",
                    color = White70,
                    fontSize = 22.sp,
                    modifier = Modifier.clickable { onBack() }
                )
            }

            Spacer(Modifier.height(24.dp))

            // Icon
            Image(
                painter = painterResource(Res.drawable.profile_rate_us),
                contentDescription = "Rate RiseWithJeet",
                modifier = Modifier.size(96.dp)
            )

            Spacer(Modifier.height(20.dp))

            // Title
            Row {
                Text(
                    "Rate ",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = playfair,
                    lineHeight = 22.sp
                )
                Text(
                    "Rise",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = playfair,
                    lineHeight = 22.sp
                )
                Text(
                    "WithJeet",
                    color = GoldAccent,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = playfair,
                    lineHeight = 22.sp
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                "Your feedback makes us better",
                color = White70,
                fontSize = 12.sp,
                fontFamily = dmSans,
                fontWeight = FontWeight.Normal,
                lineHeight = 12.sp,
                textAlign = TextAlign.Center
            )
        }

        // ── White card ──────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(0.dp, RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            if (submitted) {
                // Thank you state
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(24.dp))
                    Text("🎉", fontSize = 56.sp)
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "Thank You!",
                        color = Color(0xFF111827),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = playfair,
                        lineHeight = 22.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Your feedback helps us build a better\nUPSC learning experience.",
                        color = Color(0xFF6B7280),
                        fontSize = 14.sp,
                        fontFamily = dmSans,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )
                    Spacer(Modifier.height(32.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth().height(54.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(GoldGradient)
                            .clickable { onBack() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Back to Profile", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold,
                            fontFamily = dmSans, fontSize = 14.sp)
                    }
                    Spacer(Modifier.height(24.dp))
                }
            } else {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "How would you rate\nyour experience?",
                        color = Color(0xFF111827),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = dmSans,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Tap a star to rate",
                        color = Color(0xFF9CA3AF),
                        fontSize = 12.sp,
                        fontFamily = dmSans,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(28.dp))

                    // Star row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        (1..5).forEach { star ->
                            Image(
                                painter = painterResource(Res.drawable.rate_star),
                                contentDescription = "Rate $star",
                                modifier = Modifier
                                    .size(42.dp)
                                    .padding(horizontal = 4.dp)
                                    .graphicsLayer(alpha = if (star <= selectedStars) 1f else 0.35f)
                                    .clickable { selectedStars = star }
                            )
                        }
                    }

                    Spacer(Modifier.height(28.dp))

                    // Review text field
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFF3F4F6))
                            .border(1.dp, Color(0xFFE5E7EB), RoundedCornerShape(12.dp))
                    ) {
                        if (reviewText.isEmpty()) {
                            Text(
                                "Tell us what you love or what can be better...",
                                color = Color(0xFFB0B7C3),
                                fontSize = 14.sp,
                                fontFamily = dmSans,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        OutlinedTextField(
                            value = reviewText,
                            onValueChange = { reviewText = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 120.dp),
                            placeholder = { },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedTextColor = Color(0xFF111827),
                                unfocusedTextColor = Color(0xFF111827),
                                cursorColor = GoldAccent
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }

                    Spacer(Modifier.height(28.dp))

                    // Submit button
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(14.dp),
                                ambientColor = Color(0xFFF5A623).copy(alpha = 0.3f),
                                spotColor = Color(0xFFF5A623).copy(alpha = 0.3f)
                            )
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(Color(0xFFF5A623), Color(0xFFD4881A))
                                )
                            )
                            .clickable { if (selectedStars > 0) submitted = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Submit Review",
                            color = Color(0xFF0D1B2E),
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = dmSans,
                            fontSize = 15.sp,
                            lineHeight = 22.5.sp,
                            letterSpacing = (-0.2).sp
                        )
                    }

                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}
