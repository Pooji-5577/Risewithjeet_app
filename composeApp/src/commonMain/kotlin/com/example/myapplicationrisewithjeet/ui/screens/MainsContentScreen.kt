package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.ui.theme.*

private val contentTabs = listOf("Prelims", "Mains", "Revision", "News")

/**
 * Hosts Prelims / Mains / Revision / News tab content
 * (the tab-based flow separate from the Home dashboard).
 */
@Composable
fun MainsContentScreen(initialTab: Int = 1) {
    var selectedTab by remember { mutableStateOf(initialTab) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkBg)
                .statusBarsPadding()
                .padding(start = 20.dp, end = 16.dp, top = 12.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = White, fontWeight = FontWeight.Bold)) { append("Rise") }
                    withStyle(SpanStyle(color = GoldAccent, fontWeight = FontWeight.Bold)) { append("WithJeet") }
                },
                fontSize = 22.sp
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    modifier = Modifier.size(38.dp).clip(CircleShape).background(DarkCard).clickable {},
                    contentAlignment = Alignment.Center
                ) { Text("🔍", fontSize = 16.sp) }
                Box(
                    modifier = Modifier.size(38.dp).clip(CircleShape).background(DarkCard).clickable {},
                    contentAlignment = Alignment.Center
                ) { Text("🔔", fontSize = 16.sp) }
            }
        }

        // Tab row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkBg)
                .padding(start = 20.dp, end = 20.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            contentTabs.forEachIndexed { index, label ->
                val isSelected = index == selectedTab
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { selectedTab = index }
                ) {
                    Text(
                        label,
                        fontSize = 15.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        color = if (isSelected) White else White40
                    )
                    Spacer(Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .width(if (isSelected) 28.dp else 0.dp)
                            .height(2.dp)
                            .clip(RoundedCornerShape(1.dp))
                            .background(if (isSelected) GoldAccent else Color.Transparent)
                    )
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth().background(DarkBg)) {
            HorizontalDivider(color = DarkBorder, thickness = 1.dp)
        }

        // Content
        when (selectedTab) {
            0 -> PrelimsTabContent(onQuizClick = {})
            1 -> MainsTabContent()
            2 -> RevisionTabContent()
            3 -> NewsTabContent()
        }
    }
}

@Composable
private fun PrelimsTabContent(onQuizClick: () -> Unit) {
    val topics = listOf(
        "Indian Polity & Governance",
        "Modern History",
        "Indian & World Geography",
        "Indian Economy",
        "Environment & Ecology",
        "Science & Technology"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = DarkCard),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("🎯 Prelims Focus", color = White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text("Daily targets to improve speed and accuracy.", color = White70, fontSize = 12.sp)
                    Spacer(Modifier.height(12.dp))
                    Button(
                        onClick = onQuizClick,
                        colors = ButtonDefaults.buttonColors(containerColor = GoldAccent),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("Start Daily MCQ", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        items(topics) { topic ->
            Card(
                colors = CardDefaults.cardColors(containerColor = DarkCard),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(topic, color = White, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                    Text("Practice", color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        item { Spacer(Modifier.height(72.dp)) }
    }
}

@Composable
private fun MainsTabContent() {
    val mainsSets = listOf(
        "GS I — History, Society & Geography",
        "GS II — Governance & IR",
        "GS III — Economy, Sci-Tech & Security",
        "GS IV — Ethics, Integrity & Aptitude",
        "Essay Practice — Weekly"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { OverviewCard("✍️ Mains Writing", "Strengthen answer structure and value addition.") }
        items(mainsSets) { set ->
            TopicCard(title = set, trailing = "Open")
        }
        item { Spacer(Modifier.height(72.dp)) }
    }
}

@Composable
private fun RevisionTabContent() {
    val revision = listOf(
        "Flashcards — Polity",
        "One-page Mind Maps",
        "30-day Revision Cycle",
        "Previous Mistakes Notebook"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { OverviewCard("🧠 Smart Revision", "Spaced revision to retain concepts longer.") }
        items(revision) { item ->
            TopicCard(title = item, trailing = "Review")
        }
        item { Spacer(Modifier.height(72.dp)) }
    }
}

@Composable
private fun NewsTabContent() {
    val news = listOf(
        "Economy — RBI policy highlights",
        "Polity — Constitutional debates",
        "Environment — Biodiversity updates",
        "International — India and global affairs"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { OverviewCard("📰 News in Context", "Daily current affairs mapped to UPSC syllabus.") }
        items(news) { headline ->
            TopicCard(title = headline, trailing = "Read")
        }
        item { Spacer(Modifier.height(72.dp)) }
    }
}

@Composable
private fun OverviewCard(title: String, subtitle: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DarkCard),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, color = White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text(subtitle, color = White70, fontSize = 12.sp)
        }
    }
}

@Composable
private fun TopicCard(title: String, trailing: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DarkCard),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, color = White, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(trailing, color = GoldAccent, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}
