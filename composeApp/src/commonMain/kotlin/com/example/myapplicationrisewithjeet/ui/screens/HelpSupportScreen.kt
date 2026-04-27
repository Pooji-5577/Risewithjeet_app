package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import com.example.myapplicationrisewithjeet.ui.theme.dmSansFamily
import com.example.myapplicationrisewithjeet.ui.theme.playfairDisplayFamily
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.help_account
import myapplicationrisewithjeet.composeapp.generated.resources.help_ai_eval
import myapplicationrisewithjeet.composeapp.generated.resources.help_email
import myapplicationrisewithjeet.composeapp.generated.resources.help_payment
import myapplicationrisewithjeet.composeapp.generated.resources.help_search
import myapplicationrisewithjeet.composeapp.generated.resources.help_study_mode
import myapplicationrisewithjeet.composeapp.generated.resources.help_support_header
import myapplicationrisewithjeet.composeapp.generated.resources.help_telegram
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val HelpBg    = Color(0xFFEAEEF4)
private val CardW     = Color.White
private val LblColor  = Color(0xFF999999)
private val TxtDark   = Color(0xFF0D1B2E)
private val TxtMid    = Color(0xFF374151)

@Composable
fun HelpSupportScreen(onBack: () -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

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
                .padding(top = 16.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Text(
                    "←",
                    color = Color(0xFF6A7282),
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onBack() }
                )
            }

            Spacer(Modifier.height(20.dp))

            Image(
                painter = painterResource(Res.drawable.help_support_header),
                contentDescription = "Help and Support",
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Help & Support",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = playfairDisplayFamily(),
                lineHeight = 22.sp
            )
            Spacer(Modifier.height(6.dp))
            Text(
                "We're here for you, always",
                color = White70,
                fontSize = 12.sp,
                fontFamily = dmSansFamily(),
                fontWeight = FontWeight.Normal,
                lineHeight = 12.sp,
                textAlign = TextAlign.Center
            )
        }

        // ── Content card ────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(HelpBg)
                .padding(bottom = 40.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {

                Spacer(Modifier.height(24.dp))

                // ── CONTACT US ──────────────────────────────
                SectionLabel("CONTACT US")

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ContactCard(
                        modifier = Modifier.weight(1f),
                        icon = Res.drawable.help_email,
                        title = "Email Us",
                        subtitle = "together@risewithjeet.com"
                    )
                    ContactCard(
                        modifier = Modifier.weight(1f),
                        icon = Res.drawable.help_telegram,
                        title = "Telegram",
                        subtitle = "@RiseWithJeet"
                    )
                }

                Spacer(Modifier.height(24.dp))

                // ── FAQ SEARCH ──────────────────────────────
                SectionLabel("FREQUENTLY ASKED QUESTIONS")

                Spacer(Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFF5F5F5))
                        .padding(horizontal = 14.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.help_search),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(Modifier.width(8.dp))
                        if (searchQuery.isEmpty()) {
                            Text("Search help articles...", color = Color(0xFFB0B7C3), fontSize = 14.sp,
                                fontFamily = dmSansFamily(), fontWeight = FontWeight.Normal)
                        }
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            placeholder = { },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedTextColor = TxtDark,
                                unfocusedTextColor = TxtDark,
                                cursorColor = GoldAccent
                            )
                        )
                    }
                }

                Spacer(Modifier.height(24.dp))

                // ── QUICK HELP ──────────────────────────────
                SectionLabel("QUICK HELP")

                Spacer(Modifier.height(10.dp))

                val faqItems = listOf(
                    Triple(Res.drawable.help_ai_eval, "How does AI Mains Evaluation work?", "Instant review, detailed feedback"),
                    Triple(Res.drawable.help_study_mode, "How to use Study Mode?", "spaced repetition, flashcards"),
                    Triple(Res.drawable.help_payment, "Payment & Subscription Issues", "Billing, refunds, plan changes"),
                    Triple(Res.drawable.help_account, "Account & Login Issues", "Password reset, 2FA, sessions"),
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFF9F9F9))
                ) {
                    faqItems.forEachIndexed { i, (icon, title, sub) ->
                        FaqRow(icon = icon, title = title, subtitle = sub)
                        if (i < faqItems.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier.padding(start = 52.dp),
                                color = Color(0xFFEEEEEE),
                                thickness = 1.dp
                            )
                        }
                    }
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text,
        color = LblColor,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = dmSansFamily(),
        letterSpacing = 0.7.sp,
        lineHeight = 10.sp,
        modifier = Modifier.padding(horizontal = 20.dp)
    )
}

@Composable
private fun ContactCard(
    modifier: Modifier,
    icon: DrawableResource,
    title: String,
    subtitle: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(CardW)
            .padding(vertical = 18.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = title,
            modifier = Modifier.size(36.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(8.dp))
        Text(
            title,
            color = TxtDark,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = dmSansFamily(),
            lineHeight = 14.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(4.dp))
        Text(
            subtitle,
            color = LblColor,
            fontSize = 12.sp,
            fontFamily = dmSansFamily(),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp,
            maxLines = 1
        )
    }
}

@Composable
private fun FaqRow(icon: DrawableResource, title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(22.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = TxtDark, fontSize = 14.sp, fontWeight = FontWeight.Normal,
                fontFamily = dmSansFamily(), lineHeight = 14.sp)
            Text(subtitle, color = LblColor, fontSize = 12.sp,
                fontFamily = dmSansFamily(), fontWeight = FontWeight.Normal, lineHeight = 12.sp)
        }
        Text("›", color = Color(0xFFD1D5DB), fontSize = 20.sp)
    }
}
