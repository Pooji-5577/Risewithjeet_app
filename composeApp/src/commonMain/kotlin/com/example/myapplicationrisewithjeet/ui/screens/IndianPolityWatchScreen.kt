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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private data class PlaylistItem(
    val title: String,
    val meta: String,
    val duration: String,
    val state: String // watched, current, upcoming
)

private val playlistItems = listOf(
    PlaylistItem("Introduction to Indian Constitution | Historical Background", "42 min  ·  2.2L views", "42:08", "watched"),
    PlaylistItem("Preamble to the Constitution — Full Analysis & PYQs", "38 min  ·  1.8L views", "42:08", "watched"),
    PlaylistItem("Union & Its Territory — Article 1-4 | Important PYQs", "26 min  ·  1.4L views", "42:08", "watched"),
    PlaylistItem("Citizenship — Article 5-11 | Amendments & Case Laws", "31 min  ·  98K views", "42:08", "watched"),
    PlaylistItem("Fundamental Rights — Article 12 to 35 | Complete Deep Dive", "28 min  ·  1.1L views", "42:08", "current"),
    PlaylistItem("Parliament — Lok Sabha & Rajya Sabha | Bills & Legislation", "44 min  ·  74K views", "42:08", "upcoming"),
    PlaylistItem("Emergency Provisions — Art 352, 356, 360 | PYQ Focus", "32 min  ·  92K views", "42:08", "upcoming")
)

@Composable
fun IndianPolityWatchScreen(
    onBack: () -> Unit = {},
    onReadPdf: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.background(Color.Black)
    ) {
        item { PlayerTopBar(onBack = onBack) }
        item { VideoHero() }
        item { TimelineBar() }
        item { PlaybackControls() }
        item { PlaybackOptions() }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                    .background(Color(0xFFF0F4FA))
            ) {
                LectureDetails()
                QuickActions(onReadPdf = onReadPdf)
                PlaylistHeader()
                playlistItems.forEachIndexed { idx, playlistItem ->
                    PlaylistRow(playlistItem, idx + 1)
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(13.dp))
                            .background(Color.White)
                            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(13.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("View All 41 Videos →", color = Color(0xFF1A2744), fontSize = 13.5.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
private fun PlayerTopBar(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .background(Color(0xFF071224))
    ) {
        Text(
            "←",
            color = Color.White.copy(alpha = 0.6f),
            fontSize = 13.sp,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 32.dp)
                .clickable { onBack() }
        )
        Text(
            "Indian Polity · 5/41",
            color = Color.White.copy(alpha = 0.5f),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 34.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 26.dp, end = 16.dp)
                .size(32.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(Color.White.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Text("⋯", color = Color.White.copy(alpha = 0.7f), fontSize = 16.sp)
        }
    }
}

@Composable
private fun VideoHero() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .background(Brush.linearGradient(listOf(Color(0xFF0F1F3D), Color(0xFF223256))))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x61000000))
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Red)
                .padding(horizontal = 11.dp, vertical = 4.dp)
        ) {
            Text("▶ YouTube", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .offset(y = 5.dp)
                        .size(110.dp)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(Color(0x80F5A623), Color.Transparent),
                                radius = 120f
                            ),
                            CircleShape
                        )
                )
                Box(
                    modifier = Modifier
                        .size(66.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(Color(0xFFF5A623)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("▶", color = Color(0xFF0A0A0A), fontSize = 27.sp)
                }
            }
            Text("FUNDAMENTAL RIGHTS", color = Color.White.copy(alpha = 0.3f), fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black.copy(alpha = 0.65f))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text("Tap to open in YouTube", color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Black.copy(alpha = 0.8f))
                .padding(horizontal = 8.dp, vertical = 3.dp)
        ) {
            Text("28:14", color = Color.White, fontSize = 11.5.sp)
        }
    }
}

@Composable
private fun TimelineBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF071224))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color.White.copy(alpha = 0.15f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .height(3.dp)
                    .background(Color(0xFFF5A623))
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("09:54", color = Color.White.copy(alpha = 0.45f), fontSize = 10.5.sp)
            Text("28:14", color = Color.White.copy(alpha = 0.45f), fontSize = 10.5.sp)
        }
    }
}

@Composable
private fun PlaybackControls() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(Color(0xFF071224))
            .border(0.8.dp, Color.White.copy(alpha = 0.06f))
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf("⏮", "⏪", "▶", "⏩", "⏭").forEachIndexed { idx, icon ->
            val active = idx == 2
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (active) Color(0xFFF5A623) else Color.White.copy(alpha = 0.08f)),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, color = if (active) Color(0xFF1A2744) else Color.White.copy(alpha = 0.8f), fontSize = 17.sp)
            }
        }
    }
}

