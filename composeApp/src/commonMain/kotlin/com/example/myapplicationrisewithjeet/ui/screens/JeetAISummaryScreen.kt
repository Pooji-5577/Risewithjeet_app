package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent

// ── Palette ───────────────────────────────────────────────────
private val SumBg       = Color(0xFF0F1629)
private val SumSurface  = Color(0xFFF8F9FC)
private val SumCard     = Color.White
private val SumText     = Color(0xFF0D1B2E)
private val SumGray     = Color(0xFF6B7280)
private val SumBorder   = Color(0xFFE5E7EB)
private val SumDarkData = Color(0xFF111827)

@Composable
fun JeetAISummaryScreen(
    onBack: () -> Unit,
    onNewsFeed: () -> Unit,
    onNextArticle: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SumBg)
    ) {
        // ── Dark header ──────────────────────────────────────
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(SumBg)
                .statusBarsPadding()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(14.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "←",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 22.sp,
                    modifier = Modifier.clickable { onBack() }
                )
            }
            Spacer(Modifier.height(10.dp))
            Text("🧠", fontSize = 30.sp)
            Spacer(Modifier.height(8.dp))
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("Jeet AI ") }
                    withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold)) { append("Summary") }
                },
                fontSize = 20.sp
            )
            Spacer(Modifier.height(16.dp))
        }

        // ── Scrollable content ───────────────────────────────
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(SumSurface),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // Article header card
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(SumCard)
                        .padding(horizontal = 18.dp, vertical = 16.dp)
                ) {
                    // Source badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFFF5F0D8))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            "📰 The Hindu",
                            color = Color(0xFF856404),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Panchayati Raj at the Crossroads: Devolution, Democracy, and the 3F Challenge",
                        color = SumText,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 22.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("📅 March 22, 2026", color = SumGray, fontSize = 12.sp)
                        Spacer(Modifier.width(12.dp))
                        Text("⏱ 8 min read", color = SumGray, fontSize = 12.sp)
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

            // Core Argument
            item {
                SectionCard {
                    SectionHeader(emoji = "🎯", title = "Core Argument", titleColor = Color(0xFFDC2626))
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Despite 30 years of the 73rd Amendment, Panchayati Raj Institutions remain constitutional formalities rather than functional governments. The 3F challenge — Funds, Functions, Functionaries — persists, making local democracy largely ceremonial in most states.",
                        color = SumText,
                        fontSize = 13.sp,
                        lineHeight = 20.sp
                    )
                }
                Spacer(Modifier.height(8.dp))
            }

            // Key Points
            item {
                SectionCard {
                    SectionHeader(emoji = "📋", title = "Key Points", titleColor = Color(0xFF0D9488))
                    Spacer(Modifier.height(10.dp))
                    BulletPoint(bold = "Devolution gap:", rest = " Only 13 of 29 subjects in 11th Schedule actually devolved by most states")
                    BulletPoint(bold = "Financial dependence:", rest = " PRIs depend 90%+ on state grants; independent revenue negligible")
                    BulletPoint(bold = "Parallel bodies:", rest = " State agencies bypass PRIs for scheme implementation")
                    BulletPoint(bold = "Way forward:", rest = " Activity mapping, SFCs empowerment, citizen audits")
                }
                Spacer(Modifier.height(8.dp))
            }

            // Important Data
            item {
                SectionCard {
                    SectionHeader(emoji = "📊", title = "Important Data", titleColor = Color(0xFF16A34A))
                    Spacer(Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(SumDarkData)
                            .padding(14.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            DataPoint("15th Finance Commission:", "₹4.36 lakh crore to local bodies (2021–26)")
                            DataPoint("Gram Panchayats:", "2.5 lakh across India; 3 lakh elected women representatives")
                            DataPoint("73rd Amendment:", "1992 — Articles 243–243O added to Constitution")
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

            // Syllabus Linkage
            item {
                SectionCard {
                    SectionHeader(emoji = "🔗", title = "Syllabus Linkage", titleColor = Color(0xFF7C3AED))
                    Spacer(Modifier.height(10.dp))
                    SyllabusRow("GS II", "Governance — Panchayati Raj, devolution of powers and finances", Color(0xFF3B82F6))
                    Spacer(Modifier.height(6.dp))
                    SyllabusRow("GS II", "Social Justice — Inclusion of women & SC/ST in local governance", Color(0xFF3B82F6))
                    Spacer(Modifier.height(6.dp))
                    SyllabusRow("GS III", "Economy — Fiscal federalism, state-local financial relations", Color(0xFF10B981))
                }
                Spacer(Modifier.height(8.dp))
            }

            // Practice Questions
            item {
                SectionCard {
                    SectionHeader(emoji = "✏️", title = "Practice Questions", titleColor = Color(0xFFF59E0B))
                    Spacer(Modifier.height(10.dp))
                    // Prelims
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFFFBEB))
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                "PRELIMS LIKELY",
                                color = Color(0xFFD97706),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "Which schedule of the Indian Constitution lists 29 subjects for devolution to Panchayati Raj Institutions?",
                                color = SumText,
                                fontSize = 13.sp,
                                lineHeight = 20.sp
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    // Mains
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFF0FDF4))
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                "MAINS LIKELY",
                                color = Color(0xFF16A34A),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                "\"The 73rd Amendment created constitutional aspiration, not administrative reality.\" Critically examine.",
                                color = SumText,
                                fontSize = 13.sp,
                                lineHeight = 20.sp
                            )
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }

            // Action buttons row
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(SumCard)
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ActionButton(emoji = "📌", label = "Save Note")
                    ActionButton(emoji = "✅", label = "Practice MCQ")
                    ActionButton(emoji = "✏️", label = "Mains Writing")
                    ActionButton(emoji = "🔗", label = "Source")
                }
            }
        }

        // ── Bottom nav bar ────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(SumBg)
                .navigationBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "← News Feed",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { onNewsFeed() }
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(GoldAccent)
                    .clickable { onNextArticle() }
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text(
                    "Next Article →",
                    color = Color(0xFF101828),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// ── Reusable sub-components ───────────────────────────────────

@Composable
private fun SectionCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SumCard)
            .padding(horizontal = 18.dp, vertical = 16.dp),
        content = content
    )
}

@Composable
private fun SectionHeader(emoji: String, title: String, titleColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(emoji, fontSize = 16.sp)
        Spacer(Modifier.width(8.dp))
        Text(title, color = titleColor, fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun BulletPoint(bold: String, rest: String) {
    Text(
        buildAnnotatedString {
            append("• ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = SumText)) { append(bold) }
            withStyle(SpanStyle(color = SumText)) { append(rest) }
        },
        fontSize = 13.sp,
        lineHeight = 20.sp,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
private fun DataPoint(bold: String, rest: String) {
    Text(
        buildAnnotatedString {
            append("• ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.White)) { append(bold) }
            withStyle(SpanStyle(color = Color.White.copy(alpha = 0.85f))) { append(" $rest") }
        },
        fontSize = 12.sp,
        lineHeight = 18.sp
    )
}

@Composable
private fun SyllabusRow(tag: String, text: String, tagColor: Color) {
    Row(verticalAlignment = Alignment.Top) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(tagColor.copy(alpha = 0.12f))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(tag, color = tagColor, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.width(10.dp))
        Text(text, color = SumText, fontSize = 12.sp, lineHeight = 18.sp, modifier = Modifier.weight(1f))
    }
}

@Composable
private fun ActionButton(emoji: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(emoji, fontSize = 22.sp)
        Spacer(Modifier.height(4.dp))
        Text(label, color = Color(0xFF374151), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}
