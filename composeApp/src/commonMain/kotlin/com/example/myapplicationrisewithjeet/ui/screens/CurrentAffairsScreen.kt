package com.example.myapplicationrisewithjeet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationrisewithjeet.data.model.CurrentAffair
import com.example.myapplicationrisewithjeet.data.model.sampleCurrentAffairs
import com.example.myapplicationrisewithjeet.ui.theme.*

@Composable
fun CurrentAffairsScreen() {
    val categories = listOf("All", "Economy", "Polity", "Science & Tech", "Environment", "International", "Education")
    var selectedCategory by remember { mutableStateOf("All") }
    var bookmarks by remember { mutableStateOf(setOf<Int>()) }

    val filtered = if (selectedCategory == "All")
        sampleCurrentAffairs
    else
        sampleCurrentAffairs.filter { it.category == selectedCategory }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenIndia)
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Column {
                Text(
                    "📰 Current Affairs",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Stay updated with daily news",
                    color = Color.White.copy(0.85f),
                    fontSize = 14.sp
                )
            }
        }

        // Category filter
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { cat ->
                FilterChip(
                    selected = selectedCategory == cat,
                    onClick = { selectedCategory = cat },
                    label = { Text(cat, fontSize = 13.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = GreenIndia,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filtered, key = { it.id }) { affair ->
                CurrentAffairCard(
                    affair = affair,
                    isBookmarked = bookmarks.contains(affair.id),
                    onBookmark = {
                        bookmarks = if (bookmarks.contains(affair.id))
                            bookmarks - affair.id else bookmarks + affair.id
                    }
                )
            }
        }
    }
}

@Composable
private fun CurrentAffairCard(
    affair: CurrentAffair,
    isBookmarked: Boolean,
    onBookmark: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        onClick = { expanded = !expanded },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CategoryBadge(affair.category)
                        Spacer(Modifier.width(8.dp))
                        Text(affair.date, fontSize = 11.sp, color = OnSurfaceVariant)
                    }
                    Spacer(Modifier.height(6.dp))
                    Text(
                        affair.title,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = OnSurface,
                        lineHeight = 22.sp
                    )
                }
                IconButton(onClick = onBookmark, modifier = Modifier.size(36.dp)) {
                    Text(if (isBookmarked) "🔖" else "📑", fontSize = 18.sp)
                }
            }

            if (expanded) {
                Spacer(Modifier.height(8.dp))
                Text(
                    affair.summary,
                    fontSize = 13.sp,
                    color = OnSurfaceVariant,
                    lineHeight = 20.sp
                )
                if (affair.tags.isNotEmpty()) {
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        affair.tags.forEach { tag ->
                            Box(
                                modifier = Modifier
                                    .background(GreenContainer, RoundedCornerShape(6.dp))
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text("#$tag", fontSize = 11.sp, color = GreenIndia, fontWeight = FontWeight.Medium)
                            }
                        }
                    }
                }
            } else {
                Spacer(Modifier.height(4.dp))
                Text(
                    affair.summary,
                    fontSize = 13.sp,
                    color = OnSurfaceVariant,
                    maxLines = 2,
                    lineHeight = 19.sp
                )
                Text(
                    "Tap to read more",
                    fontSize = 11.sp,
                    color = GreenIndia,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun CategoryBadge(category: String) {
    val (bg, fg) = when (category) {
        "Economy" -> Pair(GoldContainer, Gold)
        "Polity" -> Pair(NavyBlueContainer, NavyBlue)
        "Environment" -> Pair(GreenContainer, GreenIndia)
        "Science & Tech" -> Pair(Color(0xFFE0F2F1), Color(0xFF00897B))
        "International" -> Pair(SaffronContainer, Saffron)
        "Education" -> Pair(Color(0xFFF3E5F5), Color(0xFF7B1FA2))
        else -> Pair(GoldContainer, Gold)
    }
    Box(
        modifier = Modifier
            .background(bg, RoundedCornerShape(6.dp))
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Text(category, fontSize = 10.sp, color = fg, fontWeight = FontWeight.SemiBold)
    }
}
