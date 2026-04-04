package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*

// ── Colour palette ────────────────────────────────────────────
private val DNBg    = Color(0xFF0F1629)
private val DNCard  = Color(0xFF1A2540)
private val DNWhite = Color.White
private val DNGray  = Color(0xFF9CA3AF)
private val DNLight = Color(0xFFF4F6FB)
private val DNBorder = Color(0xFFE5E7EB)

// ── Data model ────────────────────────────────────────────────
private data class NewsArticle(
    val gsTag: String,
    val gsTagColor: Color,
    val subjectTag: String,
    val subjectTagColor: Color,
    val focusTag: String,
    val focusTagColor: Color,
    val readMin: Int,
    val title: String,
    val summary: String
)

private val hinduArticles = listOf(
    NewsArticle(
        gsTag = "GS Paper II", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Polity", subjectTagColor = Color(0xFFEC4899),
        focusTag = "Prelims Focus", focusTagColor = Color(0xFF8B5CF6),
        readMin = 8,
        title = "Panchayati Raj at the Crossroads: Devolution, Democracy, and the 3F Challenge",
        summary = "The editorial examines the persistent gap between constitutional promise and ground reality in local governance — 30 years after the 73rd Amendment."
    ),
    NewsArticle(
        gsTag = "GS II", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Int'l Relations", subjectTagColor = Color(0xFFF97316),
        focusTag = "High Yield", focusTagColor = Color(0xFF22C55E),
        readMin = 8,
        title = "The India–Middle East–Europe Corridor: Geopolitics of Infrastructure",
        summary = "With the IMEC project gaining momentum, India's strategic calculation balances trade interests against regional geopolitical sensitivities."
    ),
    NewsArticle(
        gsTag = "GS Paper II", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Polity", subjectTagColor = Color(0xFFEC4899),
        focusTag = "Prelims Focus", focusTagColor = Color(0xFF8B5CF6),
        readMin = 8,
        title = "Panchayati Raj at the Crossroads: Devolution, Democracy, and the 3F Challenge",
        summary = "The editorial examines the persistent gap between constitutional promise and ground reality in local governance — 30 years after the 73rd Amendment."
    ),
    NewsArticle(
        gsTag = "GS III", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Environment", subjectTagColor = Color(0xFF22C55E),
        focusTag = "", focusTagColor = Color.Transparent,
        readMin = 8,
        title = "Climate Finance Gap: Why COP29 Pledges Fall Short",
        summary = "Developed nations' \$300 billion climate finance commitment is less than a third of what vulnerable nations actually need."
    ),
    NewsArticle(
        gsTag = "GS III", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Technology", subjectTagColor = Color(0xFF06B6D4),
        focusTag = "", focusTagColor = Color.Transparent,
        readMin = 8,
        title = "India's Semiconductor Push: PLI Scheme Progress",
        summary = "Two years into the India Semiconductor Mission, chip fab projects are progressing but talent pipeline gaps threaten long-term viability."
    ),
)

