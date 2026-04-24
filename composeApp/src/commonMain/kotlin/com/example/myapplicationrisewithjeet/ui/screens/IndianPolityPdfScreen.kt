package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IndianPolityPdfScreen(
    onBack: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.background(Color(0xFFF0F4FA), RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
    ) {
        item { PdfTopBar(onBack = onBack) }
        item { PdfHeaderInfo() }
        item { PdfBodyContent() }
        item { FeedbackRow() }
        item { UpNextCard() }
        item { PdfPlaylistHeader() }
        item { PdfPlaylistRows() }
    }
}

@Composable
private fun PdfTopBar(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().background(Color(0xFF071224))) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(84.dp)
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("←", color = Color(0xFF5A7096), fontSize = 13.sp, modifier = Modifier.clickable { onBack() })
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                IconBtn("🔍")
                IconBtn("⬇")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(33.dp)
                .background(Color(0xFF071224))
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("1/45", color = Color(0xFFF5A623), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun IconBtn(icon: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(Color(0x24EEF2F8), RoundedCornerShape(9.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(icon, fontSize = 16.sp)
    }
}

@Composable
private fun PdfHeaderInfo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) { Text("📋", fontSize = 20.sp) }
            Column {
                Text(
                    "Constitution — Foundation &\nHistorical Background",
                    color = Color(0xFF1A2744),
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text("Indian Polity", color = Color(0xFF8FA4BE), fontSize = 11.sp)
            }
        }
    }
}

