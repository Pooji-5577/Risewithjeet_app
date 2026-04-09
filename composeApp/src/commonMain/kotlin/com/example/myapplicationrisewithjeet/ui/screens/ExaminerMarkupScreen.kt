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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*
import myapplicationrisewithjeet.composeapp.generated.resources.Res
import myapplicationrisewithjeet.composeapp.generated.resources.icon_bolt
import myapplicationrisewithjeet.composeapp.generated.resources.icon_document
import myapplicationrisewithjeet.composeapp.generated.resources.icon_note
import myapplicationrisewithjeet.composeapp.generated.resources.icon_write
import org.jetbrains.compose.resources.painterResource

private val MUBg    = Color(0xFFF2F3F8)
private val MUDark  = Color(0xFF0F1629)
private val MUWhite = Color.White
private val MUGray  = Color(0xFF9CA3AF)

@Composable
fun ExaminerMarkupScreen(
    onBack: () -> Unit,
    onTryAnother: () -> Unit,
    onWhatNext: () -> Unit
) {
    var selectedFilter by remember { mutableStateOf(0) }
    val filters = listOf("All", "Strengths", "Issues", "Must Fix")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MUBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Header ─────────────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MUDark)
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("←", color = White70, fontSize = 20.sp, modifier = Modifier.clickable { onBack() })
            }
            Spacer(Modifier.height(8.dp))
            Image(
                painter = painterResource(Res.drawable.icon_note),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Spacer(Modifier.height(4.dp))
            Text("Examiner's Markup", color = MUWhite, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        }

        // ── Filter tabs ────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MUWhite)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            filters.forEachIndexed { idx, label ->
                val sel = idx == selectedFilter
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (sel) MUDark else Color(0xFFF3F4F6))
                        .clickable { selectedFilter = idx }
                        .padding(horizontal = 16.dp, vertical = 7.dp)
                ) {
                    Text(
                        label,
                        color = if (sel) MUWhite else Color(0xFF374151),
                        fontSize = 13.sp,
                        fontWeight = if (sel) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        // ── Annotated Answer card ──────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MUWhite)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_document),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("Annotated Answer", color = Color(0xFF111827), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
                Text("Pages 1/2 · Single Page", color = MUGray, fontSize = 11.sp)
            }

            Spacer(Modifier.height(12.dp))

            // Highlighted phrase (green = strong)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFDCFCE7))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    "Local government institutions",
                    color = Color(0xFF166534),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(6.dp))
            Text(
                "form the backbone of democratic decentralisation. The 73rd Constitutional Amendment (1992) gave constitutional status to Panchayati Raj Institutions (PRIs) and Urban Local Bodies (ULBs) respectively.",
                color = Color(0xFF374151),
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
            Spacer(Modifier.height(10.dp))
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color(0xFF374151))) { append("A large number of responsibilities including ") }
                    withStyle(SpanStyle(color = Color(0xFF92400E), fontWeight = FontWeight.Medium)) {
                        append("29 subjects in the 11th Schedule")
                    }
                    withStyle(SpanStyle(color = Color(0xFF374151))) {
                        append(" were devolved to local bodies to conduct regular elections and provide reservations for SCs, STs, and women (not less than 1/3rd).")
                    }
                },
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "SwaGovtA scheme, e-Gram portal, and 15th Finance Commission strengthened the financial and administrative capacity of local bodies.",
                color = Color(0xFF374151),
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
            Spacer(Modifier.height(10.dp))
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color(0xFF374151))) { append("However, the actual implementation leaves a lot to be desired and there is much that needs to be ") }
                    withStyle(SpanStyle(color = Color(0xFFDC2626), fontWeight = FontWeight.Medium)) {
                        append("make local self-government truly effective.")
                    }
                },
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
            Spacer(Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFFEF2F2))
                    .border(1.dp, Color(0xFFFCA5A5), RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    "[Too vague — needs specific examples]",
                    color = Color(0xFFDC2626),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(16.dp))

            // Legend
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                LegendItem(Color(0xFF22C55E), "Strong")
                LegendItem(Color(0xFFF0A500), "Good but improve")
                LegendItem(Color(0xFFEF4444), "Needs fix")
            }
        }

        Spacer(Modifier.height(16.dp))

        // ── Strengths ──────────────────────────────────────────
        FeedbackSection(
            emoji = "✅",
            title = "STRENGTHS",
            titleColor = Color(0xFF166534),
            bgColor = Color(0xFFF0FDF4),
            borderColor = Color(0xFF86EFAC),
            body = "Introduction contextualizes constitutional empowerment of 73rd Amendment. Good flow with clear paragraph structure. Mentioned accountability mechanism. Correct use of specific article numbers and committee names."
        )

        Spacer(Modifier.height(12.dp))

        // ── Areas to Improve ───────────────────────────────────
        FeedbackSection(
            emoji = "⚠️",
            title = "AREAS TO IMPROVE",
            titleColor = Color(0xFF92400E),
            bgColor = Color(0xFFFFFBEB),
            borderColor = Color(0xFFFCD34D),
            body = "Include more case studies—e.g., CAG report 2024 on fund devolution. Add specific state examples (Kerala success vs UP challenges). Mention RURBAN Mission, e-Gram Swaraj portal as concrete solutions. Conclusion needs a powerful closing line—examiners reward specificity. Avoid phrases like \"much needs to be done.\""
        )

        Spacer(Modifier.height(12.dp))

        // ── Must Fix ───────────────────────────────────────────
        FeedbackSection(
            emoji = "🚫",
            title = "MUST FIX",
            titleColor = Color(0xFF991B1B),
            bgColor = Color(0xFFFEF2F2),
            borderColor = Color(0xFFFCA5A5),
            body = "Way forward is slightly generic. Mention RURBAN Mission, e-Gram Swaraj portal as concrete solutions. Conclusion needs a powerful closing line—examiners reward specificity. Avoid phrases like \"much needs to be done.\""
        )

        Spacer(Modifier.height(20.dp))

        // ── Bottom action buttons ──────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onTryAnother,
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(14.dp),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_write),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("Try Another", color = Color(0xFF374151), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
            Box(
                modifier = Modifier.weight(1f).height(50.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(GoldGradient)
                    .clickable { onWhatNext() },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(Res.drawable.icon_bolt),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text("What Next?", color = Color(0xFF111827), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(color)
        )
        Spacer(Modifier.width(4.dp))
        Text(label, color = Color(0xFF6B7280), fontSize = 11.sp)
    }
}

@Composable
private fun FeedbackSection(
    emoji: String,
    title: String,
    titleColor: Color,
    bgColor: Color,
    borderColor: Color,
    body: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(bgColor)
            .border(1.dp, borderColor, RoundedCornerShape(14.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(emoji, fontSize = 16.sp)
                Spacer(Modifier.width(8.dp))
                Text(title, color = titleColor, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, letterSpacing = 0.5.sp)
            }
            Spacer(Modifier.height(8.dp))
            Text(body, color = Color(0xFF374151), fontSize = 13.sp, lineHeight = 19.sp)
        }
    }
}