private val ieArticles = listOf(
    NewsArticle(
        gsTag = "GS II", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Int'l Relations", subjectTagColor = Color(0xFFF97316),
        focusTag = "High Yield", focusTagColor = Color(0xFF22C55E),
        readMin = 8,
        title = "The India–Middle East–Europe Corridor: Geopolitics of Infrastructure",
        summary = "With the IMEC project gaining momentum, India's strategic calculation balances trade interests against regional geopolitical sensitivities."
    ),
    NewsArticle(
        gsTag = "GS III", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Environment", subjectTagColor = Color(0xFF22C55E),
        focusTag = "", focusTagColor = Color.Transparent,
        readMin = 8,
        title = "Climate Finance Gap: Why COP29 Pledges Fall Short",
        summary = "Developed nations' \$300 billion climate finance commitment is less than a third of what vulnerable nations actually need."
    ),
    NewsArticle(
        gsTag = "GS Paper II", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Polity", subjectTagColor = Color(0xFFEC4899),
        focusTag = "Prelims Focus", focusTagColor = Color(0xFF8B5CF6),
        readMin = 8,
        title = "Panchayati Raj at the Crossroads: Devolution, Democracy, and the 3F Challenge",
        summary = "The editorial examines the persistent gap between constitutional promise and ground reality in local governance — 30 years after the 73rd Amendment."
    ),
    NewsArticle(
        gsTag = "GS III", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Technology", subjectTagColor = Color(0xFF06B6D4),
        focusTag = "", focusTagColor = Color.Transparent,
        readMin = 8,
        title = "India's Semiconductor Push: PLI Scheme Progress",
        summary = "Two years into the India Semiconductor Mission, chip fab projects are progressing but talent pipeline gaps threaten long-term viability."
    ),
    NewsArticle(
        gsTag = "GS II", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Int'l Relations", subjectTagColor = Color(0xFFF97316),
        focusTag = "High Yield", focusTagColor = Color(0xFF22C55E),
        readMin = 8,
        title = "The India–Middle East–Europe Corridor: Geopolitics of Infrastructure",
        summary = "With the IMEC project gaining momentum, India's strategic calculation balances trade interests against regional geopolitical sensitivities."
    ),
    NewsArticle(
        gsTag = "GS III", gsTagColor = Color(0xFF3B82F6),
        subjectTag = "Environment", subjectTagColor = Color(0xFF22C55E),
        focusTag = "", focusTagColor = Color.Transparent,
        readMin = 8,
        title = "Climate Finance Gap: Why COP29 Pledges Fall Short",
        summary = "Developed nations' \$300 billion climate finance commitment is less than a third of what vulnerable nations actually need."
    ),
)