@Composable
private fun PlaybackOptions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(Color(0xFF071224))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        listOf("1×", "HD", "CC").forEach {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.08f))
                    .padding(horizontal = 12.dp, vertical = 5.dp)
            ) {
                Text(it, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(22.dp))
                .background(Color(0xFFF5A623))
                .padding(horizontal = 14.dp, vertical = 7.dp)
        ) {
            Text("▶ Open Full in YouTube →", color = Color(0xFF1A2744), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun LectureDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F4FA))
            .padding(18.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFE0EBF9))
                .padding(horizontal = 10.dp, vertical = 3.dp)
        ) {
            Text("INDIAN POLITY", color = Color(0xFF1A56C4), fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
        Text(
            "Fundamental Rights — Article 12 to 35 |\nComplete Deep Dive",
            color = Color(0xFF1A2744),
            fontSize = 16.sp,
            lineHeight = 21.6.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            "👁 1.1L views   ⏱ 28 min   📅 Mar 15, 2026   ⭐ 4.9 (2.4K likes)",
            color = Color(0xFF5A7096),
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            "Complete deep dive into Fundamental Rights (Articles 12–35) — covering Right to Equality, Freedom, Constitutional...",
            color = Color(0xFF5A7096),
            fontSize = 12.5.sp,
            lineHeight = 21.25.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text("Show more ▾", color = Color(0xFF1A56C4), fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 4.dp))
    }
}

@Composable
private fun QuickActions(
    onReadPdf: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F4FA))
            .padding(horizontal = 18.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
            SmallAction("▶", "YouTube", Color.Red, Modifier.width(111.4.dp))
            SmallAction("📄", "Read PDF", Color(0xFF5A7096), Modifier.width(111.4.dp), onClick = onReadPdf)
            SmallAction("🔖", "Save", Color(0xFF5A7096), Modifier.width(111.4.dp))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
            SmallAction("📤", "Share", Color(0xFF5A7096), Modifier.width(111.4.dp))
            SmallAction("👨‍🏫", "Ask Mentor", Color(0xFF1A56C4), Modifier.width(111.4.dp))
            SmallAction("📝", "Add Note", Color(0xFF5A7096), Modifier.width(111.4.dp))
        }
    }
}

@Composable
private fun SmallAction(
    icon: String,
    label: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .height(71.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(Color.White)
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(13.dp))
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(icon, fontSize = 20.sp)
        Text(label, color = color, fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun PlaylistHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.White)
            .border(0.8.dp, Color(0xFFDDE5F0))
            .padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("📚 Polity Playlist", color = Color(0xFF1A2744), fontSize = 13.5.sp, fontWeight = FontWeight.ExtraBold)
        Text("5 / 41 watched", color = Color(0xFF8FA4BE), fontSize = 11.5.sp)
    }
}

@Composable
private fun PlaylistRow(item: PlaylistItem, index: Int) {
    val bg = when (item.state) {
        "watched" -> Color(0xFFEDF9F3)
        "current" -> Color(0x0DF5A623)
        else -> Color(0xFFF0F4FA)
    }
    val leftBar = when (item.state) {
        "watched" -> Color(0xFF0E8A56)
        "current" -> Color(0xFFF5A623)
        else -> Color.Transparent
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(77.dp)
            .background(bg)
            .border(0.8.dp, Color(0xFFDDE5F0))
            .padding(start = if (item.state == "upcoming") 18.dp else 15.dp, end = 12.dp, top = 10.dp),
        verticalAlignment = Alignment.Top
    ) {
        if (leftBar != Color.Transparent) {
            Box(
                modifier = Modifier
                    .width(2.4.dp)
                    .height(57.dp)
                    .background(leftBar)
            )
        }
        Box(
            modifier = Modifier
                .padding(start = if (leftBar != Color.Transparent) 6.dp else 0.dp)
                .width(88.dp)
                .height(52.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(Brush.linearGradient(listOf(Color(0xFF0A1A38), Color(0xFF152244))))
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(22.dp)
                    .clip(RoundedCornerShape(999.dp))
                    .background(Color(0xFFE8AA2A)),
                contentAlignment = Alignment.Center
            ) {
                Text("▶", color = Color(0xFF0A0A0A), fontSize = 9.sp)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(3.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Black.copy(alpha = 0.7f))
                    .padding(horizontal = 5.dp, vertical = 1.dp)
            ) {
                Text(item.duration, color = Color.White, fontSize = 9.5.sp)
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(item.title, color = Color(0xFF1A2744), fontSize = 12.5.sp, lineHeight = 17.sp, fontWeight = FontWeight.Bold)
            Text(item.meta, color = Color(0xFF8FA4BE), fontSize = 11.sp)
        }
        when (item.state) {
            "watched" -> {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(Color(0xFFEDF9F3))
                        .border(0.8.dp, Color(0xFFB2EDD0), RoundedCornerShape(999.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("✓", color = Color(0xFF0E8A56), fontSize = 9.sp)
                }
            }
            "current" -> {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(Color(0xFFF5A623)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("▶", color = Color(0xFF1A2744), fontSize = 8.sp)
                }
            }
            else -> {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(Color(0xFFEEF2F8))
                        .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(999.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(index.toString(), color = Color(0xFF8FA4BE), fontSize = 9.sp)
                }
            }
        }
    }
}
