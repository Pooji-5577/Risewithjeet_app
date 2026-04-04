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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.google
import org.jetbrains.compose.resources.painterResource

private val LoginBg = Color(0xFF060F1F)

@Composable
fun LoginScreen(
    onBack: () -> Unit,
    onSignIn: () -> Unit,
    onCreateAccount: () -> Unit
) {
    var emailOrMobile by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LoginBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Dark top section ──────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 24.dp)
                .padding(top = 36.dp, bottom = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App icon – gold rounded square with target emoji
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .shadow(12.dp, RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(GoldAccent),
                contentAlignment = Alignment.Center
            ) {
                Text("🎯", fontSize = 40.sp)
            }

            Spacer(Modifier.height(18.dp))

            // App name
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold)) {
                        append("Rise")
                    }
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) {
                        append("WithJeet")
                    }
                },
                fontSize = 28.sp,
                letterSpacing = 0.sp
            )

            Spacer(Modifier.height(10.dp))

            Text(
                "India's most intelligent UPSC prep platform.\nTrusted by 12,000+ serious aspirants.",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(24.dp))

            // Stats row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                LoginStatCard(
                    modifier = Modifier.weight(1f),
                    value = "12k+",
                    label = "Aspirants",
                    valueColor = GoldAccent
                )
                LoginStatCard(
                    modifier = Modifier.weight(1f),
                    value = "94%",
                    label = "Success Rate",
                    valueColor = CorrectGreen
                )
                LoginStatCard(
                    modifier = Modifier.weight(1f),
                    value = "4.9★",
                    label = "App Rating",
                    valueColor = GoldAccent
                )
            }
        }

        // ── White bottom sheet card ───────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(Color.White)
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp, bottom = 40.dp)
        ) {
            Column {
                // Header
                Text(
                    "Start Your Journey 🚀",
                    color = Color(0xFF111827),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "Join thousands cracking UPSC",
                    color = Color(0xFF666666),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(28.dp))

                // Email or Mobile field
                Text(
                    "EMAIL OR MOBILE",
                    color = Color(0xFF555555),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.8.sp
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = emailOrMobile,
                    onValueChange = { emailOrMobile = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            "enter@gmail.com or +91 98765 43210",
                            color = Color(0x800D1B2E),
                            fontSize = 13.sp
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GoldAccent,
                        unfocusedBorderColor = Color(0xFFE5E7EB),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = Color(0xFF111827),
                        unfocusedTextColor = Color(0xFF111827),
                        cursorColor = GoldAccent
                    )
                )

                Spacer(Modifier.height(18.dp))

                // Password field
                Text(
                    "PASSWORD",
                    color = Color(0xFF555555),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.8.sp
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("••••••••", color = Color(0x800D1B2E), fontSize = 14.sp)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GoldAccent,
                        unfocusedBorderColor = Color(0xFFE5E7EB),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedTextColor = Color(0xFF111827),
                        unfocusedTextColor = Color(0xFF111827),
                        cursorColor = GoldAccent
                    )
                )

                Spacer(Modifier.height(10.dp))

                // Forgot password
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Text(
                        "Forgot Password?",
                        color = GoldAccent,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable {}
                    )
                }

                Spacer(Modifier.height(24.dp))

                // Sign In button — gradient
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color(0xFFF5A623), Color(0xFFD4881A))
                            )
                        )
                        .clickable { onSignIn() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Sign In →",
                        color = Color(0xFF1A1A1A),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }

                Spacer(Modifier.height(22.dp))

                // Continue text
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        "or continue with",
                        color = Color(0xFF9CA3AF),
                        fontSize = 12.sp
                    )
                }

                Spacer(Modifier.height(16.dp))

                // Google button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .border(1.5.dp, Color(0xFFE5E7EB), RoundedCornerShape(14.dp))
                        .clickable {},
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.google),
                            contentDescription = "Google",
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            "Continue with Google",
                            color = Color(0xFF111827),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(Modifier.height(24.dp))

                // Footer
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        buildAnnotatedString {
                            withStyle(SpanStyle(color = Color(0xFF6B7280))) {
                                append("Already have an account?  ")
                            }
                            withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.SemiBold)) {
                                append("Sign in")
                            }
                        },
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { onSignIn() }
                    )
                }
            }
        }
    }
}

@Composable
private fun LoginStatCard(
    modifier: Modifier,
    value: String,
    label: String,
    valueColor: Color
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.10f))
            .padding(vertical = 14.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                value,
                color = valueColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(4.dp))
            Text(label, color = Color.White.copy(alpha = 0.6f), fontSize = 10.sp, textAlign = TextAlign.Center)
        }
    }
}