@Composable
fun DailyNewsScreen(onBack: () -> Unit) {
    var selectedTab by remember { mutableStateOf(0) }   // 0 = The Hindu, 1 = Indian Express
    val articles = if (selectedTab == 0) hinduArticles else ieArticles

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DNBg),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        // ── Dark hero header ───────────────────────────────
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DNBg)
                    .statusBarsPadding()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(12.dp))

                // Back + badge row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "←",
                        color = White70,
                        fontSize = 20.sp,
                        modifier = Modifier.clickable { onBack() }
                    )
                    Spacer(Modifier.weight(1f))
                    // Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFF2A3555))
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "📰 DAILY NEWS ANALYSIS",
                            color = DNGray,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.6.sp
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Spacer(Modifier.width(24.dp)) // balance back arrow
                }

                Spacer(Modifier.height(20.dp))

                // Hero title
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(color = DNWhite, fontWeight = FontWeight.ExtraBold)) { append("Where ") }
                        withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("news") }
                        withStyle(SpanStyle(color = DNWhite, fontWeight = FontWeight.ExtraBold)) { append(" meets\nthe ") }
                        withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) { append("syllabus") }
                    },
                    fontSize = 30.sp,
                    lineHeight = 38.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    "Every editorial, every perspective —\nmapped to what UPSC asks.",
                    color = DNGray,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 19.sp
                )

                Spacer(Modifier.height(24.dp))

                // Stats row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatBox(modifier = Modifier.weight(1f), value = "8", label = "THE\nHINDU", valueColor = GoldAccent)
                    StatBox(modifier = Modifier.weight(1f), value = "6", label = "INDIAN\nEXPRESS", valueColor = DNWhite)
                    StatBox(modifier = Modifier.weight(1f), value = "4", label = "READ SO\nFAR", valueColor = DNWhite)
                    StatBox(modifier = Modifier.weight(1f), value = "2", label = "SUMMARIES", valueColor = Color(0xFF22C55E))
                }

                Spacer(Modifier.height(20.dp))
            }
        }

        // ── White content card ─────────────────────────────
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(8.dp, RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .background(DNLight)
                    .padding(top = 20.dp)
            ) {
                // Source tabs
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    SourceTab(
                        modifier = Modifier.weight(1f),
                        label = "🖊 The Hindu",
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 }
                    )
                    SourceTab(
                        modifier = Modifier.weight(1f),
                        label = "📰 Indian Express",
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 }
                    )
                }

                Spacer(Modifier.height(16.dp))

                // Date row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("📅", fontSize = 16.sp)
                        Spacer(Modifier.width(6.dp))
                        Text(
                            "Sat, Mar 22, 2026",
                            color = Color(0xFF111827),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(DNWhite)
                            .border(1.dp, DNBorder, RoundedCornerShape(20.dp))
                            .clickable {}
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("📅", fontSize = 12.sp)
                            Spacer(Modifier.width(4.dp))
                            Text("Calendar", color = Color(0xFF374151), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }

                Spacer(Modifier.height(14.dp))
            }
        }

        // ── Article cards ──────────────────────────────────
        items(articles) { article ->
            NewsArticleCard(
                article = article,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }

        // ── Streak card ────────────────────────────────────
        item {
            Spacer(Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(DNCard)
                    .padding(20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                "🔥 14-Day Streak",
                                color = DNWhite,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Spacer(Modifier.height(2.dp))
                            Text("Keep it up! Read 3 today", color = DNGray, fontSize = 12.sp)
                        }
                        Text(
                            "22%",
                            color = GoldAccent,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Spacer(Modifier.height(14.dp))

                    // Streak dots
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        repeat(14) { idx ->
                            val filled = idx < 3
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(24.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .then(if (filled) Modifier.background(GoldGradient) else Modifier.background(Color(0xFF2D3561))),
                                contentAlignment = Alignment.Center
                            ) {
                                if (filled) Text("✓", color = DNBg, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    Spacer(Modifier.height(8.dp))
                    Text("Reading 7/14", color = DNGray, fontSize = 12.sp)
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

// ── Sub-composables ───────────────────────────────────────────

@Composable
private fun StatBox(modifier: Modifier, value: String, label: String, valueColor: Color) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF1A2540))
            .padding(vertical = 14.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = valueColor, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(4.dp))
            Text(
                label,
                color = DNGray,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 13.sp
            )
        }
    }
}

@Composable
private fun SourceTab(modifier: Modifier, label: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) Color(0xFF111827) else DNWhite)
            .border(1.dp, if (selected) Color(0xFF111827) else DNBorder, RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            color = if (selected) DNWhite else Color(0xFF374151),
            fontSize = 13.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun NewsArticleCard(article: NewsArticle, modifier: Modifier = Modifier) {
    var saved   by remember { mutableStateOf(false) }
    var marked  by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(DNWhite)
            .padding(16.dp)
    ) {
        // Tags + read time
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                NewsTag(article.gsTag, article.gsTagColor)
                NewsTag(article.subjectTag, article.subjectTagColor)
                if (article.focusTag.isNotEmpty()) NewsTag(article.focusTag, article.focusTagColor)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("⏱", fontSize = 11.sp)
                Spacer(Modifier.width(2.dp))
                Text("${article.readMin} min", color = DNGray, fontSize = 11.sp)
            }
        }

        Spacer(Modifier.height(10.dp))

        // Title
        Text(
            article.title,
            color = Color(0xFF111827),
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 21.sp
        )

        Spacer(Modifier.height(6.dp))

        // Summary
        Text(
            article.summary,
            color = Color(0xFF6B7280),
            fontSize = 13.sp,
            lineHeight = 18.sp
        )

        Spacer(Modifier.height(14.dp))

        // Action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Save
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (saved) Color(0xFFFFF3E0) else DNLight)
                    .border(1.dp, DNBorder, RoundedCornerShape(10.dp))
                    .clickable { saved = !saved }
                    .padding(horizontal = 14.dp, vertical = 9.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (saved) "🔖" else "📌", fontSize = 12.sp)
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Save",
                        color = if (saved) GoldAccent else Color(0xFF374151),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Mark read
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (marked) Color(0xFFF0FDF4) else DNLight)
                    .border(1.dp, DNBorder, RoundedCornerShape(10.dp))
                    .clickable { marked = !marked }
                    .padding(horizontal = 14.dp, vertical = 9.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("✓", fontSize = 12.sp, color = if (marked) Color(0xFF22C55E) else Color(0xFF374151))
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Mark read",
                        color = if (marked) Color(0xFF22C55E) else Color(0xFF374151),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            // Jeet AI
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF111827))
                    .clickable {}
                    .padding(horizontal = 14.dp, vertical = 9.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🤖", fontSize = 12.sp)
                    Spacer(Modifier.width(4.dp))
                    Text("Jeet AI", color = DNWhite, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun NewsTag(label: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(color.copy(alpha = 0.12f))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(label, color = color, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}
