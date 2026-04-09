package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.GoldAccent
import com.example.myapplicationrisewithjeet.ui.theme.GoldGradient

// ── Palette ──────────────────────────────────────────────────
private val STBg      = Brush.linearGradient(listOf(Color(0xFF060E1D), Color(0xFF08162E)))
private val STSurface = Color(0xFFF0F4FA)
private val STCard    = Color.White
private val STText    = Color(0xFF1A2744)
private val STSub     = Color(0xFF5A7096)
private val STBorder  = Color(0xFFDDE5F0)

private data class GlanceItem(val emoji: String, val title: String, val subtitle: String)

private val glanceItems = listOf(
    GlanceItem("🎯", "Prelims GS",  "General Studies"),
    GlanceItem("✍️", "Mains",       "GS 1–4 + Essay"),
    GlanceItem("📚", "Optional",    "Choose 1 subject"),
    GlanceItem("🌐", "CSAT",        "Paper II"),
)

@Composable
fun SyllabusTrackerScreen(
    onBack: () -> Unit,
    onStartTracking: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize().background(brush = STBg)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // ── Dark Header ──────────────────────────────────
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(brush = STBg)
                        .statusBarsPadding()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(14.dp))
                    // Back button row
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            "←",
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 22.sp,
                            modifier = Modifier.clickable { onBack() }
                        )
                    }
                    Spacer(Modifier.height(14.dp))

                    // Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(GoldAccent.copy(alpha = 0.18f))
                            .border(1.dp, GoldAccent.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                            .padding(horizontal = 14.dp, vertical = 5.dp)
                    ) {
                        Text(
                            "📋  PERSONALIZED SYLLABUS TRACKER",
                            color = GoldAccent,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.8.sp
                        )
                    }
                    Spacer(Modifier.height(16.dp))

                    // Title
                    Text(
                        buildAnnotatedString {
                            withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold)) {
                                append("Know Exactly\nWhere You Stand, ")
                            }
                            withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.ExtraBold)) {
                                append("Rahul.")
                            }
                        },
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )
                    Spacer(Modifier.height(10.dp))

                    // Subtitle
                    Text(
                        "Your UPSC syllabus, fully mapped. Track every topic across Prelims, Mains and Optional.",
                        color = Color.White.copy(alpha = 0.5f),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 19.sp
                    )
                    Spacer(Modifier.height(18.dp))

                    // Stats row
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White.copy(alpha = 0.06f))
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            StatCell("0%",  "OVERALL",   GoldAccent,           hasBorder = true,  modifier = Modifier.weight(1f))
                            StatCell("0",   "DONE",      Color(0xFFFF7070),     hasBorder = true,  modifier = Modifier.weight(1f))
                            StatCell("0",   "REVISING",  Color(0xFFFF7070),     hasBorder = true,  modifier = Modifier.weight(1f))
                            StatCell("581", "REMAINING", Color(0xFFFF7070),     hasBorder = false, modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                }
            }

            // ── Light surface panel ──────────────────────────
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                        .background(STSurface)
                        .padding(horizontal = 14.dp, vertical = 16.dp)
                ) {
                    // Section header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "📋  Syllabus Tracker",
                            color = STText,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Track →",
                            color = GoldAccent,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable { onStartTracking() }
                        )
                    }
                    Spacer(Modifier.height(14.dp))

                    // Empty-state dashed card
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .dashedBorderBox(color = Color(0xFFCAD2DE), cornerRadius = 20.dp)
                            .background(STCard, RoundedCornerShape(20.dp))
                            .padding(18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("📖", fontSize = 40.sp, textAlign = TextAlign.Center)
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "No tracking started yet",
                            color = STText,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            "Start tracking your syllabus in 3 simple steps. Know what's done, what needs revision, and what to conquer next.",
                            color = STSub,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 20.sp
                        )
                        Spacer(Modifier.height(16.dp))

                        // Step indicators
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            StepBubble("1", active = true)
                            Spacer(Modifier.width(6.dp))
                            Text("→", color = STText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.width(6.dp))
                            StepBubble("2", active = false)
                            Spacer(Modifier.width(6.dp))
                            Text("→", color = STText, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.width(6.dp))
                            StepBubble("3", active = false)
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text("Pick a Subject", color = STSub, fontSize = 9.sp, textAlign = TextAlign.Center)
                            Text("Open a Topic",  color = STSub, fontSize = 9.sp, textAlign = TextAlign.Center)
                            Text("Mark Progress", color = STSub, fontSize = 9.sp, textAlign = TextAlign.Center)
                        }
                        Spacer(Modifier.height(18.dp))

                        // CTA Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(GoldGradient)
                                .clickable { onStartTracking() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "🎯 Start Tracking Syllabus→",
                                color = Color(0xFF1A2744),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(Modifier.height(22.dp))

                    // Syllabus at a Glance
                    Text(
                        "📊 Syllabus at a Glance",
                        color = STText,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.height(12.dp))

                    // 2×2 grid
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            GlanceCard(glanceItems[0], modifier = Modifier.weight(1f))
                            GlanceCard(glanceItems[1], modifier = Modifier.weight(1f))
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            GlanceCard(glanceItems[2], modifier = Modifier.weight(1f))
                            GlanceCard(glanceItems[3], modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatCell(value: String, label: String, valueColor: Color, hasBorder: Boolean, modifier: Modifier) {
    Box(
        modifier = modifier
            .then(
                if (hasBorder) Modifier.border(
                    width = 0.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(0.dp)
                ) else Modifier
            )
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, color = valueColor, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.height(2.dp))
            Text(label, color = Color.White.copy(alpha = 0.4f), fontSize = 9.5.sp, letterSpacing = 0.6.sp)
        }
    }
}

@Composable
private fun StepBubble(label: String, active: Boolean) {
    Box(
        modifier = Modifier
            .size(26.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(
                if (active) Color(0xFF0F172B)
                else Color(0xFFBEC3CC).copy(alpha = 0.38f)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            color = if (active) Color.White else STText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun GlanceCard(item: GlanceItem, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(STCard)
            .border(1.dp, STBorder, RoundedCornerShape(16.dp))
            .padding(14.dp)
    ) {
        Text(item.emoji, fontSize = 28.sp)
        Spacer(Modifier.height(6.dp))
        Text(item.title,    color = STText, fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
        Text(item.subtitle, color = STSub,  fontSize = 11.sp)
        Spacer(Modifier.height(8.dp))
        Text("0%", color = GoldAccent, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(Color(0xFF99A1AF))
        )
        Spacer(Modifier.height(4.dp))
        Text("0 of 74 topics done", color = STSub, fontSize = 9.sp)
    }
}

// ── Dashed border helper ──────────────────────────────────────
private fun Modifier.dashedBorderBox(color: Color, cornerRadius: Dp): Modifier = this.drawBehind {
    val stroke = Stroke(
        width = 3f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f), 0f)
    )
    drawRoundRect(
        color = color,
        style = stroke,
        cornerRadius = CornerRadius(cornerRadius.toPx())
    )
}