@Composable
private fun PdfBodyContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.width(4.dp).height(16.dp).background(Color(0xFFF5A623), RoundedCornerShape(999.dp)))
            Text("What is a Constitution?", color = Color(0xFF1A2744), fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)
        }
        Text(
            "A constitution is fundamental law that establishes the basis for functions of state and limits of power. It is not only a supreme but also fundamental law of the land — binding on all institutions including Parliament and State legislatures.",
            color = Color(0xFF5A7096),
            fontSize = 12.5.sp,
            lineHeight = 22.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .background(Color(0xFFE0EBF9), RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
                .border(0.8.dp, Color(0xFFE0EBF9), RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.width(2.4.dp).height(122.dp).background(Color(0xFF1A56C4)))
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("📌 KEY DEFINITION", color = Color(0xFF1A56C4), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    Text(
                        "The Indian Constitution came into effect on 26th January 1950 — chosen to honour the Purna Swaraj declaration of 1930. It replaced the Government of India Act 1935.",
                        color = Color(0xFF1A2744),
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 14.dp)) {
            Text("🏛️", fontSize = 20.sp)
            Text("Making of the Constitution", color = Color(0xFF1A2744), fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)
        }
        Text(
            "The Indian Constitution was drafted between December 1946 based on the Cabinet Mission Plan. It was chiefly prepared by:",
            color = Color(0xFF5A7096),
            fontSize = 12.5.sp,
            lineHeight = 22.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .background(Color(0xFFFEF5EC), RoundedCornerShape(12.dp))
                .border(0.8.dp, Color(0xFFFFD5A8), RoundedCornerShape(12.dp))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text("→ 249 TOTAL MEMBERS", color = Color(0xFF1A2744), fontSize = 12.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium)
            Text("→ Dr B R Ambedkar — Chairman, Drafting Committee", color = Color(0xFF1A2744), fontSize = 12.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium)
            Text("→ Dr Rajendra Prasad — President, Constituent Assembly", color = Color(0xFF1A2744), fontSize = 12.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun FeedbackRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Found this helpful?", color = Color(0xFF8FA4BE), fontSize = 11.sp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(34.dp)
                    .background(Color(0xFFEDF9F3), RoundedCornerShape(10.dp))
                    .border(0.8.dp, Color(0xFFB2EDD0), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) { Text("🌿 Mark as Read", color = Color(0xFF0E8A56), fontSize = 10.sp, fontWeight = FontWeight.Bold) }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(34.dp)
                    .background(Color(0xFFE0EBF9), RoundedCornerShape(10.dp))
                    .border(0.8.dp, Color(0xFFC0D9F5), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) { Text("✍️ Note", color = Color(0xFF1A56C4), fontSize = 10.sp, fontWeight = FontWeight.Bold) }
        }
    }
}

@Composable
private fun UpNextCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(78.dp)
            .background(Brush.linearGradient(listOf(Color(0xFF071224), Color(0xFF00133A))), RoundedCornerShape(16.dp))
            .border(0.8.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(11.dp)),
                contentAlignment = Alignment.Center
            ) { Text("📖", color = Color.White.copy(alpha = 0.7f), fontSize = 16.sp) }
            Column {
                Text("Up Next: Preamble to the\nConstitution", color = Color.White, fontSize = 12.sp, lineHeight = 15.sp, fontWeight = FontWeight.Bold)
                Text("Objectives, Principles & Amendments", color = Color.White.copy(alpha = 0.5f), fontSize = 10.sp)
            }
        }
        Box(
            modifier = Modifier
                .height(32.dp)
                .background(Color(0xFFF5A623), RoundedCornerShape(11.dp))
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Next ➜", color = Color(0xFF1A2744), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun PdfPlaylistHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(top = 12.dp)
            .background(Color(0xFFF0F4F8))
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
private fun PdfPlaylistRows() {
    val rows = listOf(
        Triple("Introduction to Indian Constitution | Historical Background", "42 min   ·   2.2L views", "watched"),
        Triple("Preamble to the Constitution — Full Analysis & PYQs", "38 min   ·   1.8L views", "watched"),
        Triple("Union & Its Territory — Article 1-4 | Important PYQs", "26 min   ·   1.4L views", "watched"),
        Triple("Citizenship — Article 5-11 | Amendments & Case Laws", "31 min   ·   98K views", "watched"),
        Triple("Fundamental Rights — Article 12 to 35 | Complete Deep Dive", "28 min   ·   1.1L views", "current"),
        Triple("Parliament — Lok Sabha & Rajya Sabha | Bills & Legislation", "44 min   ·   74K views", "upcoming"),
        Triple("Emergency Provisions — Art 352, 356, 360 | PYQ Focus", "32 min   ·   92K views", "upcoming")
    )

    rows.forEachIndexed { index, (title, meta, state) ->
        val bg = if (state == "watched") Color(0xFFEDF9F3) else if (state == "current") Color(0x0DF5A623) else Color(0xFFF0F4F8)
        val left = if (state == "watched") Color(0xFF0E8A56) else if (state == "current") Color(0xFFF5A623) else Color.Transparent
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(77.dp)
                .background(bg)
                .border(0.8.dp, Color(0xFFDDE5F0))
                .padding(start = if (state == "upcoming") 18.dp else 15.dp, top = 10.dp, end = 12.dp),
            verticalAlignment = Alignment.Top
        ) {
            if (left != Color.Transparent) {
                Box(modifier = Modifier.width(2.4.dp).height(57.dp).background(left))
            }
            Box(
                modifier = Modifier
                    .padding(start = if (left != Color.Transparent) 6.dp else 0.dp)
                    .width(88.dp)
                    .height(52.dp)
                    .background(Brush.linearGradient(listOf(Color(0xFF0A1A38), Color(0xFF152244))), RoundedCornerShape(9.dp))
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(22.dp)
                        .background(Color(0xFFE8AA2A), RoundedCornerShape(999.dp)),
                    contentAlignment = Alignment.Center
                ) { Text("▶", color = Color(0xFF0A0A0A), fontSize = 9.sp) }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(3.dp)
                        .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(4.dp))
                        .padding(horizontal = 5.dp, vertical = 1.dp)
                ) { Text("42:08", color = Color.White, fontSize = 9.5.sp) }
            }
            Column(modifier = Modifier.weight(1f).padding(start = 10.dp)) {
                Text(title, color = Color(0xFF1A2744), fontSize = 12.5.sp, lineHeight = 17.sp, fontWeight = FontWeight.Bold)
                Text(meta, color = Color(0xFF8FA4BE), fontSize = 11.sp)
            }
            if (state == "watched") {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(Color(0xFFEDF9F3), RoundedCornerShape(999.dp))
                        .border(0.8.dp, Color(0xFFB2EDD0), RoundedCornerShape(999.dp)),
                    contentAlignment = Alignment.Center
                ) { Text("✓", color = Color(0xFF0E8A56), fontSize = 9.sp) }
            } else if (state == "current") {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(Color(0xFFF5A623), RoundedCornerShape(999.dp)),
                    contentAlignment = Alignment.Center
                ) { Text("▶", color = Color(0xFF1A2744), fontSize = 8.sp) }
            } else {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(Color(0xFFEEF2F8), RoundedCornerShape(999.dp))
                        .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(999.dp)),
                    contentAlignment = Alignment.Center
                ) { Text((index + 1).toString(), color = Color(0xFF8FA4BE), fontSize = 9.sp) }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .height(48.dp)
            .background(Color.White, RoundedCornerShape(13.dp))
            .border(0.8.dp, Color(0xFFDDE5F0), RoundedCornerShape(13.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("View All 41 Videos ➜", color = Color(0xFF1A2744), fontSize = 13.5.sp, fontWeight = FontWeight.Bold)
    }
}
